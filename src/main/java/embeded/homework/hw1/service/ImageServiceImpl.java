package embeded.homework.hw1.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.ds.openimaj.OpenImajDriver;
import embeded.homework.hw1.mapper.FaceMapper;
import embeded.homework.hw1.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.awt.image.BufferedImage;

@Service
public class ImageServiceImpl implements ImageService{
    @Autowired
    FaceMapper faceMapper;

    @Override
    public BufferedImage getImage() {
        Webcam.setDriver(new OpenImajDriver());
        Webcam webcam = Webcam.getDefault();
        webcam.open();
        return webcam.getImage();
    }

    @Override
    public JSONObject insertImage(MultipartFile multipartFile) {

        String originalFilenameNoPostfix = multipartFile.getOriginalFilename().substring(0, multipartFile.getOriginalFilename().lastIndexOf("."));
        System.out.println(originalFilenameNoPostfix);
        String[] infos = originalFilenameNoPostfix.split("_");
        JSONObject jo = new JSONObject();
        jo.put("status","200");
        try {
            String result = ImageUtil.add(multipartFile.getInputStream(), infos[0], infos[1]);
            jo.put("msg", result);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return jo;
    }

    @Override
    public JSONObject insertGroup(String groupName) {
        JSONObject jo = new JSONObject();
        jo.put("status","200");
        jo.put("msg", ImageUtil.groupAdd(groupName));
        return jo;
    }

    @Override
    public JSONObject detectImage(String imgBase64) {
        JSONObject jo = new JSONObject();
        jo.put("status","200");
        String result = ImageUtil.faceSearch(imgBase64);
        JSONObject jsonObject = new JSONObject().parseObject(result);
        JSONObject jsonObject2 = jsonObject.getJSONObject("result");
        if(jsonObject2 == null){
            jo.put("msg", "对比库中查无此人");
            return jo;
        }
        JSONArray arr = jsonObject2.getJSONArray("user_list");
        JSONObject tmp = arr.getJSONObject(0);
        jo.put("msg", tmp.getString("user_id")+"       score:"+String.format("%.2f",Float.parseFloat(tmp.getString("score"))));
        return jo;
    }

    @Override
    public JSONObject captureInsert(String userName,String imgBase64) {
        JSONObject jo = new JSONObject();
        jo.put("status","200");
        try {
            String result = ImageUtil.add(imgBase64,userName, "group1");
            jo.put("msg", result);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return jo;
    }
}
