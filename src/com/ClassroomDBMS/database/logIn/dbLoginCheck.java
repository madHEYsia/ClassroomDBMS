package com.ClassroomDBMS.database.logIn;

import com.ClassroomDBMS.database.utils.DBUtils;
import com.ClassroomDBMS.main.functions.getMotherboardSN;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class dbLoginCheck {

    public static String[] dbLoginCheck(String userName, String password) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String query = DBUtils.prepareSelectQuery(" * ", "classroomdbms.userdetail", "(fullName = ? OR emailId = ? ) AND password = ?");

        String userID = getMotherboardSN.getMotherboardSN();

        String updateCurrentUserQuery = DBUtils.prepareInsertQuery("classroomdbms.currentuser", "id, fullName, emailId, phoneNumber, gender, college", "?,?,?,?,?,?");

        String[] status = new String[6];

        try {
            con = DBUtils.getConnection();
            stmt = con.prepareStatement(query);
            stmt.setString(1, userName);
            stmt.setString(2, userName);
            stmt.setString(3, password);
            rs = stmt.executeQuery();

            rs.last();
            int size = rs.getRow();
            rs.beforeFirst();

            if (size>0) {
                rs.next();
                status[0] = "success";
                status[1] = rs.getString("fullName");
                status[2] = rs.getString("emailId");
                status[3] = rs.getString("phoneNumber");
                status[4] = rs.getString("gender");
                status[5] = rs.getString("college");

                stmt = con.prepareStatement(updateCurrentUserQuery);
                stmt.setString(1, userID);
                stmt.setString(2, status[1]);
                stmt.setString(3, status[2]);
                stmt.setString(4, status[3]);
                stmt.setString(5, status[4]);
                stmt.setString(6, status[5]);
                stmt.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
            status[0] = e.getMessage();
        } finally {
            DBUtils.closeAll(rs, stmt, con);
            return status;
        }
    }
}
