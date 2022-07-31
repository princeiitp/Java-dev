package src.test;
 
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import src.main.models.Movie;
import src.main.models.Store;

public class StoreTest {

    Store store;

    @Before
    public void setup(){
        store = new Store();
        store.addMovie(new Movie("The Shawshannk Redemption", "Blue-Ray",9.2));
        store.addMovie(new Movie("The Godfather", "Blue-Ray", 9.1));
    }

    @Test

    public void movieAdded() {
        assertTrue(store.contains(new Movie("The Godfather", "Blue-Ray", 9.1)));
    }

    @Test

    public void sellMovieTest() { 
        store.sellMovie("The Godfather");
        assertFalse(store.contains(new Movie("The Godfather", "Blue-Ray", 9.1)));
    }

    @Test

    public void rentMovieTest() {
        store.rentMovie("The Shawshannk Redemption");
        assertFalse(store.getMovie(0).isAvailable());
    }

    @Test

    public void returnMovieTest(){
        store.rentMovie("The Shawshannk Redemption");
        store.returnMovie("The Shawshannk Redemption");
        assertTrue(store.getMovie(0).isAvailable());
    }



    @Test(expected = IllegalStateException.class)
    public void movieNotInStock() {
        store.rentMovie("The Godfather");
        store.sellMovie("The Godfather");
    }



}
