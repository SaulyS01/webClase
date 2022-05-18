/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package www.home.dao;

import java.util.List;
import www.home.model.Escuela;

/**
 *
 * @author DELL
 */
public interface EscuelaDao {
    int create(Escuela esc);
    int update(Escuela esc);
    int delete(int id);
    Escuela read(int id);
    List<Escuela> readAll();
}
