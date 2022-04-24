package com.mycompany.quatro.connection.azure;

import com.mycompany.quatro.graphics.DashboardHome;
import com.mycompany.quatro.graphics.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        new Login().setVisible(true);
//        new DashboardHome().setVisible(true);
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stnt = null;

        String sql = "insert into user(login, senha) values ('admin','admin@123')";

        try {

            stnt = con.prepareStatement(sql);
            stnt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro ao salvar os dados" + ex.toString());
        } finally {
            ConnectionFactory.closeConnection(con, stnt);
        }

    }
}
