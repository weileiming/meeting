package me.willwei.meeting.gateway.common;

/**
 * CurrentUser
 *
 * @author leiming
 * @date 2019/2/20
 */
public class CurrentUser {

    /**
     * 线程绑定的存储空间
     */
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    /**
     * 将用户信息放入存储空间
     *
     * @param userId
     */
    public static void saveUserId(String userId) {
        threadLocal.set(userId);
    }

    /**
     * 将用户信息去除
     *
     * @return
     */
    public static String getCurrentUser() {
        return threadLocal.get();
    }

//    /**
//     * 将用户信息放入存储空间
//     *
//     * @param userVO
//     */
//    public static void saveUserInfo(UserVO userVO) {
//        threadLocal.set(userVO);
//    }
//
//    /**
//     * 将用户信息去除
//     *
//     * @return
//     */
//    public static UserVO getCurrentUser() {
//        return threadLocal.get();
//    }

}
