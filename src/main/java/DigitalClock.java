import java.text.DecimalFormat;
import java.text.NumberFormat;

public class DigitalClock {
    private int seconds = 0;
    private int hours = 0;
    private int minutes = 0;
    private int everyFive = 5;
    private int single = 1;

    public DigitalClock(){
        
    }

    public int getBerlinSecondsToNormalSeconds(String seconds) {
        if(seconds.equals("O")) return 1;
        else return 0;
    }

    public int getBerlinFiveHourRowToNormalHour(String fiveHourRow) {
        return getLightOnCount(fiveHourRow,everyFive );
    }

    public int getBerlinSingleHourRowToNormalHour(String singleHourRow) {
        return getLightOnCount(singleHourRow, single);

    }

    public int getBerlinFiveMinuteRowToNormalMinute(String fiveMinuteRow) {
        return getLightOnCount(fiveMinuteRow, everyFive);
    }

    public int getBerlinSingleMinuteRowToNormalMinute(String singleMinuteRow) {
        return getLightOnCount(singleMinuteRow, single) ;
    }

    private int getLightOnCount(String row, int divisible){
        int count=0;
        for(int i=0; i < row.length();i++){
            if(row.charAt(i) != 'O') count++;
        }
        return (count * divisible);
    }

    public String getBerlinTimeToDigitalTime(String time) {
        seconds = getBerlinSecondsToNormalSeconds(time.substring(0,1));
        hours = getBerlinFiveHourRowToNormalHour(time.substring(1,5)) + getBerlinSingleHourRowToNormalHour(time.substring(5,9));
        minutes = getBerlinFiveMinuteRowToNormalMinute(time.substring(9,20)) + getBerlinSingleMinuteRowToNormalMinute(time.substring(20,24));
        NumberFormat formatter = new DecimalFormat("00");
        return formatter.format(hours)+":"+formatter.format(minutes)+":"+formatter.format(seconds);
    }
}
