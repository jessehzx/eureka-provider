package top.jessehzx.cloud.serviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author jessehzx
 * @Date 2018/4/8
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaServiceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceProviderApplication.class, args);
	}
}
