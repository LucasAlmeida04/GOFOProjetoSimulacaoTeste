import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;

import System.Player;

public class TestesPlayer {

    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player();
    }

    @Test
    public void testeSetGetBalance() {
        player.setBalance(100);
        assertEquals(100, player.getBalance());
    }

    @Test
    public void testeCancelBooking() {
        ArrayList<ArrayList<String>> bookedSlots = new ArrayList<>();
        bookedSlots.add(new ArrayList<>());
        bookedSlots.get(0).add("teste1");
        bookedSlots.get(0).add("teste2");

        player.Bookedslots = bookedSlots;
        player.CancelBooking("teste1", "teste2");

        Assertions.assertEquals(0, player.Bookedslots.size());
    }

    @Test
    public void testCreateTeam() {
        player = new Player();
        Player time = new Player();
        player.createTeam(time);

        assertEquals(1, player.team.size());
        assertEquals(time, player.team.get(0));
    }

    @Test
    public void testEditPlayerInfo() {
        String input = "4\ntesteAlt@testeAlt.com";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        player = new Player();
        player.setEmail("teste@teste.com");

        player.editPlayerinfo();

        assertEquals("testeAlt@testeAlt.com", player.getEmail());

    }

    @Test
    public void testGetMoney() {
        player = new Player();
        player.getMoney(200);
        assertEquals(200, player.eWallet.getBalance());
    }

}