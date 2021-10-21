package uts.pbo;

public class Main {
    public static void main(String[] args) {
        System.out.println("=====     Daftar 5 User     ====");
        
        User user1 = new User("doli1" , "doli123");
        User user2 = new User("alwan2" , "alwan123");
        User user3 = new User("arif3" , "arif123");
        User user4 = new User("kiel4", "kiel123");
        User user5 = new User("atha5" , "atha123");
        
        User.userList.add(user1);
        User.userList.add(user2);
        User.userList.add(user3);
        User.userList.add(user4);
        User.userList.add(user5);
        
        
        
        for (int i=0; i<5; i++) {
            User user = User.userList.get(i);
            System.out.println((i+1) + ". " + user.name + "\t" + user.encryptedPassword);
        }
        System.out.println();
        System.out.println();
        
        System.out.println("=====   Rename Username  =====");
        int id1 = 1;
        
        String rename_username1 = "alwan-kun";
        if (new User("","").setUserName(rename_username1) == true) {
            User.userList.get(id1).setUname(rename_username1);
            
            User user = User.userList.get(id1);
            System.out.println((id1) + ". " + user.name + "\t" + user.encryptedPassword);
        }
        
        System.out.println();
        
        
        System.out.println("==== Rename 2 Username Used =====");
        int id2 = 4;
        int id3 = 0;
        
        String rename_username2 = "atha5";
        if (new User("","").setUserName(rename_username2) == true) {
            User.userList.get(id2).setUname(rename_username2);
            System.out.println((id2+1) + ". " + User.userList.get(id2).name + "\t" + User.userList.get(id2).encryptedPassword);
        }
        
        String rename_username3 = "doli1";
        if (new User("","").setUserName(rename_username3) == true) {
            User.userList.get(id3).setUname(rename_username3);
            System.out.println((id3+1) + ". " + User.userList.get(id3).name + "\t" + User.userList.get(id3).encryptedPassword);
        }
        System.out.println();
        System.out.println();
        
        System.out.println("====  Rename 2 Username  ====");
        int id4 = 2;
        int id5 = 3;
        
        String rename_username4 = "arif30";
        if (new User("","").setUserName(rename_username4) == true) {
            User.userList.get(id4).setUname(rename_username4);
            
            User user = User.userList.get(id4);
            System.out.println((id4) + ". " + user.name + "\t" + user.encryptedPassword);
        }
        
        String rename_username5 = "kiel40";
        if (new User("","").setUserName(rename_username5) == true) {
            User.userList.get(id5).setUname(rename_username5);
            
            User user = User.userList.get(id5);
            System.out.println((id5) + ". " + user.name + "\t" + user.encryptedPassword);
        }
        
        System.out.println();
        System.out.println();
        
        
       
        System.out.println("====      All Activity  ====");
        Activity.printAllActivities();
        System.out.println();
        
       
        System.out.println("====     Today Activity   ====");
        Activity.printTodaysActivities();
        System.out.println();
        
        
        
        System.out.println("====      Login 2 User      ====");
        new User("","").logIn("doli1", "doli123");
        new User("","").logIn("alwan-kun", "alwan123");
        System.out.println();
        
        
        System.out.println("====  Failed Login 2 User  ====");
        new User("","").logIn("dolol", "doli");
        new User("","").logIn("allwan", "alwan");
        System.out.println();
        
        System.out.println("====     User Activity    ====");
        Activity.printUserActivities("doli1");
        Activity.printUserActivities("alwan-kun");
        System.out.println();
        
        System.out.println("====    Last 10 Activity    ====");
        Activity.printLastTenActivities();
        System.out.println();
    }
}
