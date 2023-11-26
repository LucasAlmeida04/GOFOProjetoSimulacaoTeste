import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import System.Administrator;
import System.Playground;

public class TestesAdministrator {

    private Administrator admin;

    @BeforeEach
    public void setUp() {
        admin = new Administrator();
    }

    @Test
    public void testApprovePlayground() {
        String input = "yes";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        admin = new Administrator();
        Playground playground = new Playground();
        playground.setName("teste");
        admin.Requested.add(playground);

        admin.approvePlayground();

        assertEquals(1, admin.Approved.size());
        assertEquals(playground, admin.Approved.get(0));
    }

    @Test
    public void testSearchByName() {
        admin = new Administrator();
        Playground playground = new Playground();
        playground.setName("teste");
        admin.Approved.add(playground);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        admin.searchByName("teste");

        String consoleOutput = outputStream.toString();
        System.setOut(System.out);

        assertNotEquals("No Playground Have the same Name Please Try agian.\n", consoleOutput);
    }

    @Test
    public void testSuspendPlayground() {
        admin = new Administrator();
        Playground playground = new Playground();
        playground.setName("teste");
        admin.Approved.add(playground);

        admin.suspendPlayground("teste");

        assertEquals(0, admin.Approved.size());
        assertEquals(1, admin.suspended.size());
    }

    @Test
    public void testDeletePlayground() {
        admin = new Administrator();
        Playground playground = new Playground();
        playground.setName("teste");
        admin.Approved.add(playground);

        admin.deletePlayground("teste");

        assertEquals(0, admin.Approved.size());
    }

    @Test
    public void testPlaygroundRequests() {
        admin = new Administrator();
        Playground playground = new Playground();
        playground.setName("teste");
        admin.playgroundRequests(playground);

        assertEquals(1, admin.Requested.size());
        assertEquals(playground, admin.Requested.get(0));
    }

    @Test
    public void testUnSuspendPlayground() {
        String input = "yes";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        admin = new Administrator();
        Playground playground = new Playground();
        playground.setName("teste");
        admin.suspended.add(playground);

        admin.unSuspendPlayground();

        assertEquals(0, admin.suspended.size());
        assertEquals(1, admin.Approved.size());
    }

}