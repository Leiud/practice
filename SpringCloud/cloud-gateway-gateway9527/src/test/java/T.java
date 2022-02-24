import java.time.ZonedDateTime;

/**
 * @author echo
 * @date 2021年 12月 29日 17:50
 */
public class T {

    public static void main(String[] args) {
        //获取当前时间串
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
        // 2021-12-29T17:51:00.951916200+08:00[Asia/Shanghai]
    }
}
