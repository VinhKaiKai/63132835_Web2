package com.checongbinh.Nexflix.model;

import java.util.Date;

public class User {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.id
	 * @mbg.generated  Mon Apr 22 07:49:29 ICT 2024
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.full_name
	 * @mbg.generated  Mon Apr 22 07:49:29 ICT 2024
	 */
	private String fullName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.user_name
	 * @mbg.generated  Mon Apr 22 07:49:29 ICT 2024
	 */
	private String userName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.user_password
	 * @mbg.generated  Mon Apr 22 07:49:29 ICT 2024
	 */
	private String userPassword;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.email
	 * @mbg.generated  Mon Apr 22 07:49:29 ICT 2024
	 */
	private String email;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.phone
	 * @mbg.generated  Mon Apr 22 07:49:29 ICT 2024
	 */
	private String phone;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.id
	 * @return  the value of user.id
	 * @mbg.generated  Mon Apr 22 07:49:29 ICT 2024
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.id
	 * @param id  the value for user.id
	 * @mbg.generated  Mon Apr 22 07:49:29 ICT 2024
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.full_name
	 * @return  the value of user.full_name
	 * @mbg.generated  Mon Apr 22 07:49:29 ICT 2024
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.full_name
	 * @param fullName  the value for user.full_name
	 * @mbg.generated  Mon Apr 22 07:49:29 ICT 2024
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.user_name
	 * @return  the value of user.user_name
	 * @mbg.generated  Mon Apr 22 07:49:29 ICT 2024
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.user_name
	 * @param userName  the value for user.user_name
	 * @mbg.generated  Mon Apr 22 07:49:29 ICT 2024
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.user_password
	 * @return  the value of user.user_password
	 * @mbg.generated  Mon Apr 22 07:49:29 ICT 2024
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.user_password
	 * @param userPassword  the value for user.user_password
	 * @mbg.generated  Mon Apr 22 07:49:29 ICT 2024
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.email
	 * @return  the value of user.email
	 * @mbg.generated  Mon Apr 22 07:49:29 ICT 2024
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.email
	 * @param email  the value for user.email
	 * @mbg.generated  Mon Apr 22 07:49:29 ICT 2024
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.phone
	 * @return  the value of user.phone
	 * @mbg.generated  Mon Apr 22 07:49:29 ICT 2024
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.phone
	 * @param phone  the value for user.phone
	 * @mbg.generated  Mon Apr 22 07:49:29 ICT 2024
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
}