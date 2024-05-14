package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.endpoints.UserEndPoints;
import com.api.payload.User;
import com.api.utilities.DataProvidersClass;

import io.restassured.response.Response;

public class DataProviderTest {
	User userPayload = new User();
	UserTest ut = new UserTest();
	UserEndPoints uertest = new UserEndPoints();

	@Test(priority=1,dataProvider="data", dataProviderClass=DataProvidersClass.class)
 public void testPostUser(String UserId,String UserName, String fristName, String LastName, String Email,String Password,String Phone) {
        userPayload.setId(Integer.parseInt(UserId));
        userPayload.setUsername(UserName);
        userPayload.setFirstName(fristName);
        userPayload.setLastName(LastName);
        userPayload.setEmail(Email);
        userPayload.setPassword(Password);
        userPayload.setPhone(Phone);
 
        Response response=uertest.createuser(userPayload);

        Assert.assertEquals(response.getStatusCode(),201);
	}

     @Test(priority=2,dataProvider="userName",dataProviderClass=DataProvidersClass.class)
        public void testDeleteUserByName(String userName) {
        	Response responce=uertest.deleteUser(userName);
        	Assert.assertEquals(responce,200);
        	}

}
