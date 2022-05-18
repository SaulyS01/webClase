/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package www.home.test;

import www.home.config.Conn;

/**
 *
 * @author DELL
 */
public class Test {
    public static void main(String[] args) {
        if(Conn.getConn() != null){
            System.out.println("Conectado");
        }else{
            System.out.println("No conectado");
        }
    }
}
