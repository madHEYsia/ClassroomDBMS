package com.ClassroomDBMS.database.speakOutMessages;

import com.ClassroomDBMS.database.utils.DBUtils;
import com.ClassroomDBMS.main.templates.speakouts.message;


import javafx.scene.layout.VBox;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class fetchLatest {

    public static VBox fetchlatest(String currentUserMailId) {

        VBox noticeList = new VBox();

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String query = DBUtils.prepareSelectQuery(" * ", "classroomdbms.speakouts", "","ORDER BY timestamp asc" );

        try {
            con = DBUtils.getConnection();
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()){
                String timestamp = rs.getString("timestamp");
                String emailId = rs.getString("emailId");
                String notice = rs.getString("message");

                if (emailId.equals(currentUserMailId))
                    noticeList.getChildren().add(message.rightformatmessage(timestamp, notice));
                else
                    noticeList.getChildren().add(message.leftformatmessage(timestamp, emailId, notice));
            }

        } catch (Exception e) {
            noticeList.getChildren().add(message.errorformatmessage());
        } finally {
            DBUtils.closeAll(rs, stmt, con);
            return noticeList;
        }
    }

}
