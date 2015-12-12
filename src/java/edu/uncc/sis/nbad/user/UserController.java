/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.sis.nbad.user;

import edu.uncc.sis.nbad.email.MailUtilGmail;
import static edu.uncc.sis.nbad.user.UserDB.*;
import static edu.uncc.sis.nbad.utils.PasswordUtil.hashPassword;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.String.format;
import java.security.NoSuchAlgorithmException;
import static java.text.MessageFormat.format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author padma
 */
@WebServlet(name = "repservlet", urlPatterns = {"/rep"})
public class UserController extends HttpServlet {

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
            throws ServletException, IOException, ParseException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String page = request.getParameter("page");
            /* TODO output your page here. You may use following sample code. */
         
            if (page.equals("login")) {
                
                  // System.out.println("loggedin");

            
              // ${cookie.host.value}cookie
                
                String email = request.getParameter("EmailAddress*");
                String password = request.getParameter("Password*");
              //  System.out.println(email);
               // UserDB db = new UserDB();
               // db.getUsers();
                User user = UserDB.getUser(email);
                //System.out.println(user.setEmail(email));
                //System.out.println(user.getName());
                //System.out.println(password);
                //System.out.println(user.getPassword());
                String hashedpassword = hashPassword(password);
                //System.out.println(hashedpassword);
                if (UserDB.validateUser(email,hashedpassword)) {
                    
                    page = "main";
                 // System.out.println(page);
                    HttpSession session = request.getSession(true);
                    session.setAttribute("theUser", user);
                    session.setAttribute("msg", "");
                } else {
                    //request.getSession().setAttribute("error", "Error while logging in");
                     page = "login";
                    request.setAttribute("error", "Error while logging in.Please retry with the correct credentials");
                   
                }
            } else if (page.equals("signup")) {
                String email = request.getParameter("EmailAddress*");
                String password = request.getParameter("Password*");
                String confirmPassword = request.getParameter("cPassword*");
                String name = request.getParameter("username");
                String referemail = request.getParameter("refer");
                String hashpassword = hashPassword(password);
                TempUser user = new TempUser();
                String outmessage = null;
                if (password.equals(confirmPassword) && name != null && email != null) {
                    
                    Calendar calendar = Calendar.getInstance();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String curDate = sdf.format(calendar.getTime());
                    String ctoken = UUID.randomUUID().toString().replaceAll("-", "");
                    user.setName(name);
                    user.setEmail(email);
                    user.setPassword(hashpassword);
                    user.setIssueDate(curDate);
                    user.setToken(ctoken);
                    TempUserDB.addTempUser(user);
                    
                String to = email;
                String from = "nbad.assignment3@gmail.com";
                String Subject= "Thanks for contacting us regarding the Researchers Exchange Participations project";
               String Body="Dear " + name + ",\n\n"
                        + "Please sign up using the below url\n\n"
                        + "http://nbad-stanneru.rhcloud.com/swapnika_assignment4/rep?page=activate&token="+ctoken+"&refer="+referemail
                        + "\n\nHave a great day!\n\n"
                        + "Regards,\n"
                        + "Swapnika and Padma";
                Boolean isBodyHTML = false;
                try{
                    MailUtilGmail.sendMail(to, from, Subject, Body, isBodyHTML);
                    outmessage = "An activation email was sent to " + email;
                }
                catch(MessagingException e)
                {
                    outmessage = "Unable to send email, please retry";
                }
                    
                    page = "login";
                   // HttpSession session = request.getSession(true);
                    request.setAttribute("outmessage", outmessage);
                    //session.setAttribute("msg", "");
                } else {
                    request.setAttribute("error", "Error during signup.Passwords do not match.Please check and retype the passwords.");
                    page = "signup";
                }
            }
            
            
            else if (page.equals("signupr")) {
                String email = request.getParameter("refer");
                //String password = request.getParameter("Password*");
                //String confirmPassword = request.getParameter("cPassword*");
                //String name = request.getParameter("username");
              request.setAttribute("refer", email);
              page = "signup";
                } 
            
