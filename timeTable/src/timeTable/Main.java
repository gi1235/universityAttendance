package timeTable;

import java.util.ArrayList;
import java.util.StringTokenizer;


/**
 * 프로그램의 기본 실행 클래스 입니다.
 * 
 * @author Lim Jonggu
 * @version 1.5
 * @since 1.0
 * 
 * @created 2024-12-22
 * @lastModified 2024-12-23
 * 
 * @changelog
 * 
 * <ul>
 *   <li>2024-12-22: 최초 생성 (Lim Jonggu)</li>
 *   <li>2024-12-22: 기본 틀 제작 (Lim Jonggu)</li>
 *   <li>2024-12-22: timeTable 배열 가독성 향상 (Lim Jonggu)</li>
 *   <li>2024-12-23: timeTable 변경 알고리즘 추가 (Lim Jonggu)</li>
 *   <li>2024-12-23: timeTable 예외 처리 부분 추가 (Lim Jonggu)</li>
 * </ul>
 */

public class Main {
    static ArrayList<universityTime> addTime = new ArrayList<>();
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
            universityTime nowAdd = addTime.get(i);
            int week = "월화수목금".indexOf(nowAdd.getWeek());
            // 예외처리 : 해당교과목이 중복인지, 해당 시간이 빈 시간인지 공강일 검사
            if(!timeTable[week][nowAdd.getTime()-1].equals("0") || dayoff.contains(nowAdd.getWeek()) || checkName(timeTable, nowAdd.getName())){
                continue;
            }
            for(int j = nowAdd.getTime() - 1 ; j < (nowAdd.getTime()-1) + nowAdd.getCredit() ; j++ ){
                timeTable[week][j] = nowAdd.getName();
            }
        }
    }

}
