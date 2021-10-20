package uts.pbo;
import java.util.ArrayList;
import java.time.ZonedDateTime;
import java.time.LocalDate;

public class Activity {
    int           activityId;             
    ZonedDateTime activityTimeDate;         
    LocalDate     activityDate;            
    String        actorUserName;            
    int           activityType;            
    String        activityStatus;
    
    static ArrayList<Activity> activityLog = new ArrayList<Activity>();
    static int    currentActivityId;        // autoinc
    
    public Activity (int activityType, String actorUserName, String activityStatus) {
        
        currentActivityId++;
        activityId = currentActivityId;
        
        activityTimeDate = ZonedDateTime.now();
        
        this.activityType  = activityType;
        this.actorUserName = actorUserName;
        
        // Date only
        activityDate = LocalDate.now();
        
        // Activity status
        this.activityStatus = activityStatus;
    }
    
    public static void printAllActivities() {
        // cetak semua aktivitas yang telah disimpan
        
        for (int i=activityLog.size()-1; i>=0; i--) {
            Activity actvt = Activity.activityLog.get(i);
            System.out.print(actvt.activityId + ". " + actvt.activityTimeDate + "\t");
            
            if (actvt.activityType == 1) {
                System.out.print  ("[1] Login User " + " ");
            }
            else if (actvt.activityType == 2) {
                System.out.print  ("[2] Create User" + " ");
            }
            else if (actvt.activityType == 3) {
                System.out.print  ("[3] Rename User" + " ");
            }
            
            System.out.println("\t" + actvt.actorUserName + "\t" + actvt.activityStatus);
        }
        
        System.out.println();
    }
    
    public static void printTodaysActivities() {
        // cetak semua aktivitas hari ini
        
        for (int i=activityLog.size()-1; i>=0; i--) {
            Activity actvt = Activity.activityLog.get(i);
            
            if (actvt.activityDate.compareTo(LocalDate.now()) == 0) {
                System.out.print(actvt.activityId + ". " + actvt.activityTimeDate + "\t");
                
                if (actvt.activityType == 1) {
                    System.out.print  ("[1] Login User " + " ");
                }
                else if (actvt.activityType == 2) {
                    System.out.print  ("[2] Create User" + " ");
                }
                else if (actvt.activityType == 3) {
                    System.out.print  ("[3] Rename User" + " ");
                }

                System.out.println("\t" + actvt.actorUserName + "\t" + actvt.activityStatus);
            }
        }
        
        System.out.println();
    }
    
    public static void printLastTenActivities() {
        // cetak 10 aktivitas terakhir (berdasarkan waktu)
        
        if (activityLog.size() < 10) {
            for (int i=activityLog.size()-1; i>=0; i--) {
                Activity actvt = Activity.activityLog.get(i);
                System.out.print(actvt.activityId + ". " + actvt.activityTimeDate + "\t");

                if (actvt.activityType == 1) {
                    System.out.print  ("[1] Login User " + " ");
                }
                else if (actvt.activityType == 2) {
                    System.out.print  ("[2] Create User" + " ");
                }
                else if (actvt.activityType == 3) {
                    System.out.print  ("[3] Rename User" + " ");
                }

                System.out.println("\t" + actvt.actorUserName + "\t" + actvt.activityStatus);
            }
        }
        else {
            int count = activityLog.size()-1;
            while (count > activityLog.size()-11) {
                Activity actvt = Activity.activityLog.get(count);
                System.out.print(actvt.activityId + ". " + actvt.activityTimeDate + "\t");

                if (actvt.activityType == 1) {
                    System.out.print  ("[1] Login User " + " ");
                }
                else if (actvt.activityType == 2) {
                    System.out.print  ("[2] Create User" + " ");
                }
                else if (actvt.activityType == 3) {
                    System.out.print  ("[3] Rename User" + " ");
                }

                System.out.println("\t" + actvt.actorUserName + "\t" + actvt.activityStatus);

                count--;
            }
        }
        
        System.out.println();
    }
    
    public static void printUserActivities(String actorUserName) {
        // mencetak semua activity yang dilakukan 1 user
        // fungsi mencetak "Activity was not found" jika tidak ada aktivitas dari user tsb
        
        for (int i=activityLog.size()-1; i>=0; i--) {
            Activity actvt = Activity.activityLog.get(i);
            
            if (actvt.actorUserName.compareTo(actorUserName) == 0) {
                System.out.print(actvt.activityId + ". " + actvt.activityTimeDate + "\t");
                
                if (actvt.activityType == 1) {
                    System.out.print  ("[1] Login User " + " ");
                }
                else if (actvt.activityType == 2) {
                    System.out.print  ("[2] Create User" + " ");
                }
                else if (actvt.activityType == 3) {
                    System.out.print  ("[3] Rename User" + " ");
                }

                System.out.println("\t" + actvt.actorUserName + "\t" + actvt.activityStatus);
            }
        }
        
        System.out.println();
    }
}
