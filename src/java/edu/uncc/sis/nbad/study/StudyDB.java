/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.sis.nbad.study;


import edu.uncc.sis.nbad.utils.ConnectionPool;
import edu.uncc.sis.nbad.utils.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;


/**
 *
 * @author Padma Kumari
 */
public class StudyDB {
       // List<Study> studies=new ArrayList<Study>();
   // Map<String,Study>  studiesMap=new HashMap<String, Study>();
    
   /* public List<Study> getStudies()
    {
        if(studies.size()<=0)
        {
            Study study=new Study();
            study.setName("GUI");
            study.setCode("GUI");
            study.setDescription("GUI");
            study.setEmail("gui@gmail.com");
            study.setQuestion("I enjoy Outdoor Activities");
            study.setStatus("START");
            study.setRequestedparticipants(10);
            study.setNumofparitipants(3);
            study.setImageURL("media/tree2.png");
            studies.add(study);
            study=new Study();
            study.setName("Sec");
            study.setCode("Sec");study.setQuestion("I use Computers in a Daily Basis");
            study.setDescription("sec");
            study.setStatus("START");
            study.setEmail("sec@gmail.com");
            study.setRequestedparticipants(5);
            study.setNumofparitipants(5);
             study.setImageURL("media/comp.png");
            studies.add(study);
            for (Study obj : studies) {
    studiesMap.put(obj.getCode(), obj);
  }
        }
        return studies;
    }*/
    
    public static ArrayList<Study> getStudiesFor(String  email)
    {
        
        System.out.println("entered getStudiesFor");
         ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs1 = null;
System.out.println(email);
        String query = "SELECT * from Study where Email = ? ";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs1 = ps.executeQuery();
           Study study = null;
           // ArrayList users = new ArrayList();
            ArrayList<Study> studies = new ArrayList<>();
 
            while (rs1.next()) {
                     //System.out.println(rs1.next());

                study = new Study();

                study.setName(rs1.getString("SName"));
                study.setCode(rs1.getString("Scode"));
                study.setDescription(rs1.getString("Description"));
                study.setEmail(rs1.getString("Email"));
                study.setDateCreated(rs1.getString("DateCreated"));
                study.setQuestion(rs1.getString("Question"));
                study.setImageURL(rs1.getString("ImageURL"));
                study.setRequestedparticipants(rs1.getInt("ReqParticipants"));
                study.setNumofparitipants(rs1.getInt("ActParticipants"));
                study.setStatus(rs1.getString("SStatus"));
                
                studies.add(study);
               //System.out.println(rs1.getString("SStatus"));
            }
            
            
            return studies;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs1);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }  
    }
    
    
    public static Study getStudy(String SCode){
         ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Study "
                + "WHERE SCode = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, SCode);
            rs = ps.executeQuery();
           Study study = null;
            if (rs.next()) {
                study = new Study();
                study.setName(rs.getString("SName"));
                study.setCode(rs.getString("Scode"));
                study.setDescription(rs.getString("Description"));
                study.setEmail(rs.getString("Email"));
                study.setDateCreated(rs.getString("DateCreated"));
                study.setQuestion(rs.getString("Question"));
                study.setImageURL(rs.getString("ImageURL"));
                study.setRequestedparticipants(rs.getInt("ReqParticipants"));
                study.setNumofparitipants(rs.getInt("ActParticipants"));
                study.setStatus(rs.getString("SStatus"));
            }
            return study;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
   
    public static ArrayList<Study> getStudies(String criteria){
    
// Need to implement this
        System.out.println("entered getStudiesFor");
         ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs1 = null;
//System.out.println(email);
        String query = "SELECT * from Study where SStatus = ? ";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, criteria);
            rs1 = ps.executeQuery();
           Study study = null;
           // ArrayList users = new ArrayList();
            ArrayList<Study> studies = new ArrayList<>();
 
            while (rs1.next()) {
                     //System.out.println(rs1.next());

                study = new Study();

                study.setName(rs1.getString("SName"));
                study.setCode(rs1.getString("Scode"));
                study.setDescription(rs1.getString("Description"));
                study.setEmail(rs1.getString("Email"));
                study.setDateCreated(rs1.getString("DateCreated"));
                study.setQuestion(rs1.getString("Question"));
                study.setImageURL(rs1.getString("ImageURL"));
                study.setRequestedparticipants(rs1.getInt("ReqParticipants"));
                study.setNumofparitipants(rs1.getInt("ActParticipants"));
                study.setStatus(rs1.getString("SStatus"));
                
                studies.add(study);
               //System.out.println(rs1.getString("SStatus"));
            }
            
            
            return studies;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs1);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }  
    }
    
    public static int addStudy(Study study){
    
ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO Study (SName, Question, Description,  ReqParticipants, Email,ImageURL,SCode,DateCreated,SStatus) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            
            ps.setString(1, study.getName());
            ps.setString(2, study.getQuestion());
            ps.setString(3, study.getDescription());
            ps.setInt(4, study.getRequestedparticipants());
            ps.setString(5, study.getEmail());
            ps.setString(6, study.getImageURL());
            ps.setString(7, study.getCode());
            ps.setString(8, study.getDateCreated());
            ps.setString(9, study.getStatus());

          
      
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
   
    public static int updateStudy(String SCode, Study study){
    
 ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "UPDATE Study SET SName = ?,Question = ?,Description = ?,ReqParticipants = ? WHERE SCode = ?";
        try {
            ps = connection.prepareStatement(query);
            
            ps.setString(1, study.getName());
            ps.setString(2, study.getQuestion());
            ps.setString(3, study.getDescription());
            ps.setInt(4, study.getRequestedparticipants());
            ps.setString(5, SCode);
            
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    
    
    public static Study getStudy(String SCode, String Email){
         ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Study "
                + "WHERE SCode = ? and Email= ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, SCode);
            ps.setString(2, Email);
            rs = ps.executeQuery();
           Study study = null;
            if (rs.next()) {
                study = new Study();
                study.setName(rs.getString("SName"));
                study.setCode(rs.getString("Scode"));
                study.setDescription(rs.getString("Description"));
                study.setEmail(rs.getString("Email"));
                study.setDateCreated(rs.getString("DateCreated"));
                study.setQuestion(rs.getString("Question"));
                study.setImageURL(rs.getString("ImageURL"));
                study.setRequestedparticipants(rs.getInt("ReqParticipants"));
                study.setNumofparitipants(rs.getInt("ActParticipants"));
                study.setStatus(rs.getString("SStatus"));
            }
            return study;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
   
    public static int updateStudyStatus(String Scode , Study study){
    
 ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "UPDATE Study SET SStatus = ? WHERE SCode = ?";
        try {
            ps = connection.prepareStatement(query);
            
            ps.setString(1, study.getStatus());
            ps.setString(2, Scode);
            
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
