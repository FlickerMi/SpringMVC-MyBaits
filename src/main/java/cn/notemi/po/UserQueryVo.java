package cn.notemi.po;

import java.util.List;

/**
 * Title：UserQueryVo
 * Description：用户包装对象
 *
 * @author Flicker
 * @create 2017-01-17 下午 7:53
 **/
public class UserQueryVo {
    //用户信息
    private User user;

    //为了系统可扩展性，对原始po进行扩展
    private UserCustom userCustom;

    //批量商品信息
    private List<UserCustom> userCustomList;

    public List<UserCustom> getUserCustomList() {
        return userCustomList;
    }

    public void setUserCustomList(List<UserCustom> userCustomList) {
        this.userCustomList = userCustomList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserCustom getUserCustom() {
        return userCustom;
    }

    public void setUserCustom(UserCustom userCustom) {
        this.userCustom = userCustom;
    }
}
