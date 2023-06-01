package Admin;
import Teacher.*;
public class Admin {
    private String nameAdmin;
    private static final String passwordAdmin = "5678";

    //use with login
    public static String getNameAdmin() {
        return "Doraemon";
    }

    public static String getPassword() {
        return passwordAdmin;
    }

}

