package com.example.lab08;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomListTest {

    private CustomList mockCityList() {
        CustomList list = new CustomList();
        return list;
    }

    @Test
    public void testAddCity() {
        CustomList list = mockCityList();
        int listSize = list.countCities();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.countCities(), listSize + 1);
    }

    @Test
    public void testHasCity() {
        CustomList list = mockCityList();
        City city = new City("Edmonton", "AB");
        list.addCity(city);
        assertTrue(list.hasCity(city));
    }

    @Test
    public void testDeleteCity() {
        CustomList list = mockCityList();
        City city = new City("Regina", "SK");
        list.addCity(city);
        assertTrue(list.hasCity(city));
        list.deleteCity(city);
        assertFalse(list.hasCity(city));
    }

    @Test
    public void testDeleteCityException() {
        CustomList list = mockCityList();
        City city = new City("Regina", "SK");
        assertThrows(IllegalArgumentException.class, () -> {
            list.deleteCity(city);
        });
    }

    @Test
    public void testCountCities() {
        CustomList list = mockCityList();
        City city = new City("Regina", "SK");
        list.addCity(city);
        assertEquals(1, list.countCities());
    }
}
