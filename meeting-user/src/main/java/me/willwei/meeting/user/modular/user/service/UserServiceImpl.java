package me.willwei.meeting.user.modular.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import me.willwei.meeting.api.user.UserService;
import org.springframework.beans.factory.annotation.Value;

/**
 * UserServiceImpl
 *
 * @author leiming
 * @date 2019/2/13
 */
@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {

    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public boolean login(String username, String password) {
        System.out.println("this is user service: " + username + ", " + password);
        return false;
    }

    @Override
    public String sayHello(String name) {
        return String.format("[%s] : Hello, %s", serviceName, name);
    }

}
