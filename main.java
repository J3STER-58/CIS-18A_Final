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
        loadSculpture(s);
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
                System.out.println("\nWould you like to save your libraries?");
                System.out.println("1) Press 'Y' to Save and Quit.");
                System.out.println("2) Press 'N' to Quit without Saving");
                
                // Grab User Input for options
                System.out.print("   Enter your choice :  ");
                choice = input.nextLine().charAt(0);
                choice = Character.toLowerCase(choice);
                
                do {
                    if (choice != 'n' && choice != 'y') {
                        System.out.println("Invalid Entry!.");
                        System.out.print("Enter your choice :  ");

                        choice = input.nextLine().charAt(0);
                        choice = Character.toLowerCase(choice);
                    }
                    else if (choice == 'y')
                    {
                        // File Creation
                        File libraryPaintings = new File("libraryPaintings.txt");
                        File librarySculptures = new File("librarySculptures.txt");
                        FileReader read = null;

                        // File Exception Jarble... for Paintings <--
                        try {
                            read = new FileReader(libraryPaintings);
                            try {
                                System.out.println("\nSaving file called libraryPaintings.txt.");
                                FileWriter writer = null;
                                writer = new FileWriter("libraryPaintings.txt");
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
                                System.out.println("Created new file called libraryPaintings.txt.");
                                FileWriter writer = null;
                                writer = new FileWriter("libraryPaintings.txt");
                                BufferedWriter out = new BufferedWriter(writer);

                                for (int i = 0; i < p.size(); i++) {
                                    out.write(p.get(i).toCSV());
                                }

                                out.close();

                            } catch (IOException ex2) {
                                System.out.println(" --- FILE ERROR --- ");
                            }
                        }

                        // File Exception Jarble... for Sculptures <--
                        try {
                            read = new FileReader(librarySculptures);
                            try {
                                System.out.println("\nSaving file called librarySculptures.txt.");
                                FileWriter writer = null;
                                writer = new FileWriter("librarySculptures.txt");
                                BufferedWriter out = new BufferedWriter(writer);

                                for (int i = 0; i < s.size(); i++) {
                                    out.write(s.get(i).toCSV());
                                }

                                out.close();

                            } catch (IOException ex2) {
                                System.out.println(" --- FILE ERROR --- ");
                            }
                        } catch (FileNotFoundException ex) {
                            try {
                                System.out.println("Created new file called librarySculptures.txt.");
                                FileWriter writer = null;
                                writer = new FileWriter("librarySculptures.txt");
                                BufferedWriter out = new BufferedWriter(writer);

                                for (int i = 0; i < s.size(); i++) {
                                    out.write(s.get(i).toCSV());
                                }
                                out.close();
                            } catch (IOException ex2) {
                                System.out.println(" --- FILE ERROR --- ");
                            }
                        }
                        System.out.println("\n\nLibraries Saved!\n");
                    }                       
                    else if (choice == 'n') {
                        System.out.println("Are you sure you want to quit without saving?");
                        System.out.print("   Enter your choice :  ");

                        choice = input.nextLine().charAt(0);
                        choice = Character.toLowerCase(choice);
                        do {
                            if (choice != 'n' && choice != 'y') {
                                System.out.println("Invalid Entry!.");
                                System.out.print("Enter your choice :  ");

                                choice = input.nextLine().charAt(0);
                                choice = Character.toLowerCase(choice);
                            }
                            else if (choice == 'y') {
                                System.out.println("\nQuit without Saving...\n");
                                System.exit(0);
                            }
                            else if (choice == 'n') {
                                System.out.println("Too late! Shutting down......");
                                System.exit(0);
                            }
                        } while (choice != 'y');
                    }
                } while (choice != 'n' && choice != 'y');
                
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
                    createSculpture(input,s);
                } else {
                    System.out.println("\nThere is no more room to add new Sculptures.");
                    System.out.println("Delete a Sculpture to add another.\n");
                }
            }
            else if (choice == 2) {
                if (!isEmpty(s)) {
                    deleteSculpture(input,s);
                } else {
                   System.out.println("\nThere are no Sculptures in the library to delete.\n");  
                }
            }
            else if (choice == 3) {
                if (!isEmpty(s)) {
                    editSculpture(input,s);
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
        String newTitle = "";
        String newArtist = "";
        String newArtMedium = "";
        String newGenre = "";
        int newYear = 0;
        double newPrice = 0.0;
        
        System.out.println("\n\nFor the new Painting, First add the ID.");
        System.out.print(" New ID :  ");
        newID = input.nextLine();
        System.out.print(" New Title :  ");
        newTitle = input.nextLine();
        System.out.print(" New Artist :  ");
        newArtist = input.nextLine();
        System.out.print(" New Art Medium :  ");
        newArtMedium = input.nextLine();
        System.out.print(" New Genre :  ");
        newGenre = input.nextLine();
        System.out.print(" New Year :  ");
        String parseYear = input.nextLine();
        newYear = Integer.parseInt(parseYear);
        System.out.print(" New Price :  ");
        String parsePrice = input.nextLine();
        newPrice = Double.parseDouble(parsePrice);
        
        add.setID(newID);
        add.setTitle(newTitle);
        add.setArtist(newArtist);
        add.setArtMedium(newArtMedium);
        add.setGenre(newGenre);
        add.setYear(newYear);
        add.setPrice(newPrice);
        
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
        int i = 0;
        int indexToEdit = -1;
        String paintingID = " ";
        char choice = ' ';
        int iChoice = 0;
        Painting temp = new Painting();

        do {
            // Displays All Paintings for Reference
            System.out.println("\nHere are the Paintings in the Library.");
            for (i = 0; i < p.size(); i++) { 
                System.out.println("\n --- Painting #" + (i+1) + " --- ");
                p.elementAt(i).showArt();
            } 
            // User Input to Select Painting to edit by ID
            System.out.println("\nEnter the ID of the Painting you want to edit.");
            System.out.print("Painting ID :  ");
            paintingID = input.nextLine();
            
            // Assigns indexToDelete to Element i withing Vector
            for (i = 0; i < p.size(); i++) { 
                if (p.get(i).getID().equals(paintingID)){
                    indexToEdit = i;
                }
            }
            
            do {
                String editID = "";
                String editTitle = "";
                String editArtist = "";
                String editArtMedium = "";
                String editGenre = "";
                int editYear = 0;
                double editPrice = 0.0;
                
                System.out.println(" --- What would you like to edit? ---");
                System.out.println("1) Press '1' to Edit ID.");
                System.out.println("2) Press '2' to Edit Title.");
                System.out.println("3) Press '3' to Edit Artist");
                System.out.println("4) Press '4' to Edit Art Medium.");
                System.out.println("5) Press '5' to Edit Genre.");
                System.out.println("6) Press '6' to Edit Year.");
                System.out.println("7) Press '7' to Edit Price.");
                System.out.println("8) Press '8' to exit Edit Menu.");
                System.out.print("   Enter your choice :  ");
                String sChoice = input.nextLine();
                iChoice = Integer.parseInt(sChoice);
                
                if (iChoice != 1 && iChoice != 2 && iChoice != 3 && iChoice != 4 && iChoice != 5 && iChoice != 6 && iChoice != 7 && iChoice != 8) {
                System.out.println("Invalid Entry!.");
                System.out.print("Enter your choice :  ");
                sChoice = input.nextLine();
                iChoice = Integer.parseInt(sChoice);
                } 
                else if (iChoice == 1) {
                    System.out.print(" New ID :  ");
                    editID = input.nextLine();
                    p.get(indexToEdit).setID(editID);
                } 
                else if (iChoice == 2) {
                    System.out.print(" New Title :  ");
                    editTitle = input.nextLine();
                    p.get(indexToEdit).setTitle(editTitle);
                } 
                else if (iChoice == 3) {
                    System.out.print(" New Artist :  ");
                    editArtist = input.nextLine();
                    p.get(indexToEdit).setArtist(editArtist);
                }
                else if (iChoice == 4) {
                    System.out.print(" New ArtMedium :  ");
                    editArtMedium = input.nextLine();
                    p.get(indexToEdit).setArtMedium(editArtMedium);
                } 
                else if (iChoice == 5) {
                    System.out.print(" New Genre :  ");
                    editGenre = input.nextLine();
                    p.get(indexToEdit).setGenre(editGenre);
                } 
                else if (iChoice == 6) {
                    System.out.print(" New Year :  ");
                    String parseYear = input.nextLine();
                    editYear = Integer.parseInt(parseYear);
                    p.get(indexToEdit).setPrice(editYear);
                } 
                else if (iChoice == 7) {
                    System.out.print(" New Year :  ");
                    String parsePrice = input.nextLine();
                    editPrice = Double.parseDouble(parsePrice);
                    p.get(indexToEdit).setPrice(editPrice);
                } 
                else if (iChoice == 8) {
                    return;
                }
                
                System.out.println("\nNew Painting created.\n\n");
                
            } while (iChoice != 8); // Continues loop until iChoice == 8
        } while (choice != 'y'); // Continues loop until 'YES'    
    }
    
    // ----------- SCULPTURE CREATE ----------- 
    public static void createSculpture(Scanner input, Vector <Sculpture> s) {
        Sculpture add = new Sculpture(); // Creates new default Sculpture
        String newID = "";
        String newTitle = "";
        String newArtist = "";
        String newMaterial = "";
        String newGenre = "";
        int newYear = 0;
        double newPrice = 0.0;
        
        System.out.println("\n\nFor the new Painting, First add the ID.");
        System.out.print(" New ID :  ");
        newID = input.nextLine();
        System.out.print(" New Title :  ");
        newTitle = input.nextLine();
        System.out.print(" New Artist :  ");
        newArtist = input.nextLine();
        System.out.print(" New Art Material :  ");
        newMaterial = input.nextLine();
        System.out.print(" New Genre :  ");
        newGenre = input.nextLine();
        System.out.print(" New Year :  ");
        String parseYear = input.nextLine();
        newYear = Integer.parseInt(parseYear);
        System.out.print(" New Price :  ");
        String parsePrice = input.nextLine();
        newPrice = Double.parseDouble(parsePrice);
        
        add.setID(newID);
        add.setTitle(newTitle);
        add.setArtist(newArtist);
        add.setMaterial(newMaterial);
        add.setGenre(newGenre);
        add.setYear(newYear);
        add.setPrice(newPrice);
        
        s.add(add); // Adds new Painting into Vector
        System.out.println("\nNew Sculpture created.\n\n");
        
    }
    
    // ----------- SCULPTURE DELETE ----------- 
    public static void deleteSculpture(Scanner input, Vector <Sculpture> s) {
        int i = 0;
        int indexToDelete = -1;
        String sculptureID = " ";
        char choice = ' ';
        
        do {
            // Displays All Paintings for Reference
            System.out.println("\nHere are the Paintings in the Library.");
            for (i = 0; i < s.size(); i++) { 
                System.out.println("\n --- Painting #" + (i+1) + " --- ");
                s.get(i).showArt();
            } 
            // User Input to Select Painting to delete by ID
            System.out.println("\nEnter the ID of the Painting you want to delete.");
            System.out.print("Painting ID :  ");
            sculptureID = input.nextLine();
            
            // Assigns indexToDelete to Element i withing Vector
            for (i = 0; i < s.size(); i++) { 
                if (s.get(i).getID().equals(sculptureID)){
                    indexToDelete = i;
                }
            }
            
            // Confirms User Input
            do {
                System.out.println("\nAre you sure you want to delete Painting :  " + s.get(indexToDelete).getID());
                System.out.println("Press 'Y' for yes or 'N' for no.");
                System.out.print("   Enter your choice :  ");
                String sChoice = input.nextLine();
                choice = sChoice.toCharArray()[0];
                choice = Character.toLowerCase(choice);
                if (choice == 'y' && sculptureID.equals(s.get(indexToDelete).getID())) {
                    s.remove(indexToDelete); // Removes Painting by ID 
                }
                else if (choice == 'n'){
                    return;
                }
                // Error with User Input
                else if ((choice != 'y' && choice != 'n' )|| !sculptureID.equals(s.get(indexToDelete).getID())) {
                    System.out.println("Invalid Entry!.");
                    System.out.print("Enter your choice :  ");
                    choice = input.nextLine().charAt(0);
                    choice = Character.toLowerCase(choice);
                }
                
            } while (choice != 'y' && choice != 'n'); // Continues loop until 'YES' AND 'NO'
        } while (choice != 'y'); // Continues loop until 'YES' 
    }
    
    // ----------- SCULPTURE EDIT -----------
    private static void editSculpture(Scanner input, Vector<Sculpture> s) {
        int i = 0;
        int indexToEdit = -1;
        String sculptureID = " ";
        char choice = ' ';
        int iChoice = 0;
        Painting temp = new Painting();

        do {
            // Displays All Paintings for Reference
            System.out.println("\nHere are the Paintings in the Library.");
            for (i = 0; i < s.size(); i++) { 
                System.out.println("\n --- Painting #" + (i+1) + " --- ");
                s.get(i).showArt();
            } 
            // User Input to Select Painting to edit by ID
            System.out.println("\nEnter the ID of the Painting you want to edit.");
            System.out.print("Painting ID :  ");
            sculptureID = input.nextLine();
            
            // Assigns indexToDelete to Element i withing Vector
            for (i = 0; i < s.size(); i++) { 
                if (s.get(i).getID().equals(sculptureID)){
                    indexToEdit = i;
                }
            }
            
            do {
                String editID = "";
                String editTitle = "";
                String editArtist = "";
                String editMaterial = "";
                String editGenre = "";
                int editYear = 0;
                double editPrice = 0.0;
                
                System.out.println(" --- What would you like to edit? ---");
                System.out.println("1) Press '1' to Edit ID.");
                System.out.println("2) Press '2' to Edit Title.");
                System.out.println("3) Press '3' to Edit Artist");
                System.out.println("4) Press '4' to Edit Art Medium.");
                System.out.println("5) Press '5' to Edit Genre.");
                System.out.println("6) Press '6' to Edit Year.");
                System.out.println("7) Press '7' to Edit Price.");
                System.out.println("8) Press '8' to exit Edit Menu.");
                System.out.print("   Enter your choice :  ");
                String sChoice = input.nextLine();
                iChoice = Integer.parseInt(sChoice);
                
                if (iChoice != 1 && iChoice != 2 && iChoice != 3 && iChoice != 4 && iChoice != 5 && iChoice != 6 && iChoice != 7 && iChoice != 8) {
                System.out.println("Invalid Entry!.");
                System.out.print("Enter your choice :  ");
                sChoice = input.nextLine();
                iChoice = Integer.parseInt(sChoice);
                } 
                else if (iChoice == 1) {
                    System.out.print(" New ID :  ");
                    editID = input.nextLine();
                    s.get(indexToEdit).setID(editID);
                } 
                else if (iChoice == 2) {
                    System.out.print(" New Title :  ");
                    editTitle = input.nextLine();
                    s.get(indexToEdit).setTitle(editTitle);
                } 
                else if (iChoice == 3) {
                    System.out.print(" New Artist :  ");
                    editArtist = input.nextLine();
                    s.get(indexToEdit).setArtist(editArtist);
                }
                else if (iChoice == 4) {
                    System.out.print(" New Material :  ");
                    editMaterial = input.nextLine();
                    s.get(indexToEdit).setMaterial(editMaterial);
                } 
                else if (iChoice == 5) {
                    System.out.print(" New Genre :  ");
                    editGenre = input.nextLine();
                    s.get(indexToEdit).setGenre(editGenre);
                } 
                else if (iChoice == 6) {
                    System.out.print(" New Year :  ");
                    String parseYear = input.nextLine();
                    editYear = Integer.parseInt(parseYear);
                    s.get(indexToEdit).setPrice(editYear);
                } 
                else if (iChoice == 7) {
                    System.out.print(" New Year :  ");
                    String parsePrice = input.nextLine();
                    editPrice = Double.parseDouble(parsePrice);
                    s.get(indexToEdit).setPrice(editPrice);
                } 
                else if (iChoice == 8) {
                    return;
                }
                
                System.out.println("\nNew Painting created.\n\n");
                
            } while (iChoice != 8); // Continues loop until iChoice == 8
        } while (choice != 'y'); // Continues loop until 'YES'    
    }
    
    public static boolean isFull(Vector std) {
        return (std.size() == std.capacity());
    }
    
    public static boolean isEmpty(Vector std) {
        return (std.size() == 0);
    }

    private static void loadPainting(Vector <Painting> p) {
        File libraryPainting = new File("libraryPaintings.txt");
        FileReader read = null;
                
        // File Exception Jarble... for Paintings <--
        try {
            read = new FileReader(libraryPainting);
            BufferedReader br = new BufferedReader(read);
        
            String line = null;
            try {
                while ((line = br.readLine()) != null) {
                    Painting paint = new Painting();
                    paint.fromCSV(line);
                    p.add(paint);  
                  }
            } catch (IOException ex) {
            System.out.println("Binary files are not supported.");
            }
        } catch (FileNotFoundException ex) {}
    }
    
    private static void loadSculpture(Vector <Sculpture> s) {
        File librarySculpture = new File("librarySculptures.txt");
        FileReader read = null;
        
        // File Exception Jarble... for Sculptures <--
        try {
            read = new FileReader(librarySculpture);
            BufferedReader br = new BufferedReader(read);
            
            String line = null;
            try {
                while ((line = br.readLine()) != null) {
                    Sculpture sculpt = new Sculpture();
                    sculpt.fromCSV(line);
                    s.add(sculpt);
                }
            } catch (IOException ex) {
                System.out.println("Binary Files are not Supported.");
            }
        } catch (FileNotFoundException ex) {}
    }
}
