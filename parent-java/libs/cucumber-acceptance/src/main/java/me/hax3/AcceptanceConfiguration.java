package me.hax3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shiver.me.timbers.waiting.WaiterAspect;

@Configuration
public class AcceptanceConfiguration {

    @Bean
    public WaiterAspect waiterAspect() {
        return new WaiterAspect();
    }
}
