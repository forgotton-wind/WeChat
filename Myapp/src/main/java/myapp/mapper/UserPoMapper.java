package myapp.mapper;

import myapp.model.UserPo;

public interface UserPoMapper {
    UserPo selectUserByLoginName(String loginName);
    Integer insertSelective(UserPo userPo);
    Integer updateByPrimaryKeySelective(UserPo userPo);
    Integer getIdByAccount(String account);
    Integer updateState(Integer state);
}
