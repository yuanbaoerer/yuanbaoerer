package novelproject;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;



public class Interface extends JFrame implements ItemListener,ActionListener{
    private JLabel jbl=new JLabel("嫌疑犯X的献身");
    private JLabel function=new JLabel("功能");
    private JPanel jpl=new JPanel();
    private BorderLayout bl=new BorderLayout(10,10);
    private JComboBox jcb=new JComboBox();
    private JButton jbt1=new JButton("出现次数排序");
    private JButton jbt2=new JButton("篇幅跨度排序");
    private JButton jbt3=new JButton("关系密度排序");
    private  JTextArea jta=new JTextArea("以下是结果:\n",30,30);
    private static String personname=null;
    private static String[] arr1=new String[]{"汤川","草薙","岸谷","间宫","石神","靖子","美里","富","工藤","小代子"};
    private static int[] arr2=new int[10];
    private static HashMap<String, Float> rls=new HashMap<String, Float>();
    private Font font1=new Font("黑体",Font.BOLD,20);
    private Font font2=new Font("华文新魏",Font.BOLD,16);
    private Font font3=new Font("黑体",Font.BOLD,14);
    public JPanel createWEST1() {
        JPanel west1=new JPanel();
        west1.setLayout(new GridLayout(6,1,5,5));
        west1.add(jcb);
        jcb.addItem("请选择人物");
        jcb.addItem("汤川");
        jcb.addItem("草薙");
        jcb.addItem("岸谷");
        jcb.addItem("间宫");
        jcb.addItem("石神");
        jcb.addItem("靖子");
        jcb.addItem("美里");
        jcb.addItem("富");
        jcb.addItem("工藤");
        jcb.addItem("小代子");
        west1.add(function);
        west1.add(jbt1);
        west1.add(jbt2);
        west1.add(jbt3);
        return west1;
    }
    public JPanel createWEST2(){
        JPanel west2=new JPanel();
        west2.setLayout(new FlowLayout());
        west2.add(createWEST1());
        return west2;
    }
    public JPanel createNORTH(){
        JPanel north=new JPanel();
        north.setLayout(new FlowLayout(FlowLayout.CENTER));
        north.add(jbl);
        return north;
    }
    public JPanel createCENTER(){
        JPanel center=new JPanel();
        center.add(jta);
        return center;
    }
    public Interface() {
        this.add(jpl);
        jpl.setLayout(bl);
        jpl.add(createWEST2(),BorderLayout.WEST);
        jpl.add(createNORTH(),BorderLayout.NORTH);
        jpl.add(createCENTER(),BorderLayout.CENTER);
        jta.setFont(font1);
        jbt1.setFont(font2);
        jbt2.setFont(font2);
        jbt3.setFont(font2);
        jbl.setFont(font1);
        function.setFont(font1);
        this.setBackground(Color.yellow);
        jcb.addItemListener(this);
        jbt1.addActionListener(this);
        jbt2.addActionListener(this);
        jbt3.addActionListener(this);
        this.setSize(500,600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void itemStateChanged(ItemEvent e){
        if(e.getStateChange()==ItemEvent.SELECTED){
            switch((String)e.getItem()){
                case "汤川":
                    personname="汤川"; break;
                case "草薙":
                    personname="草薙"; break;
                case "岸谷":
                    personname="岸谷"; break;
                case "间宫":
                    personname="间宫"; break;
                case "石神":
                    personname="石神"; break;
                case "靖子":
                    personname="靖子"; break;
                case "美里":
                    personname="美里"; break;
                case "富":
                    personname="富"; break;
                case "工藤":
                    personname="工藤"; break;
                case "小代子":
                    personname="小代子"; break;
            }
            try {
                Saver.saver(personname);
                File file=new File("result.txt");
                FileReader fr=new FileReader(file);
                BufferedReader br=new BufferedReader(fr);
                jta.setText("以下是结果；\n");
                while(true){
                    String msg=br.readLine();
                    if(msg==null) {
                        break;
                    }
                    jta.append(msg+"\n");
                }
                fr.close();
                br.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==jbt1){
            int i;
            HashMap<Integer,String> hm=new HashMap<Integer,String>();
            for(i=0;i<10;i++){
                try {
                    byte[] data=NovelFunction1.getData();
                    arr2[i]=NovelFunction1.stat(data,arr1[i]);
                    hm.put(arr2[i],arr1[i]);
                }catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            Arrays.sort(arr2);
            jta.setText("以下是结果：\n");
            for(int a:arr2){
                jta.append(hm.get(a)+" 的出现次数:"+a+"\n");
            }

        }
        else if(e.getSource()==jbt2){
            int i;
            float[] arr3=new float[10];
            HashMap<Float,String> hm=new HashMap<Float,String>();
            for(i=0;i<10;i++){
                try {
                    arr3[i]=NovelFunction2.Span(arr1[i]);
                    hm.put(arr3[i],arr1[i]);
                }catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            Arrays.sort(arr3);
            jta.setText("以下是结果：\n");
            for(float a:arr3){
                jta.append(hm.get(a)+" 的篇幅跨度为:"+a+"%"+"\n");
            }
        }
        else if(e.getSource()==jbt3){
            jta.setText("以下是结果：\n");
            for(int i= 0;i<10;i++){
                try {
                    rls=NovelFunction3.Relationship2(arr1[i]);
                    for(String a:arr1){
                        if(arr1[i]!=a){
                            if(rls.get(a)==100){
                                jta.append(arr1[i]+"与"+a+"最亲密为："+rls.get(a)+"\n");
                            }
                        }
                    }
                }catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            for(int i= 0;i<10;i++){
                try {
                    rls=NovelFunction3.Relationship2(arr1[i]);
                    for(String a:arr1){
                        if(arr1[i]!=a){
                            if(rls.get(a)==0){
                                jta.append(arr1[i]+"与"+a+"最不亲密为："+rls.get(a)+"\n");
                            }
                        }
                    }
                }catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
        else{
            System.exit(0);
        }
    }
    public static void main(String[] args) throws Exception{
        new Interface();
    }
}