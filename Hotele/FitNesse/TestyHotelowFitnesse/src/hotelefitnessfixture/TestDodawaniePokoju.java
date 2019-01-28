/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelefitnessfixture;

import fit.ColumnFixture;
import warstwa_biznesowa.City;
import warstwa_biznesowa.Facade;
import warstwa_biznesowa.Hotel;

/**
 *
 * @author Wilk
 */
public class TestDodawaniePokoju extends ColumnFixture {
    String daneTestu[];
    Facade facade;
    
    public boolean dodajPokoj()
    {
        facade = SetUp.dane.facade;
        facade.AddCity(daneTestu[0]);
        facade.AddHotel(daneTestu[0], daneTestu[1]);
        try{
            int x= Integer.parseInt(daneTestu[5]);
            for(int i=0;i<x;i++){
        facade.AddRoom(daneTestu[0], daneTestu[1], Integer.parseInt(daneTestu[2]), Integer.parseInt(daneTestu[3]), Integer.parseInt(daneTestu[4]));
             }
        return true;
        }
        catch(Exception e)
        {
            return false;
        }
    
    }
    
    public int liczbaPokoi()
    {
        City tempCity=new City(daneTestu[0]);
        Hotel tempHotel=new Hotel(tempCity,daneTestu[1]);
        return facade.FindCity(tempCity).FindHotel(tempHotel).roomList.size();
    }
    
}
