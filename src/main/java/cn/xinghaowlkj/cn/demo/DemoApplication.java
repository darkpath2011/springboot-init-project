package cn.xinghaowlkj.cn.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	public static String jwt_key = "caonimabifeiwu";
	public static int jwt_time = 3;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
