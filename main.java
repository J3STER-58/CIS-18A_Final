/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.util.Scanner;
import java.util.Vector;
/**
 *
 * @author ncc
 */

enum Choices{
    CREATE, DELETE, EDIT, DISPLAY;
}

public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Vector <Painting> p;
        Vector <Sculpture> s;
        menu(input,p,s);   
    }
    
    public static void menu(Scanner input, Vector <Painting> p, Vector <Sculpture> s) {
        char choice = ' ';
        
        System.out.flush();
        System.out.println(" --- Welcome to the SAX1JOHNO Art Museum ---");
        System.out.println(" --- We have a library of Painting and of Scultpures ---");
        System.out.println(" --- Which Library would you like to access? ---");
        System.out.println("1) Press 'P' for Paintings.");
        System.out.println("2) Press 'S' for Sculptures");
        System.out.println("2) Press 'Q' to exit.");
        System.out.print("Enter your choice :  ");
        
        do {
            choice = input.next().charAt(0);
            choice = Character.toLowerCase(choice);
            
            if (choice == 'p') {
                menuPainting(input, p);
            }
            else if (choice == 's') {
                 
            }
            else if (choice == 'q') {
                System.exit(0);
            }
            else if (choice != 'p' && choice != 's' && choice != 'q') {
                System.out.println("Invalid Entry!.");
                System.out.print("Enter your choice :  ");
                choice = input.next().charAt(0);
                choice = Character.toLowerCase(choice);

            }
        } while (choice != 'p' && choice != 's' && choice != 'q'); 
        
    }
    
    public static void menuPainting(Scanner input, Vector <Painting> p) {
        int choice = 0;
        
        System.out.flush();
        System.out.println(" --- Painting Library ---");
        System.out.println(" --- You have #" + p.size() + "of paintings in your library. ---");
        System.out.println(" --- What would you like to do? ---");
        System.out.println("1) Press '1' to Create new Painting.");
        System.out.println("2) Press '2' to Delete a Painting.");
        System.out.println("3) Press '3' to Edit a Painting.");
        System.out.println("4) Press '4' to Display all Paintings.");
                
        do {
            choice = input.next().charAt(0);
            choice = Character.toLowerCase(choice);
            
            if (choice == 1) {
                
            }
            else if (choice == 2) {
                
            }
            else if (choice == 3) {
                
            }
            else if (choice == 4) {
                displayPainting(p);
            }
            else if (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
                
            }
        } while (choice != 1 && choice != 2 && choice != 3 && choice != 4);
        
    }
    
    public static void displayPainting(Vector <Painting> p) {
        for (int i = 0; i < p.size(); i++) {
            p.showArt();
        }
        
    }
    
}
