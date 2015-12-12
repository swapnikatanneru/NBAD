/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.sis.nbad.user;

import edu.uncc.sis.nbad.utils.ConnectionPool;
import edu.uncc.sis.nbad.utils.DBUtil;
import java.sql.*;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Padma Kumari
 */
public class UserDB {
    //List<User> users=new ArrayList<User>();
   // Map<String,User>  usersMap=new HashMap<String, User>();
    
   /* public List<User> getUsers()
    {
        if(users.size()<=0)
        {
            User user=new User();
            user.setName("Kumari");
            user.setEmail("pkumari@uncc.edu");
            user.setPassword("test1");
            user.setCoins(2);
            user.setParticipants(3);
            user.setParticipation(5);
            users.add(user);
            user=new User();
            user.setName("Kumari");
            user.setEmail("idofpadma@gmail.com");
            user.setPassword("test1");
            user.setCoins(2);
            user.setParticipants(3);
            user.setParticipation(5);
            users.add(user);
            user=new User();
            user.setName("Swapnika");
            user.setEmail("swapnika@gmail.com");
            user.setPassword("test1");
            user.setCoins(2);
            user.setParticipants(3);
            user.setParticipation(5);
            users.add(user);
            user=new User();
            user.setName("Swapna");
            user.setEmail("stanneru@uncc.edu");
            user.setPassword("test1");
            user.setCoins(2);
            user.setParticipants(3);
            user.setParticipation(5);
            users.add(user);
            for (User o : users) {
    usersMap.put(o.getEmail(), o);
  }
        }
        return users;
    } */
    
    public static  User getUser(String  email)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM User "
                + "WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            User user = null;
            if (rs.next()) {
                user = new User();
                user.setName(rs.getString("UName"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                user.setParticipants(rs.getInt("Studies"));
                user.setParticipation(rs.getInt("Participation"));
                user.setCoins(rs.getInt("Coins"));
                
                
                
            }
            return user;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    
    public static int updateParticipationsAndCoins(User user){
     ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "UPDATE User SET Participation = ? AND Studies=? AND Coins=? WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            
            ps.setInt(1, user.getParticipation());
             ps.setInt(2, user.getParticipation());
              ps.setInt(3, user.getCoins());
              ps.setString(4, user.getEmail());
            
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
}

    
public static  boolean validateUser(String email, String Password)
{
    User user = null;
    user = getUser(email);
   System.out.println("validation "+user);
   
   if(user == null)
       
   {
       
       return false;
   }
   
   if (email.equals(user.getEmail()) && Password.equals(user.getPassword()) )
   {
       
       return true;
       
   }
    
       // return (email == null ? user.getEmail() == null : email.equals(user.getEmail())) & (Password == null ? user.getPassword() == null : Password.equals(user.getPassword()));
    return false;
    //Made changes in the condition when email is null we just have to return false no need to check other condition
      // return ((user == null ? false : true) & (Password == null ? false: true));
    
}

public static int addUser(User usr)
{
    ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO User (UName, Email, Password,Studies,Participation,Coins) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, usr.getName());
            ps.setString(2, usr.getEmail());
            ps.setString(3, usr.getPassword());
            ps.setInt(4, usr.getParticipants());
            ps.setInt(5, usr.getParticipation());
            ps.setInt(6, usr.getCoins());
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
}
public static int updateParticipations(String Email){
     ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "UPDATE User SET Participation = Participation+1 WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            
            ps.setString(1, Email);
            
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
}

public static int updateUserStudies(String Email)
{  ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "UPDATE User SET Studies = Studies+1 WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            
            ps.setString(1, Email);
            
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    
}


public static int updateUserCoins(String Email)
{  
  ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "UPDATE User SET Coins = Coins+1 WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            
            ps.setString(1, Email);
            
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
}

public static int updateUserCoinsByTwo(String Email)
{  
  ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "UPDATE User SET Coins = Coins+2 WHERE Email = ?";
        try {
            ps = connection.prepareStatement(query);
            
            ps.setString(1, Email);
            
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
}



public static int updateUser(User usr)
{
    ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
 System.out.println("Entered update user");
        String query = "UPDATE User SET  Password = ? WHERE Email= ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, usr.getPassword());
            ps.setString(2, usr.getEmail());
            
            System.out.println(usr.getPassword());
            System.out.println(usr.getEmail());
            
            return ps.executeUpdate();
        } catch (SQLException e) {
             System.out.println("Exception in update");
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
}


}