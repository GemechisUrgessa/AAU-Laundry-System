package com.web_project.aau_laundry_system;

import com.web_project.aau_laundry_system.Services.CampusService;
import com.web_project.aau_laundry_system.Services.ClotheServices;
import com.web_project.aau_laundry_system.Services.RecordService;
import com.web_project.aau_laundry_system.Services.UserServices;
import com.web_project.aau_laundry_system.models.Campus;
import com.web_project.aau_laundry_system.models.Clothe;
import com.web_project.aau_laundry_system.models.Record;
import com.web_project.aau_laundry_system.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AauLaundrySystemApplication implements CommandLineRunner {
  @Autowired
  CampusService campusService;
  @Autowired
  RecordService recordService;
  @Autowired
  ClotheServices clotheServices;
  @Autowired 
  UserServices userServices;
  @Autowired
  PasswordEncoder passwordEncoder;

  public static void main(String[] args) {
    SpringApplication.run(AauLaundrySystemApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

    // adding sample campus lists to the database
    Campus campusOne = new Campus("AAiT");
    Campus campusTwo = new Campus("CNCS");
    Campus campusThree = new Campus("MAIN CAMPUS");
    Campus campusFour = new Campus("EiABC");
    campusService.addCampus(campusOne);
    campusService.addCampus(campusTwo);
    campusService.addCampus(campusThree);
    campusService.addCampus(campusFour);
      
    //adding sample cloth types with wash price to the database
    Clothe clothOne = new Clothe("BLANKET",15);
    clotheServices.saveClothe(clothOne);
    Clothe clothTwo = new Clothe("DRESS",3.5f);
    clotheServices.saveClothe(clothTwo);
    Clothe clothThree = new Clothe("HOODIES",4);
    clotheServices.saveClothe(clothThree);
    Clothe clothFour = new Clothe("JACKET",5);
    clotheServices.saveClothe(clothFour);
    Clothe clothFive = new Clothe("JEANS AND PANTS",4.5f);
    clotheServices.saveClothe(clothFive);
    Clothe clothSix = new Clothe("T-SHIRT",2);
    clotheServices.saveClothe(clothSix);

    //adding sample users with admin level privilege

    User adminOne = new User();
    adminOne.setFirstName("Melaku");
    adminOne.setLastName("Solomon");
    adminOne.setEmail("melaku@Gmail.com");
    adminOne.setPhoneNumber("0964557813");
    adminOne.setUsername("adminOne");
    adminOne.setPassword(passwordEncoder.encode("123456"));
    adminOne.setRole("ADMIN");
    userServices.saveUser(adminOne);

    User adminTwo = new User();
    adminTwo.setFirstName("Bruk");
    adminTwo.setLastName("Mikiyas");
    adminTwo.setEmail("bruk@Gmail.com");
    adminTwo.setPhoneNumber("0987654214");
    adminTwo.setUsername("adminTwo");
    adminTwo.setPassword(passwordEncoder.encode("654321"));
    adminTwo.setRole("ADMIN");
    userServices.saveUser(adminTwo);

	Record recordOne = new Record("UGR/3257/12","ABEMELECH MESFIN");
    recordService.createRecord(recordOne);
    Record recordTwo = new Record("UGR/3464/12","BAHAILU ABERA");
    recordService.createRecord(recordTwo);
    Record recordThree = new Record("UGR/9574/12","Bereket ASNAKE");
    recordService.createRecord(recordThree);
    Record recordFour = new Record("UGR/2004/12","BIRUK TASSEW");
    recordService.createRecord(recordFour);
    Record recordFive = new Record("UGR/5256/12","EDEN TADDESE");
    recordService.createRecord(recordFive);
    Record recordSix = new Record("UGR/8503/12","KIDUS SINTAYEHU");
    recordService.createRecord(recordSix);
    Record recordSeven = new Record("UGR/9508/12","SIMON MEKONNEN");
    recordService.createRecord(recordSeven);
    Record recordEight = new Record("UGR/1131/12","YSIHAK BAZEZEW");
    recordService.createRecord(recordEight);

    //creating sample users with a just a user level privilege
    
    // User
	User studentOne = new User();
    studentOne.setFirstName("BIRUK");
    studentOne.setLastName("TASSEW");
    studentOne.setEmail("burik@gmail.com");
    studentOne.setPhoneNumber("0987654214");
    studentOne.setUsername("UGR/2004/12");
    studentOne.setCampus("AAiT");
    studentOne.setPassword(passwordEncoder.encode("password"));
    studentOne.setRole("USER");
    userServices.saveUser(studentOne);


    User studentTwo = new User();
    studentTwo.setFirstName("BAZEZEW");
    studentTwo.setLastName("YSIHAK");
    studentTwo.setEmail("ysu@gmail.com");
    studentTwo.setPhoneNumber("0987654214");
    studentTwo.setUsername("UGR/1131/12");
    studentTwo.setCampus("AAiT");
    studentTwo.setPassword(passwordEncoder.encode("password"));
    studentTwo.setRole("USER");
    userServices.saveUser(studentTwo);
  
  }  
}
    //adding sample student record in record table for sign up verification
