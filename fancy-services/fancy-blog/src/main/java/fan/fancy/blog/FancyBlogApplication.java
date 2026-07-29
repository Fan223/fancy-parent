package fan.fancy.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.service.registry.ImportHttpServices;

/**
 * 博客服务启动类.
 *
 * @author Fan
 */
@SpringBootApplication
@MapperScan("fan.fancy.blog.mapper")
@ImportHttpServices(basePackages = "fan.fancy.api.iam.service")
public class FancyBlogApplication {
    static void main(String[] args) {
        SpringApplication.run(FancyBlogApplication.class, args);
    }
}
