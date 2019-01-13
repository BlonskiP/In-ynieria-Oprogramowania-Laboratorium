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
import org.junit.runner.RunWith;
import warstwa_biznesowa.*;


/**
 *
 * @author Cezary
 */

@RunWith(JMockit.class)

public class ReservationTest {
    Data data = new Data();
    
    @Mocked
    Factory factory;
    
    @Test
    public void testGenerateNumber()
    {
        Facade fa = new Facade();
        
        fa.AddCity("asd");
        
        new Verifications() {{ 
            factory.CreateCity(anyString);
            times = 1;
        }};
    }
}
