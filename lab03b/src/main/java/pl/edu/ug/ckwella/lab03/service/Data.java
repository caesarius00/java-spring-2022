package pl.edu.ug.ckwella.lab03.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import pl.edu.ug.ckwella.lab03.domain.Person;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
@ImportResource("classpath:beans.xml")


public class Data {

    public static String getData(String URL) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = "";

        try {

            HttpGet request = new HttpGet(URL);

            CloseableHttpResponse response = httpClient.execute(request);

            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    // return it as a String
                    result = EntityUtils.toString(entity);
                }

            }finally {
                response.close();
            }
        }finally {
            httpClient.close();
        }
        return result;
    }

    public static HashMap getMap(ApplicationContext applicationContext, String data) throws IOException {
        HashMap<String, Person> map = new HashMap<>();

        Reader in = new StringReader(data);
        CSVFormat.Builder builder = CSVFormat.DEFAULT.builder().setHeader().setSkipHeaderRecord(true);
        Iterable<CSVRecord> records = builder.build().parse(in);
        for (CSVRecord record : records) {
            //metoda 1 - COMPONENT
            //PersonManagerService personManagerService = applicationContext.getBean(PersonManagerService.class);
            //Person p1 = personManagerService.getPerson();

            //metoda 2 - CONFIGURATION
            Person p1 = applicationContext.getBean("createUsingPrototype", Person.class);

            //metoda 3 - BEANS.XML
            //Person p1 = applicationContext.getBean("object1", Person.class);

            p1.setFirstName(record.get("first_name"));
            p1.setLastName(record.get("last_name"));
            p1.setEmail(record.get("email"));
            p1.setCompanyName(record.get("company_name"));

            String key = record.get("id");
            map.put(key, p1);

        }
        return map;
    }
}
