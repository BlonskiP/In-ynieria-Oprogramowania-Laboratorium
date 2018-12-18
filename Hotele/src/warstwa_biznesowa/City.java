/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warstwa_biznesowa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cezary
 */
public class City {
    protected String name;
    protected String country;
    
    public List<Hotel> hotelList;
    
    private Factory factory;
    
    public City(String name)
    {
        this.name = name;
        
        hotelList = new ArrayList<Hotel>();
        
        factory = new Factory();
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
    
    public boolean AddHotel(String hotelName)
    {    
        Hotel hotel = factory.CreateHotel(hotelName);
        Hotel hotelExist = FindHotel(hotel);
        
        if(hotelExist == null)
        {
            return this.hotelList.add(hotel);
        }

        return false;
    }
    
    public Hotel FindHotel(Hotel hotel)
    {
        int index = -1;
        
        if((index = this.hotelList.indexOf(hotel)) != -1)
            return this.hotelList.get(index);
        
        return null;
    }
    
    public boolean AddRoom(String hotelName, int number, int size, int price)
    {
        Hotel hotel;
        Hotel hotelTemp = factory.CreateHotel(hotelName);
        if((hotel = this.FindHotel(hotelTemp)) == null)
        {
            return false;
        }
        
        return hotel.AddRoom(number, size, price);
    }
    
    public boolean Reserve(Client client, String hotelName, int size, int price, LocalDate startDate, LocalDate endDate)
    {
        Factory factory = new Factory();
        
        Hotel hotel;
        Hotel hotelTemp = factory.CreateHotel(hotelName);
        if((hotel = this.FindHotel(hotelTemp)) == null)
        {
            return false;
        }
        
        return hotel.Reserve(client, size, price, startDate, endDate);
    }
    
    @Override
    public boolean equals(Object o)
    {
        City city = (City) o;
        return this.name.equals(city.name);
    }
}
