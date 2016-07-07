package com.canteen.manage.dto;

import com.canteen.manage.entity.Teacher;

public class TeacherAndCardDTO {
	private Teacher teacher;
	private CardInfoDTO cardInfo;
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public CardInfoDTO getCardInfo() {
		return cardInfo;
	}
	public void setCardInfo(CardInfoDTO cardInfo) {
		this.cardInfo = cardInfo;
	}

	
}
