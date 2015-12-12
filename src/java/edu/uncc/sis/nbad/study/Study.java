/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.sis.nbad.study;

import java.beans.*;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Padma Kumari
 */
public class Study implements Serializable {
    
    
private String Name;
private String Code;
private String DateCreated;
private String Email;
private String Question;
private int Requestedparticipants;
private int Numofparitipants;
private String Description;
private String Status;
private Collection Answers;
private String ImageURL;
private float Average;
    private int Minimum;
    private int Maximum;
    private int SD;
    private String datesubmitted;




/**
     * Zero Argument constructor
     */
    public Study()
    {
        
    }
    



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
     * @return the Code
     */
    public String getCode() {
        return Code;
    }

    /**
     * @param Code the Code to set
     */
    public void setCode(String Code) {
        this.Code = Code;
    }

    /**
     * @return the DateCreated
     */
    public String getDateCreated() {
        return DateCreated;
    }

    /**
     * @param DateCreated the DateCreated to set
     */
    public void setDateCreated(String DateCreated) {
        this.DateCreated = DateCreated;
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
     * @return the Question
     */
    public String getQuestion() {
        return Question;
    }

    /**
     * @param Question the Question to set
     */
    public void setQuestion(String Question) {
        this.Question = Question;
    }

    /**
     * @return the Requestedparticipants
     */
    public int getRequestedparticipants() {
        return Requestedparticipants;
    }

    /**
     * @param Requestedparticipants the Requestedparticipants to set
     */
    public void setRequestedparticipants(int Requestedparticipants) {
        this.Requestedparticipants = Requestedparticipants;
    }

    /**
     * @return the Numofparitipants
     */
    public int getNumofparitipants() {
        return Numofparitipants;
    }

    /**
     * @param Numofparitipants the Numofparitipants to set
     */
    public void setNumofparitipants(int Numofparitipants) {
        this.Numofparitipants = Numofparitipants;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * @return the Status
     */
    public String getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(String Status) {
        this.Status = Status;
    }

    /**
     * @return the Answers
     */
    public Collection getAnswers() {
        return Answers;
    }

    /**
     * @param Answers the Answers to set
     */
    public void setAnswers(Collection Answers) {
        this.Answers = Answers;
    }
    
    
      
   public String getImageURL()
    {
        return ImageURL;
    }
    
    
   public void setImageURL(String ImageURL)
    {
       this.ImageURL= ImageURL;
    }
    
    /**
     * @return the Average
     */
    public float getAverage() {
        return Average;
    }

    /**
     * @param Average the Average to set
     */
    public void setAverage(float Average) {
        this.Average = Average;
    }

    /**
     * @return the Minimum
     */
    public int getMinimum() {
        return Minimum;
    }

    /**
     * @param Minimum the Minimum to set
     */
    public void setMinimum(int Minimum) {
        this.Minimum = Minimum;
    }

    /**
     * @return the Maximum
     */
    public int getMaximum() {
        return Maximum;
    }

    /**
     * @param Maximum the Maximum to set
     */
    public void setMaximum(int Maximum) {
        this.Maximum = Maximum;
    }

    /**
     * @return the SD
     */
    public int getSD() {
        return SD;
    }

    /**
     * @param SD the SD to set
     */
    public void setSD(int SD) {
        this.SD = SD;
    }

    /**
     * @return the datesubmitted
     */
    public String getDatesubmitted() {
        return datesubmitted;
    }

    /**
     * @param datesubmitted the datesubmitted to set
     */
    public void setDatesubmitted(String datesubmitted) {
        this.datesubmitted = datesubmitted;
    }
}
