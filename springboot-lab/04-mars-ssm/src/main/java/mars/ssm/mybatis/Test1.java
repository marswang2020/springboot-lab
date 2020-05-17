package mars.ssm.mybatis;

import mars.ssm.dao.T_UserMapper;
import mars.ssm.pojo.T_User;
import mars.ssm.pojo.T_UserExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test1 {

    public static void main(String[] args) throws IOException {

        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new
                SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            T_UserMapper mapper = session.getMapper(T_UserMapper.class);
            T_UserExample user = new T_UserExample();
            T_UserExample.Criteria criteria =  user.createCriteria();
            criteria.andIdEqualTo(1);
            List<T_User> blog = mapper.selectByExample(user);
            System.out.println(blog);
        } finally {
            session.close();
        }
    }
}
