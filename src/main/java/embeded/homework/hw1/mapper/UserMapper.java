package embeded.homework.hw1.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import embeded.homework.hw1.Enum.UserSexEnum;
import embeded.homework.hw1.bean.User;

@Repository
public interface UserMapper {

    @Select("SELECT * FROM users WHERE userName = #{name}")
    @Results({
            @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    User selectByName(String name);

}
