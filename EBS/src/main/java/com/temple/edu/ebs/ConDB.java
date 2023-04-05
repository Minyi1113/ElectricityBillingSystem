/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.temple.edu.ebs;


import java.sql.DriverManager;
import java.sql.SQLException;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.sql.Connection;

/**
 *
 * @author Alex
 */
public class ConDB {
    private Connection ConnRtn = null;
    private Session session = null;

    public Connection connect() throws SQLException {
        int lport=5456;
        String Ec2UserName="ec2-user";
        String Ec2host="ec2-54-237-64-93.compute-1.amazonaws.com";
        
        String DBUserName="admin";
        String DBhost="ebsdb.c5ofayxvabia.us-east-1.rds.amazonaws.com";
        String DBPassword="Ebs3296&final";
        int DBport=3306;
        
        String url = "jdbc:mysql://localhost:"+lport+"/ebs?characterEncoding=utf-8";
        String driverName="com.mysql.jdbc.Driver";
        
        JSch jsch = new JSch();

        
        String privateKeyPath = System.getProperty("user.dir")+"\\src\\main\\java\\com\\temple\\edu\\ebs\\NEWEBS.pem";
        
        try {
            jsch.addIdentity(privateKeyPath);	    
            session = jsch.getSession(Ec2UserName, Ec2host, 22);
            session.setConfig("PreferredAuthentications", "publickey,keyboard-interactive,password");
            java.util.Properties config = new java.util.Properties(); 
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            //session.connect();
            //int assinged_port=session.setPortForwardingL(lport, DBhost, DBport);
            
            //mysql database connectivity
            Class.forName(driverName).newInstance();
//            ConnRtn = DriverManager.getConnection (url, DBUserName, DBPassword);
            ConnRtn=DriverManager.getConnection("jdbc:mysql://192.168.43.129:3306/ebs","Alexsql","mysqlAlex");   
            
            return ConnRtn;
            
        }catch(Exception e){
            e.printStackTrace();
            Disconnect();
            return null;
        }
        finally{
//	    	if(ConnRtn != null && !ConnRtn.isClosed()){
//	    		try{
//                            ConnRtn.close();
//                        }catch(Exception e){
//                        }
//                        return null;
//	    	}
//	    	if(session !=null && session.isConnected()){
//	    		session.disconnect();
//                        return null;
//	    	}
	    }
    }
    
     public boolean Disconnect() {
        try{
            session.disconnect();
            ConnRtn.close();
            return true;
        }catch(Exception e){
        
        }
        return false;
     }
    
}
