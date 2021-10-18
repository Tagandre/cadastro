package com.cadastro;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CadastroApplication{
	
	public static void main(String[] args) {
		try{
			System.setProperty("spring.devtools.restart.enabled", "false");
			SpringApplication.run(CadastroApplication.class, args);
		}catch(Exception e){
			System.out.print(e.getMessage());
		}
	}	

}
