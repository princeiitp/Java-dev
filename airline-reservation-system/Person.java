
import java.util.Arrays;
import java.util.Random;

public class Person {
    private String name;
    private String nationality;
    private String dob;
   
    String[] passport;
    private int seatNum;


  public Person(String name, String nationality, String dob, int seatNum)
  {
    this.name=name;
    this.nationality=nationality;
    this.dob=dob;
    this.seatNum=seatNum;
    this.passport= new String[3];
  }

  public Person(Person source){
     this.name=source.name;
     this.nationality=source.nationality;
     this.dob=source.dob;
     this.seatNum=source.seatNum;
     this.passport=Arrays.copyOf(source.passport, source.passport.length);
  }
  

  
   public String getName(){
      return this.name;
   }
   public String getNationality(){
      return this.nationality;
   }

   public String getDob(){
    return this.dob;
   }

   public int getSeatNum(){
    return this.seatNum;
   }

   public void setName(String name){
      this.name=name;
   }
   public void setNationality(String nationality){
      this.nationality=nationality;
   }
   public void setDob(String dob){
        this.dob=dob;
   }
   public void setSeatNum(int seatNum){
      this.seatNum=seatNum;
   }

   public String[] getPassport(){
      // String[] temp1 =Arrays.copyOf(this.passport, this.passport.length); //check how to make copy new arrays of string.
       return Arrays.copyOf(this.passport,this.passport.length);
    }

    public void setPassport(){
      this.passport=new String[]{this.name, this.nationality, this.dob};
    }

    public boolean applyPassport(){
      Random random= new Random();
      return random.nextBoolean();
   }

   public void chooseSeat(){
     this.seatNum = (int) (Math.random()*11 +1);
   }

   public String toString(){
      return "Name: " + this.name + "\n"
      +" Nationality: " + this.nationality + "\n"
      +"Date of Birth: "+ this.dob+ "\n"
      + "Seat Number: " + this.seatNum + "\n"
      + "Passport: " + Arrays.toString(this.passport)+ "\n";
   }


}
