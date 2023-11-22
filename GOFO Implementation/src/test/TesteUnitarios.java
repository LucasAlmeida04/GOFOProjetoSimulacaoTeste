import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import System.Player;

public class TesteUnitarios {

    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player();
    }

    @Test
    public void testSetAndGetBalance() {
        player.setBalance(100);
        assertEquals(200, player.getBalance());
    }
}
