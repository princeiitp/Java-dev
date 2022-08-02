package src.main.model.account;

import java.util.HashMap;   

public class Personal extends Account{
    
    public static final double BUY_FEE = 0;
    public static final double SELL_FEE = 0.05;
    public Personal(double balance ) {
        super(balance);
    }


    @Override
    public String buyShares(String stockName,int share, double stockPrice){
        return super.buy(stockName, share, stockPrice, BUY_FEE);
    }

    @Override
    public String sellShares(String stockName, int share, double stockPrice) {
        return super.sell(stockName, share, stockPrice, SELL_FEE);
    }

}
