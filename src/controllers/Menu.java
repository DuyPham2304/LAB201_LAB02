/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Menu extends ArrayList<String>{

    public Menu() {
    }
    
    public void addItem(String s){
        this.add(s);
    }
    
    public void showMenu(){
        for (String i : this){
            System.out.println(i);
        }
    }
}
