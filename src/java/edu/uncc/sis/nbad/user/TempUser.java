/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.sis.nbad.user;
import java.io.Serializable;


/**
 *
 * @author swapnika
 */
public class TempUser implements Serializable {
    
    
    
    private String Name;
    private String Email;
    private String Password;
    private String IssueDate;
    private String ExpirationDate;
    private String Token;

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * @return the IssueDate
     */
    public String getIssueDate() {
        return IssueDate;
    }

    /**
     * @param IssueDate the IssueDate to set
     */
    public void setIssueDate(String IssueDate) {
        this.IssueDate = IssueDate;
    }

    /**
     * @return the Token
     */
    public String getToken() {
        return Token;
    }

    /**
     * @param Token the Token to set
     */
    public void setToken(String Token) {
        this.Token = Token;
    }

    /**
     * @return the ExpirationDate
     */
    public String getExpirationDate() {
        return ExpirationDate;
    }

    /**
     * @param ExpirationDate the ExpirationDate to set
     */
    public void setExpirationDate(String ExpirationDate) {
        this.ExpirationDate = ExpirationDate;
    }
    
    
}
