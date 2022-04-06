/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inter;

import entity.UserSkill;
import java.util.List;

/**
 *
 * @author sabuhi
 */
public interface UserSkillInterDao {
    public List<UserSkill> getAllUserSkills();
    public boolean addUserSkill(UserSkill us);
    public boolean updateUserSkill(UserSkill us);
    public boolean removeUserSkill(UserSkill us);
    public List<UserSkill> getAllUserSkillsById(int id);
}
