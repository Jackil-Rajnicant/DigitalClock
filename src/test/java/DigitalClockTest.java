import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class DigitalClockTest {

    DigitalClock digitalClock = new DigitalClock();

    @Test
    public void testSecond(){
        assertThat(digitalClock.getBerlinSecondsToNormalSeconds("Y"), equalTo(0));
    }


    @Test
    public void testFiveHourRow(){
        assertThat(digitalClock.getBerlinFiveHourRowToNormalHour("RRRR"), equalTo(20));

    }

    @Test
    public void testSingleHourRow(){
        assertThat(digitalClock.getBerlinSingleHourRowToNormalHour("RROO"),equalTo(2));

    }

    @Test
    public void testFiveMinuteRow(){
        assertThat(digitalClock.getBerlinFiveMinuteRowToNormalMinute("YYRYYRYOOOO"),equalTo(35));

    }

    @Test
    public void testBerlinClockToDigitalClock(){
        assertThat(digitalClock.getBerlinTimeToDigitalTime("YOOOOOOOOOOOOOOOOOOOOOOO"),equalTo("00:00:00"));
        assertThat(digitalClock.getBerlinTimeToDigitalTime("ORRRRRRROYYRYYRYYRYYYYYY"),equalTo("23:59:01"));
        assertThat(digitalClock.getBerlinTimeToDigitalTime("YRRROROOOYYRYYRYYRYOOOOO"),equalTo("16:50:00"));
        assertThat(digitalClock.getBerlinTimeToDigitalTime("ORROOROOOYYRYYRYOOOOYYOO"),equalTo("11:37:01"));

    }

    @Test
    public void testSingleMinuteRow(){
        assertThat( digitalClock.getBerlinSingleMinuteRowToNormalMinute("YYYO"),equalTo(3));

    }
}
