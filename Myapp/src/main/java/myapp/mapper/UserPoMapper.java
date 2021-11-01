package myapp.mapper;

import io.swagger.models.auth.In;
import myapp.model.UserPo;

public interface UserPoMapper {
    //根据loginName查询user
    UserPo selectUserByLoginName(String loginName);
    //插入(非空项)
    Integer insertSelective(UserPo userPo);
    //根据主键更新信息
    Integer updateByPrimaryKeySelective(UserPo userPo);
}
