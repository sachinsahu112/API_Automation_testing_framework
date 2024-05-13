package com.api.endpoints;
 
//post request = petstore.swagger.io/v2/user/
//get request = petstore.swagger.io/v2/user/{username}
//update request = petstore.swagger.io/v2/user/{username}
//delete request = petstore.swagger.io/v2/user/user/{username}
 
 
public class Routes {
      
       public static String base_url="petstore.swagger.io/v2";
      
       public static String post_url=base_url+"/user";
       public static String get_url=base_url+"/user/{username}";
       public static String put_url=base_url+"/user/{username}";
       public static String delete_url=base_url+"/user/{username}";
 
}