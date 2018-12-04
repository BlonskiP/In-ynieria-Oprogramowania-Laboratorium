/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warstwa_biznesowa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Cezary
 */
public class Hotel {
    protected String name;
    protected String description;
    protected String address;
    protected int stars;
    protected String photo;
    
    public List<Room> roomList;
   
    public Hotel(String name, String address)
    {
        this.name = name;
        this.address = address;
        
        roomList = new ArrayList<Room>();
    }
    
    public void SetName(String name)
    {
        this.name = name;
    }
    
    public void SetDescription(String desc)
    {
        this.description = desc;
    }
    
    public void SetAddress(String address)
    {
        this.address = address;
    }
    
    public void SetStars(int stars)
    {
        this.stars = stars;
    }
    
    public void SetPhoto(String photo)
    {
        this.photo = photo;
    }
    
    public String GetName()
    {
        return this.name;
    }
    
    public String GetAddress()
    {
        return this.address;
    }
    
    public int GetStars()
    {
        return this.stars;
    }
    
    public String GetPhoto()
    {
        return this.photo;
    }
    
    public List GetRoomList()
    {
        return this.roomList;
    }
    
    public Room FindRoom(int size, Date date)
    {
        for(Room room : roomList)
        {
            if(room.size == size)
            {
                if(room.GetReservation(date) == null)
                {
                    return room;
                }
            }
        }
        
        return null;
    }
}
