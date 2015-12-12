/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.sis.nbad.study;

import edu.uncc.sis.nbad.answer.Answer;
import edu.uncc.sis.nbad.answer.AnswerDB;
import edu.uncc.sis.nbad.user.UserDB;
import edu.uncc.sis.nbad.user.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PadmaKumari
 */
@WebServlet(name = "studyController", urlPatterns = {"/study"})
public class StudyController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = (String) request.getParameter("page");
        // System.out.println(type);
        String page = "home";
        if (type == null || type.equals("")) {
            if (request.getSession().getAttribute("theUser") != null) {
                page = "main";
            } else {
                page = "home";

            }

        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String code = request.getParameter("Studycode");
               // StudyDB db = new StudyDB();
            // System.out.println(code);
            // db.getStudies();
            //System.out.println(code);
            switch (type) {
                case "participate":

                    if (request.getSession().getAttribute("theUser") != null) {

                        if (code == null) {
                            ArrayList<Study> studies = StudyDB.getStudies("START");
                            request.setAttribute("studies", studies);
                            page = "participate";
                        } else {
                            System.out.println("entered participate else");
                            System.out.println(code);
                            //StudyDB db = new StudyDB();
                            Study study2 = StudyDB.getStudy(code);
                            request.getSession().setAttribute("study", study2);
                            page = "question";

                        }
                         //String code = request.getParameter("Studycode");

                    } else {

                        page = "login";
                    }

                    // System.out.println("entered participate");
                    // System.out.println("study code:" + study.getCode());
                    break;
                case "startStudy":
                                               // System.out.println("entered startstudy");

                    //String code = request.getParameter("Studycode");
                    StudyDB db2 = new StudyDB();
                    Study study = db2.getStudy(code);

                    if (study.getStatus().equals("START")) {
                        study.setStatus("STOP");
                    } else {
                        study.setStatus("START");
                    }

                    request.getSession().setAttribute("StudyCode", study.getCode());
                    //TODO request.getSession().setAttribute("studies", db.getStudies());
                    page = "studies";
                    break;

                case "editStudy":
                      //  System.out.println("enteredit");

                    // request.getSession().setAttribute("study", study);
                    if (request.getSession().getAttribute("theUser") != null) {

                        if (code == null) {

                        } else {
                            page = "editstudy";
                            User user = (User) request.getSession().getAttribute("theUser");
                            Study editstudy = StudyDB.getStudy(code, user.getEmail());
                            //System.out.println(editstudy.getName());
                            request.setAttribute("study", editstudy);

                        }

                    } else {

                        page = "login";

                    }

                    break;

                case "studies":
                    //  System.out.println("enteredit");

                    if (request.getSession().getAttribute("theUser") != null) {
                        // StudyDB study1 = new StudyDB();

                        User user = (User) request.getSession().getAttribute("theUser");
                        // User user = new User();
                        //System.out.println(user.getEmail());
                        ArrayList<Study> studies = StudyDB.getStudiesFor(user.getEmail());
                        System.out.println(studies);
                        request.setAttribute("studies", studies);
                        page = "studies";
                        break;
                    } else {

                        page = "login";

                    }

                case "update":

                    if (request.getSession().getAttribute("theUser") != null) {

                        System.out.println("entered Update");
                        page = "studies";

                        String studyname = request.getParameter("studyname");
                        String question = request.getParameter("Question*");
                        String description = request.getParameter("description");
                        int participants = Integer.parseInt(request.getParameter("participants*"));

//System.out.println("initialized params");
                        Study updatestudy = new Study();
                        updatestudy.setName(studyname);
                        updatestudy.setQuestion(question);
                        updatestudy.setDescription(description);
                        updatestudy.setRequestedparticipants(participants);
                        updatestudy.setCode(code);
                        StudyDB.updateStudy(code, updatestudy);

                        User user = (User) request.getSession().getAttribute("theUser");

                        ArrayList<Study> studies = StudyDB.getStudiesFor(user.getEmail());

                        request.setAttribute("studies", studies);

                       // request.setAttribute("study", editstudy);
                        break;

                    } else {

                        page = "login";

                    }

                case "newstudy":
                    System.out.println("entered new");

                    if (request.getSession().getAttribute("theUser") != null) {

                         System.out.println("entered newstudy");
                        page = "studies";

                        String studyname = request.getParameter("studyname");
                        String question = request.getParameter("Question*");
                        String description = request.getParameter("description");
                        int participants = Integer.parseInt(request.getParameter("participants*"));
                        User user = (User) request.getSession().getAttribute("theUser");
                        System.out.println("Participants.." + participants);
                        Calendar calendar = Calendar.getInstance();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String curDate = sdf.format(calendar.getTime());
//System.out.println("initialized params");
                        Study newstudy = new Study();
                        newstudy.setName(studyname);
                        newstudy.setQuestion(question);
                        newstudy.setDescription(description);
                        newstudy.setNumofparitipants(0);
                        newstudy.setRequestedparticipants(participants);
                        newstudy.setEmail(user.getEmail());
                        newstudy.setImageURL("media/tree2.png");
                        newstudy.setCode(studyname);
                        newstudy.setDateCreated(curDate);
                        newstudy.setStatus("START");
                        StudyDB.addStudy(newstudy);

                        ArrayList<Study> studies = StudyDB.getStudiesFor(user.getEmail());

                        request.setAttribute("studies", studies);

                       // request.setAttribute("study", editstudy);
                        break;

                    } else {

                        page = "login";

                    }

                case "add":
                    page = "newstudy";

                case "studyStatus":
                    System.out.println("entered add");

                    if (request.getSession().getAttribute("theUser") != null) {

                        if (code == null) {

                        } else {

                            // System.out.println("entered Update");
                            page = "studies";

                            String studystatus = request.getParameter("Status");
                            String studycode = request.getParameter("Studycode");

//System.out.println("initialized params");
                            Study setStudyStatus = new Study();

                            if (studystatus.equals("START")) {
                                setStudyStatus.setStatus("STOP");
                            } else {
                                setStudyStatus.setStatus("START");
                            }

                            StudyDB.updateStudyStatus(studycode, setStudyStatus);

                            User user = (User) request.getSession().getAttribute("theUser");

                            ArrayList<Study> studies = StudyDB.getStudiesFor(user.getEmail());

                            request.setAttribute("studies", studies);

                       // request.setAttribute("study", editstudy);
                            break;

                        }

                    } else {

                        page = "login";

                    }
                
                
                
                  case "answer":
                    
                      String choice = request.getParameter("choice");
                      //String code = request.getParameter("Studycode");

                      User user = (User) request.getSession().getAttribute("theUser");
                      
                      Calendar calendar = Calendar.getInstance();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String curDate = sdf.format(calendar.getTime());
                        
                                                    // System.out.println("Value of code");


                    if (request.getSession().getAttribute("theUser") != null) {

                        if (code == null && choice == null) {

                        } else {

                             System.out.println("entered Update");
                            page = "participate";

                           
                            Answer setAnswer = new Answer();
                            setAnswer.setEmail(user.getEmail());
                            setAnswer.setChoice(choice);
                            setAnswer.setSCode(code);
                            setAnswer.setDateSubmitted(curDate);
                            
                            AnswerDB.addAnswer(setAnswer);
                            

                             ArrayList<Study> studies = StudyDB.getStudies("START");
                           // request.setAttribute("studies", studies);
                         
                            
                            
                            user.setCoins(user.getCoins()+1);
                                                         //System.out.println("after getcoinsplus one");

                           user.setParticipation(user.getParticipation()+1);
                                                     
                           user.setParticipants(user.getParticipants()+1);

                            // UserDB.updateParticipationsAndCoins(user);
                             
                         UserDB.updateParticipations(user.getEmail());
                         UserDB.updateUserCoins(user.getEmail());
                         UserDB.updateUserStudies(user.getEmail());

                           // ArrayList<Study> studies = StudyDB.getStudiesFor(user.getEmail());

                            request.setAttribute("studies", studies);

                       // request.setAttribute("study", editstudy);
                            break;

                        }

                    } else {

                        page = "login";

                    }

            }

            //response.sendRedirect(page + ".jsp");
            getServletContext()
                    .getRequestDispatcher("/" + page + ".jsp")
                    .forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
