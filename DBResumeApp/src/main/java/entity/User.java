/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.List;

/**
 *
 * @author sabuhi
 */
public class User {

    private int id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private Country nationality_id;
    private Country birth_place_id;
    private String profDesc;
    List<UserSkill> userSkills;
    
    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, String name, String surname, String phone, String email,String profDesc, Country nationality_id, Country birth_place_id) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.nationality_id = nationality_id;
        this.birth_place_id = birth_place_id;
        this.profDesc = profDesc;
    }


    public String getProfDesc() {
        return profDesc;
    }

    public void setProfDesc(String profDesc) {
        this.profDesc = profDesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Country getNationality_id() { 
        return nationality_id;
    }

    public void setNationality_id(Country nationality_id) {
        this.nationality_id = nationality_id;
    }

    public Country getBirth_place_id() {
        return birth_place_id;
    }

    public void setBirth_place_id(Country birth_place_id) {
        this.birth_place_id = birth_place_id;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", phone=" + phone + ", email=" + email + ", nationality_id=" + nationality_id + ", birth_place_id=" + birth_place_id + ", profDesc=" + profDesc + ", userSkills=" + userSkills + '}';
    }

    
     
    
}
