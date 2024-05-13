package com.api.endpoints;
 
 
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
 
import com.api.payload.User;
 
import io.restassured.http.ContentType;
import io.restassured.response.Response;
 
 
public class UserEndPoints {
 
              
               public  Response createuser(User payload) {
                              Response responce=given().contentType(ContentType.JSON)
                              .accept(ContentType.JSON)
                              .body(payload)
                              .when().post(Routes.post_url);
                              return responce;
               }
              
               public Response readUser(String username) {
                              Response response=given().pathParam("username", username)
                              .when().get(Routes.get_url);
                              return response;
                             
               }
              
               public Response updateUser(String username,User payload) {
               Response response=given().contentType(ContentType.JSON)
                              .accept(ContentType.JSON)
                              .pathParam("username",username )
                              .when().put(Routes.put_url);
               return response;
               }
              
               public Response deleteUser(String username) {
                              Response response=given().pathParam("username", username)
                              .when().get(Routes.delete_url);
                              return response;
                             
               }
              
              
}