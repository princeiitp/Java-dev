package src.main.model.account;
import java.util.HashMap;
import java.util.Objects;

import org.hamcrest.core.IsInstanceOf;

import src.main.utils.Color;


public abstract class Account {
    public enum Stock { AAPL, FB, GOOG, TSLA}

    private HashMap<Stock, Integer> portfolio;
    private double balance;

    public Account(double balance){
        portfolio = new HashMap<Stock, Integer>();
        this.balance = balance;
        portfolio.put(Stock.AAPL, 0);
        portfolio.put(Stock.FB, 0);
        portfolio.put(Stock.GOOG, 0);
        portfolio.put(Stock.TSLA, 0);
    }


    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Integer getShares(Stock stock) {
        return this.portfolio.get(stock);
    }

    public void setShares(Stock stock, Integer shares) {
        this.portfolio.put(stock, shares);
    }

    public void addShares(String stockName, int shares) {
        Stock stock = Stock.valueOf(stockName);
        this.setShares(stock, getShares(stock) + shares);
    }

    public void removeShares(String stockName, int shares){
        Stock stock = Stock.valueOf(stockName);
        this.setShares(stock, getShares(stock) - shares);
    }

    public abstract String buyShares(String stockName,int shares, double stockPrice);
    public abstract String sellShares(String stockName,int shares, double stockPrice);


    public String buy(String stockName,int shares, double stockPrice, double buyCharge){
        double neededAmount = (shares * stockPrice) * (1 + buyCharge);
        if(getBalance() < neededAmount ){
            return "unsuccessful";
        }
        this.setBalance(this.getBalance() - neededAmount);
        addShares(stockName, shares);
        return "successful";
    }

    public String sell(String stockName,int shares, double stockPrice, double sellCharge){
        int presentShares = getShares(Stock.valueOf(stockName));
        double sellAmount = (shares * stockPrice) * (1 - sellCharge);
        if(presentShares < shares ){
            return "unsuccessful";
        }
        this.setBalance(this.getBalance() + sellAmount);
        removeShares(stockName, shares);
        return "successful";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof Account)) return false;
        Account account = (Account) obj;
        return this.portfolio.equals(account.portfolio) && this.balance == account.balance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(portfolio, balance);
    }

    @Override
    
        public String toString() {
        
            return "\nStock" + "\t\t" + "Shares"+"\n\n"+
                Color.BLUE+Stock.AAPL + "\t\t" + Color.GREEN+portfolio.get(Stock.AAPL)+"\n"+
                Color.BLUE+Stock.GOOG + "\t\t" + Color.GREEN+portfolio.get(Stock.GOOG)+"\n"+
                Color.BLUE+Stock.TSLA+ "\t\t" + Color.GREEN+portfolio.get(Stock.TSLA)+"\n"+
                Color.BLUE+Stock.FB + "\t\t"+Color.GREEN+portfolio.get(Stock.FB)+"\n\n"+Color.RESET+
                "Funds Left" + "\t\t" + Color.GREEN + "$"+getBalance()+Color.RESET;
        }




    


    
}
