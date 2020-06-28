package pro.buildmysoftware;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {

	@GetMapping("/api/cache")
	public Tweet cache() {
		return new Tweet("cached msg");
	}
}
