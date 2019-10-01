/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author alber
 */
public class book {

    private int ID;      	
    private String name;                   	
    private String author;	
    private String category;	
    private int year;	
    private float price;	
	
     	
    public int getID() {	
        return ID;	
    }	
	
    public void setID(int ID) {	
        this.ID = ID;	
    }	
	
    public String getName() {	
        return name;	
    }	
	
    public void setName(String name) {	
        this.name = name;	
    }	
	
    public String getAuthor() {	
        return author;	
    }	
	
    public void setAuthor(String author) {	
        this.author = author;	
    }	
	
    public String getCategory() {	
        return category;	
    }	
	
    public void setCategory(String category) {	
        this.category = category;	
    }	
	
    public int getYear() {	
        return year;	
    }	
	
    public void setYear(int year) {	
        this.year = year;	
    }	
	
    public float getPrice() {	
        return price;	
    }	
	
    public void setPrice(float price) {	
        this.price = price;	
    }	

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.ID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final book other = (book) obj;
        if (this.ID != other.ID) {
            return false;
        }
        return true;
    }
    	
}
