package me.willwei.meeting.film.modular.auth.validator.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import me.willwei.meeting.film.common.persistence.dao.UserMapper;
import me.willwei.meeting.film.modular.auth.validator.IReqValidator;
import me.willwei.meeting.film.common.persistence.model.User;
import me.willwei.meeting.film.modular.auth.validator.dto.Credence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账号密码验证
 *
 * @author fengshuonan
 * @date 2017-08-23 12:34
 */
@Service
public class DbValidator implements IReqValidator {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public boolean validate(Credence credence) {
        List<User> users = userMapper.selectList(new EntityWrapper<User>().eq("userName", credence.getCredenceName()));
        if (users != null && users.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
