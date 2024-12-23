package timeTable;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 사용자에게 GUI를 제공하는 클래스 입니다.
 * 
 * @author Lim Jonggu
 * @version 1.2
 * @since 1.0
 * 
 * @created 2024-12-23
 * @lastModified 2024-12-23
 * 
 * @changelog
 * <ul>
 *   <li>2024-12-23: 최초 생성 (Lim Jonggu)</li>
 *   <li>2024-12-23: 기본 틀 제작 (Lim Jonggu)</li>
 *   <li>2024-12-23: 시간표 임시 표현(Lim Jonggu)</li>
 *   <li>2024-12-23: 액션 리스너 추가, 시간표 업데이트 알고리즘 추가 (Lim Jonggu)</li>
 * </ul>
 */

public class gui extends JFrame implements ActionListener{
    JButton addButton , dayoffButton, changeTimeTableButton;
    JTextField dayoffText;
    JTextField[] addText = new JTextField[4];
    String[] str = {"과목명 :", "요일 :", "시간 :", "학점 :"};
    String weekStr = "월화수목금";
    String[][] timeTable;
    gui(){
        setTitle("시간표");
        setSize(600, 808);
        setResizable(false);
        north();
        center();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    /**
     * GUI의 상단 부분을 표현합니다.
     * 
     * @created 2024-12-23
     * @lastModified 2024-12-23
     * 
     * @changelog
     * <ul>
     *   <li>2024-12-23: 최초 생성 (Lim Jonggu)</li>
     *   <li>2024-12-23: 배경 색 변경 (Lim Jonggu)</li>
     * </ul>
     */

    void north(){
        JPanel mainPanel = new JPanel(new GridLayout(2,0 ));

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.white);
        for(int i = 0; i< addText.length ; i++){
            panel1.add(new JLabel(str[i]));
            addText[i] = new JTextField(5);
            panel1.add(addText[i]);
        }
        addButton = new JButton("수업 추가");
        addButton.addActionListener(this);
        panel1.add(addButton);
        mainPanel.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.white);

        panel2.add(new JLabel("원하는 공강 요일 :"));
        dayoffText = new JTextField(5);
        panel2.add(dayoffText);

        dayoffButton = new JButton("공강 요일 추가");
        dayoffButton.addActionListener(this);
        panel2.add(dayoffButton);

        changeTimeTableButton = new JButton("시간표 완성하기");
        changeTimeTableButton.addActionListener(this);
        panel2.add(changeTimeTableButton);

        mainPanel.add(panel2);

        add("North", mainPanel);

    }
    
     /**
     * 데이터베이스 속성을 설정합니다.
     * 
     * @param Main.timeTable 시간표 정보를 담은 배열입니다. 빈 부분을 0으로 표현되고 수업은 university 객체로 표현되어 있습니다.
     * 
     * @created 2024-12-23
     * @lastModified 2024-12-23
     * 
     * @changelog
     * <ul>
     *   <li>2024-12-23: 최초 생성 (Lim Jonggu)</li>
     *   <li>2024-12-23: 배경 색 변경 (Lim Jonggu)</li>
     * </ul>
     */

    void center(){
        timeTable = Main.timeTable;
        JPanel panel = new JPanel(new GridLayout(0,6));
        panel.setBackground(new Color(56, 173, 193));
        panel.add(new JLabel());
        for(int i = 0 ; i <weekStr.length(); i++){
            panel.add(new JLabel(""+weekStr.charAt(i)));
        }
        for(int i = 0 ; i < timeTable[0].length ; i++){
            panel.add(panel.add(new JLabel(""+(i+1)+"교시")));
            for(int j = 0; j < timeTable.length ; j++){
                panel.add(new JLabel(timeTable[j][i]));
            }
        }
        add("Center", panel);

    }
  
     /**
     * 액션 리스너에 대한 동작을 정의합니다.
     * 
     * @param ActionEvent e 이벤트가 발생한 상황에 대한 정보를 가지고있습니다.
     * @param Main.addTime Main메소드에서 사용되는 universityTime 클래스 형태의 ArrayList 입니다. 추가하고 싶은 수업을 저장하고 있습니다.
     * @param name 수업의 이름
     * @param week 수업이 진행되는 요일 (월화수목금 중 하나)
     * @param credit 수업의 학점
     * @param time 수업 시간 (1부터 5까지의 교시 중 하나)
     * 
     * @throws Exception  시간, 학점의 입력값이 숫자가 아닐경우
     * 
     * @created 2024-12-23
     * @lastModified 2024-12-23
     * 
     * @changelog
     * <ul>
     *   <li>2024-12-23: 최초 생성 (Lim Jonggu)</li>
     *   <li>2024-12-23: 배경 색 변경 (Lim Jonggu)</li>
     * </ul>
     */
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("수업 추가")){
            try {
                String name = addText[0].getText();
                String week = addText[1].getText();
                int time = Integer.parseInt(addText[2].getText());
                int credit = Integer.parseInt(addText[3].getText());
                if(isKorean(name) && "월화수목금".contains(week) && week.length()==1 && (time+credit-1) <= 9 ){
                    Main.addTime.add(new universityTime(name, week, time, credit));
                    JOptionPane.showMessageDialog(this, "수업이 정상적으로 추가되었습니다.", "알람", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(this, "올바르게 다시 작성해 주십시오", "알람", JOptionPane.INFORMATION_MESSAGE);
                }
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "올바르게 다시 작성해 주십시오", "알람", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else if(e.getActionCommand().equals("공강 요일 추가")){
            if("월화수목금".contains(dayoffText.getText()) && dayoffText.getText().length() == 1){
                Main.dayoff.add(dayoffText.getText());
                JOptionPane.showMessageDialog(this, "공강요일이 정상적으로 추가되었습니다.", "알람", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(this, "올바르게 다시 작성해 주십시오", "알람", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        else if(e.getActionCommand().equals("시간표 완성하기")){
            Main.changeTimeTable();
            remove(getContentPane().getComponent(1)); // 기존의 시간표 패널 제거
            center();
            revalidate();
            repaint();
        }
    }


     /**
     * 입력된 값이 한글인지 확인합니다.
     * 
     * @return boolean 값 반환 true, false
     * 
     * @created 2024-12-23
     * @lastModified 2024-12-23
     * 
     * @changelog
     * <ul>
     *   <li>2022-05-20: 최초 생성 (Lee Min Jae)</li>
     * </ul>
     */
    public static boolean isKorean(String str) {
        return str.matches("[가-힣]+"); // 한글 범위만 허용
    }
    
}
