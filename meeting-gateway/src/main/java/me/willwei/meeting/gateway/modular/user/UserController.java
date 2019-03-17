package me.willwei.meeting.gateway.modular.user;

import me.willwei.meeting.api.user.UserModel;
import me.willwei.meeting.api.user.UserService;
import me.willwei.meeting.gateway.modular.vo.ResponseVO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 *
 * @author leiming
 * @date 2019-03-17
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @Reference(version = "${user.service.version}")
    private UserService userService;

    @RequestMapping("register")
    public ResponseVO register(UserModel userModel) {
        if (userModel.getUsername() == null || userModel.getUsername().trim().length() == 0) {
            return ResponseVO.serviceFail("用户名不能为空");
        }
        if (userModel.getPassword() == null || userModel.getPassword().trim().length() == 0) {
            return ResponseVO.serviceFail("密码不能为空");
        }

        boolean isSuccessful = this.userService.register(userModel);
        if (isSuccessful) {
            return ResponseVO.success("注册成功");
        } else {
            return ResponseVO.serviceFail("注册失败");
        }
    }

}
