package pl.edu.ug.ckwella.lab03;


import org.apache.http.util.EntityUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import pl.edu.ug.ckwella.lab03.service.Data;

import java.io.IOException;
import java.util.HashMap;
@ImportResource("classpath:beans.xml")

@SpringBootApplication
public class Lab03Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Lab03Application.class, args);

		try{
			//System.out.println(Data.getData("https://stepik.org/media/attachments/lesson/266646/MOCK_DATA.csv"));
			HashMap m = Data.getMap(applicationContext,Data.getData("https://stepik.org/media/attachments/lesson/266646/MOCK_DATA.csv"));
			m.forEach((k,v)-> System.out.println(k + " " + v));

		} catch (IOException e) {}

	}

}
