package timeTable;

public class universiryTime {
    private String name;
    private int time, credit;

    universiryTime(String name, int time, int credit){
        this.name = name;
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
    
}
