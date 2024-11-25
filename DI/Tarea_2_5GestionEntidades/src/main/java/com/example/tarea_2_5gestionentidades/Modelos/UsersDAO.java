package com.example.tarea_2_5gestionentidades.Modelos;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO
{
    @FXML
    private static TextField fieldActivo;
    @FXML
    private static TextField fieldPassword;
    @FXML
    private static TextField fieldLogin;
    @FXML
    private static TextField fieldActionId;
    @FXML
    private static TextField fieldCreateUid;

    public static void altaUsuario(Boolean activo, String password, String login, Integer actionId, Integer createUid)
    {
        Users user = new Users();
        try(Connection con=ConexionDB.getConnection())
        {
           Boolean.parseBoolean(fieldActivo.getText());
           fieldPassword.getText();
           fieldLogin.getText();
           Integer.parseInt(fieldActionId.getText());
           Integer.parseInt(fieldCreateUid.getText());
            String sql="INSERT INTO res_users(active,password,login,actionId,createUid) VALUES (?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql);

            ps.setBoolean(1,activo);
            ps.setString(2,password);
            ps.setString(3,login);
            ps.setInt(4,actionId);
            ps.setInt(5,createUid);
            ps.executeUpdate();

        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    private void actualizarUsuario()
    {
        String sql="UPDATE res_users SET activo=?,password=?,login=?,actionId=?,createUid=? WHERE active=?";
        Boolean activo = Boolean.parseBoolean(fieldActivo.getText());
        String password = fieldPassword.getText();
        String login = fieldLogin.getText();
        Integer actionId = Integer.parseInt(fieldActionId.getText());
        Integer createUid = Integer.parseInt(fieldCreateUid.getText());
        try(Connection con=ConexionDB.getConnection())
        {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setBoolean(1,activo);
            ps.setString(2,password);
            ps.setString(3,login);
            ps.setInt(4,actionId);
            ps.setInt(5,createUid);
            ps.executeUpdate();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private void mostrarUsuarios()
    {
        List<Users> usuarios=new ArrayList<>();

        try(Connection con=ConexionDB.getConnection())
        {
            PreparedStatement ps=con.prepareStatement("SELECT * FROM res_users");

            Users users=new Users();

            ResultSet rs=ps.executeQuery();
            users.getActivoProperty().set(rs.getBoolean("active"));
            users.getPasswordProperty().set(rs.getString("password"));
            users.getLoginProperty().set(rs.getString("login"));
            users.getAction_idProperty().set(rs.getInt("actionId"));
            users.getCreate_uidProperty().set(rs.getInt("createUid"));

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private void eliminarUsuario()
    {
        String sql=("DELETE FROM res_users WHERE id=id");

        try(Connection con=ConexionDB.getConnection())
        {
            Users users=new Users();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, users.getId());

        }catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}
