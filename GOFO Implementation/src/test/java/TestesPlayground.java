import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Assertions;

import System.Playground;

public class TestesPlayground {

    private Playground playground;

    @BeforeEach
    public void setUp() {
        playground = new Playground();
    }

    @Test
    public void testeSetGetCancellationPeriod() {
        playground.setCancellationPeriod(24);
        Assertions.assertEquals(24, playground.getCancellationPeriod());
    }

    @Test
    public void testeSetGetOwner() {
        playground.setOwner("teste teste");
        Assertions.assertEquals("teste teste", playground.getOwner());
    }

    @Test
    public void testeSetName() {
        playground.setName("teste1");
        Assertions.assertEquals("teste1", playground.getName());
    }

    @Test
    public void testeSetAndGetLocation() {
        String input = "teste";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());

        System.setIn(inputStream);

        playground = new Playground();
        playground.setLocation();
        assertEquals("teste", playground.getLocation());
    }

    @Test
    public void testeSetAndGetPrice(){
        String input = "30";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        playground = new Playground();
        playground.setPrice();
        assertEquals(30, playground.getPrice());
    }
}