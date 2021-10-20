package uts.pbo;
import java.util.ArrayList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    String userName;           
    String encryptedPassword;  
    String name;                
    String rename_username;
    String Status;
    static ArrayList<User> userList = new ArrayList<User>();
    
    public User (String username, String encryptedpassword) {
        
        this.name              = username;
        this.encryptedPassword = encryptedpassword;
        
        String password = encryptedPassword;
        String md5pass  = null;
        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            md.update(password.getBytes());
            
            byte[] bytes     = md.digest();
            StringBuilder sb = new StringBuilder();
            
            for (int i=0; i<bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            md5pass = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        
        this.encryptedPassword = md5pass;
        
        
        // Activity Log
        // Create User
        Activity actvt = new Activity(2, username, "[3] User Created");
        Activity.activityLog.add(actvt);
    }
    
    public String getUname() {
        return name;
    }
    
    public void setUname(String name) {
        this.name = name;
    }
    
    public boolean setUserName (String newUserName) {
        boolean check = false;
        
        if (check == false) {
            for (int i=0; i<5; i++) {
//                System.out.println(userList.get(i).getUname());
                if (userList.get(i).getUname() == newUserName) {
                    System.out.println(newUserName + " already used!");
                    System.out.println();
                    
                    Status = "[6] Username Update Failed, Username Exist";
                    Activity actvt = new Activity(3, newUserName, Status);
            
                    check = false;
                    return false;
                }
            }
        }
        
        
        // Activity Log
        // Rename User
        Status = "[5] Username Updated";
        Activity actvt = new Activity(3, newUserName, Status);
        Activity.activityLog.add(actvt);
        
        return true;
    }
    
    public boolean logIn (String usernameLogin, String encryptedPasswordLogin) {        
        String password = encryptedPasswordLogin;
        String md5pass  = "";
        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            md.update(password.getBytes());
            
            byte[] bytes     = md.digest();
            StringBuilder sb = new StringBuilder();
            
            for (int i=0; i<bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            md5pass = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        
        
        for (int i=0; i<5;i++){
            if (userList.get(i).getUname() == usernameLogin) {
                if (userList.get(i).encryptedPassword.equals(md5pass)) {
//                    Activity.activityLog.remove(i);
                    System.out.println("Login Berhasil!");
                    System.out.println("User : " + usernameLogin);
                    System.out.println();
                    
                    Status = "[0] Login Success";
                    Activity.activityLog.add(new Activity(1, usernameLogin, Status));

                    return true;
                }
                else{
                    System.out.println("Password Salah : " + usernameLogin);
//                    Activity.activityLog.remove(i);
                    System.out.println();
                    
                    Status = "[2] Log-in Failed Wrong Password";
                    Activity.activityLog.add(new Activity(1, usernameLogin, Status));
                    
                    return true;
                }
            } 
        }
        
        System.out.println("Failed Login, " + usernameLogin + " tidak terdaftar");
        
        Status = "[1] Log-in Failed User Not Found";
        Activity.activityLog.add(new Activity(1, usernameLogin, Status));
        System.out.println();
        
        return false;
    }
}
