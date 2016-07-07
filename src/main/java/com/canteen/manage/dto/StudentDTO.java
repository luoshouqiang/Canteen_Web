package com.canteen.manage.dto;

import java.util.Date;

public class StudentDTO {
		private int parentId;
		private String parentName;
		private String parentPhone;
		private String name;
		private int gradeId;
		private String number;
		private Date registerTime;
		public int getParentId() {
			return parentId;
		}
		public void setParentId(int parentId) {
			this.parentId = parentId;
		}
		public String getParentName() {
			return parentName;
		}
		public void setParentName(String parentName) {
			this.parentName = parentName;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getGradeId() {
			return gradeId;
		}
		public void setGradeId(int gradeId) {
			this.gradeId = gradeId;
		}
		public String getNumber() {
			return number;
		}
		public void setNumber(String number) {
			this.number = number;
		}
		public Date getRegisterTime() {
			return registerTime;
		}
		public void setRegisterTime(Date registerTime) {
			this.registerTime = registerTime;
		}
		public String getParentPhone() {
			return parentPhone;
		}
		public void setParentPhone(String parentPhone) {
			this.parentPhone = parentPhone;
		}
		@Override
		public String toString() {
			return "StudentDTO [parentId=" + parentId + ", parentName="
					+ parentName + ", parentPhone=" + parentPhone + ", name="
					+ name + ", gradeId=" + gradeId + ", number=" + number
					+ ", registerTime=" + registerTime + "]";
		}
		
		
}
