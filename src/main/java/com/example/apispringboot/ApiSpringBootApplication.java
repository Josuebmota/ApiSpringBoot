package com.example.apispringboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Arrays;

import com.example.apispringboot.models.Pessoas;
import com.example.apispringboot.repository.PessoasRepository;

@SpringBootApplication
public class ApiSpringBootApplication {

	@Autowired
	private PessoasRepository pessoasRepository;
	
	private static final Logger log = LoggerFactory.getLogger(ApiSpringBootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ApiSpringBootApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args ->{
			try{
				Pessoas[] response = restTemplate.
				getForObject("http://5e61af346f5c7900149bc5b3.mockapi.io/desafio03/employer",
					Pessoas[].class);
					List<Pessoas> pessoas = Arrays.asList(response);
					pessoasRepository.saveAll(pessoas);
			}catch(Error noFile){
				throw new IllegalArgumentException("Falha ao consumir api externa");
			}
			
		};
	}

}
