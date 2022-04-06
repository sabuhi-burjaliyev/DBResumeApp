/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package impl;

import entity.Country;
import entity.User;
import inter.UserInterDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import main.AbstractConnect;

/**
 *
 * @author sabuhi
 */
public class UserImplDao extends AbstractConnect implements UserInterDao {

    @Override
    public List<User> getAll(String name,String surname,Integer nationality_id) {
        List<User> result = new ArrayList<>();
        try (Connection c = connect()) {
            String query = "select u.*, c.country,n.nationality from user u left join country c on u.birth_place_id=c.id left join country n on u.nationality_id=n.id where 1=1";
            if(name!=null && !name.trim().isEmpty()){
                query+=" and name=? ";
            }
            if(surname!=null && !surname.trim().isEmpty()){
                query+=" and surname=? ";
            }
            if(nationality_id!=null){
                query+=" and nationality_id=? ";
            }
            PreparedStatement stmt = c.prepareStatement(query);
            int i=1;
            if(name!=null && !name.trim().isEmpty()){
               stmt.setString(i, name);
               i++;
            }
            if(surname!=null && !surname.trim().isEmpty()){
                stmt.setString(i, surname);
                i++;
            }
            if(nationality_id!=null){
                stmt.setInt(i, nationality_id);
                i++;
            }
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                User u = getUser(rs);
                result.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public User getUser(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String phone = rs.getString("phone");
        String email = rs.getString("email");
        String profDesc = rs.getString("profile_description");
        int nationality_id = rs.getInt("nationality_id");
        int birth_place_id = rs.getInt("birth_place_id");
        String country = rs.getString("country");
        System.out.println("Xeta burdadi");
        String nationality = rs.getString("nationality");
        System.out.println("Xeta burda deyil");
        return new User(id, name, surname, phone, email, profDesc, new Country(nationality_id, null, nationality), new Country(birth_place_id, country, null));
    }

    @Override
    public boolean addUser(User u) {
        try (Connection c = connect()) {
            String query = "insert into user values (?,?,?,?,?,?,?)";
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.setInt(1, u.getId());
            stmt.setString(2, u.getName());
            stmt.setString(3, u.getSurname());
            stmt.setString(4, u.getPhone());
            stmt.setString(5, u.getEmail());
            stmt.setInt(6, u.getNationality_id().getId());
            stmt.setInt(7, u.getBirth_place_id().getId());
            stmt.execute();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean removeUser(User u) {
        try (Connection c = connect()) {
            String query = "delete from user where id=" + u.getId();
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.execute();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUser(User u) {
        try (Connection c = connect()) {
            String query = "update user set name=?,surname=?,phone=?,email=?,nationality_id=?,birth_place_id=?,profile_description=? where id=?";
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getEmail());
            stmt.setInt(5, u.getNationality_id().getId());
            stmt.setInt(6, u.getBirth_place_id().getId());
            stmt.setString(7, u.getProfDesc());
            stmt.setInt(8, u.getId());
            stmt.execute();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUserById(int id) {
        try (Connection c = connect()) {
            User u = null;
            String query = "select u.*,n.nationality,c.country from user u left join country n on u.nationality_id=n.id left join country c on u.birth_place_id=c.id where u.id=" + id;
            Statement stmt = c.createStatement();
            stmt.execute(query);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                u = getUser(rs);
            }

            return u;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
