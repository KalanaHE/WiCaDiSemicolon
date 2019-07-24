/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wicadi.beta;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import java.util.InputMismatchException;

/**
 *
 * @author Kalana Hettiarachchi
 */
public class Graph extends JPanel implements ActionListener{
    int count = 0;
    //creates any variables that need to communicate between classes
    Timer tm = new Timer(1, this);
    static GraphLayout mainGraph = new GraphLayout();
    static String parentFunction;
    static double[] trans = new double[6];
    public static final String[] parents = { "Linear", "Quadratic", "Rational", "Exponential", "Logarithmic", "Sinusodial" };
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //draws the grid on the form and starts timer
        mainGraph.drawGrid(g);
        tm.start();
        //sets line color
        g.setColor(Color.RED);
        //figures out which parent function was selected and passes inputs to graph layout to graph
        if(parentFunction.equals("Linear")){
            mainGraph.plotPoints(trans[0], trans[1]);
        }else if(parentFunction.equals("Quadratic")){
            mainGraph.plotPoints(trans[0], trans[1], trans[2]);
        }else if(parentFunction.equals("Rational")){
            mainGraph.plotPoints(trans[0], trans[1], trans[2], trans[3], trans[4], trans[5]);
        }else if(parentFunction.equals("Exponential")){
            mainGraph.plotPoints(trans[0]);
        }else if(parentFunction.equals("Logarithmic")){
            mainGraph.plotPoints(trans[0], trans[1], trans[2], trans[3], trans[4]);
        }else if(parentFunction.equals("Sinusodial")){
             mainGraph.plotPoints(trans[0], trans[1], trans[2], trans[3]);
        }
        //takes the points from graph layout and draws them on the graph
        for(int i = 0;i < count;i++){
            if((mainGraph.getyPoints(i) > 0 && mainGraph.getyPoints(i) < mainGraph.getHeight()) && (mainGraph.gety2Points(i) > 0 && mainGraph.gety2Points(i) < mainGraph.getHeight())){
                g.drawLine(i, mainGraph.getyPoints(i), i - 1, mainGraph.gety2Points(i));  
            }
            
        }      
    }
    public void actionPerformed(ActionEvent e){
//      creates an effect of drawing from left to right
        if(count < mainGraph.getWidth() ){
            count++;
            repaint();
        }      
    }
    public void agraphrun() {
        //read in width, height and spacing from file
        try {
            Scanner file_io = new Scanner(new File("GraphDimensions.txt"));            
//            mainGraph.setHeight(Integer.parseInt(file_io.nextLine()));
//            mainGraph.setWidth(Integer.parseInt(file_io.nextLine()));
//            mainGraph.setSpacing(Integer.parseInt(file_io.nextLine()));
            mainGraph.setHeight(file_io.nextInt());
            mainGraph.setWidth(file_io.nextInt());
            mainGraph.setSpacing(file_io.nextInt());
	}
	catch (IOException | InputMismatchException e)  {
            System.out.println("Required file or inputs not found");
	}
        //shows help dialog
        
//        JOptionPane.showMessageDialog(null, "To use this graphing calculator choose the parent "
//                + "function you wish to graph in the following menu then enter your "
//                + "desired transformations. The form of the function can be found in "
//                + "the title of transformation input form. The dimensions for the "
//                + "graph can be changed in the Graph Dimensions text file", "Help", 
//                JOptionPane.INFORMATION_MESSAGE, null);

        //creates the list box dialogue to choose parent function
        JFrame frame = new JFrame();
        Graph input = new Graph();
        parentFunction = (String) JOptionPane.showInputDialog(frame,"What is the parent function?","Parent Function",JOptionPane.QUESTION_MESSAGE, null, parents,parents[0]);
        
        //figures out what parent function was selected then shows the required message box
        if(parentFunction.equals("Linear")){
            input.initalizeInput(2, "Form: y = ax + b");
            Graph t = new Graph();  
            JFrame jf = new JFrame();
            jf.setTitle("WiCaDi Graph ( y = ax + b )");
            jf.setSize(mainGraph.getWidth(), mainGraph.getHeight());
            jf.setVisible(true);
            jf.add(t);
        }else if(parentFunction.equals("Quadratic")){
            input.initalizeInput(3, "Form: y = a(x-b)^2 + c");
            Graph t = new Graph();  
            JFrame jf = new JFrame();
            jf.setTitle("WiCaDi Graph ( a(x-b)^2 + c )");
            jf.setSize(mainGraph.getWidth(), mainGraph.getHeight());
            jf.setVisible(true);
            jf.add(t);
        }else if(parentFunction.equals("Rational")){
            input.initalizeInput(6, "Form: y = (ax^2 + bx + c)/(dx^2 + ex + f)");
            Graph t = new Graph();  
            JFrame jf = new JFrame();
            jf.setTitle("WiCaDi Graph ( y = (ax^2 + bx + c)/(dx^2 + ex + f) )");
            jf.setSize(mainGraph.getWidth(), mainGraph.getHeight());
            jf.setVisible(true);
            jf.add(t);
        }else if(parentFunction.equals("Exponential")){
            input.initalizeInput(1, "Form: y = a^x");
            Graph t = new Graph();  
            JFrame jf = new JFrame();
            jf.setTitle("WiCaDi Graph ( y = (ax^2 + bx + c)/(dx^2 + ex + f) )");
            jf.setSize(mainGraph.getWidth(), mainGraph.getHeight());
            jf.setVisible(true);
            jf.add(t);
        }else if(parentFunction.equals("Logarithmic")){
            input.initalizeInput(5, "Form: y = a(logb(c(x + d)))+e");
            Graph t = new Graph();  
            JFrame jf = new JFrame();
            jf.setTitle("WiCaDi Graph ( a(logb(c(x + d)))+e )");
            jf.setSize(mainGraph.getWidth(), mainGraph.getHeight());
            jf.setVisible(true);
            jf.add(t);
        }else if(parentFunction.equals("Sinusodial")){
            input.initalizeInput(4, "Form: y = a(sin(b(x + c))) + d");
            Graph t = new Graph();  
            JFrame jf = new JFrame();
            jf.setTitle("WiCaDi Graph ( y = a(sin(b(x + c))) + d )");
            jf.setSize(mainGraph.getWidth(), mainGraph.getHeight());
            jf.setVisible(true);
            jf.add(t);
        }
 
    } 
    public void initalizeInput(int inputs, String form){
        //creates the panel and maximum text fields to be displayed
            JPanel myPanel = new JPanel();
            JTextField[] Field = new JTextField[6];
                for (int i = 0;i < inputs;i++ ){
                    //adds a label then text field then horizontal spacing as many times as requested
                    myPanel.add(new JLabel((char)(i + 97) + " value:"));
                    Field[i] = new JTextField(String.valueOf(0));
                    Field[i].setColumns(3);
                    myPanel.add(Field[i]);
                    myPanel.add(Box.createHorizontalStrut(15));
                }
                //creates a confirm dialouge with the panel created
                JOptionPane.showConfirmDialog(null, myPanel, 
                form, JOptionPane.DEFAULT_OPTION);
                for (int i = 0;i < inputs;i++ ){
                    //takes the numbers added to the fields
                    if(mainGraph.isValidInput(Field[i].getText(), "0123456789-.")){
                        trans[i] = Double.parseDouble(Field[i].getText());
                    }else{
                        System.out.println("Invalid Input at field " + (char)(i + 97));
                    }
                }
    }
}
