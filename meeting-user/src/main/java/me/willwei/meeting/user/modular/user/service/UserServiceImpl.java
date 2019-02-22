package me.willwei.meeting.user.modular.user.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.core.util.MD5Util;
import me.willwei.meeting.api.user.UserModel;
import me.willwei.meeting.api.user.UserService;
import me.willwei.meeting.api.user.UserVO;
import me.willwei.meeting.user.common.persistence.dao.UserTMapper;
import me.willwei.meeting.user.common.persistence.model.UserT;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

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
        return null;
    }

    @Override
    public UserVO updateUserInfo(UserVO userVO) {
        return null;
    }

}
