/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;
import warstwa_biznesowa.City;
import warstwa_biznesowa.Facade;
import warstwa_biznesowa.Hotel;
import warstwa_biznesowa.Room;

/**
 *
 * @author Cezary
 */

@Category({TestControl.class, TestEntity.class}) 
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CityTest {
    Data data = new Data();
    Facade facade = new Facade();

    @Test
    public void testAddRoom() 
    {
        City city = data.cities[0];
        Hotel hotel = data.hotels[0];
        
        city.hotelList.add(hotel);
        
        for(int i = 0; i < data.roomsData.length; i++)
        {
            assertTrue(city.AddRoom(hotel.GetName(), data.roomsData[i][0], data.roomsData[i][1], data.roomsData[i][2]));
            assertFalse(city.AddRoom(hotel.GetName(), data.roomsData[i][0], data.roomsData[i][1], data.roomsData[i][2]));
            
            Room room = hotel.roomList.get(i);
            assertEquals(i + 1, hotel.roomList.size());
            assertEquals(data.rooms[i], hotel.roomList.get(i));
        }
    }
}
