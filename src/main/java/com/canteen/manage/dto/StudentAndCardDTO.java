package com.canteen.manage.dto;


public class StudentAndCardDTO {
	private StudentDTO student;
	private CardInfoDTO card;
	public StudentDTO getStudent() {
		return student;
	}
	public void setStudent(StudentDTO student) {
		this.student = student;
	}
	
	public CardInfoDTO getCard() {
		return card;
	}
	public void setCard(CardInfoDTO card) {
		this.card = card;
	}
	@Override
	public String toString() {
		return "StudentAndCardDTO [student=" + student + ", card=" + card + "]";
	}
	
}
