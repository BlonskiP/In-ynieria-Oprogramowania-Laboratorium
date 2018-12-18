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
    public LocalDate startDate;
    public LocalDate endDate;
    
    private Client client;
    private Room room;
    
    public Reservation(Client client, Room room, LocalDate startDate, LocalDate endDate)
    {
        this.client = client;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;

        this.GenerateNumber();
    }
    
    public Reservation(String number)
    {
        this.number = number;
    }
    
    public void GenerateNumber()
    {
        // client start date + first name + client last name + room number
        String dateString = startDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String number = dateString + "_" + client.email + "_" + room.number;
        
        this.number = number;
    }
    
    @Override
    public boolean equals(Object o)
    {
        Reservation reservation = (Reservation) o;
        return this.number.equals(reservation.number);
    }
}
