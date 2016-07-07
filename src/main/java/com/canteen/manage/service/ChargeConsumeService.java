package com.canteen.manage.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.canteen.manage.dto.RechargeInfoDTO;
import com.canteen.manage.entity.CardInfo;
import com.canteen.manage.entity.CardUseDetail;
import com.canteen.manage.entity.ConsumeRecord;
import com.canteen.manage.entity.RechargeRecord;
import com.canteen.manage.entity.Student;
import com.canteen.manage.ex.BusinessException;
import com.canteen.manage.repositories.CardInfoRepository;
import com.canteen.manage.repositories.CardUseDetailRepository;
import com.canteen.manage.repositories.ConsumeRecordRepository;
import com.canteen.manage.repositories.GradeRepository;
import com.canteen.manage.repositories.RechargeRecordRepository;
import com.canteen.manage.repositories.StudentRepository;

/**
 * @author nooze
 * 消费和充值消费记录查询，生成
 */
@Service
public class ChargeConsumeService {
	
	@Autowired
	RechargeRecordRepository rechargeRecordRepository;
	
	@Autowired
	ConsumeRecordRepository consumeRecordRepository;
	
	@Autowired
	GradeRepository gradeRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CardInfoRepository cardInfoRepository;
	
	@Autowired
	CardUseDetailService cardUseDetailService;
	
	/**
	 * 根据用户查询充值记录
	 * @param userId
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public Page<RechargeRecord> queryRechargeRecords(int userId,int currentPage,int pageSize){
		Pageable pageRequest=new PageRequest(currentPage, pageSize);
		Page<RechargeRecord>  page=rechargeRecordRepository.findByUserId(userId, pageRequest);
		return page;
	};
	
	/**
	 * 根据班级查询充值记录
	 * @param gradeId
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public Page<RechargeRecord> queryGradeRechargeRecords(int gradeId,int currentPage,int pageSize){
		Page<RechargeRecord>  page= null;
		List<Student> students=studentRepository.findByClassId(gradeId);
		if(CollectionUtils.isEmpty(students)){
			List<RechargeRecord> records=Collections.emptyList();
			return new PageImpl<RechargeRecord>(records);
		}
		List<Integer> userIdList=new ArrayList<Integer>();
		for(Student student:students){
			userIdList.add(student.getUserId());
		}
		Pageable pageRequest=new PageRequest(currentPage, pageSize);
		page=rechargeRecordRepository.findOutGarde(userIdList,pageRequest);
				
		return page;
	};
	
	
	/**
	 * 根据用户查询消费记录
	 * @param userId
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public Page<ConsumeRecord> queryConsumeRecords(int userId,int currentPage,int pageSize){
		Pageable pageRequest=new PageRequest(currentPage, pageSize);
		Page<ConsumeRecord>  page=consumeRecordRepository.findByUserId(userId, pageRequest);
		return page;
	};
	
	
	/**
	 * 根据班级查询消费记录
	 * @param gradeId
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public Page<ConsumeRecord> queryGradeConsumeRecords(int gradeId,int currentPage,int pageSize){
		Page<ConsumeRecord>  page= null;
		List<Student> students=studentRepository.findByClassId(gradeId);
		if(CollectionUtils.isEmpty(students)){
			List<ConsumeRecord> records=Collections.emptyList();
			return new PageImpl<ConsumeRecord>(records);
		}
		List<Integer> userIdList=new ArrayList<Integer>();
		for(Student student:students){
			userIdList.add(student.getUserId());
		}
		Pageable pageRequest=new PageRequest(currentPage, pageSize);
		page=consumeRecordRepository.findOutGarde(userIdList,pageRequest);
				
		return page;
	};
	
	/**
	 * 个人充值
	 * @param userId
	 * @param rechargeType
	 * @param money
	 */
	@Transactional
	public void rechargePerson(RechargeInfoDTO rechargeDTO){
		BigDecimal money=rechargeDTO.getCanteenBalance();
		BigDecimal payPerMoney=rechargeDTO.getPerPayMoney();
		if(money.compareTo(BigDecimal.ZERO)<=0||payPerMoney.compareTo(BigDecimal.ZERO)<=0){
			throw new BusinessException(410, "请输入正确的充值金额");
		}
		CardInfo cardInfo=cardInfoRepository.findByUserId(rechargeDTO.getUserId());
		if(cardInfo==null){
			throw new BusinessException(410,"这位同学还没有饭卡，请先开卡");
		}
		rechargeDTO.setUserId(cardInfo.getUserId());
		rechargeDTO.setCardId(cardInfo.getId());
		recharge(rechargeDTO);
	}


	
	
