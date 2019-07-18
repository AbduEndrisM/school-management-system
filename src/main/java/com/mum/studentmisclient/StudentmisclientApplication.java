package com.mum.studentmisclient;

import com.mum.studentmisclient.service.StudentMISService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class StudentmisclientApplication implements  CommandLineRunner{


	@Autowired
	private StudentMISService studentMISService;

	public static void main(String[] args) {
		SpringApplication.run(StudentmisclientApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(3000);
		return  new RestTemplate(clientHttpRequestFactory);
	}


	@Override
	public void run(String... args) throws Exception {
		//System.out.println(studentMISService.allStudents());
	}


}
