/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inter;

import entity.Skill;
import java.util.List;

/**
 *
 * @author sabuhi
 */
public interface SkillInterDao {
    public List<Skill> getAllSkills();
    public boolean addSkill(Skill s);
    public boolean updateSkill(Skill s);
    public boolean removeSkill(Skill s);
    public Skill getSkillById(int id);
    public List<Skill> getSkillByName(String name);
    
}
