package models;

import java.util.ArrayList;

import javax.crypto.spec.IvParameterSpec;

public class Store {
    private ArrayList<Movie> movies;


    public Store(){
        this.movies = new ArrayList<Movie>();
    }

    public Movie getMovie(int index){
        // for (int i = 0; i < this.movies.size(); i++) {
        //     if (this.movies.get(i).getName().equals(name)) {
        //         return new Movie(this.movies.get(i));
        //     }
        // }
        //return null;
        return new Movie(this.movies.get(index));
    }

    public void setMovie(int index, Movie movie){
        this.movies.set(index,new Movie(movie));
    }

    public void addMovie(Movie movie){
        this.movies.add(new Movie(movie));
    }

    public void action(String name, String action){
        if(this.movies.isEmpty()){
            throw new IllegalStateException("All movies are rented/sold!");
        }
        if(!action.equals("sell") && !action.equals("rent") && !action.equals("return")){
            throw new IllegalArgumentException("INVALID ACTION");
        }
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("name cannot be null/blank");
        }
        for(int i=0; i < this.movies.size(); i++){
            if(this.movies.get(i).getName().equals(name)){
                switch(action){
                    case "sell":
                    if(!movies.get(i).isAvailable()) {
                        throw new IllegalStateException("Cannot sell movie that was rented out!");
                    } 
                       movies.remove(i) ; break;
                    case "rent": movies.get(i).setAvailable(false); break;
                    case "return": movies.get(i).setAvailable(true); break;
                }
            }
               
        }
    }

    public String toString(){
        String temp = "";
        for(int i=0; i < this.movies.size(); i++){
            temp += this.movies.get(i).toString() + "\n\n";
        }
        return temp;
    }
    
}
