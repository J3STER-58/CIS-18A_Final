/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author ncc
 */
public class Sculpture extends Art {
    private String material;
    
    // ----- Default Constructor -----
    Sculpture() { 
        this.id = null;
        this.title = null;
        this.artist = null;
        this.genre = null;
        this.year = 0;
        this.price = 0.0;
        this.material = null;
    }
    
    // ----- Overloaded Constructor -----
    Sculpture(String id, String title, String artist, String genre, int year, 
            double price, String artMedium) { 
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.year = year;
        this.price = price;
        this.material = artMedium;
    }
    
    // ----- ID Get and Set -----
    public void setID(String id) {
       this.id = id; 
    }
    public String getID() {
        return id;
    }
    
    // ----- Title Get and Set -----
    public void setTitle(String title) {
        this.title = title;
    } 
    public String getTitle() {
        return title;
    }
    
    // ----- Artist Get and Set -----
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getArtist() {
        return artist;
    }
    
    // ----- Genre Get and Set -----
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getGenre() {
        return genre;
    }
    
    // ----- Year Get and Set -----
    public void setYear(int year) {
        this.year = year;
    }
    public int getYear() {
        return year;
    }
    
    // ----- Price Get and Set -----
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    
    // ----- Material Get and Set -----
    public void setMaterial(String material) {
        this.material = material;
    }
    public String getArtMedium() {
        return material;
    }
    
    
    @Override
    public void showArt() {
	System.out.println("ID: " + id + "\nTitle: " + title 
                + "\nArtist: " + artist + "\nMaterial: " + material 
                + "\nGenre: " + genre + "\nYear: " + year 
                + "\nPrice: $" + price + "\n\n");
    }
}
