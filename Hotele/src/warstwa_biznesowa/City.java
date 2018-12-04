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
public class City {
    protected String name;
    protected String country;
    
    public List<Hotel> hotelList;
    
    public City(String name)
    {
        this.name = name;
        
        hotelList = new ArrayList<Hotel>();
    }
    
    public void SetName(String name)
    {
        this.name = name;
    }
    
    public void SetCountry(String country)
    {
        this.country = country;
    }
    
    public String GetName()
    {
        return this.name;
    }
    
    public String GetCountry()
    {
        return this.country;
    }
    
    public List GetHotelList()
    {
        return this.hotelList;
    }
    
    public void AddHotel(Hotel hotel)
    {
        this.hotelList.add(hotel);
    }
    
    public Hotel FindHotel(Hotel hotel)
    {
        int index = -1;
        
        if((index = this.hotelList.indexOf(hotel)) != -1)
            return this.hotelList.get(index);
        
        return null;
    }
    
    public boolean Reserve(Client client, String hotelName, Date date, int size, int price)
    {
        Factory factory = new Factory();
        
        Hotel hotel;
        Hotel hotelTemp = factory.CreateHotel(hotelName);
        if((hotel = this.FindHotel(hotelTemp)) == null)
        {
            return false;
        }
        
        Reservation reservation = hotel.Reserve(client, date, size, price);

        if(reservation != null)
        {
            client.reservationList.add(reservation);
            return true;
        }
        
        return false;
    }
    
    @Override
    public boolean equals(Object o)
    {
        City city = (City) o;
        return this.name.equals(city.name);
    }
}
