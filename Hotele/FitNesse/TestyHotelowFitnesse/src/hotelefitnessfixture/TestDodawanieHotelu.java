/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelefitnessfixture;

import fit.ColumnFixture;
import warstwa_biznesowa.City;
import warstwa_biznesowa.Facade;

/**
 *
 * @author Wilk
 */
public class TestDodawanieHotelu extends ColumnFixture {
    String daneTestu[];
    Facade facade;
    public boolean dodajHotel()
    {
        facade = SetUp.dane.facade;
        facade.AddCity(daneTestu[0]);
        
       
        try{
            boolean result;
           
            result = facade.AddHotel(daneTestu[0], daneTestu[1]);
            return result;
        }
        catch(Exception e) {
            return false;}
    }
    
    public int liczbaHoteli()
    {
        City tempCity=new City(daneTestu[0]);
        return facade.FindCity(tempCity).hotelList.size();
    }
}
