package cn.xinghaowlkj.cn.demo.utils;

import cn.xinghaowlkj.cn.demo.DemoApplication;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JWTUtils {
    /**
     * 获取token
     * @param map
     * @return
     */
    public static String getToken(Map<String,String> map){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE,DemoApplication.jwt_time);
        //创建JWT Builder
        JWTCreator.Builder builder = JWT.create();
        map.forEach(builder::withClaim);
        return builder.withExpiresAt(instance.getTime()).sign(Algorithm.HMAC256(DemoApplication.jwt_key));
    }

    /**
     * 验证token合法性
     * @param token
     * @return
     */
    public static DecodedJWT verify(String token){
        return JWT.require(Algorithm.HMAC256(DemoApplication.jwt_key)).build().verify(token);
    }

}
