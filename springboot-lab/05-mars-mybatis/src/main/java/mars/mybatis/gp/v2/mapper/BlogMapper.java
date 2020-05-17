package mars.mybatis.gp.v2.mapper;


import mars.mybatis.gp.v2.annotation.Entity;
import mars.mybatis.gp.v2.annotation.Select;

import java.util.List;

@Entity(Blog.class)
public interface BlogMapper {
    /**
     * 根据主键查询文章
     * @param bid
     * @return
     */
    @Select("select * from blog where bid = ?")
    public Blog selectBlogById(Integer bid);

    public List<Blog> selectList();

}
