package com.spring.bean;

/**
 * @Author: 周 杰
 * @Date: 2022/11/14/下午9:49
 * @Description:
 */
public class UserService {

    private String uId;

    private UserDao userDao;

    public String queryUserInfo(){
        return userDao.queryUserName(uId);
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
