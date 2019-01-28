/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import categories.AddRoomTestCategory;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;

/**
 *
 * @author Cezary
 */

@Categories.SuiteClasses({FacadeTest.class, CityTest.class, HotelTest.class})

@RunWith(Categories.class)
@Categories.IncludeCategory(AddRoomTestCategory.class)

public class AddRoomTest {
}
