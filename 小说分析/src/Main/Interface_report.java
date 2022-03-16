package Main;

import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱吃皮蛋的元包
 * @Date: 2022/03/10/12:28
 * @Description:分析报告图形界面
 */

public class Interface_report extends JFrame {

    private JPanel jPanel = new JPanel();
    private JPanel jPanel_SOUTH = new JPanel();
    private JTextArea jTextArea = new JTextArea();
    private JButton jButton_save = new JButton("保存");
    private JButton jButton_close = new JButton("关闭");
    private String path = new String();
    private String name1 = new String(); private String name2 = new String(); private String name3 = new String();
    private String name4 = new String(); private String name5 = new String(); private String name6 = new String();
    private String name7 = new String(); private String name8 = new String(); private String name9 = new String();
    private String name10 = new String(); private String name11 = new String(); private String name12 = new String();
    private String name13 = new String(); private String name14 = new String(); private String name15 = new String();
    private String name16 = new String(); private String name17 = new String(); private String name18 = new String();
    private String name19 = new String(); private String name20 = new String(); private String name = new String();
    private byte[] data;

    public Interface_report(){
        super("分析报告");
        this.add(jPanel);
        jPanel.setLayout(new BorderLayout());
        jPanel.add(jTextArea,BorderLayout.CENTER);

        this.setResizable(false);
        this.setVisible(true);
        this.setSize(1150,780);
    }

