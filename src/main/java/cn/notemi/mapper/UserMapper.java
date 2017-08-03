package cn.notemi.mapper;

import cn.notemi.po.User;
import cn.notemi.po.UserCustom;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    @Select({
            "select * from user WHERE ",
            "email=#{email,jdbcType=VARCHAR} and password=#{password,jdbcType=VARCHAR}",
            "limit 1"
    })
    User login(User record);

    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into user (id, username, ",
        "password, email, ",
        "creattime)",
        "values (#{id,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
        "#{creattime,jdbcType=TIMESTAMP})"
    })
    int insert(User record);

    int insertSelective(UserCustom record);

    @Select({
        "select * from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    UserCustom selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
        "set username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "creattime = #{creattime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}