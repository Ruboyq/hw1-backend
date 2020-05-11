package embeded.homework.hw1.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;

public interface ImageService {
    public BufferedImage getImage();
    public JSONObject insertImage(MultipartFile multipartFile);
    public JSONObject insertGroup(String groupName);
    public JSONObject detectImage(String imgBase64);
    public JSONObject captureInsert(String userName,String imgBase64);
}
