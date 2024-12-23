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

public class gui extends JFrame implements ActionListener{
    JButton addButton , dayoffButton, changeTimeTableButton;
    JTextField dayoffText;
    JTextField[] addText = new JTextField[4];
    String[] str = {"과목명 :", "요일 ㅣ", "시간 :", "학점 :"};
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
    
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("수업 추가")){
            try {
                String name = addText[0].getText();
                String week = addText[1].getText();
                int time = Integer.parseInt(addText[2].getText());
                int credit = Integer.parseInt(addText[3].getText());
                if(isKorean(name) && "월화수목금".contains(week) && week.length()==1){
                    Main.addTime.add(new universiryTime(name, week, time, credit));
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

    public static boolean isKorean(String str) {
        return str.matches("[가-힣]+"); // 한글 범위만 허용
    }
}
