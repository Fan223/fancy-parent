package fan.fancy.gateway.config;

import fancy.starter.server.resource.reactive.authentication.ReactiveInternalAuthenticationFilter;
import fancy.starter.server.resource.reactive.authorize.ReactiveAuthorizeCustomizer;
import fancy.starter.server.resource.reactive.configurer.ReactiveResourceServerConfigurer;
import fancy.starter.server.resource.reactive.handler.ReactiveAccessDeniedHandler;
import fancy.starter.server.resource.reactive.handler.ReactiveAuthenticationEntryPoint;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;

/**
 * 网关配置类.
 *
 * @author Fan
 */
@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class FancyGatewayConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http,
                                                         ReactiveAuthenticationEntryPoint authenticationEntryPoint,
                                                         ReactiveAccessDeniedHandler accessDeniedHandler,
                                                         Converter<Jwt, Mono<AbstractAuthenticationToken>> reactiveJwtAuthenticationConverter,
                                                         ObjectProvider<ReactiveAuthorizeCustomizer> authorizeCustomizers,
                                                         ObjectProvider<ReactiveInternalAuthenticationFilter> internalAuthenticationFilterProvider
    ) {
        ReactiveResourceServerConfigurer.applyDefaults(http, authenticationEntryPoint, accessDeniedHandler, reactiveJwtAuthenticationConverter, authorizeCustomizers, internalAuthenticationFilterProvider);
        http.authorizeExchange(spec -> spec
                .pathMatchers("/api/**").permitAll()
                .anyExchange().authenticated());
        http.oauth2Login(Customizer.withDefaults())
                .oauth2Client(Customizer.withDefaults());
        return http.build();
    }
}
