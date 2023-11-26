import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;

import System.Playground;
import System.PlaygroundOwner;
import System.eWallet;

public class TestesPlaygroundOwner {

    private PlaygroundOwner owner;

    @BeforeEach
    public void setUp() {
        owner = new PlaygroundOwner();
    }

    @Test
    public void testeAddPlayground() {
        Playground playground = new Playground();
        playground.setName("teste");
        
        owner.addPlayground(playground);
        assertTrue(owner.existPlayground("teste"));
    }

    @Test
    public void testeUpdatePlaygroundName() {
        String input = "1\ntesteAtt";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Playground playground = new Playground();
        playground.setName("teste");

        owner = new PlaygroundOwner();
        owner.addPlayground(playground);
        owner.updatePlaygroundName("teste");
        assertEquals("testeAtt", owner.listOfPlayground.get(0).getName());
    }

    @Test
    public void testePayMoney() {
        String inputPreco = "30";
        InputStream inputStream = new ByteArrayInputStream(inputPreco.getBytes());
        System.setIn(inputStream);
        Playground playground = new Playground();
        playground.setPrice();
        playground.setName("teste");

        owner = new PlaygroundOwner();
        eWallet wallet = new eWallet();
        wallet.setBalance(100);
        owner.addPlayground(playground);
        owner.setBalance(wallet);

        assertEquals(90, owner.payMoney("teste", 3));
        assertEquals(10, owner.getMyBalance());
    }

    @Test
    public void testeExistPlayground() {
        Playground playground = new Playground();
        playground.setName("teste");
        owner.addPlayground(playground);

        assertTrue(owner.existPlayground("teste"));
        assertFalse(owner.existPlayground("teste falso"));
    }
}