	/**
	 * 班级统一充值
	 * @param gradeId
	 * @param rechargeType
	 * @param money
	 */
	@Transactional
	public void rechargeGrade(RechargeInfoDTO rechargeDTO){
		BigDecimal money=rechargeDTO.getCanteenBalance();
		BigDecimal payPerMoney=rechargeDTO.getPerPayMoney();
		if(money.compareTo(BigDecimal.ZERO)<=0||payPerMoney.compareTo(BigDecimal.ZERO)<=0){
			throw new BusinessException(410, "请输入正确的充值金额");
		}
		List<Student> students=studentRepository.findByClassId(rechargeDTO.getGradeId());
		if(CollectionUtils.isEmpty(students)){
			throw new BusinessException(410,"请输入正确的班级号");
		}
		List<Integer> userIdList=new ArrayList<Integer>();
		for(Student student:students){
			userIdList.add(student.getUserId());
		}
		List<CardInfo> cardInfoList=cardInfoRepository.listGradeCard(userIdList);
		if(CollectionUtils.isEmpty(cardInfoList)){
			throw new BusinessException(410,"这个班级连一张卡也没有");
		}
		for(CardInfo cardInfo:cardInfoList){
			rechargeDTO.setUserId(cardInfo.getUserId());
			rechargeDTO.setCardId(cardInfo.getId());
			recharge(rechargeDTO);
		}
	}
	
	public void recharge(RechargeInfoDTO rechargeDTO) {
		int cardId=rechargeDTO.getCardId();
		CardUseDetail detail=cardUseDetailService.findByCardIdAndRuleId(cardId, 1);
		if(detail==null){
			detail=new CardUseDetail(cardId, 1, (short)1, "0");
		}
		BigDecimal number=rechargeDTO.getCanteenBalance().divide(rechargeDTO.getPerPayMoney());
		int oldNumber=detail.getCudAttvalue()==null?0:Integer.parseInt(detail.getCudAttvalue());
		int totalNumber=number.intValue()+oldNumber;
		detail.setCudAttvalue(String.valueOf(totalNumber));
		cardUseDetailService.saveCardDetail(detail);
		
		CardUseDetail marketDetail=cardUseDetailService.findByCardIdAndRuleId(cardId, 2);
		if(marketDetail==null){
			marketDetail=new CardUseDetail(cardId, 2, (short)1, "0");
		}
		BigDecimal oldBalance=new BigDecimal(marketDetail.getCudAttvalue()==null?"0":marketDetail.getCudAttvalue());
		BigDecimal newBalacne=oldBalance.add(rechargeDTO.getMarketBalance());
		marketDetail.setCudAttvalue(newBalacne.toEngineeringString());
		cardUseDetailService.saveCardDetail(marketDetail);
//		cardInfoRepository.save(cardInfo);
		
		RechargeRecord newChargeRecord=new RechargeRecord();
		BigDecimal totalMoney=rechargeDTO.getCanteenBalance().add(rechargeDTO.getMarketBalance());
		newChargeRecord.setRechargeMoney(totalMoney);
		newChargeRecord.setUserId(rechargeDTO.getUserId());
		newChargeRecord.setRechargeType((short)rechargeDTO.getRechargeType());
//		newChargeRecord.setRrState(rrState);
//		newChargeRecord.setRrSource("");
		newChargeRecord.setBalance(oldBalance);
		newChargeRecord.setRechargeTime(new Timestamp(System.currentTimeMillis()));
		rechargeRecordRepository.save(newChargeRecord);
	}
}
