/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warstwa_biznesowa;

import java.util.ArrayList;
import java.time.LocalDate;
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
    
    private List<Reservation> reservationList;
    
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
    
    public Reservation FindReservationByDate(Reservation reservation)
    {
        for(Reservation loopReservation : reservationList)
        {
            if(reservation.startDate.compareTo(loopReservation.startDate) >= 0 && reservation.startDate.compareTo(loopReservation.endDate) < 0
                || reservation.endDate.compareTo(loopReservation.startDate) > 0 && reservation.endDate.compareTo(loopReservation.endDate) <= 0)
                return loopReservation;
        }
        
        return null;
    }
    
    public boolean Reserve(Client client, LocalDate startDate, LocalDate endDate)
    {
        Reservation reservation = factory.CreateReservation(client, this, startDate, endDate);
        if(FindReservationByDate(reservation) != null)
        {
            return false;
        }
        
        this.reservationList.add(reservation);
        return client.Reserve(reservation);
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
