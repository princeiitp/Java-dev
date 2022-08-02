package src.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import src.main.model.account.Account;
import src.main.model.account.Personal;
import src.main.model.account.TFSA;
import src.main.model.account.Account.Stock;

public class SellTests {
    
    Account[] accounts;

    @Before
    public void setup() {
        accounts = new Account[] {new Personal(2000), new TFSA(2000) };
        accounts[0].buyShares("AAPL", 100, 15.0);
        accounts[1].buyShares("FB", 150, 10.0);
    }

    @Test
    public void sellSharesPersonal() {
        accounts[0].sellShares("AAPL", 50, 20);
        assertEquals(50, accounts[0].getShares(Stock.AAPL));
    }

    @Test
    public void sellSharesTFSA() {
        accounts[1].sellShares("FB", 110, 11);
        assertEquals(40, accounts[1].getShares(Stock.FB));
    }

    @Test
    public void insufficientShares() {
        accounts[0].sellShares("AAPL", 101, 16);
        assertEquals(500, accounts[0].getBalance());
    }

    @Test
    public void balancePersonal() {
        accounts[0].sellShares("AAPL", 20, 16.0);
        assertEquals(500 + (16 * 20) * (1 - Personal.SELL_FEE), accounts[0].getBalance());
    }

    @Test
    public void balanceTFSA() {
        accounts[1].sellShares("FB", 100, 11.0);
        assertEquals(485 + (100 * 11) * (1 - TFSA.SELL_FEE), accounts[1].getBalance());
    }
}
  