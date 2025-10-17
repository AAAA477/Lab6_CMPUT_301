package com.example.listycity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();
    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }
    /**
     * Return true if the city exists in the list
     */
    public boolean hasCity(City city) {
        for (City c : cities) {
            if (c.getCityName().equals(city.getCityName())
                    && c.getProvinceName().equals(city.getProvinceName())) {
                return true;
            }
        }
        return false;
    }
    /**
     * Remove the city if present else an exception is thrown
     */
    public void delete(City city) {
        for (int i = 0; i < cities.size(); i++) {
            City c = cities.get(i);
            if (c.getCityName().equals(city.getCityName())
                    && c.getProvinceName().equals(city.getProvinceName())) {
                cities.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException();
    }
    /**
     * Return how many cities are in the list
     */
    public int countCities() {
        return cities.size();
    }
}