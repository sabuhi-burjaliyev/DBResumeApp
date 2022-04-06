/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package impl;

import entity.Country;
import entity.Skill;
import inter.CountryInterDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import main.AbstractConnect;

/**
 *
 * @author sabuhi
 */
public class CountryImplDao extends AbstractConnect implements CountryInterDao {

    @Override
    public List<Country> getAllCountries() {
        List<Country> countries = new ArrayList<>();
        try (Connection c = connect()) {
            String query = "select * from country";
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String country = rs.getString("country");
                String nationality = rs.getString("nationality");
                countries.add(new Country(id, country, nationality));
            }
            return countries;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addCountry(Country coun) {
        try (Connection c = connect()) {
            String query = "insert into country values (?,?,?)";
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.setInt(1, coun.getId());
            stmt.setString(2, coun.getCountry());
            stmt.setString(3, coun.getNationality());
            stmt.execute();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeCountry(Country coun) {
        try (Connection c = connect()) {
            String query = "delete from country where id=" + coun.getId();
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.execute();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean updateCountry(Country coun) {
        try (Connection c = connect()) {
            String query = "update country set country=?,nationality=? where id=?";
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.setString(1, coun.getCountry());
            stmt.setString(2, coun.getNationality());
            stmt.setInt(3, coun.getId());
            stmt.execute();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Country getCountryById(int id) {
        try (Connection c = connect()) {
            String query = "select * from country where id=" + id;
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            int ide = rs.getInt("id");
            String country = rs.getString("country");
            String nationality = rs.getString("nationality");
            return new Country(ide, country, nationality);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
