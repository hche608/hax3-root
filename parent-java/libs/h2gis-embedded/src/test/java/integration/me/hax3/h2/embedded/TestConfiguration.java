package integration.me.hax3.h2.embedded;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"integration.me.hax3.h2.embedded", "me.hax3"})
@EnableAutoConfiguration
public class TestConfiguration {
}
