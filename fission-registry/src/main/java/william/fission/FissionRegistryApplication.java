package william.fission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Auther: ZhangShenao
 * @Date: 2019/3/12 10:22
 * @Description:
 */
@SpringBootApplication
@EnableEurekaServer
public class FissionRegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(FissionRegistryApplication.class, args);
    }
}
