package models;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class Contact {
        private String name;
        private String dob;
        private String phone;
        private int age;

        public Contact(String name,  String phone, String dob)throws ParseException{ 
            this.name = name;
            this.dob = dob;
            this.phone = phone;

            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            formatter.setLenient(false);
            long diff = new Date().getTime() - formatter.parse(dob).getTime();
            this.age = (int) (TimeUnit.MILLISECONDS.toDays(diff));
        }


  
  

}
