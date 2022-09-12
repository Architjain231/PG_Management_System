package com.java.model;

import java.util.ArrayList;
import java.util.Scanner;

public class PG {
    Scanner sc = new Scanner(System.in);

    private ArrayList<SingleSharing> single;
    private ArrayList<DualSharing> dual;
    private ArrayList<TripleSharing> triple;
    private int single_size,dual_size,triple_size;
    //Constructor
     public PG()
    {
        single=new ArrayList<>();
        dual=new ArrayList<>();
        triple=new ArrayList<>();
    }
    /*
    Methods
    1  addRoom()
    2  show()
    3  deleteRoom()
    4  updateRoom()
    */

    public void addRoom()
    {
        int cap=0,rent=0;
        System.out.println("Enter Seating Capacity : ");
        cap=sc.nextInt();
        while(cap<1||cap>3)
        {
            System.out.println("Invalid Capacity..Enter Valid Capacity");
            cap=sc.nextInt();
        }
        System.out.println("Enter Rent per Head : ");
        rent=sc.nextInt();
        while(rent<1)
        {
            System.out.println("Invalid Rent..Enter Valid amount");
        }
        if(cap==1)
        {
            SingleSharing obj=new SingleSharing(rent);
            single.add(obj);
            single_size++;
        }
        else if(cap==2)
        {
            DualSharing obj=new DualSharing(rent);
            dual.add(obj);
            dual_size++;
        }
        else
        {
            TripleSharing obj=new TripleSharing(rent);
            triple.add(obj);
            triple_size++;
        }
    }

    public void show()
    {   boolean flag=true;
        while(flag) {
            System.out.println("1 All One-Seaters");
            System.out.println("2 All Two-Seaters");
            System.out.println("3 All Three-Seaters");
            System.out.println("4 Particular Room");
            System.out.println("5 All Rooms");
            System.out.println("6 Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    showSingleSeaterRooms();
                    break;
                case 2:
                    showdualSeaterRooms();
                    break;
                case 3:
                    showtripleSeaterRooms();
                    break;
                case 4:
                    showRoom();
                    break;
                case 5:
                    showAll();
                    break;
                case 6:
                    flag=false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void showRoom()
    {
        System.out.println("Enter Room No: ");
        int room_num=sc.nextInt();
        Room obj=getRoom(room_num);
        if(obj!=null)
        {
            System.out.println("Room No : " + room_num/10);
            System.out.print("Capacity : "+obj.capacity+"     "+"\nRent : "+obj.rent+"\n");
        }
        else {
            System.out.println("No such room exist");
        }
    }
    private void showSingleSeaterRooms()
    {
        for(int i=0;i<single_size;i++)
        {
            System.out.println("Room no :"+(i+1)+"1\n Capacity : "+single.get(i).capacity+"\nRent : "+single.get(i).rent
            +"\nOccupied By : "+single.get(i).occupiedBy);
            System.out.println("\n");
        }
    }
    private  void showdualSeaterRooms()
    {
        for(int i=0;i<dual_size;i++)
        {
            System.out.println("Room no :"+(i+1)+"2\n Capacity : "+dual.get(i).capacity+"\nRent : "+dual.get(i).rent
                    +"\nOccupied By : "+dual.get(i).occupiedBy);
            System.out.println("\n");
        }
    }
    private void showtripleSeaterRooms()
    {
        for(int i=0;i<triple_size;i++)
        {
            System.out.println("Room no :"+(i+1)+"1\n Capacity : "+triple.get(i).capacity+"\nRent : "+triple.get(i).rent
                    +"\nOccupied By : "+triple.get(i).occupiedBy);
            System.out.println("\n");
        }
    }
    private void showAll()
    {
        boolean flag=true;
        if(single_size>0)
        {
            flag=false;
            System.out.println("Single Seaters Status : ");
            showSingleSeaterRooms();
        }
        if(dual_size>0)
        {
            flag=false;
            System.out.println("Dual Seaters Status : ");
            showdualSeaterRooms();
        }
        if(triple_size>0)
        {
            flag=false;
            System.out.println("Triple Seaters Status : ");
            showtripleSeaterRooms();
        }
        if(flag)
        {
            System.out.println("No Rooms Available");
        }
    }

    public void deleteRoom()
    {
        System.out.println("Enter room No : ");
        int num=sc.nextInt();
        if(getRoom(num)!=null)
        {
            if(num%10==1)
            {
                single.set(num/10-1,null);
            }
            else if(num%10==1)
            {
                dual.set(num/10-1,null);
            }
            else
            {
                triple.set(num/10-1,null);
            }
        }
        else
        {
            System.out.println("Room Does not exist");
        }
    }


    public void updateRoom() {
        System.out.println("Enter Room Number : ");
        int num = sc.nextInt();
        while (!isValidRoomNo(num)) {
            System.out.println("Invalid Room Number...Try Again");
            num = sc.nextInt();
        }
        System.out.println("Enter new Rent");
        getRoom(num).rent=sc.nextInt();
    }


    private boolean isValidRoomNo(int num)
    {
        int rem=num%10;
        if(rem>3||rem<1)
        {
            return false;
        }
        num=num/10;
        if(     (rem==1&&(num>single_size||single.get(num-1)==null))  ||
                (rem==2&&(num>dual_size||dual.get(num-1)==null))      ||
                (rem==3&&(num>triple_size||triple.get(num-1)==null))
        )
        {
            return false;
        }
        return true;
    }

    public Room getRoom(int room_num)
    {
        if(isValidRoomNo(room_num)) {
            int rem = room_num % 10;
            room_num /= 10;
            room_num--;
            Room obj = null;
            if (rem == 1) {
                obj = single.get(room_num);
            } else if (rem == 2) {
                obj = dual.get(room_num);
            } else {
                obj = triple.get(room_num);
            }
            return obj;
        }
        return null;
    }
}
