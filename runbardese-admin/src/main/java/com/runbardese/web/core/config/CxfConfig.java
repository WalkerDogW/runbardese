//package com.runbardese.web.core.config;
//
//import com.runbardese.system.service.WsService;
//import org.apache.cxf.Bus;
//import org.apache.cxf.jaxws.EndpointImpl;
//import org.apache.cxf.transport.servlet.CXFServlet;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.xml.ws.Endpoint;
//
//@Configuration
//public class CxfConfig {
//    @Autowired
//    private Bus bus;
//
//    @Autowired
//    WsService wsService;
//
//    /**
//     * 此方法作用是改变项目中服务名的前缀名，此处127.0.0.1或者localhost不能访问时，请使用ipconfig查看本机ip来访问
//     * 此方法被注释后:wsdl访问地址为http://127.0.0.1:8080/services/user?wsdl
//     * 去掉注释后：wsdl访问地址为：http://127.0.0.1:8080/soap/user?wsdl
//     * @return
//     */
//    @SuppressWarnings("all")
//    @Bean
//    public ServletRegistrationBean dispatcherServlet() {
//        return new ServletRegistrationBean(new CXFServlet(), "/soap/*");
//    }
//
//    /** JAX-WS
//     * 站点服务
//     * **/
//    @Bean
//    public Endpoint endpoint() {
//        EndpointImpl endpoint = new EndpointImpl(bus, wsService);
//        endpoint.publish("/bds");
//        return endpoint;
//    }
//
//}
package com.runbardese.web.core.config;
import com.runbardese.system.service.impl.CodeQueryImpl;
import com.runbardese.system.service.impl.WsServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class CxfConfig {

//    @Autowired
//    private WsServiceImpl wsService;
//
//    @Autowired
//    private CodeQueryImpl codeQuery;
    /**
     * 为了不被springSecurity拦截，自定义暴露的路径
     * 默认为/services/**
     */
    @Bean
    public ServletRegistrationBean<CXFServlet> myServlet(){
        ServletRegistrationBean<CXFServlet> registrationBean =new ServletRegistrationBean<CXFServlet>(new CXFServlet(),"/api/*");
        return registrationBean;
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    //终端路径
//    @Bean
//    @Qualifier("U8CJaxRsServiceImpl")
//    public Endpoint endpointCodeQuery(CodeQueryImpl codeQueryImpl) {
//        EndpointImpl endpoint = new EndpointImpl(springBus(), codeQueryImpl);
//        //endpoint.getInInterceptors().add(new AuthInterceptor());//添加校验拦截器
//        endpoint.publish("/U8CService");
//        return endpoint;
//    }

    @Bean
    @Qualifier("wsServiceImpl")
    public Endpoint endpoint(WsServiceImpl wsServiceImpl) {
        EndpointImpl endpoint = new EndpointImpl(springBus(), wsServiceImpl);
        //endpoint.getInInterceptors().add(new AuthInterceptor());//添加校验拦截器
        endpoint.publish("/WebService");
        return endpoint;
    }

    @Bean("jsonProvider")
    public JacksonJsonProvider getJacksonJsonProvider(){
        return new JacksonJsonProvider();
    }
}
