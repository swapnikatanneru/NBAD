/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.sis.nbad.answer;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author swapnika
 */
public class Answer implements Serializable {
    
    private String Email;
    private String Choice;
    private String SCode;
    private String DateSubmitted;
    

    
    
    /**
     * Zero Argument constructor
     */
    public Answer()
    {
        
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
     * @return the Choice
     */
    public String getChoice() {
        return Choice;
    }

    /**
     * @param Choice the Choice to set
     */
    public void setChoice(String Choice) {
        this.Choice = Choice;
    }

    /**
     * @return the SCode
     */
    public String getSCode() {
        return SCode;
    }

    /**
     * @param SCode the SCode to set
     */
    public void setSCode(String SCode) {
        this.SCode = SCode;
    }

    /**
     * @return the DateSubmitted
     */
    public String getDateSubmitted() {
        return DateSubmitted;
    }

    /**
     * @param DateSubmitted the DateSubmitted to set
     */
    public void setDateSubmitted(String DateSubmitted) {
        this.DateSubmitted = DateSubmitted;
    }

    
    
}
