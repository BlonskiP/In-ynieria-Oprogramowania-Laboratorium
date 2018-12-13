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
    protected int number;
    protected int size;
    protected int price;
    
    protected String description;
    protected String photo;
    
    public List<Reservation> reservationList;
    
    private Factory factory;
    
    public Room(int number, int size, int price)
    {
        this.number = number;
        this.size = size;
        this.price = price;
        
        reservationList = new ArrayList<Reservation>();
        
        factory = new Factory();
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
    
    public Reservation FindReservation(Reservation reservation)
    {
        int index = -1;
        
        if((index = this.reservationList.indexOf(reservation)) != -1)
            return this.reservationList.get(index);
        
        return null;
    }  
    
    public boolean Reserve(Client client, Date date)
    {
        Reservation reservation = factory.CreateReservation(date, client, this);
        if(this.FindReservation(reservation) != null)
        {
            return false;
        }
        
        client.reservationList.add(reservation);
        this.reservationList.add(reservation);
        return true;
    }
    
    public boolean CompareAttributes(int size, int price)
    {
        if(this.size != size || this.price != price)
        {
            return false;
        }
        
        return true;
    }
    
    @Override
    public boolean equals(Object o)
    {
        Room room = (Room) o;
        return this.number == room.number;
    }
}
