package com.canteen.manage.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.canteen.manage.dto.CardInfoDTO;
import com.canteen.manage.dto.RechargeInfoDTO;
import com.canteen.manage.dto.StudentAndCardDTO;
import com.canteen.manage.dto.StudentDTO;
import com.canteen.manage.dto.TeacherAndCardDTO;
import com.canteen.manage.entity.CardInfo;
import com.canteen.manage.entity.Student;
import com.canteen.manage.entity.Teacher;
import com.canteen.manage.service.CardService;
import com.canteen.manage.service.ChargeConsumeService;
import com.canteen.manage.service.StudentService;
import com.canteen.manage.service.TeacherService;
import com.canteen.manage.utils.ReturnJson;

/**
 * @author nooze
 * 处理卡相关
 */
@RestController
@RequestMapping("card")
public class CardController {
	
	private static final Logger LOG=LoggerFactory.getLogger(CardController.class);
	
	@Autowired
	CardService cardService;
	
	@Autowired
	ChargeConsumeService chargeConsumeService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	TeacherService teacherService;
	
	/**
	 * 学生开卡
	 * @param studentAndCardDTO
	 * @return
	 */
	@RequestMapping("new")
	public ReturnJson<CardInfo> createCard(@RequestBody StudentAndCardDTO studentAndCardDTO){
		LOG.info("新开学生卡"+studentAndCardDTO);
		StudentDTO studentDTO=studentAndCardDTO.getStudent();
		Student student=studentService.createNewStudent(studentDTO);
		CardInfoDTO cardInfo=studentAndCardDTO.getCard();
		cardInfo.setUserId(student.getUserId());
		CardInfo newCard=cardService.createCard(cardInfo);
		return new ReturnJson<CardInfo>(newCard);
	}
	
	/**
	 * 教师开卡
	 * @param teacherAndCardDTO
	 * @return
	 */
	@RequestMapping("newCardForTeacher")
	public ReturnJson<CardInfo> createCardForTeacher(@RequestBody TeacherAndCardDTO teacherAndCardDTO){
		LOG.info("新开教师卡"+teacherAndCardDTO);
		Teacher teacher=teacherAndCardDTO.getTeacher();
		teacher=teacherService.createTeacher(teacher);
		CardInfoDTO cardInfo=teacherAndCardDTO.getCardInfo();
		cardInfo.setUserId(teacher.getUserId());
		CardInfo newCard=cardService.createCard(cardInfo);
		return new ReturnJson<CardInfo>(newCard);
	}
	
	/**
	 * 修改卡信息
	 * @param cardInfo
	 * @return
	 */
	@RequestMapping("update")
	public ReturnJson<Void> updateCard(@RequestBody CardInfo cardInfo){
		LOG.info("修改卡信息"+cardInfo);
		cardService.updateCardInfo(cardInfo);
		return new ReturnJson<Void>();
	}
	/**
	 * 根据用户ID查询卡信息
	 * @param userId
	 * @return
	 */
	@RequestMapping("query")
	public ReturnJson<CardInfo> queryCard(@RequestParam int userId){
		LOG.info("查询饭卡信息,用户ID:"+userId);
		CardInfo cardInfo=cardService.queryCardInfo(userId);
		return new ReturnJson<CardInfo>(cardInfo);
	}
	/**
	 * 设置零钱
	 * @param cardId
	 * @param type
	 * @param pocketMoney
	 * @return
	 */
	@RequestMapping("setPocketMoney")
	public ReturnJson<Void> setPocketMoney(@RequestParam int cardId,@RequestParam int type,@RequestParam String pocketMoney){
		LOG.info("设置零钱,饭卡ID:"+cardId+",type:"+type+",零钱为:"+pocketMoney);
		cardService.setPocketMoneyRule(cardId, type, pocketMoney);
		return new ReturnJson<Void>();
	}
	
	/**
	 * 设置消费时间
	 * @param cardId
	 * @param type
	 * @param state
	 * @return
	 */
	@RequestMapping("setConsumeTime")
	public ReturnJson<Void> setConsumeTimeRule(@RequestParam int cardId,@RequestParam int type,@RequestParam int state){
		LOG.info("设置消费时间,饭卡ID:"+cardId+",type:"+type+",state为:"+state);
		cardService.setConsumeTimeRule(cardId, type, (short)state);
		return new ReturnJson<Void>();
	}
	
	@RequestMapping("rechargePerson")
	public ReturnJson<Void> recharge(@RequestBody RechargeInfoDTO rechargeDTO){
		LOG.info("个人充值,"+rechargeDTO.toString());
		chargeConsumeService.rechargePerson(rechargeDTO);
		return new ReturnJson<Void>();
	}
	@RequestMapping("rechargeGrade")
	public ReturnJson<Void> rechargeGrade(@RequestBody RechargeInfoDTO rechargeDTO){
		LOG.info("班级充值,"+rechargeDTO.toString());
		chargeConsumeService.rechargeGrade(rechargeDTO);
		return new ReturnJson<Void>();
	}
}
