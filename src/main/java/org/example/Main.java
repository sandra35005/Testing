package org.example;

import java.sql.*;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private String ip = "localhost";
    private String port = "3306";
    private String dbname = "test_db";
    private String username = "root";
    private String password = "";
    //can use same package with protected
    protected Connection get_Db_Connection() {

        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://"+ip +":"+port+"/"+dbname, username, password);
            System.out.println("Successful Connection");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }
    private ArrayList<Office> report1(Connection con){
        ArrayList<Office> al = new ArrayList<>();
        try{
            PreparedStatement ps = con.prepareStatement("SELECT officeCode, state, city FROM offices");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Office of = new Office(rs.getInt(1), rs.getString(2), rs.getString(3));
                al.add(of);
            }
            rs.close();
            ps.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return al;
    }
    public static void main(String[] args) {

        Main m = new Main();
        Connection con = m.get_Db_Connection();
        ArrayList<Office> al =m.report1(con);
        System.out.println(al);
        try {
            //connection shi lr sit pi pate tr po kaung tal
            if(con != null) {
                con.close();
                System.out.println("Connection is Closed");
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
