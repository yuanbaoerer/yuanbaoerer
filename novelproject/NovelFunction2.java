package novelproject;

import java.util.HashMap;
public class NovelFunction2 {
    public static float Span(String pn)throws Exception{
        byte[] data=NovelFunction1.getData();
        HashMap<String,Integer> hm1=new HashMap<String,Integer>();
        HashMap<String,Integer> hm2=new HashMap<String,Integer>();
        HashMap<String,Integer> hm3=new HashMap<String,Integer>();
        String dataStr=new String(data);
        int time=0;
        for(int i=0;i<dataStr.length()-pn.length()-1;i++){
            String s3 =dataStr.substring(i,i+pn.length()).toString();
            if(s3.equals(pn )){
                time++;
                if(time==1){
                    hm1.put(pn,i);
                }
                hm2.put(pn, i);
            }
        }
        hm3.put(pn, (hm2.get(pn)-hm1.get(pn)));
        float span=((hm3.get(pn)*10000)/dataStr.length());
        return (span/100);
    }
}
