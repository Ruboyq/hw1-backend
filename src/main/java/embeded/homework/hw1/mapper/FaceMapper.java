package embeded.homework.hw1.mapper;

import embeded.homework.hw1.Enum.UserSexEnum;
import embeded.homework.hw1.bean.Face;
import embeded.homework.hw1.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface FaceMapper {

    @Insert("insert into face(face_name,face_token) values(#{faceName},#{faceToken})")
    int insertFace(String faceName,String faceToken);

    @Select("SELECT * FROM face WHERE face_token = #{token}")
    Face selectByToken(String token);
}
