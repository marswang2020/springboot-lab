package mars.mybatis.gp.v2.executor;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class SimpleExecutor implements Executor {
    @Override
    public <T> T query(String statement, Object[] parameter, Class pojo) {
        StatementHandler statementHandler = new StatementHandler();
        return statementHandler.query(statement, parameter, pojo);
    }
}
