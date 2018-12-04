/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warstwa_biznesowa;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Cezary
 */
public class Main {
    public static void main(String[] args)
    {
        Facade facade = new Facade();
        
        
        // dodawanie miasta
        facade.AddCity("Wrocław");
        for(City city : facade.cityList)
        {
            System.out.println(city.name);
        }
        
        // dodawanie hotelu
        facade.AddHotel("Wrocław", "Hotel 5 Gwiazdkowy", "Plac Grunwaldzki 1");
        
        City city = facade.FindCity("Wrocław");
        for(Hotel hotel : city.hotelList)
        {
            System.out.println(hotel.name);
        }
        
        // dodawanie pokoju
        facade.AddRoom("Wrocław", "Hotel 5 Gwiazdkowy", 2, "Opis", 100);
        
        Hotel hotel = city.FindHotel("Hotel 5 Gwiazdkowy");
        for(Room room : hotel.roomList)
        {
            System.out.println("Rozmiar: " + room.size + " | Cena: " + room.price + " | Opis: " + room.description);
        }
        
        // rezerwacja
        Date date = new Date();
        
        // dodanie 3 tygodni ponieważ anulować można najpóxniej 2 tygodnie przed terminem
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_MONTH, 3);
        date = calendar.getTime();
    
        facade.MakeReservation("Wrocław", "Hotel 5 Gwiazdkowy", 2, date); // powinien byc success
        facade.MakeReservation("Wrocław", "Hotel 5 Gwiazdkowy", 2, date); // powinien byc Error

        // anulowanie
        //facade.CancelReservation("Wrocław", "Hotel 5 Gwiazdkowy", 2, date);
    }
}
