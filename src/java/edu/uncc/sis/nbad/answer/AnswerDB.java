/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.sis.nbad.answer;

import edu.uncc.sis.nbad.utils.ConnectionPool;
import edu.uncc.sis.nbad.utils.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

/**
 *
 * @author swapnika
 */
public class AnswerDB {
    
    
    
   public static int addAnswer(Answer ans){
   
   ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO Answer (Email, Choice, SCode, DateSubmitted) "
                + "VALUES (?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            
            ps.setString(1, ans.getEmail());
            ps.setString(2, ans.getChoice());
            ps.setString(3, ans.getSCode());
            ps.setString(4, ans.getDateSubmitted());
            
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
   
   }
   
   public static ArrayList<Answer> getAnswersFor(String  email){
       
       
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs1 = null;
//System.out.println(email);
        String query = "SELECT * from Answer where Email = ? ";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs1 = ps.executeQuery();
           Answer answer = null;
           // ArrayList users = new ArrayList();
            ArrayList<Answer> answers = new ArrayList<>();
 
            while (rs1.next()) {
                     //System.out.println(rs1.next());

                answer = new Answer();

                answer.setEmail(rs1.getString("Email"));
                answer.setChoice(rs1.getString("Choice"));
                answer.setSCode(rs1.getString("SCode"));
                answer.setDateSubmitted(rs1.getString("DateSubmitted"));
               
                
                
                answers.add(answer);
               //System.out.println(rs1.getString("SStatus"));
            }
            
            
            return answers;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs1);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }  
       
   }
   
   
   public static ArrayList<Answer> getAnswersForCode(String  SCode){
       
       
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs1 = null;
//System.out.println(email);
        String query = "SELECT * from Answer where SCode = ? ";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, SCode);
            rs1 = ps.executeQuery();
           Answer answer = null;
           // ArrayList users = new ArrayList();
            ArrayList<Answer> answers = new ArrayList<>();
 
            while (rs1.next()) {
                     //System.out.println(rs1.next());

                answer = new Answer();

                answer.setEmail(rs1.getString("Email"));
                answer.setChoice(rs1.getString("Choice"));
                answer.setSCode(rs1.getString("SCode"));
                answer.setDateSubmitted(rs1.getString("DateSubmitted"));
               
                
                
                answers.add(answer);
               //System.out.println(rs1.getString("SStatus"));
            }
            
            
            return answers;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs1);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }  
       
       
   }
    
}
