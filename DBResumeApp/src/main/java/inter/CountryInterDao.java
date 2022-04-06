/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inter;

import entity.Country;
import java.util.List;

/**
 *
 * @author sabuhi
 */
public interface CountryInterDao {
    public List<Country> getAllCountries();
    public boolean addCountry(Country c);
    public boolean removeCountry(Country c);
    public boolean updateCountry(Country c);
    public Country getCountryById(int id);
}
