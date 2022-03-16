package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱吃皮蛋的元包
 * @Date: 2022/03/10/12:28
 * @Description:图形界面主界面
 */

public class InterFace_main extends JFrame {

    private BorderLayout borderLayout = new BorderLayout(10,10);
    private JPanel jPanel=new JPanel();
    private JLabel jLabel_north = new JLabel("     小说分析     ");
    private JLabel jLabel1 = new JLabel("小说路径：",JLabel.CENTER);
    private JLabel jLabel2 = new JLabel("人物名称：",JLabel.CENTER);
    private JLabel jLabel3 = new JLabel("别名（可不填）：",JLabel.CENTER);
    private JLabel jlabel4 = new JLabel("功能介绍",JLabel.CENTER);
    private JLabel jLabel5 = new JLabel("分析亲密关系人名：",JLabel.CENTER);
    protected JTextField jTextField_1 = new JTextField(20); protected JTextField jTextField_2 = new JTextField(20); protected JTextField jTextField_3 = new JTextField(20);
    protected JTextField jTextField_4 = new JTextField(20); protected JTextField jTextField_5 = new JTextField(20); protected JTextField jTextField_6 = new JTextField(20);
    protected JTextField jTextField_7 = new JTextField(20); protected JTextField jTextField_8 = new JTextField(20); protected JTextField jTextField_9 = new JTextField(20);
    protected JTextField jTextField_10 = new JTextField(20); protected JTextField jTextField_11 = new JTextField(20); protected JTextField jTextField_12 = new JTextField(20);
    protected JTextField jTextField_13 = new JTextField(20); protected JTextField jTextField_14 = new JTextField(20); protected JTextField jTextField_15 = new JTextField(20);
    protected JTextField jTextField_16 = new JTextField(20); protected JTextField jTextField_17 = new JTextField(20); protected JTextField jTextField_18 = new JTextField(20);
    protected JTextField jTextField_19 = new JTextField(20); protected JTextField jTextField_20 = new JTextField(20); protected JTextField jTextField_21 = new JTextField(20);
    protected JTextField jTextField_22 = new JTextField(20);
    private JTextArea jTextArea = new JTextArea(25,5);
    private JButton jButton_fenxi = new JButton("分析");
    private JButton jButton_remake = new JButton("重置");

    public JPanel North1(){
        JPanel north1 = new JPanel();
        north1.setLayout(new FlowLayout());
        jLabel_north.setFont(new Font("黑体", Font.BOLD,30));
        jLabel_north.setBorder(BorderFactory.createTitledBorder("by 王盛渤"));
        jLabel_north.setOpaque(true);
        north1.add(jLabel_north);
        return north1;
    }

    public JPanel West1(){
        JPanel west1 = new JPanel();
        west1.setLayout(new BorderLayout(1,2));


        jTextArea.setText("1：统计每个人物（人名及外号）在小说中出现次数" +
                "\n2： 统计每个人在小说中出现的篇幅跨度，并按照篇幅跨度排序。" +
                "\n3: 给出 10 个人物的交往情况； 如果两个在相距较短的一段文字中出现，我们认\n为两个人有交往关系，距离越短，关系越近。\n找出 10 个人中：\n" +
                "关系最紧密的两个人，关系最不紧密的两个人。");
        jTextArea.setEditable(false);
        jTextArea.setFont(new Font("标楷体", Font.BOLD, 16));
        jlabel4.setFont(new Font("黑体", Font.BOLD,20));
        west1.add(jlabel4,BorderLayout.NORTH);
        west1.add(jTextArea,BorderLayout.CENTER);
        return west1;
    }

    public JPanel East1(){
        JPanel west1 = new JPanel();
        west1.setBorder(BorderFactory.createTitledBorder("输入信息"));

        JPanel west1_north = new JPanel();
        JPanel west1_Buttons = new JPanel();

        west1_north.setLayout(new FlowLayout());
        west1_north.add(jLabel1);
        west1_north.add(jTextField_1);

        JPanel west1_center = new JPanel();
        west1_center.setLayout(new GridLayout(12,2,3,3));
        west1_center.add(jLabel2); west1_center.add(jLabel3); west1_center.add(jTextField_2); west1_center.add(jTextField_3);
        west1_center.add(jTextField_4); west1_center.add(jTextField_5); west1_center.add(jTextField_6); west1_center.add(jTextField_7);
        west1_center.add(jTextField_8); west1_center.add(jTextField_9); west1_center.add(jTextField_10); west1_center.add(jTextField_11);
        west1_center.add(jTextField_12); west1_center.add(jTextField_13); west1_center.add(jTextField_14); west1_center.add(jTextField_15);
        west1_center.add(jTextField_16); west1_center.add(jTextField_17); west1_center.add(jTextField_18); west1_center.add(jTextField_19);
        west1_center.add(jTextField_20); west1_center.add(jTextField_21);

        west1_center.add(jLabel5); west1_center.add(jTextField_22);

        west1_Buttons.setLayout(new FlowLayout());
        west1_Buttons.add(jButton_fenxi);
        west1_Buttons.add(jButton_remake);

        west1.setLayout(new BorderLayout());
        west1.add(west1_north,BorderLayout.NORTH);
        west1.add(west1_center,BorderLayout.CENTER);
        west1.add(west1_Buttons,BorderLayout.SOUTH);

        /**
         * 生成分析报告
         */
        jButton_fenxi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    new Interface_report(jTextField_1.getText(),jTextField_2.getText(),jTextField_3.getText(),jTextField_4.getText(),
                            jTextField_5.getText(),jTextField_6.getText(),jTextField_7.getText(),jTextField_8.getText(),
                            jTextField_9.getText(),jTextField_10.getText(),jTextField_11.getText(),jTextField_12.getText(),
                            jTextField_13.getText(),jTextField_14.getText(),jTextField_15.getText(),jTextField_16.getText(),
                            jTextField_17.getText(),jTextField_18.getText(),jTextField_19.getText(),jTextField_20.getText(),
                            jTextField_21.getText(),jTextField_22.getText());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });

        jButton_remake.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField_1.setText(""); jTextField_2.setText(""); jTextField_3.setText("");
                jTextField_4.setText(""); jTextField_5.setText(""); jTextField_6.setText("");
                jTextField_7.setText(""); jTextField_8.setText(""); jTextField_9.setText("");
                jTextField_10.setText(""); jTextField_11.setText(""); jTextField_12.setText("");
                jTextField_13.setText(""); jTextField_14.setText(""); jTextField_15.setText("");
                jTextField_16.setText(""); jTextField_17.setText(""); jTextField_18.setText("");
                jTextField_19.setText(""); jTextField_20.setText(""); jTextField_21.setText("");
                jTextField_22.setText("");
            }
        });

        return west1;
    }

    public InterFace_main(){
        super("小说分析");
        this.add(jPanel);
        this.setResizable(false);
        jPanel.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        jPanel.setLayout(borderLayout);
        jPanel.add(North1(),BorderLayout.NORTH);
        jPanel.add(East1(),BorderLayout.EAST);
        jPanel.add(West1(),BorderLayout.WEST);

        this.setVisible(true);
        this.setSize(1150,780);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
