package com.ClassroomDBMS.main.functions;

import com.ClassroomDBMS.main.windows.home.main;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class profile {

    public static Scene main(String[] profileDetails){
        SplitPane userOptions = new SplitPane();

        StackPane optionDetails = new StackPane();
        optionDetails.setStyle("-fx-background-color: #171717");

        BorderPane options = new BorderPane();
        VBox userData = new VBox(10);
        userData.setPadding(new Insets(0,0,60,0));
        userData.setAlignment(Pos.TOP_CENTER);

        Label userLOGO = GlyphsDude.createIconLabel( FontAwesomeIcon.USER_SECRET,
                "",
                "100",
                "0",
                ContentDisplay.LEFT );
        userLOGO.setTextFill(Color.web("grey"));
        userLOGO.setPadding(new Insets(15,0,0,10));
        StackPane logo = new StackPane(userLOGO);
        logo.setStyle("-fx-background-color: #fff");

        Label fullName = new Label(profileDetails[1]);
        fullName.setFont(new Font("Cambria", 25));
        fullName.setTextFill(Color.web("#ededed"));

        Label emailID = new Label(profileDetails[2]);
        emailID.setFont(new Font("Cambria", 15));
        emailID.setTextFill(Color.web("#ededed"));

        Label college = new Label(profileDetails[3]+",  "+profileDetails[5]);
        college.setFont(new Font("Cambria", 15));
        college.setTextFill(Color.web("#ededed"));

        userData.getChildren().addAll(logo,fullName,emailID,college);
        userData.setStyle("-fx-border-color: #fff;-fx-border-width: 0 0 3 0;-fx-underline: true;");

        options.setTop(userData);

        VBox buttons = new VBox(15);

        Label findPeople = GlyphsDude.createIconLabel( FontAwesomeIcon.SEARCH,
                "  Find Students",
                "20",
                "18",
                ContentDisplay.LEFT );
        findPeople.setFont(new Font("Cambria", 20));
        findPeople.setTextFill(Color.web("#171717"));
        findPeople.setPadding(new Insets(10));
        StackPane findPeoplePane = new StackPane(findPeople);
        findPeoplePane.setStyle("-fx-background-color: grey");

        Label speakOut = GlyphsDude.createIconLabel( FontAwesomeIcon.WECHAT,
                "  SpeakOut",
                "20",
                "18",
                ContentDisplay.LEFT );
        speakOut.setFont(new Font("Cambria", 20));
        speakOut.setTextFill(Color.web("#171717"));
        speakOut.setPadding(new Insets(10));
        StackPane speakOutPane = new StackPane(speakOut);
        speakOutPane.setStyle("-fx-background-color: grey");

        Label TAs = GlyphsDude.createIconLabel( FontAwesomeIcon.USERS,
                "  Teaching Assistant",
                "20",
                "18",
                ContentDisplay.LEFT );
        TAs.setFont(new Font("Cambria", 20));
        TAs.setTextFill(Color.web("#171717"));
        TAs.setPadding(new Insets(10));
        StackPane TAsPane = new StackPane(TAs);
        TAsPane.setStyle("-fx-background-color: grey");

        buttons.getChildren().addAll(findPeoplePane, speakOutPane, TAsPane);
        options.setCenter(buttons);

        Label logout = GlyphsDude.createIconLabel( FontAwesomeIcon.SIGN_OUT,
                "  Log Out",
                "20",
                "18",
                ContentDisplay.LEFT );
        logout.setFont(new Font("Cambria", 20));
        logout.setTextFill(Color.web("#171717"));
        logout.setPadding(new Insets(10));
        StackPane logoutPane = new StackPane(logout);
        logoutPane.setStyle("-fx-background-color: grey");

        options.setBottom(logoutPane);
        optionDetails.getChildren().add(options);

        StackPane optionData = new StackPane(new Label("Data her"));

        userOptions.getItems().addAll(optionDetails, optionData);
        userOptions.setResizableWithParent(optionDetails,Boolean.FALSE);
        optionData.maxWidthProperty().bind(userOptions.widthProperty().multiply(0.7));
        optionData.minWidthProperty().bind(userOptions.widthProperty().multiply(0.7));

        Scene scene = new Scene(userOptions,800,500);
        scene.getStylesheets().add(main.class.getResource("../../resources/css/main.css").toExternalForm());
        return scene;
    }
}
