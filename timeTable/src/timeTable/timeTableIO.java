package timeTable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


/**
 * 파일을 입출력하기 위한 클래스 입니다.
 * 
 * @param file 파일의 위치를 저장
 * 
 * @author Lim Jonggu
 * @version 1.0
 * @since 1.0
 * 
 * @created 2024-12-26
 * @lastModified 2024-12-26
 * 
 * @changelog
 * <ul>
 *   <li>2024-12-26: 최초 생성 (Lim Jonggu)</li>
 * </ul>
 */

public class TimeTableIO {
    private static String file = "timeTable/myTimeTable.txt";

    /**
     * 파일을 읽어오기 위한 메스드.
     * 
     * @return String 형태로 시간표를 반환 합니다.
     * 
     * @throws Exception  해당 파일이 존재하지 않은 경우
     * 
     * @created 2024-12-26
     * @lastModified 2024-12-26
     * 
     * @changelog
     * <ul>
     *   <li>2024-12-26: 최초 생성 (Lim Jonggu)</li>
     * </ul>
     */
        public static String loadF(){
            try(BufferedReader br = new BufferedReader(new FileReader(file));){
            return ""+br.readLine();
        }catch (Exception e) {
            return "0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0";
        }

    }

    /**
     * 파일을 저장하기 위한 메스드.
     * 
     * 
     * @throws Exception  이외 오류 처리
     * 
     * @created 2024-12-26
     * @lastModified 2024-12-26
     * 
     * @changelog
     * <ul>
     *   <li>2024-12-26: 최초 생성 (Lim Jonggu)</li>
     * </ul>
     */

    public static void saveF(){
        String save ="";
            for(int i=0 ; i <Main.timeTable.length ; i++){
                for(int j=0 ; j <Main.timeTable[0].length; j++){
                    if(save.length()>0){
                        save +=", "+Main.timeTable[i][j];
                    }
                    else save+=Main.timeTable[i][j];
            }
        }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file));){
                bw.write(save);
            }catch (Exception e) {
            }
        }
}
