#Created by
Billy Infante
Ralf Fajardo
Thinh Minh To
Pakeerathan Chanderbala

Here is our soulution for task 17



#Index page
https://contacts-family-database.herokuapp.com


#routes for crud operations
https://contacts-family-database.herokuapp.com/api/person
https://contacts-family-database.herokuapp.com/api/family
https://contacts-family-database.herokuapp.com/api/address
https://contacts-family-database.herokuapp.com/api/phone
https://contacts-family-database.herokuapp.com/api/relationship
https://contacts-family-database.herokuapp.com/api/email



#how to find by id
#etc
https://contacts-family-database.herokuapp.com/api/person/{id}
https://contacts-family-database.herokuapp.com/api/family/{id}


#how to add data
use postman or curl for crud operations
#example
POST https://contacts-family-database.herokuapp.com/api/person
	{
		"firstname" : "Billy",
		"lastName" : "Infante",
		//keep in mind we are using java localDate format year-month-day
		"birthday" : "1996-02-02"
	}

PUT https://contacts-family-database.herokuapp.com/api/person/{id}
	
	{
		"attributes" : "changes"
		"attributes" : "changes"
		"attributes" : "changes"
		
	}
	
DELETE https://contacts-family-database.herokuapp.com/api/person/{id}

#Database
We are using postgresql on heroku for hosting our database

													Table
-------------------------------------------------------------------------------------------------------
Person			Email			Address				Phone			Relationship		Family
-------------------------------------------------------------------------------------------------------
id(pk)			id(pk)			id(pk)				id(pk)			id(pk)				id(pk)
firstname		current			addressref(fk)		phoneref(fk)	role				person_id(fk)
lastname		work			current				home								relative_id(fk)
birthday		emailref(fk)	work				work								relation_id(fk)
													mobile
--------------------------------------------------------------------------------------------------------
all the foreign key is connected to person table id, except of relation_id in family table that is connected to relationship id.








