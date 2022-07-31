package src.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import javax.swing.InputMap;

import org.junit.Before;
import org.junit.Test;

import src.main.models.Cart;
import src.main.models.Item;
 
public class CartTest {

    Cart cart;

    @Before

    public void setup(){
        cart = new Cart();
        cart.add(new Item("Pepsi", 1.99));
        cart.add(new Item("Crush", 1.99));
    }


    @Test

    public void itemAddedTest(){
        assertTrue(cart.contains(new Item("Pepsi", 1.99)));
    }

    @Test
    public void skipDuplicateTest(){

        assertFalse(cart.add(new Item("Pepsi", 1.99)));
    }

    @Test

    public void removedItemtest(){
        cart.remove("Crush");
        assertFalse(cart.contains(new Item("Crush", 1.99)));
    }

    @Test

    public void subTotalIsValid(){
        assertEquals(3.98, cart.getSubTotal());
    }

    @Test

    public void testIsValid(){
        assertEquals(0.52, cart.getTax(cart.getSubTotal()));
    }

    @Test

    public void totalIsValid(){
        assertEquals(96.54, cart.getTotal(85.20, 11.34));
    }

    @Test(expected = IllegalStateException.class)

    public void invalidRemoveState(){
       cart.clear();
       cart.remove("Pepsi");
    }

    @Test(expected = IllegalStateException.class)
    public void invalidCheckoutState(){
        cart.clear();
        cart.checkout();
    }

    
}
