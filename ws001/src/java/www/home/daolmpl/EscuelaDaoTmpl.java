/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package www.home.daolmpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import www.home.config.Conn;
import www.home.dao.EscuelaDao;
import www.home.model.Escuela;

/**
 *
 * @author DELL
 */
public class EscuelaDaoTmpl implements EscuelaDao{
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;
    @Override
    public int create(Escuela esc) {
        String SQL = "INSERT INTO escuela(nombre) VALUES(?)";
        int x = 0;
        try {
            cx = Conn.getConn();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, esc.getNombre());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;       
    }

    @Override
    public int update(Escuela esc) {
        String SQL = "UPDATE escuela SET nombre=? WHERE id=?";
        int x = 0;
        try {
            cx = Conn.getConn();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, esc.getNombre());
            ps.setInt(2, esc.getIdEscuela());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int delete(int id) {
        String SQL = "DELETE FROM escuela WHERE id=?";
        int x = 0;
        try {
            cx = Conn.getConn();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }
    @Override
    public Escuela read(int id) {
        String SQL = "SELECT *FROM escuela WHERE id=?";
        Escuela esc = new Escuela();
        try {
            cx = Conn.getConn();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                esc.setIdEscuela(rs.getInt("id"));
                esc.setNombre(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return esc;
    }

    @Override
    public List<Escuela> readAll() {
        String SQL = "SELECT *FROM escuela";
        List<Escuela> lista = new ArrayList<>();
        try {
            cx = Conn.getConn();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Escuela esc = new Escuela();
                esc.setIdEscuela(rs.getInt("id"));
                esc.setNombre(rs.getString("nombre"));
                lista.add(esc);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return lista;
    }
}
