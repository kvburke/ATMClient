package com.burke;




import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Account implements Serializable {
private static final long serialVersionUID = -501896252367061196L;
private int accountnumber;
private String username;
private String password;
private String message;
private String history;
private int creditscore;
private double savingsbalance;
private double currentbalance;
private double deposit;
private double withdraw;

public int getAccountnumber() {
	return accountnumber;
}
public void setAccountnumber(int accountnumber) {
	this.accountnumber = accountnumber;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getHistory() {
	return history;
}
public void setHistory(String history) {
	this.history = history;
}
public int getCreditscore() {
	return creditscore;
}
public void setCreditscore(int creditscore) {
	this.creditscore = creditscore;
}
public double getSavingsbalance() {
	return savingsbalance;
}
public void setSavingsbalance(double savingsbalance) {
	this.savingsbalance = savingsbalance;
}
public double getCurrentbalance() {
	return currentbalance;
}
public void setCurrentbalance(double currentbalance) {
	this.currentbalance = currentbalance;
}
public double getDeposit() {
	return deposit;
}
public void setDeposit(double deposit) {
	this.deposit = deposit;
}
public double getWithdraw() {
	return withdraw;
}
public void setWithdraw(double withdraw) {
	this.withdraw = withdraw;
}






}

