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
    
    public Reservation(Date date, Client client)
    {
        this.date = date;
        this.client = client;
    }
}
