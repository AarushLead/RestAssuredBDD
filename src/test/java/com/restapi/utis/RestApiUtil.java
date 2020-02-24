package com.restapi.utis;

import org.apache.commons.lang3.RandomStringUtils;

public class RestApiUtil {

	public static String getFirstName()
	{
		String firstName = RandomStringUtils.randomAlphabetic(1);
		return "John"+firstName;
	}
	public static String getLastName()
	{
		 String lastName = RandomStringUtils.randomAlphabetic(3);
		 return "Michael"+lastName;
	}
	public static String getUserName()
	{
		String userName = RandomStringUtils.randomAlphabetic(5);
		return "John"+userName;
	}
	public static String getPassword()
	{
		String passowrd = RandomStringUtils.randomAlphanumeric(5);
		return passowrd;
	}
	public static String getEmail()
	{
		String email = RandomStringUtils.randomAlphabetic(4);
		return email+"@gmail.com";
	}

	public static String empSalary()
	{
		 String sal = RandomStringUtils.randomNumeric(5);
		 return sal;
	}
	public static String empAge()
	{
		String age = RandomStringUtils.randomNumeric(2);
		return age;
	}
}
