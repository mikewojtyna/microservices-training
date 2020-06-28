package pro.buildmysoftware;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TweetsController {

	private Tweet tweet = new Tweet("msg " + UUID.randomUUID());

	@GetMapping("/api/tweets")
	public Tweet randomTweet() {
		return tweet;
	}
}
