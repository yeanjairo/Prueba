/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.BUsuario;
import config.Conexion;
import interfaces.InterfazUsuario;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Windows 10
 */
public class DaoUsuarioImag implements InterfazUsuario{
    Conexion cnx;
    Connection con;
    BUsuario u;
    private PreparedStatement pst;
    private ResultSet rs;

    public DaoUsuarioImag() throws SQLException {
        this.cnx = new Conexion();
    }

    @Override
    public List listar() throws SQLException{
        String sql = "SELECT * FROM usuario";
        try{
            con = cnx.getConexion();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            List<BUsuario> datos = new ArrayList<>();
            while(rs.next()){
                u = new BUsuario();
                u.setId(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setApellidos(rs.getString(3));
                datos.add(u);
            }
            pst.close();
            rs.close();
            con.close();
            return datos;
        }catch(SQLException e){
            throw e;
        }
    }

    @Override
    public BUsuario listarID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String add(String nombre, String apellidos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String adit(int id, String nombre, String apellidos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BUsuario delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) throws SQLException, IOException {
        DaoUsuarioImag bu = new DaoUsuarioImag();
        List<BUsuario> beansU = bu.listar();
        int i = 0;
        int t = beansU.size();
        while(i<=t-1){
            System.out.println(beansU.get(i).getId() + " - " + beansU.get(i).getNombre() + " - " + beansU.get(i).getApellidos());
            i++;
        }
        
    }
    
}
