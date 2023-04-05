/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.temple.edu.ebs;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Alex
 */
public class GBVal {
    //admin =1  customer =0
    public static boolean isAuto=false;
    private static int identity = -1;
    private static String customerid=""; 
    private static int billid = -1;
    
    
    //bill
    private static int dueday=0;
   
    
    //bill 
    public static int getDueday() {
        return dueday;
    }
    
    public static void setDueday(int set_Dueday) {
        dueday=set_Dueday;
    }
    
    //role 
    public static int getRole() {
        return identity;
    }
    
    public static void setRole(int set_identity) {
        identity=set_identity;
    }

    //customer id
    public static String getCustomerID() {
        return customerid;
    }
    
    public static void setCustomerID(String set_identity) {
        customerid=set_identity;
    }

    //bill id
    public static int getBillID() {
        return billid;
    }
    
    public static void setBillID(int set_identity) {
        billid=set_identity;
    }    
    
    //create customer ID
    public static String timeStamp(){  
         long time = System.currentTimeMillis();
         String t = String.valueOf(time);  
         return t;  
    }  
    
    //md5 password
    public static String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}
