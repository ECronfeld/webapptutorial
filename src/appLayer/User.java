package appLayer;

import dataLayer.DB_user;

public class User {

    public boolean isValidUSerCredentials(String username, String userpassword){
        DB_user DB_user_object = new DB_user();
        return DB_user_object.isValidUserLogin(username, userpassword);
    }
}
