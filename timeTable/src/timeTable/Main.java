package timeTable;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){
        String myTimeTable = "0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0";

        // 요일을 행 시간을 열로 배치
        String[][] timeTable = new String[5][9];

        ArrayList<universiryTime> addTime = new ArrayList<>();
        addTime.add(new universiryTime("math", 3, 3));
        addTime.add(new universiryTime("korean", 8, 2));
        addTime.add(new universiryTime("english", 3, 2));
        addTime.add(new universiryTime("math", 4, 3));
        StringTokenizer tk = new StringTokenizer(myTimeTable, ", ");

        for(int i=0 ; i <timeTable.length ; i++){
            for(int j=0 ; j <timeTable[0].length; j++){
                timeTable[i][j] = tk.nextToken();
            }
        }
        
        for(int i = 0 ; i < addTime.size() ; i++){
            if(timeTable[2][addTime.get(i).getTime()].equals("0") && !checkName(timeTable, addTime.get(i).getName()) ){
                timeTable[2][addTime.get(i).getTime()] = addTime.get(i).getName();
            }
        }

        for(int i=0 ; i <timeTable.length ; i++){
            for(int j=0 ; j <timeTable[0].length; j++){
                System.out.print(timeTable[i][j]);
            }
            System.out.println();
        }

    }

    public static boolean checkName(String[][] timeTable, String name){
        for(int i =0 ; i < timeTable.length; i++){
            for (String str : timeTable[i]){
                if(str.equals(name)){
                    return true;
                }
            }
        }
        
        return false;
    }
}
