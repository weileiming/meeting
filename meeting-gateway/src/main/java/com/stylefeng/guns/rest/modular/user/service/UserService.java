package com.stylefeng.guns.rest.modular.user.service;

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
