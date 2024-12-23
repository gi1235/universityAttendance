package timeTable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridLayout;

public class gui extends JFrame{
    JButton addButton , dayoffButton;
    JTextField dayoffText;
    JTextField[] addText = new JTextField[4];
    String[] str = {"과목명 :", "요일 ㅣ", "시간 :", "학점 :"};
    String week = "월화수목금";
    String[][] timeTable = Main.timeTable;
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
        for(int i = 0; i< addText.length ; i++){
            panel1.add(new JLabel(str[i]));
            addText[i] = new JTextField(5);
            panel1.add(addText[i]);
        }
        addButton = new JButton("수업 추가");
        panel1.add(addButton);
        mainPanel.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("원하는 공강 요일 :"));
        dayoffText = new JTextField(5);
        panel2.add(dayoffText);
        dayoffButton = new JButton("공강 요일 추가");
        panel2.add(dayoffButton);
        mainPanel.add(panel2);

        add("North", mainPanel);

    }
        
    void center(){
        JPanel panel = new JPanel(new GridLayout(0,6));
        panel.add(new JLabel());
        for(int i = 0 ; i <week.length(); i++){
            panel.add(new JLabel(""+week.charAt(i)));
        }
        for(int i = 0 ; i < timeTable[0].length ; i++){
            panel.add(panel.add(new JLabel(""+(i+1)+"교시")));
            for(int j = 0; j < timeTable.length ; j++){
                panel.add(new JLabel(timeTable[j][i]));
            }
        }
        add("Center", panel);

    }
}
