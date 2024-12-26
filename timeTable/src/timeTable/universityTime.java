package timeTable;


/**
 * 수업의 정보를 담고잇는 클래스 입니다.
 * 
 * @param name String 수업의 제목 저장.
 * @param week String 수업의 요일 저장.
 * @param time int 수업 시간 저장.
 * @param credit int 수업 학점 저장.
 * 
 * @author Lim Jonggu
 * @version 1.0
 * @since 1.0
 * 
 * @created 2024-12-23
 * @lastModified 2024-12-23
 * 
 * @changelog
 * <ul>
 *   <li>2024-12-23: 최초 생성 (Lim Jonggu)</li>
 * </ul>
 */

public class UniversityTime {
    private String name, week;
    private int time, credit;

    UniversityTime(String name, String week, int time, int credit){
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
