package cn.notemi.service;

import cn.notemi.po.User;
import cn.notemi.po.UserCustom;
import cn.notemi.po.UserQueryVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Title：UserService
 * Description：用户管理service
 *
 * @author Flicker
 * @create 2017-01-18 下午 4:39
 **/
public interface UserService {
    User Login(User user) throws Exception;
    int add(UserCustom userCustom) throws Exception;
    int deleteById(Integer id) throws Exception;
    int updateChoose(User user) throws Exception;
    UserCustom selectById(Integer id) throws Exception;
    List<UserCustom> selectChooseList(UserQueryVo userQueryVo) throws Exception;
}
