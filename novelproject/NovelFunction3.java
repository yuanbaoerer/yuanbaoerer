package novelproject;

import java.util.HashMap;

public class NovelFunction3 {
    private static float[] rs=new float[10];
    private static HashMap<String,Float> rls=new HashMap<String,Float>();
    private static String[] arr=new String[]{"汤川","草薙","岸谷","间宫","石神","靖子","美里","富","工藤","小代子"};
    public static float Relationship1(String pn1,String pn2)throws Exception{
        byte[] data=NovelFunction1.getData();
        String dataStr=new String(data);
        int time=NovelFunction1.stat(data,pn1);
        int score=0;
        int length1=0;
        int length2=1000;
        for(;(length2<dataStr.length());length1+=1000,length2+=1000){
            for(int i=length1;i<length2-pn1.length()-1;i++){
                String s1=dataStr.substring(i,i+pn1.length()).toString();
                for(int j=length1;(s1.equals(pn1))&&(j<length2-pn2.length()-1);j++){
                    String s2=dataStr.substring(j,j+pn2.length()).toString();
                    if(s2.equals(pn2)){
                        score++; break;
                    }
                }
            }
        }
        float rs=((score*10000)/time);
        return rs/100;
    }
    public static HashMap<String,Float> Relationship2(String pn)throws Exception{
        for(int i=0;i<10;i++){
            rs[i]=Relationship1(pn,arr[i]);
            rls.put(arr[i],rs[i]);
        }
        return rls;
    }
}
