package ru.homecredit.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.hateoas.mvc.TypeConstrainedMappingJackson2HttpMessageConverter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.hateoas.MediaTypes.HAL_JSON;


/**
 * Created by RRybasov on 05.07.16.
 */

@Configuration
@EnableOAuth2Client
public class RestConfiguration {

    @Value("${oauth.resource:http://localhost:8082}")
    private String baseUrl;
    @Value("${oauth.authorize:http://localhost:8082/oauth/authorize}")
    private String authorizeUrl;
    @Value("${oauth.token:http://localhost:8082/oauth/token}")
    private String tokenUrl;
    @Value("${auth.username}")
    private String clientId;
    @Value("${auth.password}")
    private String clientSecret;

    @Bean
    protected ClientCredentialsResourceDetails resource() {

        ClientCredentialsResourceDetails resource = new ClientCredentialsResourceDetails();
//        List scopes = new ArrayList<String>(2);
//        scopes.add("write");
//        scopes.add("read");
        resource.setId("oauthClientPos");
        resource.setAccessTokenUri(tokenUrl);
        resource.setClientId(clientId);
        resource.setClientSecret(clientSecret);
        resource.setGrantType("client_credentials");
        resource.setTokenName("access_token");


        return resource;
    }

    @Bean
    public OAuth2RestOperations restTemplate() {
        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resource(), new DefaultOAuth2ClientContext());
        List<HttpMessageConverter<?>> existingConverters = restTemplate.getMessageConverters();
        List<HttpMessageConverter<?>> newConverters = new ArrayList<>();
        newConverters.add(getHalMessageConverter());
        newConverters.addAll(existingConverters);
        restTemplate.setMessageConverters(newConverters);
        return restTemplate;
    }

    private HttpMessageConverter getHalMessageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new Jackson2HalModule());
        MappingJackson2HttpMessageConverter halConverter = new TypeConstrainedMappingJackson2HttpMessageConverter(ResourceSupport.class);
        halConverter.setSupportedMediaTypes(Arrays.asList(MediaType.ALL));
        halConverter.setObjectMapper(objectMapper);
        return halConverter;
    }
}
