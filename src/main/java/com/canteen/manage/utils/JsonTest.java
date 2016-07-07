package com.canteen.manage.utils;

import java.math.BigDecimal;
import java.util.Date;

import com.canteen.manage.dto.CardInfoDTO;
import com.canteen.manage.dto.RechargeInfoDTO;
import com.canteen.manage.dto.StudentAndCardDTO;
import com.canteen.manage.dto.StudentDTO;
import com.canteen.manage.dto.TeacherAndCardDTO;
import com.canteen.manage.entity.CardInfo;
import com.canteen.manage.entity.Student;
import com.canteen.manage.entity.Teacher;
import com.canteen.manage.entity.User;

public class JsonTest {
	
	public static void main(String[] args) {
		User user=new User();
		user.setId(1);
		user.setName("李明");
		user.setPhone("1365555999");
		user.setType(1);
		user.setHeadUrl("http://xxx.com");
		ReturnJson<User> jsonObject=new ReturnJson<User>(user);
		
		
		StudentDTO dto=new StudentDTO();
		dto.setGradeId(1);
		dto.setName("李明");
		dto.setNumber("1234");
//		dto.setParentId(1);
		dto.setParentName("李刚");
		dto.setParentPhone("13533333333");
		dto.setRegisterTime(new Date());
		
		Student student=new Student();
		student.setClassId(1);
		student.setEnrolTime(new Date());
		student.setId(1);
		student.setName("李明");
		student.setNumber("1234");
		student.setStatus(1);
		student.setUserId(2);
		
		CardInfo card=new CardInfo();
		card.setBalance(BigDecimal.ONE);
		card.setId(1);
		card.setRealId("12345");
		card.setState((short)1);
		card.setType((short)1);
		card.setUserId(1);
		
		CardInfo cardInfo=new CardInfo();
		cardInfo.setBalance(new BigDecimal("2.55"));
		card.setId(1);
		
		StudentAndCardDTO studentAndCard=new StudentAndCardDTO();
		StudentDTO studentDTO=new StudentDTO();
		dto.setGradeId(1);
		dto.setName("李明");
		dto.setNumber("1234");
//		dto.setParentId(1);
		dto.setParentName("李刚");
		dto.setParentPhone("13533333333");
		dto.setRegisterTime(new Date());
		
		CardInfoDTO cardInfoDTO=new CardInfoDTO();
		cardInfoDTO.setCanteenBalance(new BigDecimal("6"));
		cardInfoDTO.setMarketBalance(new BigDecimal("3"));
		cardInfoDTO.setPerPayMoney(new BigDecimal("3"));
		cardInfoDTO.setType((short)1);
		cardInfoDTO.setUserId(1);
		studentAndCard.setCard(cardInfoDTO);
		studentAndCard.setStudent(studentDTO);
		
		TeacherAndCardDTO teacherAndCardDTO=new TeacherAndCardDTO();
		Teacher teacher=new Teacher();
		teacher.setHead(1);
		teacher.setManager(1);
		teacher.setName("李思");
		teacher.setPhone("13566666666");
		teacher.setSchoolId(1);
		teacher.setUserId(2);
		teacherAndCardDTO.setCardInfo(cardInfoDTO);
		teacherAndCardDTO.setTeacher(teacher);
		
		RechargeInfoDTO rechargeDTO=new RechargeInfoDTO();
		rechargeDTO.setCardId(1);
		rechargeDTO.setRechargeType(1);
		rechargeDTO.setUserId(1);
		System.out.println(JsonUtil.objToJson(rechargeDTO));
	}
}
