# Role-Based-Auth-System
Create a role based authorization system to restrict access to certain resources

Implement a role based auth system. System should be able to assign a role to user and remove a user from the role.

Entities are USER, ACTION TYPE, RESOURCE, ROLE

ACTION TYPE defines the access level(Ex: READ, WRITE, DELETE)

Access to resources for users are controlled strictly by the role.One user can have multiple roles. Given a user, action type and resource system should be able to tell whether user has access or not.

Please list down the assumptions made. Scope out things if you feel this takes more than 3 hours and add them to assumptions.

Note:
1. Use any object oriented programming language.
2. Code should be maintainable and production ready
3. Follow the best practices of engineering and design patterns.

---------------------------------------------------------------------------------------------------------------------
**PREREQUISITIES:**
1.	Java 1.7,
2.	MySql
3.	Maven

**RUN:**
1.	Change database.properties file under resources and add mysql username and password
2.	Run init_data.sql from under resources, before starting the project to load all tables in db.
    Type _source <filePath>_ of init_data.sql in sql commandLine
3.	Run the class AuthorizationTest.java from package main
---------------------------------------------------------------------------------------------------------------------  
**Class Diagram:**
![]({{site.baseurl}}/https://raw.githubusercontent.com/supriyajaha/Role-Based-Auth-System/master/Capture.JPG)




**Tables**: USER, ROLE, RESOURCE, ACTIONTYPE

**Mapping Tables:**
1.	ROLE_ACTION_TYPE
Contains role ids and allowed actions_types ids for that role
2.	USER_RESOURCE_ROLE
Contains User ids, resource ids and allowed role ids for that user and resource combination

**ROLE ACTION TYPE VALUES:**
1.	Admin Role has read, update, create,delete allowed action types
2.	Guest Role has only read action type
3.	Employee_Team_A has read and update as allowed action types
4.	Employee_Team_B has read and update as allowed action types

**USER RESOURCE ROLE VALUES:**
1.	dylan_locus has admin role on all resources. So this user can do everything.
2.	robin_locus has guest role on all resources. So this user can only read.
3.	manu_locus has employee_team_a role on file_team_a. So this user can read and update file_team_a. But, can only read file_team_b.
4.	sameer_locus has employee_team_b role on file_team_b. So this user can read and update file_team_b. But, can only read file_team_a.


**LOGIC:**

_1.	Input : robin_locus, file_team_a, read_
- Input is validated for empty and null checks
- Query is formed by joining USER_RESOURCE_ROLE to USER, RESOURCE,ROLE and ROLE to ACTION_TYPE
- First robin_locus and file_team_a is queried on USER_RESOURCE_ROLE and allowed ROLES for that username and resource is found which is GUEST.
- Then ACTION_TYPES are queried for role GUEST which is read
- As given action_type is present in allowed action_type, request is authorized


_2.	Input: manu_locus_a, file_team_b, update_
- Input is validated for empty and null checks
- Query is formed by joining USER_RESOURCE_ROLE to USER, RESOURCE,ROLE and ROLE to ACTION_TYPE
- First manu_locus and file_team_b is queried on USER_RESOURCE_ROLE and allowed ROLES for that username and resource which is EMPLOYEE_TEAM_A.
- Then ACTION_TYPES are queried for role EMPLOYEE_TEAM_A which is read
- As given action_type – update is not present in allowed action_type, request is not authorized

