package src.main.model.account;

import src.main.model.account.impl.Taxable;

public class Chequing extends Account implements Taxable{ 

    private static final double OVERDRAFT_FEE = 5.50;
    private static final double OVERDRAFT_LIMIT = 200;
    private static final double TAXABLE_INCOME = 3000;
    public Chequing(String id, String name, double balance){
       super(id,name,balance);
    }

    public Chequing(Chequing source){
        super(source);
    }

    @Override
    public Account clone() {
        // TODO Auto-generated method stub
        return new Chequing(this);
    }

    @Override
    public void deposit(double amount) {
        super.setBalance(super.round(super.getBalance() + amount));
    }

    @Override
    public boolean withdraw(double amount) {
        if(amount - super.getBalance() > OVERDRAFT_LIMIT){
            return true;
        }else if(super.getBalance() < amount){
            super.setBalance(super.round(super.getBalance() - amount - OVERDRAFT_FEE));
        }else{
            super.setBalance(super.round(super.getBalance() - amount));
        }
        return true;
        //eturn false;
    }

    @Override
    public void tax(double income) {
       double tax = Math.max(0, income - TAXABLE_INCOME) * 0.15;
       super.setBalance(super.round(super.getBalance() - tax));
    }


}
 