package com.hpp.servicehi.controller;

import com.hpp.servicehi.model.AuthInfo;
import com.hpp.servicehi.service.WxAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
    public String webAuth() {
        String url = "http://baidu.com";
        return url;
    }

    @RequestMapping("/test")
    public void test() {
        List<AuthInfo> a = wxAuthService.selectAll();
        wxAuthService.selectByPrimaryKey(1);
    }
}
