package com.example.restful_web_service;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.example.demo_1.Demo1Application;

@SpringBootApplication
public class RestfulWebServiceApplication {

		public static void main(String[] args) {
			SpringApplication.run(RestfulWebServiceApplication.class, args);
		
		}
//		@Bean(name="entityManagerFactory")
//		@Primary
//		public LocalSessionFactoryBean sessionFactory() {
//		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//		return sessionFactory;
//		}
		
		//for internationalisation
		@Bean
		public LocaleResolver localeResolver() {
			SessionLocaleResolver slr=new SessionLocaleResolver();
			slr.setDefaultLocale(Locale.US);
			return slr;
		}
		
		//for internationalisation
		@Bean
		//@Primary
		public ResourceBundleMessageSource bms() {
			ResourceBundleMessageSource rm=new ResourceBundleMessageSource();
			rm.setBasename("message");
			return rm;
		}
}
