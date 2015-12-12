/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.sis.nbad.user;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author swapnika
 */
public class User implements Serializable {
    
    private String Name;
    private String Email;
    private int Coins;
    private int Participants;
    private int Participation;

    private String Password;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    /**
     * Zero Argument constructor
     */
    public User()
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
     * @return the Coins
     */
    public int getCoins() {
        return Coins;
    }

    /**
     * @param Coins the Coins to set
     */
    public void setCoins(int Coins) {
        this.Coins = Coins;
    }

    /**
     * @return the Participants
     */
    public int getParticipants() {
        return Participants;
    }

    /**
     * @param Participants the Participants to set
     */
    public void setParticipants(int Participants) {
        this.Participants = Participants;
    }

    /**
     * @return the Participation
     */
    public int getParticipation() {
        return Participation;
    }

    /**
     * @param Participation the Participation to set
     */
    public void setParticipation(int Participation) {
        this.Participation = Participation;
    }


   
}
