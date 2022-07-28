package models;

public class Movie {
    private String name;
    private String format;
    private double rating;
    private double sellingPrice;
    private double rentalPrice;
    private boolean isAvailable;

    public Movie(String name, String format, double rating){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("name cannot be null/blank");
        }
        if(!format.equals("DVD") && !format.equals("Blue-Ray")){
            throw new IllegalArgumentException("format cannot only DVD or Blue-Ray");
        }
        if(rating < 0 || rating > 10){
            throw new IllegalArgumentException("INVALID RATING");
        }
        this.name = name;
        this.format = format;
        this.rating = rating;
        this.isAvailable = true;
        this.sellingPrice = format.equals("DVD") ? 2.25 : 4.25;
        this.rentalPrice = format.equals("DVD") ? 0.99 : 1.99;
    }

    public Movie(Movie source){
        this.name = source.name;
        this.format = source.format;
        this.rating = source.rating;
        this.isAvailable = source.isAvailable;
        this.rentalPrice = source.rentalPrice;
        this.sellingPrice = source.sellingPrice;
    }

    public String getName(){
        return this.name;
    }
    public String getFormat(){
        return this.format;
    }
    public double getRating(){
        return this.rating;
    }
    public double getSellingPrice(){
        return this.sellingPrice;
    }
    public double getRentalPrice(){
        return this.rentalPrice;
    }
    public boolean isAvailable(){
        return this.isAvailable;
    }
    public void setName(String name){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public void setFormat(String format){
        if(format == null || format.isBlank() || (!format.equals("DVD") && !format.equals("Blue-Ray"))){
            throw new IllegalArgumentException("fomat must be DVD or Blur-Ray");
        }
        this.format = format;
        setSellingPrice(format.equals("Blue-Ray") ? 4.25 : 2.25);
        setRentalPrice(format.equals("Blue-Ray") ? 1.99 : 0.99);
    }
    public void setRating(double rating){
        if(rating < 0 || rating > 10){
            throw new IllegalArgumentException("INVALID RATING");
        }
        this.rating = rating;
    } 
    private void setSellingPrice(double sellingPrice){
        this.sellingPrice = sellingPrice;
    }
    private void setRentalPrice(double rentalPrice){
        this.rentalPrice = rentalPrice;
    }
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String toString(){
        String temp = "";
        temp +=  "\t Name: " + this.name + "\n" +

        "\t Format: " + this.format + "\n" +

        "\t Rating: " + this.rating + "\n" +

        "\t Selling Price: " + this.sellingPrice + "\n" +

        "\t Rental Price: " + this.rentalPrice + "\n" +

        "\t Availability: " + (this.isAvailable ? "in-stock" : "rented") + "\n";

        return temp;
    }
}



