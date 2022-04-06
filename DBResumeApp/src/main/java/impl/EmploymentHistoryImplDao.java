/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package impl;

import entity.EmploymentHistory;
import entity.User;
import inter.EmploymentHistoryInterDao;
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
public class EmploymentHistoryImplDao extends AbstractConnect implements EmploymentHistoryInterDao{

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryById(int id) {
        List<EmploymentHistory> result = new ArrayList<>();
        try(Connection c = connect()){
            PreparedStatement stmt = c.prepareStatement("select * from employment_history where id="+id);
            ResultSet rs = stmt.getResultSet();
            while(rs.next()){
                EmploymentHistory eh = getEmploymentHistory(rs);
                result.add(eh);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    
    public EmploymentHistory getEmploymentHistory(ResultSet rs) throws SQLException{
        int id = rs.getInt("id");
        int user_id = rs.getInt("user_id");
        String header = rs.getString("header");
        String job_description = rs.getString("job_description");
        return new EmploymentHistory(id,new User(user_id),header,job_description);
    }
    
}
