package com.java.tenant;

import com.java.manager.PGManager;
import com.java.model.PG;
import com.java.model.*;
import com.java.model.SingleSharing;

import java.io.IOException;

public class Tenant
{
     PGManager manager;
    String name;
    String contact_no;
    int age;

    public Tenant(String name, String contact_no, int age) {
        this.name = name;
        this.contact_no = contact_no;
        this.age = age;
        manager=PGManager.getManager();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact_no() {
        return contact_no;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void roomRequired() throws IOException {
        int count=1;
        for(PG pg: manager.pgs)
        {
            System.out.println("---------------------------------------PG : "+count+"---------------------------------------\n");
            pg.show();
        }
        System.out.println("Wanna Book or Not.....yes or no");
        System.out.println("Wanna Book or Not");
                System.in.read();
        bookRoom(1,11);
    }
     public void bookRoom(int pgNo,int roomNo)
     {
       PG pg= manager.pgs.get(pgNo);
       Room room=pg.getRoom(roomNo);
       if(room!=null)
       {
           boolean bookOrNot=false;
           if(room instanceof SingleSharing&& room.capacity>room.occupiedBy)
           {
               System.out.println("Room Booking Done....");
               room.occupiedBy--;
               bookOrNot=true;
           }
           else if(room instanceof DualSharing&& room.capacity>room.occupiedBy)
           {
               System.out.println("Room Booking Done....");
               room.occupiedBy--;
               bookOrNot=true;
           }
           else if(room instanceof TripleSharing&& room.capacity>room.occupiedBy)
           {
               System.out.println("Room Booking Done....");
               room.occupiedBy--;
               bookOrNot=true;
           }
           else
           {
               System.out.println("Room not available...");
           }
           if(bookOrNot)
           {
               manager.tenant.add(new Tenant("Archit","7456813796",20));
           }
       }
     }
}
