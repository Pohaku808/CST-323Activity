package com.jads;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.jads.business.LoginBusinessService;
import com.jads.business.ProductBusinessService;
import com.jads.business.RegisterBusinessService;


/**
 * Spring Configuration class
 */
@Configuration
public class SpringConfig 
{
	/**
	 * Spring bean for loginBusinessService
	 * @return
	 */
    @Bean(name="loginBusinessService", initMethod="init", destroyMethod="destroy")
    @RequestScope
    public  LoginBusinessService processLogin() {
        return new LoginBusinessService();
    }
    
    /**
     * Spring bean for registerBusinessService
     * @return
     */
    @Bean(name="registerBusinessService", initMethod="init", destroyMethod="destroy")
    @RequestScope 
    public  RegisterBusinessService processRegister() {
        return new RegisterBusinessService();
    }
    
    /**
     * Spring bean for productBusinessService
     * @return
     */
    @Bean(name="productBusinessService", initMethod="init", destroyMethod="destroy")
    @SessionScope
    public  ProductBusinessService getproductsBusiness() {
        return new ProductBusinessService();
    }
}
