package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;


/**
 * 统计每个人物（人名及外号）在小说中出现次数
 */
public class Function1 {


    /**
     * 获取小说文本数据
     * @param path
     * @return
     * @throws IOException
     */
    public static byte[] getData(String path) throws IOException {
        File novel = new File(path);
        FileInputStream fis = new FileInputStream(novel);
        byte[] data = new byte[(int) novel.length()];
        fis.read(data);
        fis.close();
        return data;
    }

    /**
     * 功能一情况分析
     * @param data
     * @param name1
     * @param name2
     * @return
     */
    public static int countTimes_Main(byte[] data,String name1,String name2){
        if (name1.equals("") && name2.equals("")){
            return -1;
        }else if (!name1.equals("") && name2.equals("")){
            return countTimes(data,name1);
        }else if (!name1.equals("") && !name2.equals("")){
            return countTimes(data,name1,name2);
        }else if (name1.equals("") && !name2.equals("")){
            return countTimes(data,name2);
        }
        return -1;
    }

    /**
     * 统计人名出现次数
     * @param data
     * @param name
     * @return
     */
    private static int countTimes(byte[] data,String name){
        String dataStr = new String(data);
        int time = 0;
        for (int i = 0;i<dataStr.length() - name.length();i++){
            String s = dataStr.substring(i,i+name.length()).toString();
            if (s.equals(name)){
                time++;
            }
        }
        return time;
    }

    /**
     * 统计人名及外号出现次数
     * @param data
     * @param name1
     * @param name2
     * @return
     */
    private static int countTimes(byte[] data,String name1,String name2){
        String dataStr = new String(data);
        int time1 = 0,time2 = 0,times = 0;
        for (int i = 0;i<dataStr.length() - name1.length();i++){
            String s = dataStr.substring(i,i+name1.length()).toString();
            if (s.equals(name1)){
                time1++;
            }
        }
        for (int i = 0;i<dataStr.length() - name2.length();i++){
            String s = dataStr.substring(i,i+name2.length()).toString();
            if (s.equals(name2)){
                time2++;
            }
        }
        times = time1 + time2;
        return times;
    }

}
