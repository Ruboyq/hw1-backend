package embeded.homework.hw1.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import embeded.homework.hw1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "login")
    public JSONObject getUser(@RequestBody JsonNode jsonNode) {
        String userName = jsonNode.hasNonNull("userName") ? jsonNode.get("userName").textValue() : null;
        String password = jsonNode.hasNonNull("password") ? jsonNode.get("password").textValue() : null;
        return userService.login(userName, password);
    }
}
