Feature: http://httpbin.org/ rest api tests 

Scenario Outline: : Check Http Status Code for GET 
	Given I request the endpoint "<URL>" 
	Then I check the status code "<Status Code>" 
	
	Examples: 
		|URL						| Status Code|
		|http://httpbin.org/get		| 200	     |
		|http://httpbin.org/ge		| 404	     |
		|http://httpbin.org/headers | 200		 |
		|http://httpbin.org/header  | 404		 |
		|http://httpbin.org/ip  	| 200		 |
		|http://httpbin.org/i  		| 404		 |
		
		
Scenario Outline: : Check response contant type for GET 
	Given I request the endpoint "<URL>" 
	Then I check the response contant type "<Contant Type>" 
	
	Examples: 
		|URL						| Contant Type			  |
		|http://httpbin.org/get		| application/json	      |
		|http://httpbin.org/ge		| text/html	    		  |
		|http://httpbin.org/headers | application/json		  |
		|http://httpbin.org/header  | text/html				  |
		
Scenario Outline: : Check Http Status Code for POST 
	Given I request the post endpoint "<URL>": 
		"""
			{
  				"origin": "52.22.60.255"
			}
			""" 
	Then I check the status code "<Status Code>" 
	
	Examples: 
		|URL						| Status Code|
		|http://httpbin.org/post	| 200	     |
		|http://httpbin.org/po		| 404	     |
		
Scenario Outline: : Check response contant for POST 
	Given I request the post endpoint "<URL>": 
		"""
			{
  				"origin": "52.22.60.255"
			}
			""" 
	Then I check the response contant with "<Element>" "<Contant>" 
	
	Examples: 
		|URL						| Element	| Contant	    	     |
		|http://httpbin.org/post	| origin	| 52.22.60.255           |
		
Scenario Outline: : Check response contant for GET 
	Given I request the endpoint "<URL>" 
	Then I check the response contant with "<Element>" "<Contant>" 
	
	Examples: 
		|URL						| Element	| Contant	    	     |
		|http://httpbin.org/get		| origin	| 52.22.60.255           |
		|http://httpbin.org/get		| url	    | http://httpbin.org/get |
		|http://httpbin.org/ip 		| origin	| 52.22.60.255           |
		