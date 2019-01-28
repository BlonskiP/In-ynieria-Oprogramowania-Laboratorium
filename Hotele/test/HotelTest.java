import categories.AddRoomTestCategory;
import categories.ReserveTestCategory;
import categories.TestControl;
import categories.TestEntity;
import java.time.LocalDate;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.categories.Category;
import warstwa_biznesowa.City;
import warstwa_biznesowa.Client;
import warstwa_biznesowa.Facade;
import warstwa_biznesowa.Hotel;
import warstwa_biznesowa.Room;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Blonski
 */

@Category({TestControl.class, TestEntity.class}) 

public class HotelTest {
    Data data;
    Hotel hotel;
    Facade facade = new Facade();
    
    public Room room1;
    
    @Before
    public void setUp()
    {
        hotel = new Hotel(null,"TestHotel");
    }
    
    @Test
    public void roomListShouldContainRooms(){
        hotel.AddRoom(1, 1, 50);
        hotel.AddRoom(2, 2, 100);
        hotel.AddRoom(3, 3, 150);
        
       assertEquals(hotel.roomList.size(), 3); //check Size
       
       for(int i=0;i<hotel.roomList.size();i++)
       {
           assertEquals(hotel.roomList.get(i),data.rooms[i]);
       }
    
    }
    
    @Test
    public void FindRoomShouldGiveSpecificRooms()
    {
        hotel.roomList.add(data.rooms[0]);
        hotel.roomList.add(data.rooms[1]);
        hotel.roomList.add(data.rooms[2]);
        
        assertEquals(hotel.FindRoom(data.rooms[0]),data.rooms[0]);
        assertEquals(hotel.FindRoom(data.rooms[1]),data.rooms[1]);
        assertEquals(hotel.FindRoom(data.rooms[2]),data.rooms[2]);
    }
    
    @Category({AddRoomTestCategory.class})
    @Test
    public void testAddRoom()
    {
        Hotel hotel = data.hotels[0];
        
        for(int i = 0; i < data.roomsData.length; i++)
        {
            assertTrue(hotel.AddRoom(data.roomsData[i][0], data.roomsData[i][1], data.roomsData[i][2]));
            assertFalse(hotel.AddRoom(data.roomsData[i][0], data.roomsData[i][1], data.roomsData[i][2]));
            
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
        Hotel hotel = city.hotelList.get(0);
        
        assertTrue(hotel.Reserve(client, data.roomsData[0][1], data.roomsData[0][2], LocalDate.now(), LocalDate.now()));
    }
}
