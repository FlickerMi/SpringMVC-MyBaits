package cn.notemi.service.impl;

import cn.notemi.exception.CustomException;
import cn.notemi.mapper.UserCustomMapper;
import cn.notemi.mapper.UserMapper;
import cn.notemi.po.User;
import cn.notemi.po.UserCustom;
import cn.notemi.po.UserQueryVo;
import cn.notemi.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Title：UserServiceImpl
 * Description：
 *
 * @author Flicker
 * @create 2017-01-18 下午 4:43
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserCustomMapper userCustomMapper;

    /**
     * 登录验证
     * @param user 邮箱和密码
     * @return
     * @throws Exception
     */
    public User Login(User user) throws Exception{
        return this.userMapper.login(user);
    }
    /**
     * 添加用户
     * @param userCustom 用户
     * @return
     */
    public int add(UserCustom userCustom) throws Exception{
        return this.userMapper.insertSelective(userCustom);
    }
    /**
     * 删除用户
     * @param id 要删除的用户id
     * @return
     */
    public int deleteById(Integer id) throws Exception{
        return this.userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据id更新用户
     * @param user 要更新的user属性
     * @return
     */
    public int updateChoose(User user) throws Exception{
        return this.userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 根据id查询用户
     * @param id 用户id
     * @return UserCustom对象
     */
    public UserCustom selectById(Integer id) throws Exception{
//        return this.userMapper.selectByPrimaryKey(id);
        User user = this.userMapper.selectByPrimaryKey(id);
        if (id == null){
            throw new CustomException("用户id不能为空");
        }
        //这中间可以进行业务处理
        UserCustom userCustom = new UserCustom();
        BeanUtils.copyProperties(user,userCustom);
        return userCustom;
    }

    /**
     * 根据传入的userQueryVo包装对象的属性来查询
     * @param userQueryVo user包装对象
     * @return UserCustom List
     * @throws Exception
     */
    public List<UserCustom> selectChooseList(UserQueryVo userQueryVo) throws Exception{
        return this.userCustomMapper.selectChooseList(userQueryVo);
    }

}
