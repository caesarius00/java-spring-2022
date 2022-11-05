package pl.edu.ug.ckwella.lab03;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Lab03Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab03Application.class, args);
		CloseableHttpClient httpClient = HttpClients.createDefault();

		try {

			HttpGet request = new HttpGet("https://stepik.org/media/attachments/lesson/266646/MOCK_DATA.csv");

			CloseableHttpResponse response = httpClient.execute(request);

			try {

				// Get HttpResponse Status
				System.out.println(response.getProtocolVersion());              // HTTP/1.1
				System.out.println(response.getStatusLine().getStatusCode());   // 200
				System.out.println(response.getStatusLine().getReasonPhrase()); // OK
				System.out.println(response.getStatusLine().toString());        // HTTP/1.1 200 OK

				HttpEntity entity = response.getEntity();
				if (entity != null) {
					// return it as a String
					String result = EntityUtils.toString(entity);
					System.out.println(result);
				}

			} catch (IOException e) {}
			finally {
				response.close();
			}
		}catch (IOException e) {}
		finally {
			try{
				httpClient.close();
			}catch (IOException e) {}
		}

	}

}
