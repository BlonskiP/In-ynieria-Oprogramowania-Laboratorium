/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warstwa_biznesowa;

import java.util.Date;

/**
 *
 * @author Cezary
 */
public class Reservation {
    public Date date;
    private Client client;
    private Room room;
    
    public Reservation(Date date, Client client, Room room)
    {
        this.date = date;
        this.client = client;
        this.room = room;
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
