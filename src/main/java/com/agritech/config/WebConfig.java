package com.agritech.config;
import org.springframework.context.annotation.*; import org.springframework.web.servlet.config.annotation.*; import org.thymeleaf.spring5.SpringTemplateEngine; import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver; import org.thymeleaf.spring5.view.ThymeleafViewResolver;
@Configuration @EnableWebMvc @ComponentScan("com.agritech.web")
public class WebConfig implements WebMvcConfigurer {
 @Bean public SpringResourceTemplateResolver templateResolver(){var r=new SpringResourceTemplateResolver();r.setPrefix("/WEB-INF/views/");r.setSuffix(".html");r.setTemplateMode("HTML");r.setCharacterEncoding("UTF-8");r.setCacheable(false);return r;}
 @Bean public SpringTemplateEngine templateEngine(){var e=new SpringTemplateEngine();e.setTemplateResolver(templateResolver());return e;}
 @Bean public ThymeleafViewResolver viewResolver(){var v=new ThymeleafViewResolver();v.setTemplateEngine(templateEngine());v.setCharacterEncoding("UTF-8");return v;}
 public void addResourceHandlers(ResourceHandlerRegistry r){r.addResourceHandler("/assets/**").addResourceLocations("/assets/");}
}