/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.sis.nbad.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @author Matthew Jones, 2009
 */
public class CreateImageUtil {

    public static void main(String[] args) throws IOException {
        try {

            // collect correct inputs or DIE.
            String email = "My studies and results";
            Color bg = new Color(60,219,251);
            Color fg = new Color(5,0,1);
            String filename = System.getProperty("user.dir");
            filename = filename + "/web/media/mystudies.png";
System.out.println();
            // call render image method.
            RenderedImage rendImage = writeImage(email, fg, bg);

            File file = new File(filename);

            ImageIO.write(rendImage, "png", file);

        } catch (Exception e) {
            // Sloppy Error handling below
           // System.out.println("Usage: textToImage.jar email fg-colour-hex bg-colour-hex filename");
            //System.out.println("Example: textToImage.jar eg@eg.com FFFFFF 0000FF C:\\dir\\image.png");
            System.out.print(e.getMessage());
        }
    }

    private static RenderedImage writeImage(String text, Color fgc, Color bgc) {

        // calculate image size requirements.
        int width = (text.length() * 7) + 5;

        // standard height requirement of 16 px.
        int height = 300;
        BufferedImage buffRenderImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D flatGraphic = buffRenderImage.createGraphics();


        // Draw background
        flatGraphic.setColor(bgc);
        flatGraphic.fillRect(0, 0, width, height);

        //Draw text
        flatGraphic.setColor(fgc);
        Font font = new Font("Courier", Font.BOLD, 12);
        flatGraphic.setFont(font);
        flatGraphic.drawString(text, 1, 10);
        flatGraphic.drawString("_____________________", 1, 20);

        // don't use drawn graphic anymore.
        flatGraphic.dispose();

        return buffRenderImage;
    }
}
