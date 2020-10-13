/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import beans.BUsuario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Windows 10
 */
public interface InterfazUsuario {
    public List listar() throws SQLException;
    public BUsuario listarID(int id);
    public String add(String nombre, String apellidos);
    public String adit(int id, String nombre, String apellidos);
    public BUsuario delete (int id);

}
