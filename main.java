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

public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Vector <Painting> p = new Vector <Painting> ();
        Vector <Sculpture> s = new Vector <Sculpture> ();
        menu(input,p,s);   
    }
    
    public static void menu(Scanner input, Vector <Painting> p, Vector <Sculpture> s) {
        char choice = ' '; 
        do {
            System.out.flush();
            System.out.println("\n --- Welcome to the SAX1JOHNO Art Museum ---");
            System.out.println(" --- We have a library of Painting and of Scultpures ---");
            System.out.println(" --- Which Library would you like to access? ---");
            System.out.println("1) Press 'P' for Paintings.");
            System.out.println("2) Press 'S' for Sculptures");
            System.out.println("3) Press 'Q' to exit.");
            System.out.print("   Enter your choice :  ");
            choice = input.next().charAt(0);
            choice = Character.toLowerCase(choice);
            
            if (choice == 'p') {
                menuPainting(input, p);
            }
            else if (choice == 's') {
                 menuSculpture(input, s);
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
        } while (choice != 'q'); 
        
    }
    
    public static void menuPainting(Scanner input, Vector <Painting> p) {
        int choice = 0;       
        do {
            System.out.flush();
            System.out.println("\n --- Painting Library ---");
            System.out.println(" --- You have #" + p.size() + " paintings in your library. ---");
            System.out.println(" --- What would you like to do? ---");
            System.out.println("1) Press '1' to Create new Painting.");
            System.out.println("2) Press '2' to Delete a Painting.");
            System.out.println("3) Press '3' to Edit a Painting.");
            System.out.println("4) Press '4' to Display all Paintings.");
            System.out.println("5) Press '5' to return to Main Menu.");
            System.out.print("   Enter your choice :  ");
            choice = input.nextInt();
            choice = Character.toLowerCase(choice);
            
            if (choice == 1) {
                if (!isFull(p)) {
                    
                } else {
                    System.out.println("\nThere is no more room for new Paintings.");
                    System.out.println("Delete a Painting to add another.\n");
                }
            }
            else if (choice == 2) {
                if (!isEmpty(p)) {
                    deletePainting(input, p);
                } else {
                   System.out.println("\nThere are no Paintings in the library.\n");  
                }
            }
            else if (choice == 3) {
                if (!isEmpty(p)) {
                    
                } else {
                    System.out.println("\nThere are no Paintings in the library.\n"); 
                }
            }
            else if (choice == 4) {
                if (!isEmpty(p)) {
                    for (int i = 0; i < p.size(); i++) {
                        p.elementAt(i).showArt();
                    }
                } else {
                   System.out.println("\nThere are no Paintings in the library.\n"); 
                }
            }
            else if (choice == 5) {
                return;
            }
            else if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
                System.out.println("Invalid Entry!.");
                System.out.print("Enter your choice :  ");
                choice = input.nextInt();
                choice = Character.toLowerCase(choice);
            }
        } while (choice != 5);
        
        
    } 
    
    public static void menuSculpture(Scanner input, Vector <Sculpture> s) {
        int choice = 0;       
        do {
            System.out.flush();
            System.out.println("\n --- Sculpture Library ---");
            System.out.println(" --- You have #" + s.size() + " Sculptures in your library. ---");
            System.out.println(" --- What would you like to do? ---");
            System.out.println("1) Press '1' to Create new Sculpture.");
            System.out.println("2) Press '2' to Delete a Sculpture.");
            System.out.println("3) Press '3' to Edit a Sculpture.");
            System.out.println("4) Press '4' to Display all Sculptures.");
            System.out.println("5) Press '5' to return to Main Menu.");
            System.out.print("   Enter your choice :  ");
            choice = input.nextInt();
            choice = Character.toLowerCase(choice);
            
            if (choice == 1) {
                if (!isFull(s)) {
                    
                } else {
                    System.out.println("\nThere is no more room for new Sculptures.");
                    System.out.println("Delete a Sculpture to add another.\n");
                }
            }
            else if (choice == 2) {
                if (!isEmpty(s)) {
                    
                } else {
                   System.out.println("\nThere are no Sculptures in the library.\n");  
                }
            }
            else if (choice == 3) {
                if (!isEmpty(s)) {
                    
                } else {
                    System.out.println("\nThere are no Sculptures in the library.\n"); 
                }
            }
            else if (choice == 4) {
                if (!isEmpty(s)) {
                    for (int i = 0; i < s.size(); i++) {
                        s.elementAt(i).showArt();
                    }
                } else {
                   System.out.println("\nThere are no Sculptures in the library.\n"); 
                }
            }
            else if (choice == 5) {
                return;
            }
            else if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
                System.out.println("Invalid Entry!.");
                System.out.print("Enter your choice :  ");
                choice = input.nextInt();
                choice = Character.toLowerCase(choice);
            }
        } while (choice != 5);
        
        
    }
    
    public static void deletePainting(Scanner input, Vector <Painting> p) {
        int i = 0;
        String paintingNum = " ";
        
        do {
        System.out.println("Here are the Paintings in the Library.\n");
        for (i = 0; i < p.size(); i++) {
            System.out.println("\n --- Painting #" + (i+1) + " --- ");
            p.elementAt(i).showArt();
        } 
        System.out.println("\nEnter the ID of the Painting you want to delete.");
        System.out.print("Painting ID :  ");
        paintingNum = input.nextLine();
        } while (paintingNum != p.elementAt(i).getID());
        
        p.remove(paintingNum);
    }
    
    public static boolean isFull(Vector std) {
        return (std.size() == std.capacity());
    }
    
    public static boolean isEmpty(Vector std) {
        return (std.size() == 0);
    }
}

