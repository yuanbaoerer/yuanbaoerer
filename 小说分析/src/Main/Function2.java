package Main;

import java.io.IOException;

/**
 * 统计每个人在小说中出现的篇幅跨度（第一次出现和最后一个出现的行间距），按照篇幅跨度排序
 */
public class Function2 {


    /**
     * 统计每个人在小说中出现的篇幅跨度（第一次出现和最后一个出现的行间距），按照篇幅跨度排序
     * @param data
     * @param name1
     * @param name2
     * @return
     * @throws IOException
     */
    public static double PianFuKuaDu_Main(byte[] data,String name1,String name2) throws IOException {
        if (name1.equals("") && name2.equals("")){
            return -1;
        }else if (!name1.equals("") && name2.equals("")){
            return PianFuKuaDu(data,name1);
        }else if (!name1.equals("") && !name2.equals("")){
            return PianFuKuaDu(data,name1,name2);
        }else if (name1.equals("") && !name2.equals("")){
            return PianFuKuaDu(data,name2);
        }
        return -1;
    }
    private static double PianFuKuaDu(byte[] data,String name) throws IOException {
        String dataStr = new String(data);
        int start = 0, end = 0;
        double pianFuKuaDu = 0;
        boolean flag = false;
        for (int i = 0;i < dataStr.length() - name.length();i++){
            String s = dataStr.substring(i,i + name.length());
            if (s.equals(name) && flag == false){
                start = i;
                flag = true;
            }
            if (s.equals(name)){
                end = i;
            }
        }
        int length = dataStr.length();
        pianFuKuaDu = (double) (end - start)/length;

        return pianFuKuaDu;
    }
    private static double PianFuKuaDu(byte[] data,String name1,String name2) throws IOException {
        String dataStr = new String(data);
        int start = 0,end = 0, start1 = 0, end1 = 0,start2 = 0,end2 = 0;
        double pianFuKuaDu = 0;
        boolean flag1 = false,flag2 = false;
        for (int i = 0;i < dataStr.length() - name1.length();i++){
            String s = dataStr.substring(i,i + name1.length());
            if (s.equals(name1) && flag1 == false){
                start1 = i;
                flag1 = true;
            }
            if (s.equals(name1)){
                end1 = i;
            }
        }
        for (int i = 0;i < dataStr.length() - name2.length();i++){
            String s = dataStr.substring(i,i + name1.length());
            if (s.equals(name1) && flag2 == false){
                start2 = i;
                flag2 = true;
            }
            if (s.equals(name1)){
                end2 = i;
            }
        }
        int length = dataStr.length();
        start = start1 < start2 ? start1 : start2;
        end = end1 > end2 ? end1 : end2;
        pianFuKuaDu = (double) (end - start)/length;

        return pianFuKuaDu;
    }
}
