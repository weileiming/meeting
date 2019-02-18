package me.willwei.meeting.api.user;

/**
 * UserService
 *
 * @author leiming
 * @date 2019/2/13
 */
public interface UserService {

    int login(String username, String password);

    boolean register(UserModel userModel);

    boolean checkUserName(String username);

    UserVO getUserInfo(Integer uuid);

    UserVO updateUserInfo(UserVO userVO);

}
