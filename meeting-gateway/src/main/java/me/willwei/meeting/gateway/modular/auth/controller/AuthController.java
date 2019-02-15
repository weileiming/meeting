package me.willwei.meeting.gateway.modular.auth.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.core.exception.GunsException;
import me.willwei.meeting.api.user.UserService;
import me.willwei.meeting.gateway.common.exception.BizExceptionEnum;
import me.willwei.meeting.gateway.modular.auth.controller.dto.AuthRequest;
import me.willwei.meeting.gateway.modular.auth.controller.dto.AuthResponse;
import me.willwei.meeting.gateway.modular.auth.util.JwtTokenUtil;
import me.willwei.meeting.gateway.modular.auth.validator.IReqValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @Resource(name = "simpleValidator")
    private IReqValidator reqValidator;

    @Reference(version = "1.0.0")
    private UserService userService;

    @RequestMapping(value = "${jwt.auth-path}")
    public ResponseEntity<?> createAuthenticationToken(AuthRequest authRequest) {
        userService.login(authRequest.getUserName(), authRequest.getPassword());

        boolean validate = reqValidator.validate(authRequest);

        if (validate) {
            final String randomKey = jwtTokenUtil.getRandomKey();
            final String token = jwtTokenUtil.generateToken(authRequest.getUserName(), randomKey);
            return ResponseEntity.ok(new AuthResponse(token, randomKey));
        } else {
            throw new GunsException(BizExceptionEnum.AUTH_REQUEST_ERROR);
        }
    }
}
