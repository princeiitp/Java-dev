package src.main.models;

import java.util.Arrays;
import java.util.Objects;

import javax.lang.model.element.Element;

public class Team {
 
    private String keeper;
    private String house;
    private String seeker;
    private String[] chasers;
    private static final String POSITION_CHASER = "chaser";
    private static final String POSITION_SEEKER = "seeker";
    private static final String POSITION_KEEPER = "keeper";

/* FREQUENTLY ASKED QUESTIONS:
    
Question: the constants are final, so why can't we make them public? It's not possible for the caller to update them.
  Answer: Even if the constant is final, I prefer to expose a method instead of the variable. But if you want to expose the variable, that's also correct.

*/

    public Team(String house, String keeper, String seeker, String[] chasers){
        if(house == null || keeper == null || seeker == null){
            throw new IllegalArgumentException("Fields values cannot be null");
        }

        if(house.isBlank() || keeper.isBlank() || seeker.isBlank()){
            throw new IllegalArgumentException("Fields values cannot be blank");
        }

        if(chasers.length != 3){
            throw new IllegalArgumentException("must have 3 chasers");
        }

        if(hasNull(chasers) || hasBlank(chasers)){
            throw new IllegalArgumentException("Illegal elements!");
        }
        this.seeker = seeker;
        this.house = house;
        this.keeper = keeper;
        this.chasers =Arrays.copyOf(chasers, chasers.length);
    }

    public Team(Team source){
        this.seeker = source.seeker;
        this.house = source.house;
        this.keeper = source.keeper;
        this.chasers =Arrays.copyOf(source.chasers, source.chasers.length);
    }

    public String getHouse() {
        return house;
    }

    public String[] getChasers() {
        return Arrays.copyOf(chasers, chasers.length);
    }

    public String getKeeper() {
        return keeper;
    }
    public String getSeeker() {
        return seeker;
    }
     public static String getPositionChaser() {
         return POSITION_CHASER;
     }

     public static String getPositionSeeker() {
         return POSITION_SEEKER;
     }

     public static String getPositionKeeper() {
         return POSITION_KEEPER;
     }

     public void setHouse(String house) {
        checkField(house);
         this.house = house;
     }

     public void setChasers(String[] chasers) {
        if(chasers.length !=3 || hasNull(chasers) || hasBlank(chasers)){
            throw new IllegalArgumentException("Illegal chaser argument");
        }
         this.chasers =Arrays.copyOf(chasers, chasers.length);
     }

     public void setKeeper(String keeper) {
        checkField(keeper);
         this.keeper = keeper;
     }

     public void setSeeker(String seeker) {
        checkField(seeker);
         this.seeker = seeker;
     }

     public static boolean hasNull(String[] array){
        return Arrays.stream(array).anyMatch((element) -> element == null );
    }

    public static boolean hasBlank(String[] array){
        return Arrays.stream(array).anyMatch((element) -> element.isBlank());
    }

    public void checkField(String field){
        if(field == null || field.isBlank()){
            throw new IllegalArgumentException(field + "cannot be null/blank.");
        }
    }

     public String toString(){
        return "House: " + this.house + "\n" +
            "Keeper: " + this.keeper + "\n" +         
            "Seeker: "  + this.seeker + "\n" +         
            "Chasers: " + Arrays.toString(this.chasers) + "\n"; 
     }

     public boolean equals(Object obj){
        if(obj == null) return false;
        if(!(obj instanceof Team))return false;
        Team team = (Team)obj;
        return this.house.equals(team.house) && this.keeper.equals(team.keeper) 
        && this.seeker.equals(team.seeker) && 
        Arrays.toString(this.chasers).equals(Arrays.toString(team.chasers));
     }

     public int hashCode(){
        return Objects.hash(house, keeper, seeker, Arrays.toString(this.chasers));
     }

}
