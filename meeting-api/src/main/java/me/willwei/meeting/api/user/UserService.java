package me.willwei.meeting.api.user;

/**
 * UserService
 *
 * @author leiming
 * @date 2019/2/13
 */
public interface UserService {

    boolean login(String username, String password);

    String sayHello(String name);

}
