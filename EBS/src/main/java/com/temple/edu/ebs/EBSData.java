package com.temple.edu.ebs;

import java.util.Date;

/**
 *
 * @author Alex
 */
public class EBSData {
    //Database fields
    //customer table
    private String customer_id=""; 
    private String username="";
    private String first_name=""; 
    private String middle_name=""; 
    private String last_name=""; 
    private Date date_of_birth; 
    private String gender=""; 
    private String city=""; 
    private String state=""; 
    private String address=""; 
    private String zip_code=""; 
    private String email_address=""; 
    private String phone=""; 
    private String password_hash=""; 
    private double balance=0.0; 
    private Date date_registered; 
    private Date date_unregistered; 
    //bill table
    private int bill_id=-1; 
    private Date start_date; 
    private Date end_date; 
    private long start_meter_no=0; 
    private long end_meter_no=0; 
    private double unit_price=0.0; 
    private double total_price=0.0; 
    private double total_paid=0.0; 
    private double penalty=0.0; 
    private int my_role=0;

    //set data
    public void set_customer_id(String CUSTOMER_ID) {
      this.customer_id=CUSTOMER_ID;
    }
    
    public void set_username(String USERNAME) {
     this.username=USERNAME;
    }

    public void set_first_name(String FIRST_NAME) {
         this.first_name=FIRST_NAME;
    }

    public void set_middle_name(String MIDDLE_NAME) {
         this.middle_name=MIDDLE_NAME;
    }

    public void set_last_name(String LAST_NAME) {
         this.last_name=LAST_NAME;
    }

    public void set_date_of_birth(Date DATE_OF_BIRTH) {
         this.date_of_birth=DATE_OF_BIRTH;
    }

    public void set_gender(String GENDER) {
         this.gender=GENDER;
    }

    public void set_city(String CITY) {
         this.city=CITY;
    }

    public void set_state(String STATE) {
         this.state=STATE;
    }

    public void set_address(String ADDRESS) {
         this.address=ADDRESS;
    }

    public void set_zip_code(String ZIP_CODE) {
         this.zip_code=ZIP_CODE;
    }

    public void set_email_address(String EMAIL_ADDRESS) {
         this.email_address=EMAIL_ADDRESS;
    }

    public void set_phone(String PHONE) {
         this.phone=PHONE;
    }

    public void set_password_hash(String PASSWORD_HASH) {
         this.password_hash=PASSWORD_HASH;
    }

    public void set_balance(double BALANCE) {
         this.balance=BALANCE;
    }

    public void set_date_registered(Date DATE_REGISTERED) {
         this.date_registered=DATE_REGISTERED;
    }

    public void set_date_unregistered(Date DATE_UNREGISTERED) {
         this.date_unregistered=DATE_UNREGISTERED;
    }

    public void set_bill_id(int BILL_ID) {
         this.bill_id=BILL_ID;
    }

    public void set_start_date(Date START_DATE) {
         this.start_date=START_DATE;
    }

    public void set_end_date(Date END_DATE) {
         this.end_date=END_DATE;
    }

    public void set_start_meter_no(long START_METER_NO) {
         this.start_meter_no=START_METER_NO;
    }

    public void set_end_meter_no(long END_METER_NO) {
         this.end_meter_no=END_METER_NO;
    }

    public void set_unit_price(double UNIT_PRICE) {
         this.unit_price=UNIT_PRICE;
    }

    public void set_total_price(double TOTAL_PRICE) {
         this.total_price=TOTAL_PRICE;
    }
    
    public void set_total_paid(double TOTAL_PAID) {
         this.total_paid=TOTAL_PAID;
    }
    
    public void set_penalty(double TOTAL_PENALTY) {
         this.penalty=TOTAL_PENALTY;
    }
    
    public void set_role(int iROLE) {
        this.my_role = iROLE;
    }    
    
    //get data 
    public String get_customer_id() {
         return this.customer_id;
    }

    public String get_username() {
         return this.username;
    }    

    public String get_first_name() {
         return this.first_name;
    }

    public String get_middle_name() {
         return this.middle_name;
    }

    public String get_last_name() {
         return this.last_name;
    }

    public Date get_date_of_birth() {
         return this.date_of_birth;
    }

    public String get_gender() {
         return this.gender;
    }

    public String get_city() {
         return this.city;
    }

    public String get_state() {
         return this.state;
    }

    public String get_address() {
         return this.address;
    }

    public String get_zip_code() {
         return this.zip_code;
    }

    public String get_email_address() {
         return this.email_address;
    }

    public String get_phone() {
         return this.phone;
    }

    public String get_password_hash() {
         return this.password_hash;
    }

    public double get_balance() {
         return this.balance;
    }

    public Date get_date_registered() {
         return this.date_registered;
    }

    public Date get_date_unregistered() {
         return this.date_unregistered;
    }

    public int get_bill_id() {
         return this.bill_id;
    }

    public Date get_start_date() {
         return this.start_date;
    }

    public Date get_end_date() {
         return this.end_date;
    }

    public long get_start_meter_no() {
         return this.start_meter_no;
    }

    public long get_end_meter_no() {
         return this.end_meter_no;
    }

    public double get_unit_price() {
         return this.unit_price;
    }

    public double get_total_price() {
         return this.total_price;
    }

    public double get_total_paid() {
         return this.total_paid;
    }

    public double get_penalty() {
         return this.penalty;
    }    
    
    public int get_role(){
        return this.my_role;
    }
    
}
