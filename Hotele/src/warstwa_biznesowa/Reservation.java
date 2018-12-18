/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warstwa_biznesowa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Cezary
 */
public class Reservation {
    public String number;
    public LocalDate date;
    
    private Client client;
    private Room room;
    
    public Reservation(LocalDate date, Client client, Room room)
    {
        this.date = date;
        this.client = client;
        this.room = room;
        
        this.GenerateNumber();
    }
    
    public void GenerateNumber()
    {
        // client start date + first name + client last name + room number
        String dateString = date.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String number = dateString + "_" + client.email + "_" + room.number;
        
        this.number = number;
    }
    
    @Override
    public boolean equals(Object o)
    {
        Reservation reservation = (Reservation) o;
        
        if(this.date.compareTo(reservation.date) != 0)
            return false;
        
        if(!this.room.equals(reservation.room))
            return false;
        return true;
    }
}
