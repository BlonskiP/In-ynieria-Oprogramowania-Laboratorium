import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
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

public class HotelTest {
    Data data;
    Hotel hotel;
    
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
}
