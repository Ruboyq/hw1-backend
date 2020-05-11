package embeded.homework.hw1.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import embeded.homework.hw1.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@RequestMapping(value =  "/image")
public class ImageController {
    @Autowired
    ImageService imageService;

    @RequestMapping(value = "/get",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public BufferedImage getImage() throws IOException {
        return imageService.getImage();
    }

    @PostMapping(value = "/insert")
    public JSONObject insertImage(@RequestParam("file") MultipartFile multipartFile) {
        return imageService.insertImage(multipartFile);
    }

    @PostMapping(value = "/group/insert")
    public JSONObject insertGroup(@RequestBody JsonNode jsonNode) {
        String groupName = jsonNode.hasNonNull("groupName") ? jsonNode.get("groupName").textValue() : null;
        return imageService.insertGroup(groupName);
    }
    @PostMapping(value = "/detect")
    public JSONObject detectImage(@RequestBody JsonNode jsonNode) {
        String img = jsonNode.hasNonNull("img") ? jsonNode.get("img").textValue() : null;
        return imageService.detectImage(img);
    }

    @PostMapping(value = "/capture/insert")
    public JSONObject captureInsert(@RequestBody JsonNode jsonNode) {
        String img = jsonNode.hasNonNull("img") ? jsonNode.get("img").textValue() : null;
        return imageService.captureInsert("yjp",img);
    }
}
