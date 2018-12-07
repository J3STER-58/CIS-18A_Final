/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.util.Scanner;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author ncc
 */

public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Input and Vector <Art> Libraries Creation
        Scanner input = new Scanner(System.in);
        Vector <Painting> p = new Vector <Painting> ();
        Vector <Sculpture> s = new Vector <Sculpture> ();
        
        // Call Menu
        loadPainting(p);
        menu(input,p,s);   
    }
    
    // ----------- MAIN MENU ----------- 
    public static void menu(Scanner input, Vector <Painting> p, Vector <Sculpture> s) {
        char choice = ' '; 
        do {
            // Main Menu Displayed
            System.out.println("\n --- Welcome to the SAX1JOHNO Art Museum ---");
            System.out.println(" --- We have a library of Painting and of Scultpures ---");
            System.out.println(" --- Which Library would you like to access? ---");
            System.out.println("1) Press 'P' for Paintings Library.");
            System.out.println("2) Press 'S' for Sculptures Library");
            System.out.println("3) Press 'Q' to save and quit.");

            
            // Grab User Input for options
            System.out.print("   Enter your choice :  ");
            choice = input.nextLine().charAt(0);
            choice = Character.toLowerCase(choice);
            
            // Go to Painting Vector
            if (choice == 'p') {
                menuPainting(input, p);
            }
            // Go to Sculpture Vector
            else if (choice == 's') {
                 menuSculpture(input, s);
            }
            // Save and Quit the Program
            else if (choice == 'q') {
                
                // Ask user if they would like to save their progress
                
                // File Creation
                File library = new File("library.txt");
                FileReader read = null;
                
                // File Exception Jarble...
                try {
                    read = new FileReader(library);
                    try {
                        System.out.println("Created new file called library.txt.");
                        FileWriter writer = null;
                        writer = new FileWriter("library.txt");
                        BufferedWriter out = new BufferedWriter(writer);
                        
                        for (int i = 0; i < p.size(); i++) {
                            out.write(p.get(i).toCSV());
                        }
                        
                        out.close();
                
                    } catch (IOException ex2) {
                        System.out.println(" --- FILE ERROR --- ");
                    }
                } catch (FileNotFoundException ex) {
                    try {
                        System.out.println("Created new file called library.txt.");
                        FileWriter writer = null;
                        writer = new FileWriter("library.txt");
                        BufferedWriter out = new BufferedWriter(writer);
                        
                        for (int i = 0; i < p.size(); i++) {
                            out.write(p.get(i).toCSV());
                        }
                        
                        out.close();
                
                    } catch (IOException ex2) {
                        System.out.println(" --- FILE ERROR --- ");
                    }
                }
                                        
                // Double Check if 'NO'
                
                System.exit(0); // Ends Program
            }
            // Error with User Input
            else if (choice != 'p' && choice != 's' && choice != 'q') {
                System.out.println("Invalid Entry!.");
                System.out.print("Enter your choice :  ");
                
                choice = input.nextLine().charAt(0);
                choice = Character.toLowerCase(choice);
            }
        } while (choice != 'q'); // Continue loop while !Exit
        
    }
    
    // ----------- PAINTING MENU ----------- 
    public static void menuPainting(Scanner input, Vector <Painting> p) {
        int choice = 0;       
        do {
            // Painting Menu Displayed
            System.out.println("\n --- Painting Library ---");
            System.out.println(" --- You have #" + p.size() + " paintings in your library. ---");
            System.out.println(" --- What would you like to do? ---");
            System.out.println("1) Press '1' to Create new Painting.");
            System.out.println("2) Press '2' to Delete a Painting.");
            System.out.println("3) Press '3' to Edit a Painting.");
            System.out.println("4) Press '4' to Display all Paintings.");
            System.out.println("5) Press '5' to return to Main Menu.");
            
            // Grab User Input for options
            System.out.print("   Enter your choice :  ");
            String sChoice = input.nextLine();
            choice = Integer.parseInt(sChoice);
            
            // Create New Painting in Library/Vector
            if (choice == 1) {
                if (!isFull(p)) {
                    createPainting(input,p); // Create Painting Function Call
                } else { // If Library/Vector is filled with Paintings
                    System.out.println("\nThere is no more room to add new Paintings.");
                    System.out.println("Delete a Painting to add another.\n");
                }
            }
            // Delete Painting from Library/Vector
            else if (choice == 2) {
                if (!isEmpty(p)) {
                    deletePainting(input, p); // Delete Painting Function Call
                } else {  // If no Paintings exist
                   System.out.println("\nThere are no Paintings in the library to delete.\n");  
                }
            }
            // Edit Painting from Library/vector
            else if (choice == 3) {
                if (!isEmpty(p)) {
                    editPainting(input, p); // Edit Painting Function Call
                } else {  // If no Paintings exist
                    System.out.println("\nThere are no Paintings in the library to edit.\n"); 
                }
            }
            // Displays all Paintings from Library/Vector
            else if (choice == 4) {
                if (!isEmpty(p)) {
                    System.out.println("\n\n --- Complete Painting Library --- ");
                    for (int i = 0; i < p.size(); i++) {
                        p.elementAt(i).showArt();
                    }
                } else {  // If no Paintings exist
                   System.out.println("\nThere are no Paintings in the library to display.\n"); 
                }
            }
            // Return to Main Menu
            else if (choice == 5) {
                return;
            }
            // Error with User Input
            else if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
                System.out.println("Invalid Entry!.");
                System.out.print("Enter your choice :  ");
                choice = input.nextInt();
            }
        } while (choice != 5); // Continue loop while !(Return to Main Menu)
        
        
    } 
    
    // ----------- SCULPTURE MENU ----------- 
    public static void menuSculpture(Scanner input, Vector <Sculpture> s) {
        int choice = 0;       
        do {
            System.out.println("\n --- Sculpture Library ---");
            System.out.println(" --- You have #" + s.size() + " Sculptures in your library. ---");
            System.out.println(" --- What would you like to do? ---");
            System.out.println("1) Press '1' to Create new Sculpture.");
            System.out.println("2) Press '2' to Delete a Sculpture.");
            System.out.println("3) Press '3' to Edit a Sculpture.");
            System.out.println("4) Press '4' to Display all Sculptures.");
            System.out.println("5) Press '5' to return to Main Menu.");
            System.out.print("   Enter your choice :  ");
            String sChoice = input.nextLine();
            choice = Integer.parseInt(sChoice);
            
            if (choice == 1) {
                if (!isFull(s)) {
                    //createSculpture(input,s);
                } else {
                    System.out.println("\nThere is no more room to add new Sculptures.");
                    System.out.println("Delete a Sculpture to add another.\n");
                }
            }
            else if (choice == 2) {
                if (!isEmpty(s)) {
                    //deleteSculpture(input,s);
                } else {
                   System.out.println("\nThere are no Sculptures in the library to delete.\n");  
                }
            }
            else if (choice == 3) {
                if (!isEmpty(s)) {
                    //editSculpture(input,s)
                } else {
                    System.out.println("\nThere are no Sculptures in the library to edit.\n"); 
                }
            }
            else if (choice == 4) {
                if (!isEmpty(s)) {
                    for (int i = 0; i < s.size(); i++) {
                        s.elementAt(i).showArt();
                    }
                } else {
                   System.out.println("\nThere are no Sculptures in the library to display.\n"); 
                }
            }
            else if (choice == 5) {
                return;
            }
            else if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
                System.out.println("Invalid Entry!.");
                System.out.print("Enter your choice :  ");
                sChoice = input.nextLine();
                choice = Integer.parseInt(sChoice);
            }
        } while (choice != 5);  
    }
    
    // ----------- PAINTING CREATE ----------- 
    public static void createPainting(Scanner input, Vector <Painting> p) {
        Painting add = new Painting(); // Creates new default Painting
        String newID = "";
        
        System.out.println("\n\nFor the new Painting, First add the ID.");
        System.out.print(" New ID :  ");
        newID = input.nextLine();
        
        /* 
        Needs Title
        Needs Artist
        Needs Art Medium
        Needs Genre
        Needs Year
        Needs Price
        
        **** SIMILAR TO ID ****
        
        */
        
        add.setID(newID);
        p.add(add); // Adds new Painting into Vector
        System.out.println("\nNew Painting created.\n\n");
        
    }
    
    // ----------- PAINTING DELETE ----------- 
    public static void deletePainting(Scanner input, Vector <Painting> p) {
        int i = 0;
        int indexToDelete = -1;
        String paintingID = " ";
        char choice = ' ';
        
        do {
            // Displays All Paintings for Reference
            System.out.println("\nHere are the Paintings in the Library.");
            for (i = 0; i < p.size(); i++) { 
                System.out.println("\n --- Painting #" + (i+1) + " --- ");
                p.elementAt(i).showArt();
            } 
            // User Input to Select Painting to delete by ID
            System.out.println("\nEnter the ID of the Painting you want to delete.");
            System.out.print("Painting ID :  ");
            paintingID = input.nextLine();
            
            // Assigns indexToDelete to Element i withing Vector
            for (i = 0; i < p.size(); i++) { 
                if (p.get(i).getID().equals(paintingID)){
                    indexToDelete = i;
                }
            }
            
            // Confirms User Input
            do {
                System.out.println("\nAre you sure you want to delete Painting :  " + p.get(indexToDelete).getID());
                System.out.println("Press 'Y' for yes or 'N' for no.");
                System.out.print("   Enter your choice :  ");
                String sChoice = input.nextLine();
                choice = sChoice.toCharArray()[0];
                choice = Character.toLowerCase(choice);
                if (choice == 'y' && paintingID.equals(p.get(indexToDelete).getID())) {
                    p.remove(indexToDelete); // Removes Painting by ID 
                }
                else if (choice == 'n'){
                    return;
                }
                // Error with User Input
                else if ((choice != 'y' && choice != 'n' )|| !paintingID.equals(p.get(indexToDelete).getID())) {
                    System.out.println("Invalid Entry!.");
                    System.out.print("Enter your choice :  ");
                    choice = input.nextLine().charAt(0);
                    choice = Character.toLowerCase(choice);
                }
                
            } while (choice != 'y' && choice != 'n'); // Continues loop until 'YES' AND 'NO'
        } while (choice != 'y'); // Continues loop until 'YES' 
    }
    
    // ----------- PAINTING EDIT -----------
    private static void editPainting(Scanner input, Vector<Painting> p) {
        
    }
    
    /*
    
    NEEDS SCULPTURE CREATE
    NEEDS SCULPTURE DELETE
    NEEDS SCULPTURE EDIT
    
    **** EXACT SAME AS PAINTING FUNCTIONS ****
    **** REPLACE 'p' WITH 's' ****
    
    */
    
    
    public static boolean isFull(Vector std) {
        return (std.size() == std.capacity());
    }
    
    public static boolean isEmpty(Vector std) {
        return (std.size() == 0);
    }

    private static void loadPainting(Vector <Painting> p) {
        File library = new File("library.txt");
        FileReader read = null;
                
        // File Exception Jarble...
        try {
            read = new FileReader(library);
            BufferedReader br = new BufferedReader(read);
        
            String line = null;
            try {
                while ((line = br.readLine()) != null) {
                    Painting paint = new Painting();
                    paint.fromCSV(line);
                    p.add(paint);  
                  }
            } catch (IOException ex) {
            System.out.println("Binary files are not supported");
            }
        } catch (FileNotFoundException ex) {}
    }
}
