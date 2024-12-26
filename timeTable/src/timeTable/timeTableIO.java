package timeTable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


/**
 * 파일을 입출력하기 위한 클래스 입니다.
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

public class timeTableIO {
    private static String file = "timeTable/myTimeTable.txt";
        public static String loadF(){
            try(BufferedReader br = new BufferedReader(new FileReader(file));){
            return ""+br.readLine();
        }catch (Exception e) {
            return "0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0";
        }

    }

    public static void saveF(){
        String save ="";
            for(int i=0 ; i <Main.timeTable.length ; i++){
                for(int j=0 ; j <Main.timeTable[0].length; j++){
                    if(save.length()>0){
                        save +=", "+Main.timeTable[i][j];
                    }       
            }
            try {BufferedWriter bw = new BufferedWriter(new FileWriter(file));{
                bw.write(save);
            }
            } catch (Exception e) {
            }
        }
    }
}
