



@Configuration
public class CorsConfig extends WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
                .allowedHeaders(HttpHeaders.ORIGIN, HttpHeaders.CONTENT_TYPE, HttpHeaders.ACCEPT, HttpHeaders.AUTHORIZATION)
                .allowCredentials(true);
    }
}
@Value("${cors.allowedOrigins}")
private List<String> allowedOrigins;

@Bean
public CorsFilter corsFilter() {
    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    final CorsConfiguration config = new CorsConfiguration();
    config.setAllowCredentials(true);
    config.setAllowedOrigins(allowedOrigins);  // Use dynamic list of allowed origins
    config.setAllowedHeaders(Arrays.asList(
            HttpHeaders.ORIGIN,
            HttpHeaders.CONTENT_TYPE,
            HttpHeaders.ACCEPT,
            HttpHeaders.AUTHORIZATION
    ));
    config.setAllowedMethods(Arrays.asList(
            "GET",
            "POST",
            "DELETE",
            "PUT",
            "PATCH"
    ));
    source.registerCorsConfiguration("/**", config);
    return new CorsFilter(source);
}

