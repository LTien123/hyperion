package com.fanci.Hyperion_be.configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.paypal.core.PayPalEnvironment;
import com.paypal.core.PayPalHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import javax.crypto.spec.SecretKeySpec;


@Configuration
@EnableWebSocketMessageBroker
public class BeanConfig {
    @Value("${jwt.signerKey}")
    private String singerKey;

    @Value("${paypal.client.id}")
    private String clientId;

    @Value("${paypal.client.secret}")
    private String clientSecret;

    @Value("${paypal.mode}")
    private String mode;

    @Bean
    public PayPalHttpClient payPalHttpClient(){
        String clientId = this.clientId;
        String clientSecret = this.clientSecret;

        PayPalEnvironment environment = new PayPalEnvironment.Sandbox(clientId, clientSecret);
        return new PayPalHttpClient(environment);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        SecretKeySpec secretKeySpec = new SecretKeySpec(singerKey.getBytes(), "HS512");
        return NimbusJwtDecoder
                .withSecretKey(secretKeySpec)
                .macAlgorithm(MacAlgorithm.HS512)
                .build();
    }
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.registerModule(new JavaTimeModule());

        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        return objectMapper;
    }

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dt6ukgxqc",
                "api_key", "844334283148543",
                "api_secret", "pRP6Gc6FoPVgN1mxVc4wkcIZsQk"
        ));
    }



}
