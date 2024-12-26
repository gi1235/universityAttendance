package timeTable;

import java.util.ArrayList;
import java.util.StringTokenizer;


/**
 * 프로그램의 기본 실행 클래스 입니다.
 * 
 * @param addTime 추가할 수업의 정보를 담고있는 universityTime 클래스 타입의 arraylist
 * @param dayoff 공강요일을 저장할 String 타입의 arraylist
 * @param timeTable 현재 수업의 시간표를 담고있는 String 타입의 배열
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
 *   <li>2024-12-23: timeTable 초기화, 검사 알고리즘 추가 (Lim Jonggu)</li>
 * </ul>
 */

public class Main {
    static ArrayList<UniversityTime> addTime = new ArrayList<>();
    static ArrayList<String> dayoff = new ArrayList<>();
    static String[][] timeTable = new String[5][9];

    public static void main(String[] args){
        StringTokenizer tk = new StringTokenizer(TimeTableIO.loadF(), ", ");

        for(int i=0 ; i <timeTable.length ; i++){
            for(int j=0 ; j <timeTable[0].length; j++){
                timeTable[i][j] = tk.nextToken();
            }
        }
        Gui gui = new Gui();
    }
    
    /**
     * 현재 시간표 정보를 가져와 중복된 과목인지 확인합니다.
     * 
     * @return boolean 값으로 해당 과목이 지금 시간표에 있는지의 여부
     * 
     * @created 2024-12-23
     * @lastModified 2024-12-23
     * 
     * @changelog
     * <ul>
     *   <li>2024-12-23: 최초 생성 (Lim Jonggu)</li>
     * </ul>
     */
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
    /**
     * 추가할 수업을 현재 시간표에 저장합니다.
     * 
     * @param nowAdd universityTime 클래스의 형태로 현재 추가할 수업의 정보를 가지고 있음
     * 
     * 
     * @created 2024-12-23
     * @lastModified 2024-12-23
     * 
     * @changelog
     * <ul>
     *   <li>2024-12-23: 최초 생성 (Lim Jonggu)</li>
     * </ul>
     */
    public static void changeTimeTable(){
        for(int i = 0 ; i < addTime.size() ; i++){
            UniversityTime nowAdd = addTime.get(i);
            int week = "월화수목금".indexOf(nowAdd.getWeek());
            // 예외처리 : 해당교과목이 중복인지, 해당 시간이 빈 시간인지 공강일 검사
            if(!timeTable[week][nowAdd.getTime()-1].equals("0") || dayoff.contains(nowAdd.getWeek()) || checkName(timeTable, nowAdd.getName())){
                continue;
            }
            for(int j = nowAdd.getTime() - 1 ; j < (nowAdd.getTime()-1) + nowAdd.getCredit() ; j++ ){
                timeTable[week][j] = nowAdd.getName();
            }
        }
        TimeTableIO.saveF();
    }

    /**
     * 시간표 정보를 초기화 합니다.
     * 
     * @created 2024-12-26
     * @lastModified 2024-12-26
     * 
     * @changelog
     * <ul>
     *   <li>2024-12-26: 최초 생성 (Lim Jonggu)</li>
     * </ul>
     */
    public static void resetTimeTable(){
        for(int i=0 ; i <timeTable.length ; i++){
            for(int j=0 ; j <timeTable[0].length; j++){
                Main.timeTable[i][j] = "0"; 
            }
        }
    }

    /**
     * 현재 시간표에 저장된 총학점을 검사합니다.
     * 
     * @param cnt 학점을 저장
     * 
     * @return 현재 시간표의 총학점
     * 
     * @created 2024-12-26
     * @lastModified 2024-12-26
     * 
     * @changelog
     * <ul>
     *   <li>2024-12-26: 최초 생성 (Lim Jonggu)</li>
     * </ul>
     */
    public static int checkCradit(){
        int cnt = 0;
        for(int i =0 ; i < timeTable.length; i++){
            for (String str : timeTable[i]){
                if(str.equals("0")){
                    cnt++;
                }
            }
        }
        return 18-cnt;
    }

}
