package com.canteen.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.canteen.manage.entity.ConsumeRecord;
import com.canteen.manage.entity.RechargeRecord;
import com.canteen.manage.service.ChargeConsumeService;
import com.canteen.manage.utils.ReturnJson;


/**
 * 消费记录和充值记录查询
 * @author nooze
 *
 */
@RestController
@RequestMapping(value = "record")
public class RecordController {

	@Autowired
	ChargeConsumeService chargeConsumeService;

	@RequestMapping(value = "consumePersonal")
	public ReturnJson<Page<ConsumeRecord>> personalConsumptionRecord(@RequestParam int userId,
			@RequestParam int currentPage, @RequestParam int pageSize) {
		Page<ConsumeRecord> page = chargeConsumeService.queryConsumeRecords(userId,
				currentPage, pageSize);
		return new ReturnJson<Page<ConsumeRecord>>(page);
	}
	
	@RequestMapping(value = "consumeGrade")
	public ReturnJson<Page<ConsumeRecord>> gradeConsumptionRecord(@RequestParam int gradeId,
			@RequestParam int currentPage, @RequestParam int pageSize) {
		Page<ConsumeRecord> page = chargeConsumeService.queryGradeConsumeRecords(gradeId, currentPage, pageSize);
		return new ReturnJson<Page<ConsumeRecord>>(page);
	}
	
	@RequestMapping(value = "rechargePersonal")
	public ReturnJson<Page<RechargeRecord>> personalRechargeRecord(@RequestParam int userId,
			@RequestParam int currentPage, @RequestParam int pageSize) {
		Page<RechargeRecord> page = chargeConsumeService.queryRechargeRecords(userId,
				currentPage, pageSize);
		return new ReturnJson<Page<RechargeRecord>>(page);
	}
	
	@RequestMapping(value = "rechargeGrade")
	public ReturnJson<Page<RechargeRecord>> gradeRechargeRecord(@RequestParam int gradeId,
			@RequestParam int currentPage, @RequestParam int pageSize) {
		Page<RechargeRecord> page = chargeConsumeService.queryGradeRechargeRecords(gradeId,
				currentPage, pageSize);
		return new ReturnJson<Page<RechargeRecord>>(page);
	}
	

}
