/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warstwa_biznesowa;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cezary
 */
public class Facade {
    protected List<City> cityList;
    protected List<Client> clientList;
    private Factory factory;

    public Facade()
    {
        factory = new Factory();
        cityList = new ArrayList<City>();
        clientList = new ArrayList<Client>();
    }
    
    public static void main(String[] args)
    {
        Facade facade = new Facade();
       
        facade.AddClient("test@gmail.com", "haslo");
        
        // dodawanie miasta
        facade.AddCity("Wrocław");
        for(City loopCity : facade.cityList)
        {
            System.out.println(loopCity.name);
        }
        
        
        City city = facade.FindCity(facade.factory.CreateCity("Wrocław"));
        
        // dodawanie hotelu
        facade.AddHotel("Wrocław", "Hotel 5 Gwiazdkowy");
        for(Hotel loopHotel : city.hotelList)
        {
            System.out.println(loopHotel.name);
        }

        Hotel hotel = city.FindHotel(facade.factory.CreateHotel("Hotel 5 Gwiazdkowy"));
        
        // dodawanie pokoju
        facade.AddRoom("Wrocław", "Hotel 5 Gwiazdkowy", 100, 2, 100);
        for(Room loopRoom : hotel.roomList)
        {
            System.out.println(loopRoom.size + " " + loopRoom.price);
        }
        
        
        // ------ REZERWACJA ------ //
        
        // Dodanie do daty początkowej 3 tygodni, ponieważ anulować można tylko max 2 tyg przed datą początkową
        LocalDate startDate = LocalDate.now().plus(3, ChronoUnit.WEEKS),
                endDate = startDate.plus(7, ChronoUnit.DAYS);
        
        boolean test;
        test = facade.Reserve("test@gmail.com", "haslo", "Wrocław", "Hotel 5 Gwiazdkowy", 2, 100, startDate, endDate);
        System.out.println(test); // powinien byc true
        test = facade.Reserve("test@gmail.com", "haslo", "Wrocław", "Hotel 5 Gwiazdkowy", 2, 100, startDate, endDate);
        System.out.println(test); // powinien byc false
        
        // ------ ANULOWANIE ------ //
        Room room = hotel.roomList.get(0);
        Reservation reservation = (Reservation) room.GetReservationList().get(0);
        facade.CancelReservation("test@gmail.com", "haslo", reservation.number);
        
        test = facade.Reserve("test@gmail.com", "haslo", "Wrocław", "Hotel 5 Gwiazdkowy", 2, 100, startDate, endDate);
        System.out.println(test); // powinien byc true
        
        // Dopisać jakieś ładniejsze wyświetlanie danych + więcej przypadków
    }
    
    public boolean AddClient(String email, String password)
    {
        Client client = factory.CreateClient(email, password);
        
        if(FindClient(client) != null)
        {
            return false;
        }
  
        return clientList.add(client);
    }
    
    public boolean AddCity(String name)
    {
        City city = factory.CreateCity(name);
        
        if(FindCity(city) != null)
        {
            return false;
        }
        
        return cityList.add(city);
    }
    
    public boolean AddHotel(String cityName, String hotelName)
    {
        City city;
        City cityTemp = factory.CreateCity(cityName);
        
        if((city = FindCity(cityTemp)) == null)
        {
            return false;
        }
        
        
        return city.AddHotel(hotelName);
    }
    
    public boolean AddRoom(String cityName, String hotelName, int number, int size, int price)
    {
        City city;
        City cityTemp = factory.CreateCity(cityName);
        
        if((city = this.FindCity(cityTemp)) == null)
        {
            return false;
        }

        return city.AddRoom(hotelName, number, size, price);
    }
    
    public Client FindClient(Client client)
    {
        int index = -1;
        
        if((index = this.clientList.indexOf(client)) != -1)
            return this.clientList.get(index);
        
        return null;
    }
    
    public City FindCity(City city)
    {
        int index = -1;
        
        if((index = this.cityList.indexOf(city)) != -1)
            return this.cityList.get(index);
        
        return null;
    }
    
    public boolean Reserve(String email, String password, String cityName, String hotelName, int size, int price, LocalDate startDate, LocalDate endDate)
    {
        Client client;
        City city;
        
        Client clientTemp = factory.CreateClient(email, password);
        if((client = this.FindClient(clientTemp)) == null)
        {
            return false;
        }
     
        City cityTemp = factory.CreateCity(cityName);
        if((city = this.FindCity(cityTemp)) == null)
        {
            return false;
        }
        
        return city.Reserve(client, hotelName, size, price, startDate, endDate);
    }
    
    public boolean CancelReservation(String email, String password, String reservationNumber)
    {
        Client client;
 
        Client clientTemp = factory.CreateClient(email, password);
        if((client = this.FindClient(clientTemp)) == null)
        {
            return false;
        }
        
        return client.CancelReservation(reservationNumber);
    }
    
    public boolean RemoveClient(String email, String password)
    {
        return true;
    }
    
    public boolean RemoveCity(String cityName)
    {        
        City city;
        
        City cityTemp = factory.CreateCity(cityName);
        if((city = this.FindCity(cityTemp)) == null)
        {
            return false;
        }
        
        if(!city.CancelReservations())
        {
            return false;
        }
        
        return this.cityList.remove(city);
    }
    
    public boolean RemoveHotel(String cityName, String hotelName)
    {
        return true;
    }
    
    public boolean RemoveRoom(String cityName, String hotelName, int number)
    {
        return true;
    }
}
