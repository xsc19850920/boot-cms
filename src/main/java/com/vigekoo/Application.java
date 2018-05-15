package com.vigekoo;

import java.net.InetAddress;
import java.util.HashSet;
import java.util.Set;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.vigekoo.common.utils.SpringContextUtils;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    protected final static Logger log = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args) throws Exception {
//    	System.setProperty("http.proxySet", "true");  
//        System.setProperty("http.proxyHost", "58.2.221.9");  
//        System.setProperty("http.proxyPort", "80");  
    	
        log.debug("start application...");
        SpringApplication app = new SpringApplication(Application.class);
        Set<Object> set = new HashSet<>();
        if (set.size() > 0)
            app.setSources(set);
        app.run(args);
        try {
            String serverIp = InetAddress.getLocalHost().getHostAddress();
            log.info("app started. http://" + serverIp + ":" + SpringContextUtils.getPort() + SpringContextUtils.getContentPath());
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }
    
    //Tomcat large file upload connection reset
    //http://www.mkyong.com/spring/spring-file-upload-and-connection-reset-issue/
    @Bean
    public TomcatEmbeddedServletContainerFactory tomcatEmbedded() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
        tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
            if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
                //-1 means unlimited
                ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
            }
        });
        return tomcat;
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}
