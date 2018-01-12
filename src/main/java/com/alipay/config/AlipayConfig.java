package com.alipay.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * AlipayConfig created with IntelliJ IDEA.
 * User: PengFei
 * Date: 2018-01-12
 * Time: 10:25
 */
@ConfigurationProperties(prefix = "alipay")
@PropertySource("classpath:/config/alipay.properties")
@Component
public class AlipayConfig {

    /**
     * 支付宝网关
     */
    private String url;

    /**
     * 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
     */
    private String appId;

    /**
     * 商户私钥，您的PKCS8格式RSA2私钥
     */
    private String appPrivateKey;

    /**
     * 仅支持JSON
     */
    private String format;

    /**
     * 字符编码格式
     */
    private String charset;

    /**
     * 支付宝公钥
     */
    private String alipayPublicKey;

    /**
     * 签名方式 支付宝推荐用RSA2 更安全
     */
    private String signType;

    /**
     * 固定格式 必填
     */
    private String productCode;

    /**
     * 页面跳转同步通知页面路径
     */
    private String returnUrl;

    /**
     * 服务器异步通知页面路径
     */
    private String notifyUrl;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppPrivateKey() {
        return appPrivateKey;
    }

    public void setAppPrivateKey(String appPrivateKey) {
        this.appPrivateKey = appPrivateKey;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
}
