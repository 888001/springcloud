package com.hpp.servicehi.controller;

import com.hpp.servicehi.utils.SHA1;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * @作者：胡鹏鹏
 * @创建时间：2018/2/27 15:49
 */
@RestController
public class Common {
    private Logger log =Logger.getLogger(this.getClass().getName());
    @RequestMapping("/a")
    public void common(HttpServletRequest request, HttpServletResponse response ) throws Exception {
        String echostr = request.getParameter("echostr");
        response.getWriter().print(echostr);
    }
}
