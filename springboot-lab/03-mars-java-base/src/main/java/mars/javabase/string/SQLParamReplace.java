package mars.javabase.string;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SQLParamReplace {

    public static void main(String[] args) {

        String sql = "select * from ac01 where aac001 = ? and aac147 = ? and aac005 = ?";
        Integer aac001 = 141123411;
        String aac147 = "52212419891005243X";
        Date date = new Date();

        List<Object> params = new ArrayList<Object>();
        params.add(aac001);
        params.add(aac147);
        params.add(date);

        sql = sqlParamReplace(sql,params);
        System.out.println(sql);
    }

    public static String sqlParamReplace(String  sql,List<Object> params){
        String[] sqlParamsList = sql.split("\\?");

        if (params.size() != sqlParamsList.length){
            System.err.println("参数个数不匹配");
        }else{
            for (Object value:params) {
                if (value instanceof String){
                    String valueStr = "'" + value.toString() + "'";
                    sql = sql.replaceFirst("\\?",  valueStr);
                }else if (value instanceof Date){
                    DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.CHINA);
                    String valueStr = "'" + formatter.format(value) + "'";
                    sql = sql.replaceFirst("\\?",  valueStr);
                }else{
                    sql = sql.replaceFirst("\\?", String.valueOf(value));
                }
            }
        }
        return sql;
    }

}
