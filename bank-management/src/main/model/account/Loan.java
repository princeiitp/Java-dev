package src.main.model.account;

public class Loan extends Account{

    private static final double MAX_DEBT = 10000;

    public Loan(String id, String name, double balance){
       super(id,name,balance);
    }

    public Loan(Loan source){
        super(source);
    }

    @Override
    public Account clone() {
        // TODO Auto-generated method stub
        return new Loan(this);
    }

    @Override
    public void deposit(double amount) {
       super.setBalance(super.round(super.getBalance() - amount));
    }

    @Override
    public boolean withdraw(double amount) {
        if(amount + super.getBalance() > MAX_DEBT){
            return false;
        }
        super.setBalance(super.round(super.getBalance() + (amount * (1 + 0.02)) ));
        return true;
    }

}
 