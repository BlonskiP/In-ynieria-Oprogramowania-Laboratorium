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
    public Hotel CreateHotel(String name, String address ){
        return new Hotel(name, address);
    };
    public City CreateCity(String name){return new City(name);};
    
    public Room CreateRoom(String desc, int size, int price)
    {
        return new Room(desc, size, price);
    }
    
    public Client CreateClient(String email, String pass, String firstName, String lastName, String address)
    {
        return new Client(email, pass, firstName, lastName, address);
    }
    
    public Reservation CreateReservation(Date date, Client client)
    {
        return new Reservation(date, client); 
    }
}
