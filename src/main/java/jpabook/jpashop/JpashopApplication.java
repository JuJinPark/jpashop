package jpabook.jpashop;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpashopApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(JpashopApplication.class, args);
	}

//	@Bean
//	Hibernate5Module hibernate5Module(){
//		// 모듈 사용시 프록시에서 정상적으로 데이터가 로딩된건만 반환됨
//		return new Hibernate5Module();
//		//이게 엔티티 레이지 로딩 된것은 json 으로변환시 무시함(레이지 로딩된건 아직 초기화가 안됬기에 무시)
//		// 양방향은 JSON IGNORE 해주어얌
////
//
////		Hibernate5Module hibernate5Module = new Hibernate5Module();
////		hibernate5Module.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING,
////				true);
////		return hibernate5Module;
//
//		//이렇게 하면 강제로 레이지 로딩부분을 로딩한다(이터레이션으로 로딩시키는 것과 동일)
//		}

}
