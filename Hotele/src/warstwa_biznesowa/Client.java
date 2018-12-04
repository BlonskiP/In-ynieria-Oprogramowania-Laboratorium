/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warstwa_biznesowa;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cezary
 */
public class Client {
    protected String email;
    protected String password;
    protected String firstName;
    protected String lastName;
    protected String phone;
    protected String address;
    
    public List<Reservation> reservationList;
    
    public Client(String email, String password, String firstName, String lastName, String address)
    {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        
        reservationList = new ArrayList<Reservation>();
    }
    
    public void SetEmail(String email)
    {
        this.email = email;
    }
    
    public void SetPassword(String password)
    {
        this.password = password;
    }
    
    public void SetFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public void SetLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public void SetPhone(String phone)
    {
        this.phone = phone;
    }
    
    public void SetAddress(String address)
    {
        this.address = address;
    }
    
    public String GetEmail()
    {
        return this.email;
    }
    
    public String GetFirstName()
    {
        return this.firstName;
    }
    
    public String GetLastName()
    {
        return this.lastName;
    }
    
    public String GetPhone()
    {
        return this.phone;
    }
    
    public String GetAddress()
    {
        return this.address;
    }
    
    public List GetReservationlist()
    {
        return this.reservationList;
    }
    
    public boolean CheckPassword(String password)
    {
        return true;
    }
}
