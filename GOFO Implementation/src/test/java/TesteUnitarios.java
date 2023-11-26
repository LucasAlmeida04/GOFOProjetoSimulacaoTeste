import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;

import System.Player;
import System.Playground;

public class TesteUnitarios {

    private Player player;
    private Playground playground;

    @BeforeEach
    public void setUp() {
        player = new Player();
        playground = new Playground();
    }

    @Test
    public void testSetAndGetBalance() {
        player.setBalance(100);
        assertEquals(100, player.getBalance());
    }

    @Test
    public void testCancelBooking() {
        ArrayList<ArrayList<String>> bookedSlots = new ArrayList<>();
        bookedSlots.add(new ArrayList<>());
        bookedSlots.get(0).add("teste1");
        bookedSlots.get(0).add("teste2");

        player.Bookedslots = bookedSlots;
        player.CancelBooking("teste1", "teste2");

        Assertions.assertEquals(0, player.Bookedslots.size());
    }

    @Test
    public void testSetAndGetCancellationPeriod() {
        playground.setCancellationPeriod(24);
        Assertions.assertEquals(24, playground.getCancellationPeriod());
    }

    @Test
    public void testSetAndGetOwner() {
        playground.setOwner("teste teste");
        Assertions.assertEquals("teste teste", playground.getOwner());
    }

    @Test
    public void testSetName() {
        playground.setName("teste1");
        Assertions.assertEquals("teste1", playground.getName());
    }
}