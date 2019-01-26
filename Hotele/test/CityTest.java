/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import categories.AddRoomTestCategory;
import categories.ReserveTestCategory;
import categories.TestControl;
import categories.TestEntity;
import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;
import warstwa_biznesowa.City;
import warstwa_biznesowa.Client;
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

    @Category({AddRoomTestCategory.class})
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
    
    @Category({ReserveTestCategory.class})
    @Test
    public void testReserve()
    {
        Client client = data.clients[0];
        
        facade.AddCity(data.citiesData[0]);
        facade.AddHotel(data.citiesData[0], data.hotelsData[0][1]);
        facade.AddRoom(data.citiesData[0], data.hotelsData[0][1], data.roomsData[0][0], data.roomsData[0][1], data.roomsData[0][2]);
        
        City city = facade.cityList.get(0);
        
        assertTrue(city.Reserve(client, data.hotelsData[0][1], data.roomsData[0][1], data.roomsData[0][2], LocalDate.now(), LocalDate.now()));
    }
}
