package br.com.mercadolivre.identificator;

import br.com.mercadolivre.identificator.model.Dna;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = IdentificatorApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IdentificatorApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetAllDnas() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/v1/stats",
				HttpMethod.GET, entity, String.class);
		

		Assert.assertNotNull(response.getBody());
	}

	@Test
	public void testCreateDna() {
		Dna dna = new Dna();
		dna.setDna("lalalla");
		dna.setSpecies(1);

		ResponseEntity<Dna> postResponse = restTemplate.postForEntity(getRootUrl() + "/api/v1/simian", dna, Dna.class);
		Assert.assertNotNull(postResponse);
		Assert.assertNotNull(postResponse.getBody());
	}

}
