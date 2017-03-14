package Login.DAO;

import Entity.User;

import java.util.Map;

/**
 *
 */
public interface Login_registerDAO {

    /**
     * 用户注册数据接口
     * @return  注册状态码
     */
     int SaveUserData(User user);

    /**
     * 用户登录后返回的验证token
     * @param userId 根据userid去查询用户token
     * @return 返回查询到的token和状态码
     */
    public String GetUserToken(Long userId);

    /**
     * 用户登录验证接口，
     * @param name   用户名
     * @param password   密码
     * @return  用户id和用户token的集合
     */
    public Map<String,Object> query_user_login(String name,String password);

    int cache_User();
}
