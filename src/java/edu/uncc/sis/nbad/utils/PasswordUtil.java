/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.sis.nbad.utils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;


/**
 *
 * @author swapnika
 */


public class PasswordUtil {
    
    /*  This code uses SHA-256. If this algorithm isn't available to you,
        you can try a weaker level of encryption such as SHA-128.
    */    
    public static String hashPassword(String password)
            throws NoSuchAlgorithmException {        
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.reset();
        md.update(password.getBytes());
        byte[] mdArray = md.digest();
        StringBuilder sb = new StringBuilder(mdArray.length * 2);
        for (byte b : mdArray) {
            int v = b & 0xff;
            if (v < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }        
        return sb.toString();        
    }
    
    
    
    public static void checkPasswordStrength(String password) throws Exception {
        if (password == null || password.trim().isEmpty()) {
            throw new Exception("Password cannot be empty.");
        } else if (password.length() < 8) {
            throw new Exception("Password is to short. " +
                    "Must be at least 8 characters long.");
        }
    }

    public static boolean validatePassword(String password) {
        try {
            checkPasswordStrength(password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
  
}