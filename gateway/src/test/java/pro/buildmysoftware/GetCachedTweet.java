package pro.buildmysoftware;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class GetCachedTweet {

	@Autowired
	private WebTestClient webTestClient;

	// @formatter:off
	@DisplayName(
	        "given no service at /api/tweets, " +
	        "when GET on /api/tweets, " +
	        "then cached result is returned"
	)
	//@formatter:on
	@Test
	void test() throws Exception {
		// when
		webTestClient
			.get()
			.uri("/api/tweets")
			.exchange()

			// then
			.expectStatus()
			.isOk()
			.expectBody()
			.jsonPath("$.msg")
			.isEqualTo("cached msg");
	}
}
