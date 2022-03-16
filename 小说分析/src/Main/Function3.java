package Main;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * （3） 给出 10 个人物的交往情况； 如果两个在相距较短的一段文字中出现，
 * 我们认为两个人有交往关系，距离越短，关系越近。找出 10 个人中：
 * 关系最紧密的两个人，关系最不紧密的两个人。
 * 输入一个人名，列出该人和其他人关系的紧密程度排名。
 */
public class Function3 {

    public static int guanxi_Main(byte[] data, String name, String name1) {
        if (name1.equals("")) {
            return -1;
        } else {
            return guanxi(data, name, name1);
        }
    }

    private static int guanxi(byte[] data, String name, String name1) {
        String dataStr = new String(data);
        int count = 0;
        int num = 100;
        for (int i = num; i < dataStr.length(); i += num) {
            boolean flag = false, flag1 = false;
            for (int j = i - num; j < i; j++) {
                String s = dataStr.substring(j, j + name.length());
                if (s.equals(name)) {
                    flag = true;
                    break;
                }
            }
            for (int j = i - num; j < i; j++) {
                String s1 = dataStr.substring(j, j + name1.length());
                if (s1.equals(name1)) {
                    flag1 = true;
                    break;
                }
            }
            if (flag && flag1) count++;
        }
        System.out.println(count);

        return count;
    }

    protected static String judgeRelationship(List list,String name) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name + "的关系状况：\n");

        double max = 0, min = ((Function3_relationship) list.get(0)).count;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, ((Function3_relationship) list.get(i)).count);
            min = Math.min(min, ((Function3_relationship) list.get(i)).count);
        }
        for (int i = 0;i<list.size();i++){
            if (((Function3_relationship) list.get(i)).count / max == 1){
                stringBuilder.append(((Function3_relationship) list.get(i)).name + "：关系最为亲密，亲密度100%  ※\n");
            }else if (((Function3_relationship) list.get(i)).count / min == 1 || min == 0){
                stringBuilder.append(((Function3_relationship) list.get(i)).name + "：毫无关系，亲密度0%  ※\n");
            }else if (((Function3_relationship) list.get(i)).count / max < 1 && ((Function3_relationship) list.get(i)).count / max >= 0.750){
                stringBuilder.append(((Function3_relationship) list.get(i)).name + "：关系亲密\n");
            }else if (((Function3_relationship) list.get(i)).count / max < 0.75 && ((Function3_relationship) list.get(i)).count / max > 0.5){
                stringBuilder.append(((Function3_relationship) list.get(i)).name + "：关系较亲密\n");
            }else if (((Function3_relationship) list.get(i)).count / max < 0.50 && ((Function3_relationship) list.get(i)).count / max > 0.25){
                stringBuilder.append(((Function3_relationship) list.get(i)).name + "：关系较薄弱\n");
            }else if (((Function3_relationship) list.get(i)).count / max < 0.25 && ((Function3_relationship) list.get(i)).count / max > 0){
                stringBuilder.append(((Function3_relationship) list.get(i)).name + "：关系薄弱\n");
            }
        }

        return String.valueOf(stringBuilder) + "\n（亲密度分级：100%关系最为亲密、75-100%关系亲密、50-75%关系较亲密、25-50%关系较薄弱、0-25%关系薄弱、0%毫无关系）";
    }

}
