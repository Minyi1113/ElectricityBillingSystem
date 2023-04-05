package com.temple.edu.ebs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class DBData {
    ConDB cdb;
    
    //loading data part
    public String canLogin(String sUser, String sPw, int role){
        String sPWM=GBVal.md5(sPw);
        String sSQL="select CUSTOMER_ID,USERNAME,PASSWORD_HASH from customer where DATE_UNREGISTERED is null And USERNAME='"+sUser+"' And PASSWORD_HASH='"+sPWM+"' And MY_ROLE="+role;
        String sRtn="";
        ArrayList<EBSData> aTmp=new ArrayList<EBSData>(); 
        aTmp=getData(sSQL);

        if (aTmp.size()>0){
            sRtn=aTmp.get(0).get_customer_id();
        }
        return sRtn;
    }
    
    public EBSSetting getSetting(){
        EBSSetting eRtn=new EBSSetting();
        String sSQL="select * from ebssetting where LID=1";

        ArrayList<EBSSetting> rtnA=new ArrayList<EBSSetting>(); 
        ConDB cn=null;
        Statement st=null;
        ResultSet rs=null;
        try{
            cn=new ConDB();
            Connection conn=cn.connect();
            st=conn.createStatement();
            rs=st.executeQuery(sSQL);
            while (rs.next())
            {
              EBSSetting uDD=new EBSSetting();
              //customer table
            try {uDD.unitCharge=rs.getDouble("unitCharge");}
              catch (SQLException e){uDD.unitCharge=0.00;}
            try {uDD.supplyCharge=rs.getDouble("supplyCharge");}
              catch (SQLException e){uDD.supplyCharge=0.00;}
            try {uDD.taxes=rs.getDouble("taxes");}
              catch (SQLException e){uDD.taxes=0.00;}
            try {uDD.penalty=rs.getDouble("penalty");}
              catch (SQLException e){uDD.penalty=0.00;}
            try {uDD.dueDay=rs.getInt("dueDay");}
              catch (SQLException e){uDD.dueDay=0;}
            try {uDD.balanceLimit=rs.getDouble("balanceLimit");}
              catch (SQLException e){uDD.balanceLimit=0.00;}
            try {uDD.currencyUnit=rs.getString("currencyUnit");}
              catch (SQLException e){uDD.currencyUnit="$";}
              rtnA.add(uDD);
          }
        }
        catch(Exception e){

            
        }
        finally{
            try{
            st.close();
            }
            catch(Exception e){
            }
            cn.Disconnect();
        }
        if (rtnA.size()>0){
            eRtn=rtnA.get(0);
        }   
        return eRtn; 
    }
    
    public int setSetting(EBSSetting uDD){
        int iRtn=0;
        ConDB cn=null;
        Statement st=null;
        ResultSet rs=null;

        try{
            cn=new ConDB();
            Connection conn=cn.connect();
            st=conn.createStatement();
            
            String sSQL="UPDATE ebssetting set ";
            
            sSQL=sSQL+"unitCharge="+uDD.unitCharge+",";
            sSQL=sSQL+"supplyCharge="+uDD.supplyCharge+",";
            sSQL=sSQL+"taxes="+uDD.taxes+",";
            sSQL=sSQL+"penalty="+uDD.penalty+",";
            sSQL=sSQL+"dueDay="+uDD.dueDay+",";
            sSQL=sSQL+"balanceLimit="+uDD.balanceLimit+",";
            sSQL=sSQL+"currencyUnit='"+uDD.currencyUnit+"'";
            sSQL=sSQL+" Where LID=1"; 
                        

            iRtn=st.executeUpdate(sSQL);
        }
        catch(Exception e){
        }
        finally{
            try{
            st.close();
            }
            catch(Exception e){
            }
            cn.Disconnect();
        }
        return iRtn;
    }
    
    public EBSData getCurrentUserProfile(){
        EBSData eRtn=new EBSData();
        
        String sSQL="select * from customer where CUSTOMER_ID='"+GBVal.getCustomerID()+"'";
        ArrayList<EBSData> aTmp=new ArrayList<EBSData>(); 
        aTmp=getData(sSQL);
        if (aTmp.size()>0){
            eRtn=aTmp.get(0);
        }        
        return eRtn; 
    }
    
    public EBSData getOneBill(int iBillid){
        EBSData eRtn=new EBSData();
        String sSQL="select * from billdetail where BILL_ID="+iBillid;
        ArrayList<EBSData> aTmp=new ArrayList<EBSData>(); 
        aTmp=getData(sSQL);
        if (aTmp.size()>0){
            eRtn=aTmp.get(0);
        }        
        return eRtn; 
    }
    
    public ArrayList<EBSData> getCustomerBill(String sCustomerID){
        String sSQL="select * from billdetail where CUSTOMER_ID="+sCustomerID;
        ArrayList<EBSData> aTmp=new ArrayList<EBSData>(); 
        aTmp=getData(sSQL);
        return aTmp; 
    }
    
    //get the data from database
    public ArrayList<EBSData> getData(String sSQL){
        ArrayList<EBSData> rtnA=new ArrayList<EBSData>(); 
        ConDB cn=null;
        Statement st=null;
        ResultSet rs=null;

        try{
            cn=new ConDB();
            Connection conn=cn.connect();
            st=conn.createStatement();
            rs=st.executeQuery(sSQL);
            while (rs.next())
            { 
              EBSData uDD=new EBSData();
              //customer table
              try {uDD.set_customer_id(rs.getString("CUSTOMER_ID"));}
              catch (SQLException e){uDD.set_customer_id("");}
              try {uDD.set_username(rs.getString("USERNAME"));}
              catch (SQLException e){uDD.set_username("");}
              try {uDD.set_first_name(rs.getString("FIRST_NAME"));}
              catch (SQLException e){uDD.set_first_name("");}
              try {uDD.set_last_name(rs.getString("LAST_NAME"));}
              catch (SQLException e){uDD.set_last_name("");}
              try {uDD.set_middle_name(rs.getString("MIDDLE_NAME"));}
              catch (SQLException e){uDD.set_middle_name("");}
              try {uDD.set_date_of_birth(rs.getDate("DATE_OF_BIRTH"));}
              catch (SQLException e){uDD.set_date_of_birth(null);}
              try {uDD.set_gender(rs.getString("GENDER"));}
              catch (SQLException e){uDD.set_gender("");}
              try {uDD.set_address(rs.getString("ADDRESS"));}
              catch (SQLException e){uDD.set_address("");}
              try {uDD.set_city(rs.getString("CITY"));}
              catch (SQLException e){uDD.set_city("");}
              try {uDD.set_state(rs.getString("STATE"));}
              catch (SQLException e){uDD.set_state("");}
              try {uDD.set_zip_code(rs.getString("ZIP_CODE"));}
              catch (SQLException e){uDD.set_zip_code("");}
              try {uDD.set_email_address(rs.getString("EMAIL_ADDRESS"));}
              catch (SQLException e){uDD.set_email_address("");}
              try {uDD.set_phone(rs.getString("PHONE"));}
              catch (SQLException e){uDD.set_phone("");}
              try {uDD.set_balance(rs.getDouble("BALANCE"));}
              catch (SQLException e){uDD.set_balance(0);}
              try {uDD.set_date_registered(rs.getDate("DATE_REGISTERED"));}
              catch (SQLException e){uDD.set_date_registered(null);}
              try {uDD.set_date_unregistered(rs.getDate("DATE_UNREGISTERED"));}
              catch (SQLException e){uDD.set_date_unregistered(null);}
              try {uDD.set_password_hash(rs.getString("PASSWORD_HASH"));}
              catch (SQLException e){uDD.set_password_hash("");}
              try {uDD.set_role(rs.getInt("MY_ROLE"));}
              catch (SQLException e){uDD.set_role(0);}
              
              //bill table
              try {uDD.set_bill_id(rs.getInt("BILL_ID"));}
              catch (SQLException e){uDD.set_bill_id(0);}
              try {uDD.set_start_date(rs.getDate("START_DATE"));}
              catch (SQLException e){uDD.set_start_date(null);}
              try {uDD.set_end_date(rs.getDate("END_DATE"));}
              catch (SQLException e){uDD.set_end_date(null);}
              try {uDD.set_start_meter_no(rs.getInt("START_METER_NO"));}
              catch (SQLException e){uDD.set_start_meter_no(0);}
              try {uDD.set_end_meter_no(rs.getInt("END_METER_NO"));}
              catch (SQLException e){uDD.set_end_meter_no(0);}
              try {uDD.set_unit_price(rs.getDouble("UNIT_PRICE"));}
              catch (SQLException e){uDD.set_unit_price(0.0);}
              try {uDD.set_total_price(rs.getDouble("TOTAL_PRICE"));}
              catch (SQLException e){uDD.set_total_price(0.0);}
              try {uDD.set_total_paid(rs.getDouble("TOTAL_PAID"));}
              catch (SQLException e){uDD.set_total_paid(0.0);}
              try {uDD.set_penalty(rs.getDouble("PENALTY  "));}
              catch (SQLException e){uDD.set_penalty(0.0);}

              rtnA.add(uDD);

           }
            
        }
        catch(Exception e){
        }
        finally{
            try{
            st.close();
            }
            catch(Exception e){
            }
            cn.Disconnect();
        }
        return rtnA;
    }
    
    
    //////////save part
    
    public boolean UpdateOneUserProfile(EBSData eRtn){
        ArrayList<EBSData> aTmp=new ArrayList<EBSData>(); 
        aTmp.add(eRtn);
        return (setData("customer",aTmp,false)>0); 
    }
    
    public boolean UpdateOneBill(EBSData eRtn){
        ArrayList<EBSData> aTmp=new ArrayList<EBSData>(); 
        aTmp.add(eRtn);
        return (setData("billdetail",aTmp,false)>0); 
    }
    
    //save data to database
    public int setData(String sTable,ArrayList<EBSData> rtnA, Boolean isNew){
        int iRtn=0;
        ConDB cn=null;
        Statement st=null;
        ResultSet rs=null;

        try{
            cn=new ConDB();
            Connection conn=cn.connect();
            st=conn.createStatement();
            for (EBSData uDD: rtnA)
            {
                String sSQL="";
                //new records
                if (isNew){
                    
                    if (sTable.equals("customer")){
                        sSQL="INSERT INTO "+sTable+" (CUSTOMER_ID,USERNAME,PASSWORD_HASH,EMAIL_ADDRESS,DATE_REGISTERED,MY_ROLE) values ('"+GBVal.timeStamp()+"',";
                        sSQL=sSQL+"'"+uDD.get_username()+"',";
                        sSQL=sSQL+"'"+uDD.get_password_hash()+"',";
                        sSQL=sSQL+"'"+uDD.get_email_address()+"',";
                        sSQL=sSQL+"CURDATE(),";
                        sSQL=sSQL+""+uDD.get_role()+")";
                    }else if (sTable.equals("billdetail")){
                        sSQL="INSERT INTO billdetail (CUSTOMER_ID,START_DATE,END_DATE,START_METER_NO,END_METER_NO,UNIT_PRICE,TOTAL_PRICE,TOTAL_PAID,PENALTY) VALUES (";
                        sSQL=sSQL+"'"+uDD.get_customer_id()+"',";
                        sSQL=sSQL+"'"+uDD.get_start_date().toString()+"',";
                        sSQL=sSQL+"'"+uDD.get_end_date().toString()+"',";
                        sSQL=sSQL+""+uDD.get_start_meter_no()+",";
                        sSQL=sSQL+""+uDD.get_end_meter_no()+",";
                        sSQL=sSQL+""+uDD.get_unit_price()+",";
                        sSQL=sSQL+""+uDD.get_total_price()+",";
                        sSQL=sSQL+""+uDD.get_total_paid()+",";
                        sSQL=sSQL+""+uDD.get_penalty()+")";
                    };
                }
                //update records
                else{
                    sSQL="UPDATE "+sTable+" set ";
                    if (sTable.equals("customer")){
                       sSQL=sSQL+"USERNAME='"+uDD.get_username()+"',";
                       sSQL=sSQL+"FIRST_NAME='"+uDD.get_first_name()+"',";
                       sSQL=sSQL+"MIDDLE_NAME='"+uDD.get_middle_name()+"',";
                       sSQL=sSQL+"LAST_NAME='"+uDD.get_last_name()+"',";
                       sSQL=sSQL+"GENDER='"+uDD.get_gender()+"',";
                       sSQL=sSQL+"ADDRESS='"+uDD.get_address()+"',";
                       sSQL=sSQL+"CITY='"+uDD.get_city()+"',";
                       sSQL=sSQL+"STATE='"+uDD.get_state()+"',";
                       sSQL=sSQL+"ZIP_CODE='"+uDD.get_zip_code()+"',";
                       sSQL=sSQL+"EMAIL_ADDRESS='"+uDD.get_email_address()+"',";
                       sSQL=sSQL+"PHONE='"+uDD.get_phone()+"',";
                       sSQL=sSQL+"BALANCE="+uDD.get_balance()+",";
                       sSQL=sSQL+"MY_ROLE="+uDD.get_role()+"";
                        
                       sSQL=sSQL+" Where CUSTOMER_ID='"+uDD.get_customer_id()+"'"; 
                        
                    }else if (sTable.equals("billdetail")){
                        sSQL=sSQL+"START_DATE='"+uDD.get_start_date().toString()+"',";
                        sSQL=sSQL+"END_DATE='"+uDD.get_end_date().toString()+"',";
                        sSQL=sSQL+"START_METER_N=O"+uDD.get_start_meter_no()+",";
                        sSQL=sSQL+"END_METER_NO="+uDD.get_end_meter_no()+",";
                        sSQL=sSQL+"UNIT_PRICE="+uDD.get_unit_price()+",";
                        sSQL=sSQL+"TOTAL_PRICE="+uDD.get_total_price()+",";
                        sSQL=sSQL+"TOTAL_PAID="+uDD.get_total_paid()+",";
                        sSQL=sSQL+"PENALTY="+uDD.get_penalty()+"";
                        sSQL=sSQL+" Where BILL_ID="+uDD.get_bill_id();
                    }
                }
               iRtn=st.executeUpdate(sSQL);
           }
            
        }
        catch(Exception e){
        }
        finally{
            try{
            st.close();
            }
            catch(Exception e){
            }
            cn.Disconnect();
        }
        return iRtn;
    }
    
    //update price for all unpay bill    
    public int updateUnpaybill(){
        EBSSetting ebs=getSetting();
        int iRtn=0;
        ConDB cn=null;
        Statement st=null;
        ResultSet rs=null;

        try{
            cn=new ConDB();
            Connection conn=cn.connect();
            st=conn.createStatement();
            
            double uPr=ebs.unitCharge+ebs.unitCharge;
            
            String sSQL;
            sSQL="UPDATE billdetail set Unit_price="+uPr;
            sSQL=sSQL+",TOTAL_PRICE=UNIT_PRICE*(END_METER_NO-START_METER_NO) where BILL_ID>0 AND TOTAL_PAID=0";
            iRtn=st.executeUpdate(sSQL);
        }
        catch(Exception e){
        }
        finally{
            try{
            st.close();
            }
            catch(Exception e){
            }
            cn.Disconnect();
        }
        return iRtn;
    }
    
    public int MakeNewbill(){
        EBSSetting ebs=getSetting();
        double uPr=ebs.unitCharge+ebs.unitCharge;
        
        ArrayList<EBSData> uTemp=getData("SELECT MAX(END_DATE) AS END_DATE, billdetail.CUSTOMER_ID, MAX(END_METER_NO) as END_METER_NO, DATE_REGISTERED FROM billdetail join customer on customer.customer_id=billdetail.customer_id WHERE DATE_UNREGISTERED is null and MY_ROLE=0 GROUP BY CUSTOMER_ID;");

        int iRtn=0;
        ConDB cn=null;
        Statement st=null;
        ResultSet rs=null;

        try{
            cn=new ConDB();
            Connection conn=cn.connect();
            st=conn.createStatement();
            
            Date today=new Date();
                        
            for (EBSData uDD: uTemp){
                String sSQL;
                Random r = new Random();
                long iEnd=uDD.get_end_meter_no()+r.nextInt(500)+123;
                
                if (today.getDate()==uDD.get_end_date().getDate())
                    continue;
                
                sSQL="INSERT INTO billdetail (CUSTOMER_ID,START_DATE,END_DATE,START_METER_NO,END_METER_NO,UNIT_PRICE,TOTAL_PRICE,TOTAL_PAID,PENALTY) VALUES (";
                        sSQL=sSQL+"'"+uDD.get_customer_id()+"',";
                        sSQL=sSQL+"DATE_ADD('"+uDD.get_end_date()+"', INTERVAL 1 DAY),";
                        sSQL=sSQL+"CURDATE(),";
                        sSQL=sSQL+""+uDD.get_end_meter_no()+",";
                        sSQL=sSQL+""+iEnd+",";
                        sSQL=sSQL+""+uPr+",";
                        sSQL=sSQL+""+uPr*(iEnd-uDD.get_end_meter_no())+",";
                        sSQL=sSQL+"0,";
                        sSQL=sSQL+"0)";
                iRtn+=st.executeUpdate(sSQL);
            }
        }
        catch(Exception e){
        }
        finally{
            try{
            st.close();
            }
            catch(Exception e){
            }
            cn.Disconnect();
        }
        return iRtn;       
    }
    
    
}
