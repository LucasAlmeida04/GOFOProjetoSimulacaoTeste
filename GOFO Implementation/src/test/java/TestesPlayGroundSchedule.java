import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import System.PlayGroundSchedule;

public class TestesPlayGroundSchedule {

    private PlayGroundSchedule schedule;

    @BeforeEach
    public void setUp() {
        schedule = new PlayGroundSchedule();
    }

    @Test
    public void testeSetSchedule() {
        String input = "5\n7";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        schedule = new PlayGroundSchedule();
        schedule.setschedule();
        schedule.displayAllSlots();
        assertEquals(5, schedule.getBegin());
        assertEquals(7, schedule.getEnd());
    }

    @Test
    public void testeSetPrice() {
        String input = "5";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        schedule = new PlayGroundSchedule();
        schedule.setPrice();
        assertEquals(5, schedule.getTimeSlotPerHour());
    }

    @Test
    public void testeDisplayFreeSlots() {
        schedule = new PlayGroundSchedule();
        schedule.displayFreeSlots();
        assertEquals(1, schedule.getDayIndex("sunday"));
        assertEquals(2, schedule.getDayIndex("monday"));

    }

    @Test
    public void testeGetDayIndex() {
        assertEquals(1, schedule.getDayIndex("sunday"));
        assertEquals(2, schedule.getDayIndex("monday"));
        assertEquals(3, schedule.getDayIndex("tuesday"));
        assertEquals(4, schedule.getDayIndex("wendesday"));
        assertEquals(5, schedule.getDayIndex("thursday"));
        assertEquals(6, schedule.getDayIndex("friday"));
        assertEquals(7, schedule.getDayIndex("saturday"));
        assertEquals(-1, schedule.getDayIndex("invalid day"));
    }

}