package novelproject;

import java.io.File;
import java.io.FileInputStream;
public class NovelFunction1 {
    public static byte[] getData()throws Exception{           //读文件
        File novel=new File("C:\\Users\\31031.000\\Desktop\\嫌疑犯x的献身.txt");
        FileInputStream fis=new FileInputStream(novel);
        byte[] data=new byte[(int)novel.length()];
        fis.read(data);
        fis.close();
        return data;
    }
    public static int stat(byte[] data,String pn)throws Exception{         //统计次数
        String dataStr=new String(data);
        int time=0;
        for(int i=0;i<dataStr.length()-pn.length()-1;i++){
            String s3 =dataStr.substring(i,i+pn.length()).toString();
            if(s3.equals(pn)){
                time++;
            }
        }
        return time;
    }

}
