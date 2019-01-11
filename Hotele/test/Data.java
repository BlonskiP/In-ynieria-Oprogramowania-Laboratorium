
import warstwa_biznesowa.Client;

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
}
