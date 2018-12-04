/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warstwa_biznesowa;

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
    
    public City(String name)
    {
        this.name = name;
        this.country = null;
        
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
    
    public boolean AddHotel(Hotel hotel)
    {
        
        hotelList.add(hotel);
        System.out.println("[SUCCESS] Hotel został dodany prawidłowo - City");
        return true;
    }
    
    public Hotel FindHotel(String name)
    {   System.out.println("Szukam Hotelu");
        for(Hotel hotel : this.hotelList) //https://www.baeldung.com/find-list-element-java
        {System.out.println(hotel.name);
            if(hotel.name.equals(name))
            {
                return hotel;
            }
        }
        return null;
    }
}
