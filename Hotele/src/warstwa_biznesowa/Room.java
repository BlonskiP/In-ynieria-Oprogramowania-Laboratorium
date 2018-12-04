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
public class Room {
    protected String description;
    protected int size;
    protected int price;
    protected String photo;
    
    public List<Reservation> reservationList;
    
    public Room(String desc, int size, int price)
    {
        this.description = desc;
        this.size = size;
        this.price = price;
        
        reservationList = new ArrayList<Reservation>();
    }
    
    public void SetDescription(String des)
    {
        this.description = des;
    }
    
    public void SetSize(int size)
    {
        this.size = size;
    }
    
    public void SetPrice(int price)
    {
        this.price = price;
    }
    
    public void SetPhoto(String photo)
    {
        this.photo = photo;
    }
    
    public int GetPrice()
    {
        return this.price;
    }
    
    public int GetSize()
    {
        return this.size;
    }
    
    public String GetPhoto()
    {
        return this.photo;
    }
    
    public List GetReservationList()
    {
        return this.reservationList;
    }
    
    public Reservation GetReservation(Date date)
    {
        for(Reservation reservation : reservationList)
        {
            if(reservation.date.compareTo(date) == 0)
            {
                return reservation;
            }
        }
        
        return null;
    }
}
