import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import System.eWallet;

public class TesteEWallet {

    private eWallet wallet;

    @BeforeEach
    public void setUp() {
        wallet = new eWallet();
    }

    @Test
    public void testeSetBalanceWithStringInput() {
        String input = "100";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        wallet = new eWallet();
        wallet.setBalance();

        assertEquals(100, wallet.getBalance());
    }

    @Test
    public void testeSetBalanceWithIntInput() {
        wallet.setBalance(200);

        assertEquals(200, wallet.getBalance());
    }

    @Test
    public void testeDeposit() {
        wallet.setBalance(100);

        wallet.deposit(50);

        assertEquals(150, wallet.getBalance());
    }

    @Test
    public void testeWithdraw() {
        wallet.setBalance(100);

        wallet.withdraw(30);

        assertEquals(70, wallet.getBalance());
    }

    @Test
    public void testeGetBalance() {
        wallet.setBalance(300);

        assertEquals(300, wallet.getBalance());
    }
}