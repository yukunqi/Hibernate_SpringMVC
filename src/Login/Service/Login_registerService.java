package Login.Service;


import Entity.User;

import java.util.Map;

/**
 *
 */
public interface Login_registerService {

    /**
     * 处理注册用户的数据
     * @return 返回注册状态码
     */
    public Map<String,Object> register_data(User user);

    /**
     * 处理用户登录数据
     * @param name
     * @param password
     * @return 返回状态码，用户id 用户验证token
     */
    public Map<String,Object> login_data(String name,String password);
}
