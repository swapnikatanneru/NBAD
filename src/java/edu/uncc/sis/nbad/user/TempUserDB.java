/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.sis.nbad.user;
import edu.uncc.sis.nbad.utils.ConnectionPool;
import edu.uncc.sis.nbad.utils.DBUtil;
import java.sql.*;

/**
 *
 * @author swapnika
 */
public class TempUserDB {
    
    
     public static  TempUser getUser(String  Token)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
System.out.println("Entered tempdb1");
        String query = "SELECT * FROM TempUser "
                + "WHERE Token = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, Token);
            rs = ps.executeQuery();
            System.out.println("Entered tempdb2");
            TempUser user = null;
            if (rs.next()) {
                user = new TempUser();
                user.setName(rs.getString("UName"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                user.setIssueDate(rs.getString("IssueDate"));
                user.setToken(rs.getString("Token"));
                user.setExpirationDate(rs.getString("ExpirationDate"));
            }
            System.out.println("Entered tempdb3");
            System.out.println(user);
            return user;
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Entered activate null");
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
     
     
     
     
      public static  int deleteTempUser(String  Token)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "DELETE FROM TempUser "
                + "WHERE Token = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, Token);
            return ps.executeUpdate();

            
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
     
     
     
     
     
     public static int addTempUser(TempUser usr)
{
    ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO TempUser (UName, Email, Password,IssueDate,Token,ExpirationDate)"
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, usr.getName());
            ps.setString(2, usr.getEmail());
            ps.setString(3, usr.getPassword());
            ps.setString(4, usr.getIssueDate());
            ps.setString(5, usr.getToken());
            ps.setString(6, usr.getExpirationDate());
     
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
}
    
    
}
