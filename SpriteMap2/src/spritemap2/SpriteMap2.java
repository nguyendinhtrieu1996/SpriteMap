/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spritemap2;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author dinhtrieu
 */
public class SpriteMap2 {
    
     private static int rowQty = 2;
     private static int colQty = 2;
     
      public static void join(String inputPath,String outputPath) throws IOException {
        File directory=new File(inputPath);
        File[] files=directory.listFiles();
        BufferedImage sprite=ImageIO.read(files[0]);
        int width = sprite.getWidth() * colQty;
        int height = sprite.getHeight() * rowQty;
        BufferedImage spritemap=new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g2d=spritemap.createGraphics();
        int x = 0;
        int y = 0;
        int i = 0;
        
        for (; i < rowQty; ++i) {
            sprite=ImageIO.read(files[i]);
            if (sprite != null) {
                g2d.drawImage(sprite, null, x, y);
                x+=sprite.getWidth();
         
            }
        }
        
        x = 0;
        y = sprite.getHeight();
        for (; i < rowQty * colQty; ++i) {
            sprite=ImageIO.read(files[i]);
            if (sprite != null) {
                g2d.drawImage(sprite, null, x, y);
                x+=sprite.getWidth();
            }
        }
        
        ImageIO.write(spritemap, "PNG", new File(outputPath));
      }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);
         System.out.println("Input: ");
         String input=scanIn.nextLine();
         System.out.println("Output: ");
         String output=scanIn.nextLine();
        try {
            
            SpriteMap2.join(input, output);
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}
