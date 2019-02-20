package me.willwei.meeting.gateway.modular.auth.controller;

import me.willwei.meeting.api.user.UserService;
import me.willwei.meeting.gateway.modular.auth.controller.dto.AuthRequest;
import me.willwei.meeting.gateway.modular.auth.controller.dto.AuthResponse;
import me.willwei.meeting.gateway.modular.auth.util.JwtTokenUtil;
import me.willwei.meeting.gateway.modular.vo.ResponseVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 请求验证的
 *
 * @author fengshuonan
 * @Date 2017/8/24 14:22
 */
@RestController
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Reference(version = "${user.service.version}")
    private UserService userService;

    @RequestMapping(value = "${jwt.auth-path}")
    public ResponseVO createAuthenticationToken(AuthRequest authRequest) {
        boolean validate = true;

        // 去掉guns自带的用户名密码验证机制，使用自己的
        int userId = userService.login(authRequest.getUserName(), authRequest.getPassword());
        if (userId == 0) {
            validate = false;
        }

        if (validate) {
            // 生成randomKey和token
            final String randomKey = jwtTokenUtil.getRandomKey();
            final String token = jwtTokenUtil.generateToken(String.valueOf(userId), randomKey);
            return ResponseVO.success(new AuthResponse(token, randomKey));
        } else {
            return ResponseVO.serviceFail("用户名或密码错误");
        }
    }

}
