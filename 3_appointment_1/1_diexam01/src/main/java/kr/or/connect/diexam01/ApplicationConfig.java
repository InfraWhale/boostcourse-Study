package kr.or.connect.diexam01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 이 클래스는 config 파일. applicationContex.xml처럼 사용가능
public class ApplicationConfig { 
  @Bean
  public Car car(Engine e) {
    Car c = new Car();
    c.setEngine(e);
    return c;
  }

  @Bean
  public Engine engine() {
    return new Engine();
  }
}
