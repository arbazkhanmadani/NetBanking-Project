package com.arbaz.dto;

public class UserLoginDto {
	
	private String accno=null;
	private int mpin=0;
	private String question=null;
	private String answer=null;
	private double amount=0.0;
	private String selfAccountNumber=null;
	
	public String getSelfAccountNumber() {
		return selfAccountNumber;
	}
	public void setSelfAccountNumber(String selfAccountNumber) {
		this.selfAccountNumber = selfAccountNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public int getMpin() {
		return mpin;
	}
	public void setMpin(int mpin) {
		this.mpin = mpin;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	
}
