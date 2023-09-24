package com.mcs.logoengine.config.seller;

import com.mcs.logoengine.config.DatabaseConfig;
import com.mcs.logoengine.entity.seller.SellerEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Objects;

public class SellerRegistration {
    private static final JdbcTemplate SellerRegDB = DatabaseConfig.NewJdbcTemplate();

    public static String RegisterSeller(SellerEntity sellerEntity){
        String Pan_no = sellerEntity.getPan_no();
        String Name = sellerEntity.getName();
        String State = sellerEntity.getState();
        String Phone_no = sellerEntity.getPhone_no();
        String Email = sellerEntity.getEmail();
        String Username = sellerEntity.getUsername();
        String Password = sellerEntity.getPassword();
        String Usertype = "seller";

        String queryForSellerDB = "INSERT INTO SELLERDB(PAN_NO, NAME, STATE, USERNAME) VALUES(?,?,?,?)";
        String queryForUsernameBD = "INSERT INTO USERNAMEDB VALUES(?,?,?,?,?)";

        String DataValidationMsg = SellerDataValidation(Pan_no, Phone_no, Email, Username);
        String ReturnStatement = "Successfully registered as " + Usertype;

        if(Objects.equals(DataValidationMsg, "p7Wav70v2Pga")){

            SellerRegDB.update(queryForSellerDB, Pan_no, Name, State, Username);

            SellerRegDB.update(queryForUsernameBD, Username, Usertype, Email, Phone_no, Password);
        }
        else {
            ReturnStatement = DataValidationMsg;
        }




        return ReturnStatement;
    }

    public static String SellerDataValidation(String pan, String phone, String email, String username){

        String QueryForPan = "SELECT COUNT(*) FROM SELLERDB WHERE PAN_NO = ?";
        String QueryForPhone = "SELECT COUNT(*) FROM USERNAMEDB WHERE PHONE_NO = ?";
        String QueryForEmail = "SELECT COUNT(*) FROM USERNAMEDB WHERE EMAIL = ?";
        String QueryForUsername = "SELECT COUNT(*) FROM USERNAMEDB WHERE USERNAME = ?";

        String ReturnStatement ="";
        int ValidationStatement = 0;
        String Exists = "already exists";

        // Validation Of Pan Card
        if (Validate(QueryForPan, pan) == 0){
            ValidationStatement++;
        }
        else {
            ReturnStatement += "Pan, ";
        }

        // Validation of Phone Number
        if (Validate(QueryForPhone, phone) == 0){
            ValidationStatement++;
        }
        else {
            ReturnStatement += "Phone No, ";
        }

        // Validation of Email
        if (Validate(QueryForEmail, email) == 0){
            ValidationStatement++;
        }
        else {
            ReturnStatement += "Email, ";
        }

        // Validation of Username
        if (Validate(QueryForUsername, username) == 0){
            ValidationStatement++;
        }
        else {
            ReturnStatement += "Username, ";
        }

        if (ValidationStatement == 4){
            ReturnStatement = "p7Wav70v2Pga";
        }
        else{
            ReturnStatement+= Exists;
        }


        return ReturnStatement;
    }

    public static int Validate(String Query, String Param){
        return SellerRegDB.queryForObject(Query, Integer.class, Param);
    }

}
