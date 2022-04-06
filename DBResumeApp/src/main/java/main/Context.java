/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import impl.CountryImplDao;
import impl.EmploymentHistoryImplDao;
import impl.SkillImplDao;
import impl.UserImplDao;
import impl.UserSkillImplDao;
import inter.CountryInterDao;
import inter.EmploymentHistoryInterDao;
import inter.SkillInterDao;
import inter.UserInterDao;
import inter.UserSkillInterDao;

/**
 *
 * @author sabuhi
 */
public class Context {
    public static UserInterDao instanceUserDao(){
        return new UserImplDao();
    }
    public static UserSkillInterDao instanceUserSkillDao(){
        return new UserSkillImplDao();
    }
    public static SkillInterDao instanceSkillDao(){
        return new SkillImplDao();
    }
    public static CountryInterDao instanceCountryDao(){
        return new CountryImplDao();
    }
    public static EmploymentHistoryInterDao instanceEmploymentHistoryDao(){
        return new EmploymentHistoryImplDao();
    }
}
