package models;

import java.util.ArrayList;

public class Cart {
    ArrayList<Item> items;

    public Cart(){
        this.items = new ArrayList<Item>();
    }


    public Item getItem(int index) {
        return new Item(items.get(index));
    }

    public void setItems(int index, Item item) {
        this.items.set(index, new Item(item));
    }

    public boolean add(Item item){
        if(this.items.contains(item)){
            return false;
        }
        this.items.add(new Item(item));
        return true;
    }

    public boolean isEmpty(){
        return this.items.isEmpty();
    }

    public void remove(String name){
        if(items.isEmpty()){
            throw new IllegalStateException("cannot remove items from empty cart.");
        }
        for(int i=0; i < items.size(); i++){
            if(items.get(i).getName().equals(name)){
                items.remove(i);
            }
        }
    }

    public String checkout(){  //receipt purpose
        if(items.isEmpty()){
            throw new IllegalStateException("cannot checkout an empty cart.");
        }
        double[] measures = new double[3];
        for(int i=0; i < items.size(); i++){
            measures[0] += items.get(i).getPrice();
        }
        String temp = "";
        measures[1] = measures[0] * 0.13;
        measures[2] = measures[0] + measures[1];
        temp += "\tRECEIPT\n\n" +
        "\tSubtotal: $" + measures[0] + "\n" +
        "\tTax: $" + measures[1] + "\n" +
        "\tTotal: $" + measures[2] + "\n";

        return temp;
    }

    public String toString(){
        String temp = "";
        for(int i=0; i < items.size(); i++){
            temp += items.get(i).toString() + "\n"; 
        }
        return temp;
    }

   /**
    * Name: add
    * @param item
    * @return boolean
    *
    * Inside the function:
    *   1. Adds an item to the cart if it wasn't already added.
    */

 
 
  
   /**
    * Name: remove
    * @param name
    *
    * Inside the function:
    *   1. Removes the item that matches the name passed in.
    */

 
 
  
   /**
    *  Name: checkout
    *  @return (String)
    *
    *  Inside the function:
    *   1. Calculates the subtotal (price before tax).
    *   2. Calculates the tax (assume tax is 13%).
    *   3. Calculates total: subtotal + tax
    *   4. Returns a String that resembles a receipt. See below.
    */
    
}
