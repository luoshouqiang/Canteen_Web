package com.canteen.manage;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.engine.spi.PersistenceContext;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.canteen.manage.constant.ConstantType;
import com.canteen.manage.controller.UserServer;
import com.canteen.manage.dto.CardInfoDTO;
import com.canteen.manage.dto.StudentDTO;
import com.canteen.manage.entity.CardInfo;
import com.canteen.manage.entity.Student;
import com.canteen.manage.service.CardService;
import com.canteen.manage.service.StudentService;
import com.canteen.manage.service.TeacherService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes={UserServer.class,PersistenceContext.class})
public class CardServiceTest {
	@Autowired
	CardService cardService;
	@Autowired
	StudentService studentService;
	@Autowired
	TeacherService teacherService;
	@BeforeClass
	public  static void init(){
		System.setProperty("spring.config.name", "manager-server");
	}
	
	@Test
//	@Transactional
//	@Rollback
	public void  testCreateCard(){
		CardInfoDTO cardInfo=new CardInfoDTO();
		cardInfo.setCanteenBalance(BigDecimal.TEN);
		cardInfo.setMarketBalance(BigDecimal.ONE);
		cardInfo.setPerPayMoney(BigDecimal.ONE);
		cardInfo.setUserId(1);
		cardInfo.setRealId("1234");
		cardInfo.setState((short)1);
		cardInfo.setType((short)1);
		cardService.createCard(cardInfo);
		CardInfo baseCard=cardService.queryCardInfo(1);
		Assert.assertNotEquals(0, baseCard.getId());
		
	}
	
	@Test
	public void testCreateStudent(){
		StudentDTO student=new StudentDTO();
		student.setGradeId(1);
		student.setName("xiao");
		student.setNumber("1234");
		student.setParentId(1);
		student.setParentPhone("13455555556");
		student.setRegisterTime(new Date());
		Student st=studentService.createNewStudent(student);
		Assert.assertNotEquals(0, st.getId());
	}
	
	@Test
	public void testSetRule(){
		cardService.setConsumeTimeRule(1, 3, (short)1);
	}
	
	
	

}
