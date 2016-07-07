package com.canteen.manage.service;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.canteen.manage.dto.CardInfoDTO;
import com.canteen.manage.dto.RechargeInfoDTO;
import com.canteen.manage.entity.CardInfo;
import com.canteen.manage.entity.CardRecord;
import com.canteen.manage.entity.CardUseDetail;
import com.canteen.manage.entity.CardUseDetailPK;
import com.canteen.manage.entity.CardUseRule;
import com.canteen.manage.ex.BusinessException;
import com.canteen.manage.repositories.CardInfoRepository;
import com.canteen.manage.repositories.CardRecordRepository;
import com.canteen.manage.repositories.CardUseDetailRepository;
import com.canteen.manage.repositories.CardUseRuleRepository;
import com.canteen.manage.repositories.StudentRepository;

/**
 * @author nooze
 * 处理饭卡相关的业务，包括开卡和设置限制
 */
@Service
@Transactional
public class CardService {

	@Autowired
	CardInfoRepository cardInfoRepository;
	
	@Autowired
	CardUseRuleRepository ruleRepository;
	
	@Autowired
	CardUseDetailRepository useDetailRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CardRecordRepository cardRecordRepository;
	
	@Autowired
	ChargeConsumeService chargeConsumeService;
	
	/**
	 * 开卡
	 * @param cardInfo
	 * @return
	 */
	public CardInfo createCard(CardInfoDTO cardInfo){
		if(cardInfo==null||
				cardInfo.getUserId()==0
				||cardInfo.getType()==0
				||cardInfo.getState()==0
				||StringUtils.isEmpty(cardInfo.getRealId())
				||cardInfo.getCanteenBalance()==null
				||cardInfo.getPerPayMoney()==null){
			throw new BusinessException(410,"请填写完整的开卡数据");
		}
		newCardRecord(cardInfo);
		CardInfo baseCardInfo=convertToCardInfo(cardInfo);	
		
		baseCardInfo= cardInfoRepository.save(baseCardInfo);
		rechargeRecord(cardInfo, baseCardInfo);	
		return baseCardInfo;
	}

	private void newCardRecord(CardInfoDTO cardInfo) {
		CardRecord record=new CardRecord();
		record.setCardId(cardInfo.getId());
		record.setCardType(cardInfo.getType());
		record.setCreateTime(new Timestamp(System.currentTimeMillis()));
		record.setUserId(cardInfo.getUserId());
		cardRecordRepository.save(record);
	}

	private void rechargeRecord(CardInfoDTO cardInfo, CardInfo baseCardInfo) {
		RechargeInfoDTO rechargeInfoDTO=new RechargeInfoDTO();
		rechargeInfoDTO.setUserId(cardInfo.getUserId());
		rechargeInfoDTO.setCardId(baseCardInfo.getId());
		rechargeInfoDTO.setCanteenBalance(cardInfo.getCanteenBalance());
		rechargeInfoDTO.setMarketBalance(cardInfo.getMarketBalance());
		rechargeInfoDTO.setPerPayMoney(cardInfo.getPerPayMoney());
		chargeConsumeService.recharge(rechargeInfoDTO);
	}
	
	/**
	 * 修改卡信息
	 * @param cardInfo
	 */
	public void updateCardInfo(CardInfo cardInfo){
		if(cardInfo==null||
				cardInfo.getId()==0){
			throw new BusinessException(410,"请选择需要修改的卡");
		}
	
		cardInfoRepository.save(cardInfo);
	}
	
	public void unbind(CardInfo cardInfo){
		cardInfo.setState((short)2);
		cardInfo.setUserId(0);
		cardInfo.setBalance(BigDecimal.ZERO);
		CardUseDetailPK pk=new CardUseDetailPK();
		pk.setAttributeId(1);
		pk.setCardId(cardInfo.getId());
		CardUseDetail cardUseDetail=useDetailRepository.findOne(pk);
		cardUseDetail.setCudAttvalue("0");
		useDetailRepository.save(cardUseDetail);
		pk.setAttributeId(2);
		pk.setCardId(cardInfo.getId());
		cardUseDetail=useDetailRepository.findOne(pk);
		cardUseDetail.setCudAttvalue("0");
		useDetailRepository.save(cardUseDetail);
		
		cardInfoRepository.save(cardInfo);
	}
	
	/**
	 * 设置零钱限制
	 * @param cardId
	 * @param type
	 * @param pocketMoney
	 */
	public void setPocketMoneyRule(int cardId,int type,String pocketMoneyString){
		BigDecimal pocketMoney =new BigDecimal(pocketMoneyString);
		if(pocketMoney.compareTo(BigDecimal.ZERO)<=0){
			throw new BusinessException(410,"零花钱不能小于0，有意思么");
		}
		CardInfo cardInfo=cardInfoRepository.findOne(cardId);
		if(cardInfo==null){
			throw new BusinessException(401, "没有找到饭卡信息");
		}
		if(cardInfo.getBalance().compareTo(pocketMoney)<=0){
			throw new BusinessException(410,"零花钱不能大于等于余额");
		}
		CardUseRule rule=ruleRepository.findOne(type);
		if(rule==null){
			throw new BusinessException(410, "这个地方不支持设置零钱");
		}
		CardUseDetailPK detailPk = new CardUseDetailPK();
		detailPk.setCardId(cardId);
		detailPk.setAttributeId(rule.getCurId());
		CardUseDetail usedDetail = new CardUseDetail();
		usedDetail.setId(detailPk);
		usedDetail.setCudAttvalue(pocketMoney.toEngineeringString());
		useDetailRepository.save(usedDetail);
		
	}
	
	/**
	 * 设置时间限制
	 * @param cardId
	 * @param type
	 * @param state
	 */
	public void setConsumeTimeRule(int cardId,int type,short state){
		CardUseRule rule=ruleRepository.findOne(type);
		if(rule==null){
			throw new BusinessException(410, "不支持设置这个属性"+type);
		}
		CardUseDetailPK detailPk = new CardUseDetailPK();
		detailPk.setCardId(cardId);
		detailPk.setAttributeId(rule.getCurId());
		CardUseDetail usedDetail = new CardUseDetail();
		usedDetail.setId(detailPk);
		usedDetail.setCudState(state);
		useDetailRepository.save(usedDetail);
	}
	
	/**
	 * 查询卡信息
	 * @param userId
	 * @return
	 */
	public CardInfo queryCardInfo(int userId){
		return cardInfoRepository.findByUserId(userId);
	}
	
	public CardInfo queryCardInfo(String realId){
		Assert.notNull(realId);
		return cardInfoRepository.findByRealId(realId);
	}
	
	private CardInfo convertToCardInfo(CardInfoDTO cardInfoDTO){
		CardInfo cardInfo=new CardInfo();
		BeanUtils.copyProperties(cardInfoDTO, cardInfo);
		return cardInfo;
	}
	
}
