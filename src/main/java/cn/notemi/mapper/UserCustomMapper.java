package cn.notemi.mapper;

import cn.notemi.po.User;
import cn.notemi.po.UserCustom;
import cn.notemi.po.UserQueryVo;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserCustomMapper {

    //根据用户名查询
    List<UserCustom> selectByUsername(UserQueryVo userQueryVo)throws Exception;

    List<UserCustom> selectChooseList(UserQueryVo userQueryVo)throws Exception;

}