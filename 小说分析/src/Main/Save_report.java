package Main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 爱吃皮蛋的元包
 * @Date: 2022/03/07/1:08
 * @Description:保存功能
 */
public class Save_report {

    public static void Save_report(String text){

        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\31031.000\\Desktop\\save.txt")) {
            fos.write(text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
