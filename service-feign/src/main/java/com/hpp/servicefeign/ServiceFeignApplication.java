package com.hpp.servicefeign;

import com.hpp.servicefeign.web.SchedualServiceHiHystric;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ServiceFeignApplication {

	public static void main(String[] args) {

		SpringApplication.run(ServiceFeignApplication.class, args);
	}
	@FeignClient(value = "service-hi",fallback = SchedualServiceHiHystric.class)
	public interface SchedualServiceHi {
		@RequestMapping(value = "/hi",method = RequestMethod.GET)
		String sayHiFromClientOne(@RequestParam(value = "name") String name);
	}

}
