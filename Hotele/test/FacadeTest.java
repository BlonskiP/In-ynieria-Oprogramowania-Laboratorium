/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.time.LocalDate;
import mockit.*;
import mockit.integration.junit4.JMockit;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import warstwa_biznesowa.*;


/**
 *
 * @author Cezary
 */
@Category({TestControl.class, TestEntity.class}) 
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class FacadeTest {
    Data data = new Data();
    Facade facade = new Facade();
    
    @Before
    public void setUp()
    {
        //facade.AddCity("Wrocław");
        //facade.AddHotel("Wrocław", "Hotel 5");
        //facade.AddRoom("Wrocław", "Hotel 5", 1, 2, 100);
    }
    
    @Test
    public void testAddClient()
    {
        for(int i = 0; i < data.clientsData.length; i++)
        {
            facade.AddClient(data.clientsData[i][0], data.clientsData[i][1]);

            assertEquals(i + 1, facade.clientList.size());
            assertEquals(data.clients[i], facade.clientList.get(i));
        }
    }
    
    @Test
    public void testAddCity()
    {
        for(int i = 0; i < data.citiesData.length; i++)
        {
            facade.AddCity(data.citiesData[i]);

            assertEquals(i + 1, facade.cityList.size());
            assertEquals(data.cities[i], facade.cityList.get(i));
        }
    }
    
    @Test
    public void testAddHotel()
    {
        for(int i = 0; i < data.hotelsData.length; i++)
        {
            facade.AddCity(data.citiesData[i]);
            facade.AddHotel(data.hotelsData[i][0], data.hotelsData[i][1]);

            City city = facade.cityList.get(i);
            
            assertEquals(1, city.hotelList.size());
            assertEquals(data.hotels[i], city.hotelList.get(0));
        }
    }
}
