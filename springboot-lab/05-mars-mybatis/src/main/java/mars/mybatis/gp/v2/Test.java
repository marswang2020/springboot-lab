package mars.mybatis.gp.v2;

import java.util.Locale;
import java.util.ResourceBundle;

public class Test {

    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        ResourceBundle mesql = ResourceBundle.getBundle("mesql",locale);
        ResourceBundle bundle = ResourceBundle.getBundle("sql",locale);
        ResourceBundle properties = ResourceBundle.getBundle("mybatis",locale);
    }
}
