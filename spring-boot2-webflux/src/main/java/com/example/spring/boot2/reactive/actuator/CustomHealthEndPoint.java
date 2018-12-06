package com.example.spring.boot2.reactive.actuator;

import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://www.baeldung.com/spring-boot-actuators
 *
 * Important Changes Unlike in previous versions, Actuator comes with most endpoints disabled.
 *
 * Thus, the only two available by default are /health and /info.
 *
 * Would we want to enable all of them, we could set management.endpoints.web.exposure.include=*. Alternatively, we
 * could list endpoints which should be enabled.
 *
 * Actuator now shares the security config with the regular App security rules. Hence, the security model is
 * dramatically simplified.
 *
 * Therefore, to tweak Actuator security rules, we could just add an entry for /actuator/**:
 *
 * <pre>
 * @Bean
 * public SecurityWebFilterChain securityWebFilterChain(
 *   ServerHttpSecurity http) {
 *     return http.authorizeExchange()
 *       .pathMatchers("/actuator/**").permitAll()
 *       .anyExchange().authenticated()
 *       .and().build();
 * }
 * </pre>
 *
 * We can find further details on the brand new Actuator official docs.
 *
 * Also, by default, all Actuator endpoints are now placed under the /actuator path.
 *
 * Same as in the previous version, we can tweak this path, using the new property management.endpoints.web.base-path.
 */
@Component
@Endpoint(id = "custom-health")
public class CustomHealthEndPoint {

    @ReadOperation
    public CustomHealth health() {
        Map<String, Object> details = new LinkedHashMap<>();
        details.put("CustomHealthStatus", "Everything looks good");

        CustomHealth health = new CustomHealth();
        health.setHealthDetails(details);
        return health;
    }

    @ReadOperation
    public String customEndPointByName(@Selector String name) {
        return "custom-end-point";
    }

    @WriteOperation
    public void writeOperation(@Selector String name) {
        // perform write operation
    }

    @DeleteOperation
    public void deleteOperation(@Selector String name) {
        // delete operation
    }

    public class CustomHealth {

        private Map<String, Object> healthDetails;

        public Map<String, Object> getHealthDetails() {
            return this.healthDetails;
        }

        public void setHealthDetails(Map<String, Object> healthDetails) {
            this.healthDetails = healthDetails;
        }
    }

}
