/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import inter.UserInterDao;

/**
 *
 * @author sabuhi
 */
public class Main {
    public static void main(String[] args) {
        UserInterDao dao = Context.instanceUserDao();
        System.out.println(dao.getUserById(1));
    }
}
