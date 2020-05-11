package embeded.homework.hw1.service;

import com.alibaba.fastjson.JSONObject;

public interface UserService {
    /** 查询单个*/
    public JSONObject login(String name, String password);
}