    public Interface_report(String path,String name1,String name2,String name3,String name4,String name5,String name6,String name7,
                            String name8,String name9,String name10,String name11,String name12,String name13,String name14,String name15,
                            String name16,String name17,String name18,String name19,String name20,String name) throws IOException {
        super("分析报告");
        this.add(jPanel);
        this.name1 = name1; this.name2 = name2; this.name3 = name3;
        this.name4 = name4; this.name5 = name5; this.name6 = name6;
        this.name7 = name7; this.name8 = name8; this.name9 = name9;
        this.name10 = name10; this.name11 = name11; this.name12 = name12;
        this.name13 = name13; this.name14 = name14; this.name15 = name15;
        this.name16 = name16; this.name17 = name17; this.name18 = name18;
        this.name19 = name19; this.name20 = name20; this.name = name;

        data = Function1.getData(path);

        jPanel_SOUTH.setLayout(new FlowLayout());
        jPanel_SOUTH.add(jButton_save);
        jPanel_SOUTH.add(jButton_close);

        jPanel.setLayout(new BorderLayout());
        jPanel.add(jTextArea,BorderLayout.CENTER);
        jPanel.add(jPanel_SOUTH,BorderLayout.SOUTH);

        //功能一、功能二、功能三分析文本
        jTextArea.setText(fenxi_Function1() + "\n" + fenxi_Function2() + "\n" + fenxi_Function3());
        jTextArea.setFont(new Font("标楷体", Font.BOLD, 16));

        jButton_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opt = JOptionPane.showConfirmDialog(jPanel,
                        "保存分析报告为桌面sava.txt文件", "确认",
                        JOptionPane.YES_NO_OPTION);
                if (opt == JOptionPane.YES_OPTION) {
                    Save_report.Save_report(jTextArea.getText());;
                }
            }
        });

        jButton_close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        this.setResizable(false);
        this.setVisible(true);
        this.setSize(1150,780);
    }

    private String fenxi_Function1() throws IOException {

        StringBuilder fenxi = new StringBuilder();

        if (Function1.countTimes_Main(data,name1,name2) != -1){
            fenxi.append(name1 + " " + name2 + " 出现次数为："+Function1.countTimes_Main(data,name1,name2) + "\n");
        }if (Function1.countTimes_Main(data,name3,name4) != -1){
            fenxi.append(name3 + " " + name4 + " 出现次数为："+Function1.countTimes_Main(data,name3,name4) + "\n");
        }if (Function1.countTimes_Main(data,name5,name6) != -1){
            fenxi.append(name5 + " " + name6 + " 出现次数为："+Function1.countTimes_Main(data,name5,name6) + "\n");
        }if (Function1.countTimes_Main(data,name7,name8) != -1){
            fenxi.append(name7 + " " + name8 + " 出现次数为："+Function1.countTimes_Main(data,name7,name8) + "\n");
        }if (Function1.countTimes_Main(data,name9,name10) != -1){
            fenxi.append(name9 + " " + name10 + " 出现次数为："+Function1.countTimes_Main(data,name9,name10) + "\n");
        }if (Function1.countTimes_Main(data,name11,name12) != -1){
            fenxi.append(name11 + " " + name12 + " 出现次数为："+Function1.countTimes_Main(data,name11,name12) + "\n");
        }if (Function1.countTimes_Main(data,name13,name14) != -1){
            fenxi.append(name13 + " " + name14 + " 出现次数为："+Function1.countTimes_Main(data,name13,name14) + "\n");
        }if (Function1.countTimes_Main(data,name15,name16) != -1){
            fenxi.append(name15 + " " + name16 + " 出现次数为："+Function1.countTimes_Main(data,name15,name16) + "\n");
        }if (Function1.countTimes_Main(data,name17,name18) != -1){
            fenxi.append(name17 + " " + name18 + " 出现次数为："+Function1.countTimes_Main(data,name17,name18) + "\n");
        }if (Function1.countTimes_Main(data,name19,name20) != -1){
            fenxi.append(name19 + " " + name20 + " 出现次数为："+Function1.countTimes_Main(data,name19,name20) + "\n");
        }

        return String.valueOf(fenxi);

    }

    private String fenxi_Function2() throws IOException {

        StringBuilder fenxi = new StringBuilder();
        double[] pianFuKuaDus = new double[10];

        HashMap hashMap = new HashMap();

        if (Function2.PianFuKuaDu_Main(data,name1,name2) != -1){
            pianFuKuaDus[0] = Function2.PianFuKuaDu_Main(data,name1,name2);
            hashMap.put(pianFuKuaDus[0],name1);
        }if (Function2.PianFuKuaDu_Main(data,name3,name4) != -1){
            pianFuKuaDus[1] = Function2.PianFuKuaDu_Main(data,name3,name4);
            hashMap.put(pianFuKuaDus[1],name3);
        }if (Function2.PianFuKuaDu_Main(data,name5,name6) != -1){
            pianFuKuaDus[2] = Function2.PianFuKuaDu_Main(data,name5,name6);
            hashMap.put(pianFuKuaDus[2],name5);
        }if (Function2.PianFuKuaDu_Main(data,name7,name8) != -1){
            pianFuKuaDus[3] = Function2.PianFuKuaDu_Main(data,name7,name8);
            hashMap.put(pianFuKuaDus[3],name7);
        }if (Function2.PianFuKuaDu_Main(data,name9,name10) != -1){
            pianFuKuaDus[4] = Function2.PianFuKuaDu_Main(data,name9,name10);
            hashMap.put(pianFuKuaDus[4],name9);
        }if (Function2.PianFuKuaDu_Main(data,name11,name12) != -1){
            pianFuKuaDus[5] = Function2.PianFuKuaDu_Main(data,name11,name12);
            hashMap.put(pianFuKuaDus[5],name11);
        }if (Function2.PianFuKuaDu_Main(data,name13,name14) != -1){
            pianFuKuaDus[6] = Function2.PianFuKuaDu_Main(data,name13,name14);
            hashMap.put(pianFuKuaDus[6],name13);
        }if (Function2.PianFuKuaDu_Main(data,name15,name16) != -1){
            pianFuKuaDus[7] = Function2.PianFuKuaDu_Main(data,name15,name16);
            hashMap.put(pianFuKuaDus[7],name15);
        }if (Function2.PianFuKuaDu_Main(data,name17,name18) != -1){
            pianFuKuaDus[8] = Function2.PianFuKuaDu_Main(data,name17,name18);
            hashMap.put(pianFuKuaDus[8],name17);
        }if (Function2.PianFuKuaDu_Main(data,name19,name20) != -1){
            pianFuKuaDus[9] = Function2.PianFuKuaDu_Main(data,name19,name20);
            hashMap.put(pianFuKuaDus[9],name19);
        }
        Arrays.sort(pianFuKuaDus);
        for (double x : pianFuKuaDus){
            if (x != 0){
                fenxi.append(hashMap.get(x) + " 篇幅跨度为：" + x + "\n");
            }
        }
        fenxi.append("ps:(以升序排序)\n");

        return String.valueOf(fenxi);
    }

    private String fenxi_Function3(){
        HashMap hashMap = new HashMap();
        List list = new ArrayList();
        if (!name.equals("")){
            if (Function3.guanxi_Main(data,name,name1) != -1 && !name.equals(name1)){
                list.add(new Function3_relationship(name1,Function3.guanxi_Main(data,name,name1)));
            }if (Function3.guanxi_Main(data,name,name3) != -1 && !name.equals(name3)){
                list.add(new Function3_relationship(name3,Function3.guanxi_Main(data,name,name3)));
            }if (Function3.guanxi_Main(data,name,name5) != -1 && !name.equals(name5)){
                list.add(new Function3_relationship(name5,Function3.guanxi_Main(data,name,name5)));
            }if (Function3.guanxi_Main(data,name,name7) != -1 && !name.equals(name7)){
                list.add(new Function3_relationship(name7,Function3.guanxi_Main(data,name,name7)));
            }if (Function3.guanxi_Main(data,name,name9) != -1 && !name.equals(name9)){
                list.add(new Function3_relationship(name9,Function3.guanxi_Main(data,name,name9)));
            }if (Function3.guanxi_Main(data,name,name11) != -1 && !name.equals(name11)){
                list.add(new Function3_relationship(name11,Function3.guanxi_Main(data,name,name11)));
            }if (Function3.guanxi_Main(data,name,name13) != -1 && !name.equals(name13)){
                list.add(new Function3_relationship(name13,Function3.guanxi_Main(data,name,name13)));
            }if (Function3.guanxi_Main(data,name,name15) != -1 && !name.equals(name15)){
                list.add(new Function3_relationship(name15,Function3.guanxi_Main(data,name,name15)));
            }if (Function3.guanxi_Main(data,name,name17) != -1 && !name.equals(name17)){
                list.add(new Function3_relationship(name17,Function3.guanxi_Main(data,name,name17)));
            }if (Function3.guanxi_Main(data,name,name19) != -1 && !name.equals(name19)){
                list.add(new Function3_relationship(name19,Function3.guanxi_Main(data,name,name19)));
            }
        }else return "未进行亲密度分析操作";

        return Function3.judgeRelationship(list,name);
    }

}

