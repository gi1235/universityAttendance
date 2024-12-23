package timeTable;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<universiryTime> addTime = new ArrayList<>();
    static ArrayList<String> dayoff = new ArrayList<>();
    static String[][] timeTable = new String[5][9];

    public static void main(String[] args){
        String myTimeTable = "0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0";
        StringTokenizer tk = new StringTokenizer(myTimeTable, ", ");

        for(int i=0 ; i <timeTable.length ; i++){
            for(int j=0 ; j <timeTable[0].length; j++){
                timeTable[i][j] = tk.nextToken();
            }
        }

        for(int i=0 ; i <timeTable.length ; i++){
            for(int j=0 ; j <timeTable[0].length; j++){
                System.out.print(timeTable[i][j]+" ");
            }
            System.out.println();
        }
        gui gui = new gui();
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

    public static void changeTimeTable(){
        for(int i = 0 ; i < addTime.size() ; i++){
            universiryTime nowAdd = addTime.get(i);
            // 예외처리 : 해당교과목이 중복인지, 해당 시간이 빈 시간인지 공강일 검사
            if(timeTable[0][nowAdd.getTime()].equals("0") && dayoff.contains(nowAdd.getWeek()) && !checkName(timeTable, nowAdd.getName())){
                continue;
            }
            int week = "월화수목금".indexOf(nowAdd.getWeek());
            for(int j = nowAdd.getTime() - 1 ; j < (nowAdd.getTime()-1) + nowAdd.getCredit() ; j++ ){
                timeTable[week][j] = nowAdd.getName();
            }
         }
         for(int i=0 ; i <timeTable.length ; i++){
            for(int j=0 ; j <timeTable[0].length; j++){
                System.out.print(timeTable[i][j]+" ");
            }
            System.out.println();
        }
    }

}
