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
       
        Client client = facade.factory.CreateClient("test@gmail.com", "haslo");
        facade.clientList.add(client);
        
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
        
        // rezerwacja
        LocalDate date = LocalDate.now();
        
        // dodanie 3 tygodni ponieważ anulować można najpóxniej 2 tygodnie przed terminem
        date = date.plus(3, ChronoUnit.WEEKS);
        
        boolean test;
        test = facade.Reserve("test@gmail.com", "haslo", "Wrocław", "Hotel 5 Gwiazdkowy", 2, 100, date);
        System.out.println(test); // powinien byc true
        test = facade.Reserve("test@gmail.com", "haslo", "Wrocław", "Hotel 5 Gwiazdkowy", 2, 100, date);
        System.out.println(test); // powinien byc false
    }
    
    public boolean AddCity(String name)
    {
        City city = factory.CreateCity(name);
        
        if(this.FindCity(city) == null)
        {
            return cityList.add(city);
        }
        
        return false;
    }
    
    public boolean AddHotel(String cityName, String hotelName)
    {
        City cityTemp = factory.CreateCity(cityName);
        City cityExist = FindCity(cityTemp);
        
        if(cityExist != null)
        {
            return cityExist.AddHotel(hotelName);
        }
        
        return false;
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
    
    public boolean AddClient(String email, String password)
    {
        return true;
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
    
    public boolean Reserve(String email, String password, String cityName, String hotelName, int size, int price, LocalDate date)
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
    
    public boolean CancelReservation(int id)
    {
        /*if(client.reservationList.get(id) != null)          // sprzwdzenie czy rezerwacja faktycznie istnieje
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
                return true;
            }
            else
            {
                return false; // Minął okres rezerwacji.
            }
        }
        else
        {
            return false; // Brak rezerwacji o podanym numerze.
        }*/
        return false;
    }
    
    public void RemoveClient()
    {
    }
    
    public boolean RemoveCity(String cityName)
    {        
        // pętla po wszystkich miastach, bo (String string : list) nie pójdzie bo klasa, musiałbym pomyśleć ale tak też zadziała
        for(int i =0; i < cityList.size(); i++) {
            if(cityList.get(i).name.equals(cityName)) {
                // sprawdzenie czy miasto ma jakieś hotele
                if(cityList.get(i).hotelList.isEmpty()) {
                    cityList.remove(i);
                    return true;
                }
                else 
                {
                    return false; // Błąd. Miasto zawiera hotele.
                }
            }
            else
            {
                return false; //Błąd. Nie znaleziono takiego miasta.
            }
        }
        return false;
    }
}
