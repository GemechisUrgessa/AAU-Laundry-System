#Fundamentals of web design and programming group assignment.
# AAU-Laundry-System

The system we aimed to develop is the  AAU laundry system. Most universities in the developed countries serve their students with  a laundry service and here in our university a place for laundry is provided but it's not modern and it doesn't match a first generation university.
This laundry is different from other laundries because it gives service only for AAU students and the service fee is very low. Students used to face a lot of challenges to wash their clothes and they waste a lot of time while waiting till it gets dry. Besides, they used to lose their clothes, they got stolen a number of times. The environment was not suitable for handicapped students too. Our system uses the students ID for authentication service and gives the service for each student by reaching into their dorms. Rather than the payment maid for the laundry itself, the delivery service won't cost them a penny. 

Features:-
 =>The System will allow sign up of new users to the laundry system 
Users signing up for the system will be verified to ensure that they are student of Addis Ababa University.
 =>The authentication will be done based on the Student ID and email that is stored on the school database.
 =>The system will provide a list of cloth categories that are supported by the organization for wash.
 =>The user can select the type of cloth they want to get washed and select the quantity of the cloth item, then they will immediately be notified the total price amount they would pay.
 =>The system will provide two options for the users in case of delivering their clothes to the laundry. These are, either by themselves or having it delivered by the delivery personnel of the laundry.
 =>The system will generate a random code for order ID.
 =>The user can  create account by signing up, login, change/ update their profile and also delete their account.
 =>The system will allow certain features based on access control.
 =>The system will show the admin how many users have signed up, how much income has generated,  how many closes are currently ordered for wash, finished laundry process, waiting for delivery using categories.
 =>The system will provide update options for the system admin related to change of the laundry cost of any cloth items or any other changes, provide a dashboard for assigning, revoking, managing permissions.
 =>The system will allow the laundry personnel to set or update wash status, delivery status and payment status of any order.
 =>The system will provide notification for the users when their laundry is done.
 =>The users can provide comments and suggestions.
 =>The admin is the one with the full credentials to create, update and delete data from the database. 
 
 General overview of the website 
  1, for the website we use database schema with name "aaulaundry" and password of 43410@GMl
  2, We have created two admins with username for admin one as "adminOne" and for admin two as "adminTwo".
     For admin one the password is 123456 and for admin two the password is 654321
  3, we have created two student accounts with ID "UGR/2004/12" and "UGR/1131/12" and password of "password" for each.
  4, the website allows only registration of AAU students, for that purpose we have created a sample table name "record"
     to store sample Students IDs with their name. A student can only register if he/she entered their ID along with 
     the correct name of the student that is stored in the record table.
     As a sample we have added 8 students with their ID and Name in the record table, the sample student  entery is as follows:
    
       1  ABEMELECH MESFIN   UGR/3257/12      
       2  BAHAILU ABERA      UGR/3464/12  
       3  Bereket ASNAKE     UGR/9574/12  
       4  BIRUK TASSEW       UGR/2004/12  
       5  EDEN TADDESE       UGR/5256/12   
       6  KIDUS SINTAYEHU    UGR/8503/12     
       7  SIMON MEKONNEN     UGR/9508/12  
       8  YSIHAK BAZEZEW     UGR/1131/12  


  since the assumption is that the laundry will use a database filled with students Full names and Usernames as an ID of AAU Students ,which
  is if,provided and all the names and id's are filled on the record table the system will manage to secure only the ones whose 
  info is on the database to get registered.
  
  since biruk tassew and ysihak bazezew have been alrady registered as a sample student user, it is not possible to create a new account with their ID

  5, we have added 6 Cloth types and their price to the table cloth which can later be edited by the admin
  6, the update feature allows a user to update its peronal infos as well as the password at the same time. 
  6, we have used command line runner interface to add the above sample datas to the database table
 
 
#Group members:-
Name                            ID                            Section
1. MELAT ERMIYAS            UGR/8994/12                      Section 3
2. GETNET   ADUGNA          UGR/3381/12                      Section 3
3. ZEAMANUAL FELEKE         UGR/8657/12                      Section 3
4. GEMECHIS URGESSA         UGR/7128/12                      Section 3
5. ZENAMARKOS MOLLA         UGR/4176/12                      Section 3


