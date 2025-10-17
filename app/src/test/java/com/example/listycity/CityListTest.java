package com.example.listycity;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Test methods
 */
public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    public City mockCity() {
        return new City("Edmonton", "Alberta");
    }
    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }
    @Test
    public void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }
    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
// This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
// is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
// This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
// Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }
    @Test
    public void testHasCity() {
        CityList list = mockCityList();
        City present = new City("Edmonton", "Alberta");
        City absent  = new City("Calgary", "Alberta");

        assertTrue(list.hasCity(present));
        assertFalse(list.hasCity(absent));
    }

    @Test
    public void testDeleteRemoves() {
        CityList list = new CityList();
        City c = new City("Regina", "Saskatchewan");
        list.add(c);

        assertTrue(list.hasCity(c));
        list.delete(c);
        assertFalse(list.hasCity(c));
        assertEquals(0, list.countCities());
    }

    @Test
    public void testDeleteThrowsWhenAbsent() {
        CityList list = mockCityList();
        City missing = new City("Yellowknife", "NT");

        assertThrows(IllegalArgumentException.class, () -> list.delete(missing));
    }

    @Test
    public void testCountCities() {
        CityList list = new CityList();
        assertEquals(0, list.countCities());

        list.add(new City("Charlottetown", "PEI"));
        list.add(new City("Halifax", "Nova Scotia"));
        assertEquals(2, list.countCities());
    }
}