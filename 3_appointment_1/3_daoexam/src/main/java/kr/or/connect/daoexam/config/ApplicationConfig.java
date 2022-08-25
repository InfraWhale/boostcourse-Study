package kr.or.connect.daoexam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "kr.or.connect.daoexam.dao" })
@Import({DBConfig.class}) // 설정파일 여러개로 나눠서 작성 가능 | 하나가 모든 정보 가지고 있으면 유지보수 힘듬
public class ApplicationConfig {

}
