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
public class Facade {
    protected List<City> cityList;
    protected List<Client> clientList;
    private Factory factory;
    private Client client;

    public Facade()
    {
        factory = new Factory();
        client = new Client("test@gmail.com", "haslo", "Jan", "Nowak", "Wroclaw");
        cityList = new ArrayList<City>();
        clientList = new ArrayList<Client>();
    }
    
    public boolean AddCity(String name)
    {
        if(FindCity(name) == null)
        {
            City city = factory.CreateCity(name);
            cityList.add(city);
            return true;
        }
        
        return false;
    }
    
    public boolean AddHotel(String cityName, String name, String address)
    {
        //Walidacja
        if(name == null)
        {
            System.out.println("[ERROR] Błąd danych!");
            return false;
        }
        
        if(this.FindCity(cityName) == null)
        {
            AddCity(cityName);
        }
        
        City city = FindCity(cityName);
        
        if(city.FindHotel(name) != null)
        {
            System.out.println("[ERROR] Taki Hotel już istnieje!");
            return false;
        }
        
        city.AddHotel(name, address);
        System.out.println("[SUCCESS] Hotel został dodany prawidłowo - Fasada");
        return true;
    }
    
    public boolean AddRoom(String cityName, String hotelName, int size, String desc, int price)
    {
        Room room = factory.CreateRoom(desc, size, price);
           
        City city = this.FindCity(cityName);
        if(city == null)
        {
            System.out.println("[ERROR] Nie ma miasta");
            return false;
        }
        
        Hotel hotel = city.FindHotel(hotelName);
        if(hotel == null)
        {
            System.out.println("[ERROR] Nie ma hotelu");
            return false;
        }
        
        hotel.roomList.add(room);
        System.out.println("[SUCCESS] Dodano pokój do hotelu");
        return true;
    }
    
    public boolean AddClient(String email, String password)
    {
        return false;
    }
    
    public City FindCity(String name)
    {
        for(City city : this.cityList) //https://www.baeldung.com/find-list-element-java
        {
            if(city.name.equals(name))
            {
                return city;
            }
        }
        
        return null;
    }
    
    public Client FindClient()
    {
        return client;
    }
    
    public boolean MakeReservation(String cityName, String hotelName, int size, Date date)
    {
        // tutaj poprawić
        if(this.FindClient() == null)
        {
            System.out.println("[ERROR] Nie ma klienta");
            return false;
        }
        
        City city = this.FindCity(cityName);
        if(city == null)
        {
            System.out.println("[ERROR] Nie ma miasta");
            return false;
        }
        
        Hotel hotel = city.FindHotel(hotelName);
        if(hotel == null) // dopytać czy to porównanie ma być w klasie City tak jak na diagramie
        {
            System.out.println("[ERROR] Nie ma hotelu");
            return false;
        }
        
        Room room = hotel.FindRoom(size, date);
        if(room == null)
        {
            System.out.println("[ERROR] Nie ma pokoju w tym terminie");
            return false;
        }
        
        Reservation reservation = factory.CreateReservation(date, client);
        room.reservationList.add(reservation);
        client.reservationList.add(reservation);

        System.out.println("[SUCCESS] Rezerwacja została dokonana");
        return true;
    }
    
    public void CancelReservation(Reservation reservation)
    {
        
    }
    
    public void DeleteClient()
    {
    }
}
