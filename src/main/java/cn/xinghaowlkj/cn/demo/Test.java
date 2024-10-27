package cn.xinghaowlkj.cn.demo;

import cn.xinghaowlkj.cn.demo.utils.JWTUtils;
import cn.xinghaowlkj.cn.demo.utils.Requst.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Test {
    @GetMapping("/get")
    public Result<String> onGet(String openid){
        Map<String,String> tokenmap=new HashMap<>();
        tokenmap.put("openid",openid);
        return Result.success(JWTUtils.getToken(Map.of(
                "openid", openid)
        ));
    }

    @GetMapping("/decode")
    public Result<Map<String, String>> decode(String token){
        return Result.success(Map.of(
                "openid", JWTUtils.verify(token).getClaim("openid").asString()
        ));
    }
}
