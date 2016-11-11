package cc.aisc;

import cc.aisc.config.interceptor.StatusVaryInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * 配置拦截器
	 *	 */
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new StatusVaryInterceptor()).addPathPatterns("/**");
	}

}
