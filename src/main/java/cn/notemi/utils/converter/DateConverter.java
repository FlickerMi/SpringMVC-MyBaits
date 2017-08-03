package cn.notemi.utils.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Title：DateConverter
 * Description：自定义的日期类型转换器
 *
 * @author Flicker
 * @create 2017-01-20 下午 1:52
 **/
public class DateConverter implements Converter<String,Date> {
    public Date convert(String source) {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            //成功
            return simpleDateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
