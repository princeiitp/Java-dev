import java.util.Scanner;

import models.Car;
import models.Dealership;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        
        Car[] cars = new Car[] {
            new Car("nisaan", 5000),
            new Car("Honda", 12000),
        };
        cars[1].setMake("Hyundai");
        cars[1].setPrice(12000);

        Dealership dealership = new Dealership(cars);

        System.out.println("\n************* JAVA DEALERSHIP *************");
        while (true) {
            System.out.println(dealership);
            if(dealership.isEmpty()){
                System.out.println("We are all sold out!");
                break;
            }
            System.out.print("Enter the spot number of the car you want to buy: "); 
            if(!scan.hasNextInt()){
                String someval = scan.nextLine();
                System.out.println("INVALID INPUT.");
                continue;
            }
            int spot = scan.nextInt();
            scan.nextLine(); 
            if(spot < 0 || spot >= dealership.getLength()){
                System.out.println("Please choose a valid parking spot.");
                continue;
            }else if(dealership.getCar(spot) == null){
                System.out.println("Spot " + spot + " is empty.");
                continue;
            }
            dealership.sell(spot); 
            System.out.println("Type 'yes' to continue shopping: ");
            if(!scan.nextLine().equals("yes")){
              break;
            }       
        }
       scan.close();
    }
}
