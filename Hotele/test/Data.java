
import warstwa_biznesowa.Client;
import warstwa_biznesowa.Room;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cezary
 */
public class Data {
    public static String clientsData[][] = new String[][] {
        {"testowy@gmail.com", "haslo"}
    };
    
    public static Client clients[] = {
        new Client("testowy@gmail.com", "haslo")
    };
    
    public static Room rooms[] = {
        new Room(null,1,1,50),
        new Room(null,2,2,100),
        new Room(null,3,3,150),
    };
}//End of Data
