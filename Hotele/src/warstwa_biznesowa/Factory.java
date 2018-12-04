/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warstwa_biznesowa;

import java.util.Date;

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
    
    public Room CreateRoom(int size, int price)
    {
        return new Room(size, price);
    }
    
    public Reservation CreateReservation(Date date, Client client, Room room)
    {
        return new Reservation(date, client, room); 
    }
}
