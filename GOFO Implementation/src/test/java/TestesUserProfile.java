import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import System.eWallet;
import System.userProfile;

public class TestesUserProfile {

    private userProfile user;

    @BeforeEach
    public void setUp() {
        user = new userProfile();
    }

    @Test
    public void testGetFullName() {
        user.setFName("Teste");
        user.setLName("Teste");
        assertEquals("Teste Teste", user.getFullName());
    }

    @Test
    public void testGetID() {
        user.setID(123);
        assertEquals(123, user.getID());
    }

    @Test
    public void testGetEmail() {
        user.setEmail("teste@teste.com");
        assertEquals("teste@teste.com", user.getEmail());
    }

    @Test
    public void testGetPhone() {
        user.setPhone(999999999);
        assertEquals(999999999, user.getPhone());
    }

    @Test
    public void testGetRule() {
        user.setRule("teste");
        assertEquals("teste", user.getRule());
    }

    @Test
    public void testSetPayment() {
        eWallet wallet = new eWallet();
        user.setPayment(wallet);
        assertEquals(wallet, user.service);
    }
}