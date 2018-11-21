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
public class Art {
    protected String id;
    protected String title;
    protected String artist;
    protected String genre;
    protected int year;
    protected double price;
    
    public void showArt() {
	System.out.println("ID: " + id + "\nTitle: " + title 
                + "\nArtist: " + artist + "\nGenre: " + genre 
                + "\nYear: " + year + "\nPrice: $" + price + "\n\n");
    }
}
