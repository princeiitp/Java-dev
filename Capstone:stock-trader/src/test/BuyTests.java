package src.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import src.main.model.account.Account;
import src.main.model.account.Personal;
import src.main.model.account.TFSA;
import src.main.model.account.Account.Stock;

public class BuyTests {
    
    Account[] accounts;

    @Before
    public void setup(){

        accounts = new Account[] {
            new Personal(1000), new TFSA(1000)
        };
    }

    @Test
    public void purchaseShares(){
        accounts[0].buyShares("AAPL",12,23.64);
        assertEquals(12, accounts[0].getShares(Stock.AAPL));
    }

    @Test
    public void tfsaShares() {
        accounts[1].buyShares("FB", 10, 18.50);
        assertEquals(10, accounts[1].getShares(Stock.FB));
    }

    @Test
    public void insufficientFund() {
        accounts[1].buyShares("GOOG", 1000, 20);
        assertEquals(0, accounts[1].getShares(Stock.GOOG));
    }

    @Test
    public void balancAvailabePersonal() {
        accounts[0].buyShares("TSLA", 8 , 25);
        assertEquals(800, accounts[0].getBalance());
    }

    @Test
    public void balanceAvailableTFSA() {
        accounts[1].buyShares("FB", 9, 50);
        assertEquals(1000 - ((9 * 50) * (1 + TFSA.BUY_FEE)), accounts[1].getBalance());
    }

}
  