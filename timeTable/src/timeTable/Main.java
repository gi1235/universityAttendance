package timeTable;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<universiryTime> addTime = new ArrayList<>();
    static ArrayList<String> dayoff = new ArrayList<>();
    static String[][] timeTable = new String[5][9];

    public static void main(String[] args){
        String myTimeTable = "0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0";
        gui gui = new gui();
        // 요일을 행 시간을 열로 배치
        dayoff.add("월");
        addTime.add(new universiryTime("math","월" , 3, 3));
        addTime.add(new universiryTime("korean","화", 8, 2));
        addTime.add(new universiryTime("english","수", 3, 2));
        addTime.add(new universiryTime("math","화", 4, 3));
        StringTokenizer tk = new StringTokenizer(myTimeTable, ", ");

        for(int i=0 ; i <timeTable.length ; i++){
            for(int j=0 ; j <timeTable[0].length; j++){
                timeTable[i][j] = tk.nextToken();
            }
        }
        

        for(int i = 0 ; i < addTime.size() ; i++){
            // 예외처리 : 해당교과목이 중복인지, 해당 시간이 빈 시간인지 공강일 검사
            if(timeTable[0][addTime.get(i).getTime()].equals("0") && dayoff.contains(addTime.get(i).getWeek()) && !checkName(timeTable, addTime.get(i).getName())){
                continue;
            }
            switch (addTime.get(i).getWeek()) {
                case "월":
                    for(int j = addTime.get(i).getTime() - 1 ; j < (addTime.get(i).getTime()-1) + addTime.get(i).getCredit() ; j++ ){
                        timeTable[0][j] = addTime.get(i).getName();
                    }
                    break;

                case "화": 
                    for(int j = addTime.get(i).getTime() - 1 ; j < (addTime.get(i).getTime()-1) + addTime.get(i).getCredit() ; j++ ){
                        timeTable[1][j] = addTime.get(i).getName();
                    }
                    break;
                
                case "수":
                    for(int j = addTime.get(i).getTime() - 1 ; j < (addTime.get(i).getTime()-1) + addTime.get(i).getCredit() ; j++ ){
                        timeTable[2][j] = addTime.get(i).getName();
                    }
                    break;
                
                case "목":
                    for(int j = addTime.get(i).getTime() - 1 ; j < (addTime.get(i).getTime()-1) + addTime.get(i).getCredit() ; j++ ){
                        timeTable[3][j] = addTime.get(i).getName();
                    }
                    break;
                
                case "금":
                    for(int j = addTime.get(i).getTime() - 1 ; j < (addTime.get(i).getTime()-1) + addTime.get(i).getCredit() ; j++ ){
                        timeTable[4][j] = addTime.get(i).getName();
                    }
                    break;
                    
                default:
                    break;
            }
            
            
        }

        for(int i=0 ; i <timeTable.length ; i++){
            for(int j=0 ; j <timeTable[0].length; j++){
                System.out.print(timeTable[i][j]+" ");
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
