/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warstwa_biznesowa;

import java.util.ArrayList;
import java.util.Calendar;
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
        cityList = new ArrayList<City>();
        clientList = new ArrayList<Client>();
    }
    
    public static void main(String[] args)
    {
        Facade facade = new Facade();
       
        Client client = facade.factory.CreateClient("test@gmail.com", "haslo");
        facade.clientList.add(client);
        
        // dodawanie miasta
        City city = facade.AddCity("Wrocław");
        for(City loopCity : facade.cityList)
        {
            System.out.println(loopCity.name);
        }
        
        // dodawanie hotelu
        Hotel hotel = facade.AddHotel("Wrocław", "Hotel 5 Gwiazdkowy");
        for(Hotel loopHotel : city.hotelList)
        {
            System.out.println(loopHotel.name);
            hotel.roomList.add(new Room(2, 100));
        }
        
        // dodawanie pokoju
        //facade.AddRoom("Wrocław", "Hotel 5 Gwiazdkowy", 2, 100)
        for(Room loopRoom : hotel.roomList)
        {
            System.out.println(loopRoom.size + " " + loopRoom.price);
        }
        
        // rezerwacja
        Date date = new Date();
        
        // dodanie 3 tygodni ponieważ anulować można najpóxniej 2 tygodnie przed terminem
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_MONTH, 3);
        date = calendar.getTime();
        
        boolean test;
        test = facade.MakeReservation("test@gmail.com", "haslo", "Wrocław", "Hotel 5 Gwiazdkowy", 2, 100, date);
        System.out.println(test); // powinien byc true
        test = facade.MakeReservation("test@gmail.com", "haslo", "Wrocław", "Hotel 5 Gwiazdkowy", 2, 100, date);
        System.out.println(test); // powinien byc false
    }
    
    public City AddCity(String name)
    {
        City city = factory.CreateCity(name);
        
        if(this.FindCity(city) == null)
        {
            cityList.add(city);
            return city;
        }
        
        return null;
    }
    
    public Hotel AddHotel(String cityName, String name)
    {
        City cityTemp = factory.CreateCity(cityName), city;
        if((city = this.FindCity(cityTemp)) == null)
        {
            city = this.AddCity(cityName);
        }
        
        /*Hotel hotel = factory.CreateCity(cityName);
        if(city.FindHotel(name) != null)
        {
            System.out.println("[ERROR] Taki Hotel już istnieje!");
            return false;
        }*/
        
        Hotel hotel = factory.CreateHotel(name);
        city.AddHotel(hotel);
        return hotel;
    }
    
    public boolean AddRoom(String cityName, String hotelName, int size, int price)
    {
        Room room = factory.CreateRoom(size, price);
        /*City cityTemp = factory.CreateCity(cityName), city;
        if((city = this.FindCity(cityTemp)) == null)
        {
            city = this.AddCity(cityName);
        }
        
        Hotel hotel = city.FindHotel(hotelName);
        System.out.println("Szukam hotelu");
        if(hotel == null)
        {
            System.out.println("[ERROR] Nie ma hotelu - Fasada FindHotel" );
            return false;
        }
        */
        /*hotel.roomList.add(room);*/
        return true;
    }
    
    public boolean AddClient(String email, String password)
    {
        return false;
    }
    
    public City FindCity(City city)
    {
        int index = -1;
        
        if((index = this.cityList.indexOf(city)) != -1)
            return this.cityList.get(index);
        
        return null;
    }
    
    public Client FindClient(Client client)
    {
        int index = -1;
        
        if((index = this.clientList.indexOf(client)) != -1)
            return this.clientList.get(index);
        
        return null;
    }
    
    public boolean MakeReservation(String email, String password, String cityName, String hotelName, int size, int price, Date date)
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
        
        return city.Reserve(client, hotelName, date, size, price);
    }
    
    public void CancelReservation(int id)
    {
        if(client.reservationList.get(id) != null)          // sprzwdzenie czy rezerwacja faktycznie istnieje
        {         
            Date today = new Date();
            Date tmp = client.reservationList.get(id).date; // tworzenie daty do sprawdzenia, czy 
            int noOfDays = 14; //i.e two weeks  
            Calendar calendar = Calendar.getInstance();     // ogólnie czy data rezerwacji + 2 tydodnie jest mniejsza od dzisiaj
            calendar.setTime(tmp);            
            calendar.add(Calendar.DAY_OF_YEAR, noOfDays);
            Date date = calendar.getTime();                 // date = data pobytu + 2 tyg 
            
            if(date.compareTo(today) < 0)                   // sprzwdzenie czy są 2 tygodnie przed
            {                                               // date.compareTo(_date) jest mniejsze od 0 gdy dzisiejsza data jest mniejsza o więcej niż 2 tygodnie od daty pobytu
                client.reservationList.remove(id);
            }
            else{
                System.out.print("Minął okres rezerwacji.");
            }
        }
        else{
            System.out.print("Brak rezerwacji o podanym numerze.");
        }
    }
    
    public void DeleteClient()
    {
    }
}
