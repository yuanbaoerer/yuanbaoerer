package novelproject;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;



import javax.swing.JOptionPane;
public class Saver {
    public static String time=null;
    private static String sp=null;
    private static HashMap<String,Float> rls=new HashMap<String,Float>();
    private static String[] arr=new String[]{"汤川","草薙","岸谷","间宫","石神","靖子","美里","富","工藤","小代子"};
    public static void saver(String personname)throws Exception{
        try{
            byte[] data=NovelFunction1.getData();
            int ti=NovelFunction1.stat(data,personname);
            time=String.valueOf(ti);
            sp=String.valueOf(NovelFunction2.Span(personname));
            rls=NovelFunction3.Relationship2(personname);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "操作异常");
        }
        PrintStream ps=new PrintStream(new FileOutputStream("e:\\eclipse\\lny\\result.txt"));
        String msg1="人物：";
        ps.println(msg1+personname+"\n");
        String msg2="出现次数：";
        ps.println(msg2+time+"\n");
        String msg3="人物篇幅跨度为：";
        ps.println(msg3+sp+"%"+"\n");
        String msg4="人物关系密度：";
        ps.println(msg4);
        HashMap<Float,String> hm=new HashMap<Float,String>();
        float[] aa=new float[10];
        for(int i=0;i<10;i++){
            aa[i]=rls.get(arr[i]);
            hm.put(aa[i], arr[i]);
        }
        Arrays.sort(aa);
        for(float a:aa){
            if(personname!=hm.get(a)){
                ps.println(personname+"与"+hm.get(a)+"的关系密度为"+a);

            }
        }
        ps.close();
    }
}
