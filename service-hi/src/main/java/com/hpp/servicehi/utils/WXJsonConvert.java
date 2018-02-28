package com.hpp.servicehi.utils;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * @作者：胡鹏鹏
 * @创建时间：2018/2/27 19:51
 */
public class WXJsonConvert extends MappingJackson2HttpMessageConverter {
    public WXJsonConvert(){
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.TEXT_PLAIN);
        setSupportedMediaTypes(mediaTypes);// tag6
    }
}
