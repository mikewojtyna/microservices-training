package pro.buildmysoftware;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class GatewayConfig {

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder
			.routes()
			.route(predicateSpec -> predicateSpec
				.path("/api/tweets")
				.and()
				.method(HttpMethod.GET)
				.filters(gatewayFilterSpec -> gatewayFilterSpec.hystrix(
					config -> config.setFallbackUri("forward:/api/cache")))
				.uri("http://localhost:8081/api/tweets"))
			.build();
	}
}
