package kr.or.connect.mvcexam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "kr.or.connect.mvcexam.controller" })
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/META-INF/resources/webjars/").setCachePeriod(31556926);
    registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
    registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
    registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
  } // 앞처럼 들어오는 요청은 뒤에서 찾는다.

  // default servlet handler를 사용하게 합니다.
  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  } // default servlet 사용 위해

  @Override // 특정 url에 대한 처리를 컨트롤러 클래스를 작성하지 않고 매핑하도록 해줌
  public void addViewControllers(final ViewControllerRegistry registry) {
    System.out.println("addViewControllers가 호출됩니다. ");
    registry.addViewController("/").setViewName("main");
  }

  @Bean
  public InternalResourceViewResolver getInternalResourceViewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".jsp");
    return resolver;
  }
}
