/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.categories.Category;
import java.util.IllegalFormatCodePointException;
import org.junit.rules.ExpectedException;

import org.junit.runner.RunWith;
import warstwa_biznesowa.Client;
import warstwa_biznesowa.Factory;

/**
 *
 * @author Cezary
 */

//@Category({TestControl.class, TestEntity.class}) 

public class FactoryTest {
    Data data;
    
    @Before
    public void setUp() 
    {
        data = new Data();
    }
    
    @Test
    public void testCreateClient()
    {
       Factory factory = new Factory();

       Client client = factory.CreateClient("testowy@gmail.com", "haslo");
       assertEquals(data.clients[0], client);
    }
}
