package com.wode.tomcat;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Administrator on 2018/11/6 0006.
 */
public class ServletMappingConfig {
    public static List<ServletMapping> servletMappingList = new ArrayList<>();
    static {
        //此处是手动写死的
        //应该从配置文件获取
        // 比如Tomcat的web.xml
        servletMappingList.add(new ServletMapping("helloWorldServlet","/world","com.wode.tomcat.HelloWorldServlet"));
    }
}
