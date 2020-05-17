package mars.ssm.dao;

import java.util.List;
import mars.ssm.pojo.T_User;
import mars.ssm.pojo.T_UserExample;
import mars.ssm.pojo.T_UserKey;
import org.apache.ibatis.annotations.Param;

public interface T_UserMapper {
    long countByExample(T_UserExample example);

    int deleteByExample(T_UserExample example);

    int deleteByPrimaryKey(T_UserKey key);

    int insert(T_User record);

    int insertSelective(T_User record);

    List<T_User> selectByExample(T_UserExample example);

    T_User selectByPrimaryKey(T_UserKey key);

    int updateByExampleSelective(@Param("record") T_User record, @Param("example") T_UserExample example);

    int updateByExample(@Param("record") T_User record, @Param("example") T_UserExample example);

    int updateByPrimaryKeySelective(T_User record);

    int updateByPrimaryKey(T_User record);
}