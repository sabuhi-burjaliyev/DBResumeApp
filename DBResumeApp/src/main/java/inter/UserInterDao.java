/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inter;

import entity.User;
import java.util.List;

/**
 *
 * @author sabuhi
 */
public interface UserInterDao {

    public List<User> getAll(String name,String surname,Integer nationality_id);

    public boolean addUser(User u);

    public boolean removeUser(User u);

    public boolean updateUser(User u);
    
    public User getUserById(int id);    
}
