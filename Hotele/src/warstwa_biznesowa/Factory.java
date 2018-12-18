/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warstwa_biznesowa;

import java.time.LocalDate;

/**
 *
 * @author Wilk
 */
public class Factory {
    Factory(){};
    
    public Client CreateClient(String email, String password)
    {
        return new Client(email, password);
    }
    
    public City CreateCity(String name)
    {
        return new City(name);
    }
    
    public Hotel CreateHotel(String name)
    {
        return new Hotel(name);
    }
    
    public Room CreateRoom(int number, int size, int price)
    {
        return new Room(number, size, price);
    }
    
    public Reservation CreateReservation(Client client, Room room, LocalDate startDate, LocalDate endDate)
    {
        return new Reservation(client, room, startDate, endDate); 
    }
}
