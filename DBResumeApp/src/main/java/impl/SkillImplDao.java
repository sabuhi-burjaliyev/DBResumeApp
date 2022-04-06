/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package impl;

import entity.Skill;
import inter.SkillInterDao;
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
public class SkillImplDao extends AbstractConnect implements SkillInterDao {

    @Override
    public List<Skill> getAllSkills() {
        List<Skill> skills = new ArrayList<>();
        try (Connection c = connect()) {
            String query = "select * from skill";
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                skills.add(new Skill(id, name));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return skills;
    }

    @Override
    public boolean addSkill(Skill s) {
        try (Connection c = connect()) {
            String query = "insert into skill values(?,?)";
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.setInt(1, s.getId());
            stmt.setString(2, s.getName());
            stmt.execute();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateSkill(Skill s) {
        try (Connection c = connect()) {
            String query = "update skill set name=? where id=?";
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.setString(1, s.getName());
            stmt.setInt(2, s.getId());
            stmt.execute();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeSkill(Skill s) {
        try (Connection c = connect()) {
            String query = "delete from skill where id=" + s.getId();
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.execute();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Skill getSkillById(int id) {
        try (Connection c = connect()) {
            String query = "select * from skill where id=" + id;
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            int ide = rs.getInt("id");
            String name = rs.getString("name");
            return new Skill(ide, name);

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Skill> getSkillByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
