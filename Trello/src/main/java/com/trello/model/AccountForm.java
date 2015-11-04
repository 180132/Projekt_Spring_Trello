package com.trello.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class AccountForm {
	
	//Dane osobowe
	private String username;
	private String password;
	private String confirmPassword;
	private String firstName;
	private String lastName;
	private String email;
	
	//Zgoda na informacje marketingowe
	private boolean marketingOk = true;
	//Potwierdzenie umowy
	private boolean acceptTerms = false;
	
	public String getUsername(){
		return username;
	}
	
	public void setUsername(String username){
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isMarketingOk() {
		return marketingOk;
	}

	public void setMarketingOk(boolean marketingOk) {
		this.marketingOk = marketingOk;
	}

	public boolean isAcceptTerms() {
		return acceptTerms;
	}

	public void setAcceptTerms(boolean acceptTerms) {
		this.acceptTerms = acceptTerms;
	}

	public String toString(){
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append("username", username)
				.append("firstName", firstName)
				.append("lastName", lastName)
				.append("email", email)
				.append("marketingOk", marketingOk)
				.append("acceptTerms", acceptTerms)
				.toString();
	}

}
