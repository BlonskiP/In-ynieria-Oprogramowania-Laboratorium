/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelefitnessfixture;

import fit.ColumnFixture;
import static hotelefitnessfixture.Data.facade;
import java.time.LocalDate;
import warstwa_biznesowa.City;
import warstwa_biznesowa.Client;
import warstwa_biznesowa.Hotel;

/**
 *
 * @author Wilk
 */
public class TestDodawanieRezerwacji extends ColumnFixture {
    City tempCity;
                               //0   1          2                   3   4 5 6
    String daneTestu[]; //|Warszawa,DobryHotel,AdresMail@gmail.com,1qaz,1,2,3|
    public boolean dodajRezerwacje()
    {
        tempCity= new City(daneTestu[0]);
        Hotel tempHotel=new Hotel(tempCity,daneTestu[1]);
        facade = SetUp.dane.facade;
        facade.AddCity(daneTestu[0]);
        facade.AddHotel(daneTestu[0], daneTestu[1]);
        facade.AddClient(daneTestu[2], daneTestu[3]);
        int size=Integer.parseInt(daneTestu[4]);
        int price = Integer.parseInt(daneTestu[5]);
        int number = Integer.parseInt(daneTestu[6]);
        facade.FindCity(tempCity).FindHotel(tempHotel).AddRoom(number,size,price);
        
        try{
        
            facade.Reserve(daneTestu[2], daneTestu[3], daneTestu[0], daneTestu[1], size, price, LocalDate.MAX, LocalDate.MAX);
            return true;
        
        }
        catch(Exception e){return false;}
    
    }
    
    public int ileRezerwacji()
    {   
        Client tempClient=new Client(daneTestu[2], daneTestu[3]);
        return facade.FindClient(tempClient).reservationList.size();
    }
    
}
