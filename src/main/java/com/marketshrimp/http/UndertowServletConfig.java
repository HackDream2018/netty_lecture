/*
package com.marketshrimp.http;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.wd.common.core.utils.CustomDefaultStringEncryptor;
import lombok.Getter;
import lombok.Setter;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

*/
/**
 * Created by liufeng on 2017/2/20.
 *//*

@Getter
@Setter
@Configuration
public class UndertowServletConfig {
    @Value("${undertow.servlet.port}")
    private int port;
    @Value("${undertow.servlet.contextPath}")
    private String contextPath;

    @Bean
    public EmbeddedServletContainerFactory servletContainer(){
        UndertowEmbeddedServletContainerFactory factory = new UndertowEmbeddedServletContainerFactory();
        factory.setPort(port);
        factory.setContextPath(contextPath);
        return factory;
    }

    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        return new CustomDefaultStringEncryptor();
    }

    @Bean(name="restTemplate")
    public RestTemplate restTemplate(){
        RestTemplate  restTemplate=	 new RestTemplate(simpleClientHttpRequestFactory());
        restTemplate.getMessageConverters().add(new FastJsonHttpMessageConverter());
        return restTemplate;
    }

    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        try {
            return new HttpComponentsClientHttpRequestFactory(httpClient());
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
            factory.setReadTimeout(15000);// ms
            factory.setConnectTimeout(15000);// ms
            return factory;
        }
    }

    */
/**
     *
     * @return
     * @throws KeyManagementException
     * @throws NoSuchAlgorithmException
     *//*

    public HttpClient httpClient() throws KeyManagementException, NoSuchAlgorithmException {
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory> create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                //.register("https", SSLConnectionSocketFactory.getSocketFactory())
                //采用绕过验证的方式处理https请求
                .register("https", new SSLConnectionSocketFactory(createIgnoreVerifySSL()))
                .build();
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(registry);
        connectionManager.setMaxTotal(100);
        connectionManager.setDefaultMaxPerRoute(100);

        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(15000)
                .setConnectTimeout(15000)
                .setConnectionRequestTimeout(20000)
                .build();

        return HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .setConnectionManager(connectionManager)
                .build();
    }

    */
/**
     * 绕过验证
     *
     * @return
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     *//*

    public static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sc = SSLContext.getInstance("SSLv3");

        // 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
        X509TrustManager trustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) { }
            @Override
            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) {
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };

        sc.init(null, new TrustManager[]{trustManager}, null);
        return sc;
    }

}
*/
