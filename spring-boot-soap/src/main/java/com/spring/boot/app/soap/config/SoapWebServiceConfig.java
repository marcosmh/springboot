package com.spring.boot.app.soap.config;

import com.spring.boot.app.soap.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;


@EnableWs
@Configuration
public class SoapWebServiceConfig extends WsConfigurerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SoapWebServiceConfig.class);

    public SoapWebServiceConfig() {
        LOGGER.info("SoapWebServiceConfig ... ");
    }

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        LOGGER.info("SoapWebServiceConfig::messageDispatcherServlet");
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet,"/soapWS/*");
    }

    @Bean
    public XsdSchema userSchema() {
        LOGGER.info("SoapWebServiceConfig::XsdSchema");
        return new SimpleXsdSchema(new ClassPathResource("users.xsd"));
    }

    @Bean
    public DefaultWsdl11Definition defaultWsdlDefinition(XsdSchema userSchema) {
        LOGGER.info("SoapWebServiceConfig::defaultWsdlDefinition");
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        try {
            definition.setSchema(userSchema);
            definition.setLocationUri("/soapWS");
            definition.setPortTypeName("UserService");
            definition.setTargetNamespace("http://markcode.com/spring-booot-soap");
        } catch(Exception e) {
            LOGGER.error("Errror::DefaultWsdl11Definition => ",e);
        }

        return definition;
    }
}
