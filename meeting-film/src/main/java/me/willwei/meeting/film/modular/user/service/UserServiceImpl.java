package me.willwei.meeting.film.modular.user.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.core.util.MD5Util;
import me.willwei.meeting.api.user.UserModel;
import me.willwei.meeting.api.user.UserService;
import me.willwei.meeting.api.user.UserVO;
import me.willwei.meeting.film.common.persistence.dao.UserTMapper;
import me.willwei.meeting.film.common.persistence.model.UserT;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

/**
 * UserServiceImpl
 *
 * @author leiming
 * @date 2019/2/13
 */
@Service(version = "${user.service.version}")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserTMapper userTMapper;

    @Override
    public int login(String username, String password) {
        UserT userT = new UserT();
        userT.setUserName(username);
        UserT result = this.userTMapper.selectOne(userT);

        if (result != null && result.getUuid() > 0) {
            String md5Pwd = MD5Util.encrypt(password);
            if (result.getUserPwd().equals(md5Pwd)) {
                return result.getUuid();
            }
        }
        return 0;
    }

    @Override
    public boolean register(UserModel userModel) {
        // 将注册信息实体转换为数据实体
        UserT userT = new UserT();
        userT.setUserName(userModel.getUsername());
        userT.setUserPhone(userModel.getPhone());
        userT.setEmail(userModel.getEmail());
        userT.setAddress(userModel.getAddress());
        // 创建时间和修改时间 -> CURRENT_TIMESTAMP
        // 数据加密【MD5混淆加密 + 盐值 -> Shiro加密】
        String md5Pwd = MD5Util.encrypt(userModel.getPassword());
        userT.setUserPwd(md5Pwd);

        // 将数据实体存入数据库
        Integer insert = this.userTMapper.insert(userT);
        if (insert > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkUserName(String username) {
        EntityWrapper<UserT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("user_name", username);
        Integer result = this.userTMapper.selectCount(entityWrapper);

        if (result != null && result > 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public UserVO getUserInfo(Integer uuid) {
        UserT userT = this.userTMapper.selectById(uuid);
        UserVO userVO = this.do2UserVO(userT);
        return userVO;
    }

    @Override
    public UserVO updateUserInfo(UserVO userVO) {
        UserT userT = new UserT();
        userT.setUuid(userVO.getUuid());
        userT.setNickName(userVO.getNickname());
        userT.setLifeState(Integer.valueOf(userVO.getLifeState()));
        userT.setBirthday(userVO.getBirthday());
        userT.setBiography(userVO.getBiography());
//        userT.setBeginTime(new Date(userVO.getBeginTime()));
        userT.setHeadUrl(userVO.getHeadAddress());
        userT.setEmail(userVO.getEmail());
        userT.setAddress(userVO.getAddress());
        userT.setUserPhone(userVO.getPhone());
        userT.setUserSex(userVO.getSex());
        userT.setUpdateTime(new Date(System.currentTimeMillis()));

        Integer isSuccessful = this.userTMapper.updateById(userT);
        if (isSuccessful > 0) {
            return this.getUserInfo(userT.getUuid());
        } else {
            return userVO;
        }
    }

    private UserVO do2UserVO(UserT userT) {
        UserVO userVO = new UserVO();
        userVO.setUuid(userT.getUuid());
        userVO.setHeadAddress(userT.getHeadUrl());
        userVO.setPhone(userT.getUserPhone());
        userVO.setUpdateTime(userT.getUpdateTime().getTime());
        userVO.setEmail(userT.getEmail());
        userVO.setUsername(userT.getUserName());
        userVO.setNickname(userT.getNickName());
        userVO.setLifeState(String.valueOf(userT.getLifeState()));
        userVO.setBirthday(userT.getBirthday());
        userVO.setAddress(userT.getAddress());
        userVO.setSex(userT.getUserSex());
        userVO.setBeginTime(userT.getBeginTime().getTime());
        userVO.setBiography(userT.getBiography());

        return userVO;
    }

}
