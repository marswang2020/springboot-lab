package mars.mybatis.gp.v1;

public class SqlSession {

    private GPConfiguration configuration;

    private GPExecutor executor;

    public SqlSession(GPConfiguration configuration, GPExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T selectOne(String statementId, Object parameter){
        String sql = GPConfiguration.sqlMappings.getString(statementId);
        return executor.query(sql,parameter);
    }

    public <T> T getMapper(Class clazz){
        return configuration.getMapper(clazz,this);
    }
}
