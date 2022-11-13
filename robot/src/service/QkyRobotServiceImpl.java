package service;

import com.google.gson.Gson;
import model.Response;
import util.HttpUtils;

public class QkyRobotServiceImpl implements RobotService{

    private static final String apiTpl = "http://api.qingyunke.com/api.php?key=free&appid=0&msg=%s";
    private static final Gson gson = new Gson();

    @Override
    public Response qa(String msg) throws Exception {

        //找到apiTpl中的%s然后替换成msg的内容
        String api = String.format(apiTpl,msg);
        String result = HttpUtils.request(api);
        //解析成response对象
        Response response = gson.fromJson(result,Response.class);
        return response;
    }


}
