package me.willwei.meeting.user.modular.user.service;

import me.willwei.meeting.api.user.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * UserServiceImpl
 *
 * @author leiming
 * @date 2019/2/13
 */
@Service(version = "${user.service.version}")
public class UserServiceImpl implements UserService {

    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public boolean login(String username, String password) {
        System.out.println(serviceName + ": " + "this is user service: " + username + ", " + password);
        return false;
    }

}
