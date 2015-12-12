/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.sis.nbad.email;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.MessagingException;

/**
 *
 * @author swapnika
 */
@WebServlet(name = "EmailListServlet", urlPatterns = {"/EmailListServlet"})
public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/contact.jsp";
        
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "errorContact";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("errorContact")) {
            url = "/home.jsp";    // the "join" page
        } 
        else if (action.equals("sendContactInfo")) {
            // get parameters from the request
            String username = request.getParameter("username");
            String email = request.getParameter("EmailAddress*");
            String inputmessage = request.getParameter("message");

            // store data in User object
           // User user = new User(firstName, lastName, email);
	    //System.out.println("in emailList, firstname="+ firstName);
            // validate the parameters
            String outmessage;
            if (username == null || email == null || inputmessage == null ||
                username.isEmpty() || email.isEmpty() || inputmessage.isEmpty()) {
                outmessage = "Please fill all the information.";
                url = "/contact.jsp";
            } 
            else {
                outmessage = "An email was sent";
                
                
                String to = email;
                String from = "nbad.assignment3@gmail.com";
                String Subject= "Thanks for contacting us regarding the Researchers Exchange Participations project";
                String Body="Dear " + username + ",\n\n"
                        + "Thanks for contacting us. We will get back to you regarding your message. \n\n"
                        + "Have a great day!\n\n"
                        + "Regards,\n"
                        + "Swapnika and Padma";
                Boolean isBodyHTML = false;
                try{
                    MailUtilGmail.sendMail(to, from, Subject, Body, isBodyHTML);
                }
                catch(MessagingException e)
                {
                    outmessage = "Unable to send email, please retry";
                }
                
                
                
                
                
                url = "/confirmc.jsp";
                //UserDB.insert(user);
            }
           // request.setAttribute("user", user);
            request.setAttribute("outmessage", outmessage);
        }
        
            else if (action.equals("sendrecommendInfo")) {
            // get parameters from the request
            String username = request.getParameter("rusername");
            String email = request.getParameter("Email*");
            String femail = request.getParameter("Femail*");
            String inputmessage = request.getParameter("rmessage");

            // store data in User object
           // User user = new User(firstName, lastName, email);
	    //System.out.println("in emailList, firstname="+ firstName);
            // validate the parameters
            String outmessage;
            if (username == null || email == null || femail == null || inputmessage == null ||
                username.isEmpty() || email.isEmpty() || inputmessage.isEmpty() || femail.isEmpty()) {
                outmessage = "Please fill all the information.";
                url = "/recommend.jsp";
            } 
            else {
                outmessage = "Recommendation email sent to "+ femail;
                
                
                String to = femail;
                String from = email;
                String Subject= "Recommendation for Researchers Exchange Participations project";
                String Body="Dear " + username + ",\n\n"
                        + "You received the below message from your friend \n\n"
                        + inputmessage+"\n\n"
                        + "Please sign up using the below url\n\n"
                        + "http://nbad-stanneru.rhcloud.com/swapnika_assignment4/rep?page=signupr&refer="+email
                        + "\n\nHave a great day!\n\n"
                        + "Regards,\n"
                        + "Swapnika and Padma";
                Boolean isBodyHTML = false;
                try{
                    MailUtilGmail.sendMail(to, from, Subject, Body, isBodyHTML);
                }
                catch(MessagingException e)
                {
                    outmessage = "Unable to send email, please retry";
                }
                
                
                
                
                
                url = "/confirmr.jsp";
                //UserDB.insert(user);
            }
           // request.setAttribute("user", user);
            request.setAttribute("outmessage", outmessage);
        }
        
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }    
}