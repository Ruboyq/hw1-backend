package embeded.homework.hw1.service;

import com.alibaba.fastjson.JSONObject;
import embeded.homework.hw1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import embeded.homework.hw1.bean.User;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    /**
     * 查询单个
     *
     * @param name
     */
    @Override
    public JSONObject login(String name, String password) {
        User user = userMapper.selectByName(name);
        JSONObject jo = new JSONObject();
        if(user == null){
            jo.put("status","454");
            jo.put("msg","用户不存在");
        }
        else if(user.getPassWord().equals(password)){
            jo.put("status","200");
            jo.put("msg","登录成功");
        }else{
            jo.put("status","454");
            jo.put("msg","用户名或密码错误");
            jo.put("user",user);
        }
        return jo;
    }
}
