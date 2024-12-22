package timeTable;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){
        String myTimeTable = "0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0";
        String[] timeTable = new String[45];
        ArrayList<universiryTime> addTime = new ArrayList<>();
        addTime.add(new universiryTime("math", 3, 3));
        addTime.add(new universiryTime("korean", 8, 2));
        addTime.add(new universiryTime("english", 3, 2));
        addTime.add(new universiryTime("math", 4, 3));
        StringTokenizer tk = new StringTokenizer(myTimeTable, ", ");
        int i = 0;
        while (tk.hasMoreTokens()) {
            timeTable[i] = tk.nextToken();
            i++;
        }
        
        for(i = 0 ; i < addTime.size() ; i++){
            if(timeTable[addTime.get(i).getTime()].equals("0") && ! checkTime(timeTable, addTime.get(i).getName())){
                timeTable[addTime.get(i).getTime()] = addTime.get(i).getName();
            }
        }
        for(i = 0; i <timeTable.length; i++){
            if(i % 5 == 0){
                System.out.println();
            }
            System.out.print(timeTable[i]);
        }

    }
    public static boolean checkTime(String[] timeTable, String name){
        for (String str : timeTable){
            if(str.equals(name)){
                return true;
            }
        }
        return false;
    }
}
