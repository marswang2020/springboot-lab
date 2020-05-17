package mars.mybatis.gp.v1;

import mars.mybatis.gp.v1.mapper.BlogMapper;

public class MyBatisBoot {
    public static void main(String[] args) {
        SqlSession sqlSession = new SqlSession(new GPConfiguration(), new GPExecutor());
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        blogMapper.selectBlogById(1);
    }
}
