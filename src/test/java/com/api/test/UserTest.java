package com.api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.api.endpoints.UserEndPoints;
import com.api.payload.User;
import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class UserTest {
	UserEndPoints uertest = new UserEndPoints();
	Faker facker;
	User userPayLoad;

	@BeforeClass
	public void setupData() {
		facker = new Faker();
		userPayLoad = new User();

		userPayLoad.setId(facker.idNumber().hashCode());
		userPayLoad.setUsername(facker.name().username());
		userPayLoad.setFirstName(facker.name().firstName());
		userPayLoad.setLastName(facker.name().lastName());
		userPayLoad.setEmail(facker.internet().emailAddress());
		userPayLoad.setPassword(facker.internet().password(5, 10));
		userPayLoad.setPhone(facker.phoneNumber().cellPhone());
	}

	@Test()
	public void testPostuser() {
		Response response = uertest.createuser(userPayLoad);
		response.then().statusCode(201).log().all();

		Assert.assertEquals(response.getStatusCode(), 201);
	}

	@Test()
	public void testGetUserByName() {

		Response response = uertest.readUser(this.userPayLoad.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		response.then().log().all();
	}

	@Test
	public void updateUser() {

	}

}