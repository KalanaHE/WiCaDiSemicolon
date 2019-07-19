/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wicadi.beta;

/**
 *
 * @author Kalana Hettiarachchi
 */
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

public class TestKeyListener extends JPanel {
   private KeyLis listener;

   public TestKeyListener() {
      
      listener = new KeyLis();
      this.setFocusable(true);
      this.requestFocus();
      this.addKeyListener(listener);
   }



   private class KeyLis extends KeyAdapter {
      @Override
      public void keyPressed(KeyEvent e) {
         switch (e.getKeyCode()) {
         case KeyEvent.VK_LEFT:
            System.out.println("VK_LEFT pressed");
            break;
         case KeyEvent.VK_RIGHT:
            System.out.println("VK_RIGHT pressed");
            break;
         }
      }
   }

   private static void createAndShowGui() {
      TestKeyListener mainPanel = new TestKeyListener();

      JFrame frame = new JFrame("TestKeyListener");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}