/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import categories.ReserveTestCategory;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;

/**
 *
 * @author Blonski
 */
@Categories.SuiteClasses({FacadeTest.class, CityTest.class, HotelTest.class, RoomTest.class, ClientTest.class})

@RunWith(Categories.class)
@Categories.IncludeCategory(ReserveTestCategory.class)

public class ReserveTest {

}
