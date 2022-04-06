/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package impl;

import entity.Skill;
import entity.User;
import entity.UserSkill;
import inter.UserSkillInterDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import main.AbstractConnect;

/**
 *
 * @author sabuhi
 */
public class UserSkillImplDao extends AbstractConnect implements UserSkillInterDao {

    public UserSkill getUserSkill(ResultSet rs) throws SQLException {
        int user_id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String phone = rs.getString("phone");
        String email = rs.getString("email");
        int nationality_id = rs.getInt("nationality_id");
        int birth_place_id = rs.getInt("birth_place_id");
        int user_skill_id = rs.getInt("user_skill_id");
        int power = rs.getInt("power");
        int skill_id = rs.getInt("skill_id");
        String profDesc = rs.getString("profile_description");
        String skill_name = rs.getString("skill_name");
        return new UserSkill(user_skill_id, new User(user_id), new Skill(skill_id, skill_name), power);
    }

    @Override
    public List<UserSkill> getAllUserSkills() {
        List<UserSkill> userSkills = new ArrayList<>();
        try (Connection c = connect()) {
            PreparedStatement stmt = c.prepareStatement("select us.*,s.name from user_skill us left join skill as s on us.skill_id=s.id");
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                int userSkillId = rs.getInt("id");
                int userId = rs.getInt("user_id");
                int skillId = rs.getInt("skill_id");
                String skillName = rs.getString("name");
                int power = rs.getInt("power");
                UserSkill us = new UserSkill(userSkillId, new User(userId), new Skill(skillId, skillName), power);
                userSkills.add(us);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userSkills;
    }

    @Override
    public boolean addUserSkill(UserSkill us) {
        try (Connection c = connect()) {
            String query = "insert into user_skill values(?,?,?,?)";
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.setInt(1, us.getId());
            stmt.setInt(2, us.getSkill().getId());
            stmt.setInt(3, us.getUser().getId());
            stmt.setInt(4, us.getPower());
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUserSkill(UserSkill us) {
        try (Connection c = connect()) {
            String query = "update user_skill set user_id=?,skill_id=?,power=? where id=" + us.getId();
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.setInt(2, us.getSkill().getId());
            stmt.setInt(1, us.getUser().getId());
            stmt.setInt(3, us.getPower());
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeUserSkill(UserSkill us) {
        try (Connection c = connect()) {
            String query = "delete from user_skill where id=" + us.getId();
            PreparedStatement stmt = c.prepareStatement(query);
            stmt.execute();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<UserSkill> getAllUserSkillsById(int id) {
        List<UserSkill> result = new ArrayList<>();
        try (Connection c = connect()) {
            String query = "select u.*,us.id as user_skill_id,us.power,s.id as skill_id,s.name as skill_name from user u left JOIN user_skill us on u.id= us.user_id left join skill s on us.skill_id=s.id where u.id=" + id;

            PreparedStatement stmt = c.prepareStatement(query);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                UserSkill us = getUserSkill(rs);
                result.add(us);
            }
            System.out.println(result);
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