            else {
                    //request.setAttribute("error", "Error during signup.Please try again.");
                    //page = "signup";
                }
            
            if (page.equals("home")) {
               
            
                          // System.out.println(cookie.getValue());
                           //System.out.println(port.getValue());


                page = "home";
            } else if (page.equals("main")) {
                page = "main";
            } else if (page.equals("about")) {
                page = "about";
            } else if (page.equals("aboutl")) {
                page = "aboutl";
            } else if (page.equals("confirmc")) {
                page = "confirmc";
            } else if (page.equals("confirmr")) {
                page = "confirmr";
            } else if (page.equals("contact")) {
                page = "contact";
            } else if (page.equals("reset")) {
                page = "reset";
                
               // String resetflag = "noreset";
                String email = request.getParameter("email");
                 String emailadr = request.getParameter("EmailAddress*");
                String token = request.getParameter("token");
                String resetflag = request.getParameter("resetflag");
                String pass = request.getParameter("Password*");
               String cpass = request.getParameter("cPassword*");
               
                              //System.out.println("Entered reset");
                             // System.out.println("resetflag   " + resetflag);
                             // System.out.println("token" + token);


                
                Calendar calendar = Calendar.getInstance();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String curDate = sdf.format(calendar.getTime());
                
                TempUser tuser = new TempUser();
                tuser = TempUserDB.getUser(token);
               //System.out.println(tuser.getExpirationDate());
              Date date1 = sdf.parse(curDate);
              Date date2 = sdf.parse(tuser.getExpirationDate());
              
              

         
               if((tuser.getToken().equals(token)) && (date1.before(date2)) && (resetflag == null))
                   
               {
                   request.setAttribute("email", email);
                   request.setAttribute("token", token);
                   
               }
                
               
               else if((date1.before(date2)) && (resetflag.equals("reset")) && (pass.equals(cpass)))
                       {
               
                           
                           User user = new User();
             
                    //user.setName(email);
                    user.setEmail(emailadr);
                    user.setPassword(hashPassword(pass));
                    //user.setParticipants(0);
                    //user.setParticipation(0);
                    //user.setCoins(0);
                    UserDB.updateUser(user);
                    TempUserDB.deleteTempUser(token);
                   
                    //HttpSession session = request.getSession(true);
                    //session.setAttribute("theUser", user);
                   // session.setAttribute("msg", "");
                         
               
                     
                     //Send an email after confirmation
                     
                     String to = emailadr;
                String from = "nbad.assignment3@gmail.com";
                String Subject= "Password changed successfully";
               String Body="Dear User,\n\n"
                        + "Your password was changed successfully\n\n"
                        + "\n\nHave a great day!\n\n"
                        + "Regards,\n"
                        + "Swapnika and Padma";
                Boolean isBodyHTML = false;
                try{
                    MailUtilGmail.sendMail(to, from, Subject, Body, isBodyHTML);
                    //outmessage = "An activation email was sent to " + email;
                }
                catch(MessagingException e)
                {
                    //outmessage = "Unable to send email, please retry";
                }
                
                request.setAttribute("msg", "Password was changed successfully.Please login again");  
                     
               }
                
               else
                   
                   
               {
                   
                   if(resetflag.equals("reset"))
                   {
                       
                     page = "reset"; 
                     request.setAttribute("errorr", "Password reset failed.... The token might have expired or password dosnt match.Please try  again");
                     request.setAttribute("email", email);
                   }
                   
                   else
                       
                   {
               page = "forgot";
               request.setAttribute("errorf", "Password reset failed. The token might have expired or password dosnt match.Please try  again");
                   }
               }
                
                
                
                
                
                
            } else if (page.equals("forgot")) {
                page = "forgot";
                
            String email = request.getParameter("EmailAddress*");
 
            
            if ( email == null)
            {
            
            
            
            }
            
            else
                   
            {
            
                
                
      TempUser user = new TempUser();
      
              String outmessage = null;
                if ( email != null) {
                    
                    Calendar calendar = Calendar.getInstance();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String curDate = sdf.format(calendar.getTime());
                        calendar.add(Calendar.HOUR, 1);
                        String expDate = sdf.format(calendar.getTime());
                    String ctoken = UUID.randomUUID().toString().replaceAll("-", "");
                    //user.setName("tempuser");
                    user.setEmail(email);
                   // user.setPassword(password);
                    user.setIssueDate(curDate);
                    user.setExpirationDate(expDate);
                    user.setToken(ctoken);
                    TempUserDB.addTempUser(user);
                    
                String to = email;
                String from = "nbad.assignment3@gmail.com";
                String Subject= "Researchers Exchange Participations : Forgot password";
               String Body="Dear User, \n\n"
                        + "You have recently requested to have your Researchers Exchange Participations project account password reset.\n\n"
                       +"To reset your password, please click on the link below:\n\n"
                        + "http://nbad-stanneru.rhcloud.com/swapnika_assignment4/rep?page=reset&email="+email+"&token="+ctoken
                        + "\n\nIf you are unable to click on the link, please copy and paste the complete link into the address bar of your web browser.\n\n"
                        + "Regards,\n"
                        + "Swapnika and Padma";
                Boolean isBodyHTML = false;
                try{
                    MailUtilGmail.sendMail(to, from, Subject, Body, isBodyHTML);
                    outmessage = "A password reset  email was sent to " + email;
                }
                catch(MessagingException e)
                {
                    outmessage = "Unable to send email, please retry";
                }
                    
                    //page = "forgot";
                   // HttpSession session = request.getSession(true);
                    request.setAttribute("outmessage", outmessage);
                    //session.setAttribute("msg", "");
                } else {
                    request.setAttribute("errorf", "Errors during signup.Passwords do not match.Please check and retype the passwords.");
                    //page = "signup";
                }
      
                
            
            }
            
    
                
            } else if (page.equals("footer")) {
                page = "footer";
            } else if (page.equals("header")) {
                page = "header";
            } else if (page.equals("headerl")) {
                page = "headerl";
            } else if (page.equals("home")) {
                page = "home";
                
               
            } else if (page.equals("how")) {
                page = "how";
            } else if (page.equals("index")) {
                page = "index";
            } else if (page.equals("left_menu")) {
                page = "left_menu";
            } else if (page.equals("newstudy")) {
                page = "newstudy";
            } else if (page.equals("participate")) {
                page = "participate";

               // StudyDB study = new StudyDB();
                //System.out.println(study.getStudies().size()+"");
                //request.getSession().setAttribute("studies", study.getStudies());
            } else if (page.equals("question")) {
                page = "question";
            } else if (page.equals("recommend")) {
                page = "recommend";
            } else if (page.equals("activate")) {
                
              // System.out.println("Entered activate");
                String token = request.getParameter("token");
                String referer = request.getParameter("refer");
                
                TempUser tuser = new TempUser();
               tuser = TempUserDB.getUser(token);
               
              // System.out.println("tuser" + tuser);
               
               if((tuser != null) && (tuser.getToken().equals(token)))
                   
               {
                  // System.out.println("Entered activate IF block");
                   
                User user = new User();
             
                    user.setName(tuser.getName());
                    user.setEmail(tuser.getEmail());
                    user.setPassword(tuser.getPassword());
                    user.setParticipants(0);
                    user.setParticipation(0);
                    user.setCoins(0);
                    UserDB.addUser(user);
                    TempUserDB.deleteTempUser(token);
                   
                    if (referer != null)
                    {
                       // System.out.println("Entered activate IF referer block");
                        UserDB.updateUserCoinsByTwo(referer);
                        
                        
                    }
                    
                    
                    
                    HttpSession session = request.getSession(true);
                    session.setAttribute("theUser", user);
                    session.setAttribute("msg", "");
                
               
               page = "main";
               
               }
               
               else
                   
               {
               request.setAttribute("error", "Error during activation.The token is expired or not found.Please signup again");

               page = "signup";}
               
                
                
            } 

            // System.out.println("Before redirect");
            //response.sendRedirect(page + ".jsp");
             getServletContext()
                .getRequestDispatcher("/"+page + ".jsp")
                .forward(request, response);
        } finally {
            out.close();
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
        
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
