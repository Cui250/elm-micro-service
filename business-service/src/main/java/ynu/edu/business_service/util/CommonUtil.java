package ynu.edu.business_service.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {

    /**
     * 获取当前日期，格式化为 yyyy-MM-dd
     * @return 当前日期的字符串表示
     */
    public static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Date());
    }

    // 可以添加更多通用工具方法
}