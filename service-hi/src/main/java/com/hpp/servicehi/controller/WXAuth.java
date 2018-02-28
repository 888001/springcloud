package com.hpp.servicehi.controller;

import com.hpp.servicehi.model.AuthInfo;
import com.hpp.servicehi.service.WxAuthService;
import com.hpp.servicehi.utils.WXJsonConvert;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @作者：胡鹏鹏
 * @创建时间：2018/2/26 21:47
 */
@RestController
@RequestMapping("wx/auth")
public class WXAuth {
    @Autowired
    WxAuthService wxAuthService;

    @RequestMapping("/way")
    public String authWay(String way) {
        if ("web".equals(way)) {
            return "redirect:wx/auth/web";
        }
        return "";
    }

    @RequestMapping("/web")
    @ResponseBody
    public Map webAuth(HttpServletRequest request, @ RequestBody Map<String,String> paraMap) throws Exception {
        //String appid_md5 =request.getParameter("appid");
        String appid_md5 =paraMap.get("appid");
        Map map = new HashMap<>();
        map.put("appidMd5",appid_md5);
        AuthInfo authInfo = wxAuthService.selectAuthInfoByAppidMD5(map);
        String appid = authInfo.getAppid();
        String redirect_url = authInfo.getRedirectUri();
        redirect_url = URLEncoder.encode(redirect_url,"utf-8");
        String scope = paraMap.get("scope");
        //state默认appid的md5加密
        String state = authInfo.getState();
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?";
        url=url+"appid="+appid+"&redirect_uri="+redirect_url+"&response_type=code&scope="+scope+"&state="+state+"#wechat_redirect";
        Map response = new HashMap();
        response.put("authUrl",url);
        return response;
    }
    @RequestMapping("/redirect")
    @ResponseBody
    public Map redirect(HttpServletRequest request ){
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        Map map = new HashMap<>();
        map.put("state",state);
        AuthInfo authInfo = wxAuthService.selectAuthInfoByState(map);
        String appid = authInfo.getAppid();
        String secret = authInfo.getAppsecret();

        String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+secret+"&code="+code+"&grant_type=authorization_code";
        //第二步：通过code换取网页授权access_token
        Map<String,Object> amap = new HashMap<String,Object>();
        amap.put("access_token","");
        amap.put("expires_in","");
        amap.put("refresh_token","");
        amap.put("openid","");
        amap.put("scope","");
        RestTemplate restTemplate  = new RestTemplate();
        restTemplate.getMessageConverters().add(new WXJsonConvert());

        Map json = restTemplate.getForObject(url, Map.class);
        //获取access_token
        String access_token = String.valueOf(json.get("access_token")) ;
        String expires_in = String.valueOf(json.get("expires_in"));
        String refresh_token = String.valueOf(json.get("refresh_token"));
        String openid = String.valueOf(json.get("openid"));
        String scope = String.valueOf( json.get("scope"));
        if("snsapi_userinfo".equals(scope)){
            //最后一步：拉取用户信息(需scope为 snsapi_userinfo)
            String getUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token="+access_token+"&openid="+openid+"&lang=zh_CN";
            Map userJson = restTemplate.getForObject(getUserInfoUrl,Map.class);
            return  userJson;

        }else if("snsapi_base".equals(scope)){
            //最后一步：拉取用户信息(需scope为 snsapi_userinfo)
            String getUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token="+access_token+"&openid="+openid+"&lang=zh_CN";
            Map userJson = restTemplate.getForObject(getUserInfoUrl,Map.class);
            return  userJson;
        }else {
            return  null;
        }
    }
}
