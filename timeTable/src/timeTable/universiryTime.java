package timeTable;

public class universiryTime {
    private String name, week;
    private int time, credit;

    universiryTime(String name, String week, int time, int credit){
        this.name = name;
        this.week = week;
        this.time = time;
        this.credit = credit;
    }

    public String getName(){
        return name;
    }

    public int getTime(){
        return time;
    }

    public int getCredit(){
        return credit;
    }

    public String getWeek(){
        return week;
    }
    
}
