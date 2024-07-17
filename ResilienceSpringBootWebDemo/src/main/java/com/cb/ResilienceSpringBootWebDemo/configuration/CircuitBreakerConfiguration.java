package com.cb.ResilienceSpringBootWebDemo.configuration;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.core.registry.EntryAddedEvent;
import io.github.resilience4j.core.registry.EntryRemovedEvent;
import io.github.resilience4j.core.registry.EntryReplacedEvent;
import io.github.resilience4j.core.registry.RegistryEventConsumer;
import io.github.resilience4j.retry.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class CircuitBreakerConfiguration {

    @Bean
    public RegistryEventConsumer<Retry> myRegistryEventRetryConsumer(){
        System.out.println("retry");
        return new RegistryEventConsumer<Retry>() {
            @Override
            public void onEntryAddedEvent(EntryAddedEvent<Retry> entryAddedEvent) {
                entryAddedEvent.getAddedEntry().getEventPublisher().onRetry(event ->
                        log.warn("retry {} for {} number of attempts {} ",
                                event.getName(), event.getEventType(), event.getNumberOfRetryAttempts()

                        ));

            }

            @Override
            public void onEntryRemovedEvent(EntryRemovedEvent<Retry> entryRemoveEvent) {

            }

            @Override
            public void onEntryReplacedEvent(EntryReplacedEvent<Retry> entryReplacedEvent) {

            }
        };
    }
    @Bean
    public RegistryEventConsumer<CircuitBreaker> myRegistryEventConsumer() {
        System.out.println("event");
        return new RegistryEventConsumer<CircuitBreaker>() {
            @Override
            public void onEntryAddedEvent(EntryAddedEvent<CircuitBreaker> entryAddedEvent) {

                entryAddedEvent.getAddedEntry().getEventPublisher().onEvent(event ->
                        log.warn("circuit breaker {} on success of {} ",
                                event.getCircuitBreakerName(), event.getEventType()

                        ));
                entryAddedEvent.getAddedEntry().getEventPublisher().onStateTransition(event->
                        log.warn("circuit breaker {} on  {} from {} to {} ",
                                event.getCircuitBreakerName(), event.getEventType(),
                                event.getStateTransition().getFromState(),
                                event.getStateTransition().getToState()

                        ));
            }

            @Override
            public void onEntryRemovedEvent(EntryRemovedEvent<CircuitBreaker> entryRemoveEvent) {

            }

            @Override
            public void onEntryReplacedEvent(EntryReplacedEvent<CircuitBreaker> entryReplacedEvent) {

            }
        };
    }
}
