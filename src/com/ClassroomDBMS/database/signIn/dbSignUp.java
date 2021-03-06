package com.ClassroomDBMS.database.signIn;

import com.ClassroomDBMS.database.utils.DBUtils;
import com.ClassroomDBMS.main.functions.getMotherboardSN;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class dbSignUp {

    public static String[] userSignUp(String fullName, String emailId, String password, String phoneNumber, String gender, String college){
        Connection con = null;

        PreparedStatement stmt = null;
        String query = DBUtils.prepareInsertQuery("classroomdbms.userdetail", "fullName, emailId, password, phoneNumber, gender, college", "?,?,?,?,?,?");

        String userID = getMotherboardSN.getMotherboardSN();

        String updateCurrentUserQuery = DBUtils.prepareInsertQuery("classroomdbms.currentuser", "id, fullName, emailId, phoneNumber, gender, college", "?,?,?,?,?");

        String[] status = new String[6];
        status[1]=fullName;
        status[2]=emailId;
        status[3]=phoneNumber;
        status[4]=gender;
        status[5]=college;

        try{
            con = DBUtils.getConnection();
            stmt = con.prepareStatement(query);
            stmt.setString(1, fullName);
            stmt.setString(2, emailId);
            stmt.setString(3, password);
            stmt.setString(4, phoneNumber);
            stmt.setString(5, gender);
            stmt.setString(6, college);
            stmt.executeUpdate();
            status[0]="success";

            stmt = con.prepareStatement(updateCurrentUserQuery);
            stmt.setString(1, userID);
            stmt.setString(2, fullName);
            stmt.setString(3, emailId);
            stmt.setString(4, phoneNumber);
            stmt.setString(5, gender);
            stmt.setString(6, college);
            stmt.executeUpdate();
        }
        catch(Exception e){
            status[0] = e.getMessage();
        }
        finally{
            DBUtils.closeStatement(stmt);
            DBUtils.closeConnection(con);
            return status;
        }
    }
}
