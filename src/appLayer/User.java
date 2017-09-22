package appLayer;

public class User {

    public boolean isValidUSerCredentials(String username, String userpassword){
        if(username.equals("Emil") && userpassword.equals("123")){
            return true;
        }   else {
            return false;
        }
    }
}
