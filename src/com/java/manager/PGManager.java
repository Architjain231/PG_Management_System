package com.java.manager;

import com.java.model.PG;
import com.java.model.Room;
import com.java.tenant.Tenant;

import java.util.ArrayList;
import java.util.Scanner;

public class PGManager
{
    Scanner sc = new Scanner(System.in);
    static PGManager manager;
    String name;
    static public  ArrayList<PG> pgs=new ArrayList<>();
    public ArrayList<Tenant> tenant=new ArrayList<>();
    //Constructor
    private  PGManager(String name)
    {
        this.name=name;
    }
    private PGManager()
    {

    }
      public static PGManager getManager(String name)
      {
          if(manager==null)
          {
              manager=new PGManager(name);
          }
          return manager;
      }
    static public PGManager getManager()
    {
        if(manager==null)
        {
            manager=new PGManager();
        }
        return manager;
    }
    // init_pg()
    /*
    Methods
    1 fillPGSpecification
    2 addPG()
    3 showPG()
    4 updatePG()
     */
//    public void fillPGSpecification(int count)
//    {
//
//        for(int i=0;i<count;i++)
//        {
//            System.out.printf("Enter Details of %d PG",i+1);
//            PG ob=new PG();
//            System.out.println("How many rooms are there ?");
//            int rooms=sc.nextInt();
//            if(rooms<1)
//            {
//                System.out.println("Invalid room count");
//                i--;
//                continue;
//            }
//            for(int j=0;j<rooms;j++)
//            {
//                System.out.printf("Enter Details of %d Room",j+1);
//                ob.addRoom();
//            }
//            pgs.add(ob);
//        }
//    }
    public void addPG()
    {
        System.out.printf("Enter PG Details : ");
        PG pg=new PG();
        System.out.println("How many rooms are there ?");
        int rooms=sc.nextInt();
        while(rooms<1)
        {
            System.out.println("Invalid room count");
            rooms=sc.nextInt();
        }
        for(int j=0;j<rooms;j++)
        {
            System.out.printf("Enter Details of %d Room",j+1);
            pg.addRoom();
        }
        pgs.add(pg);
    }
    public void operatePGs()
    {
        System.out.print("Enter PG No : ");
        int num=sc.nextInt();
        PG pgObj=pgs.get(num-1);
        boolean flag=true;
        while(flag)
        {
            System.out.println("Enter Your Choice");
            System.out.println("1 Add Room");
            System.out.println("2 Show Rooms");
            System.out.println("3 Delete Room");
            System.out.println("4 Update Room");
            System.out.println("5 Exit");
            int choice=sc.nextInt();
            switch(choice)
            {
                case 1: pgObj.addRoom();
                    break;
                case 2: pgObj.show();
                    break;
                case 3: pgObj.deleteRoom();
                    break;
                case 4: pgObj.updateRoom();
                    break;
                case 5: flag=false;
                    break;
                default:
                    System.out.println("Invalid Choice...");

            }
        }
    }
    public void updatePG()
    {
        System.out.println("Enter PG Number : ");
        int num=sc.nextInt();
        while(num>pgs.size()||num<1)
        {
            System.out.println("Invalid PG Number...Try Again");
            num=sc.nextInt();
        }
        num--;
        PG pg=pgs.get(num);
//
//
//
//
        pg.updateRoom();
    }

//    public void checkAvailability()
//    {
//        System.out.println("Enter Tenant count : ");
//        int count=sc.nextInt();
//        for(int i=0;i< pgs.size();i++)
//        {
//            PG pg=pgs.get(i);
//
//        }
//    }
}
