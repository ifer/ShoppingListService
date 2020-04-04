package ifer.web.shopping.config;



import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;




@Configuration
@EnableWebSecurity
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailServiceImpl userDetailsService;   
	
	@Autowired
	private AuthenticationEntryPoint authEntryPoint;
    @Autowired
    private RESTAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private RESTAuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private RESTAuthenticationFailureHandler authenticationFailureHandler;
	
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.cors();
        http.authorizeRequests().antMatchers( "/login", "/logout/**", "/api/logout").permitAll()
								.anyRequest().authenticated();
        http.csrf().disable();
        http.httpBasic();
        
        http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
        http.formLogin().successHandler(authenticationSuccessHandler);
        http.formLogin().failureHandler(authenticationFailureHandler);

        http.sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
//        http.requiresChannel().anyRequest().requiresSecure();
    }
    
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.applyPermitDefaultValues();
		
//		configuration.setAllowedOrigins(Arrays.asList("http://localhost:8080", "http://192.168.1.2:8080"));
//		configuration.setAllowedMethods(Arrays.asList("GET","POST"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}    
    
    /*
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
				.authorizeRequests()
					.antMatchers( "/login/**", "/logout/**").permitAll()
				.anyRequest().authenticated()
				.and().httpBasic();
//				.and().cors();
//				.authenticationEntryPoint(authEntryPoint);
//		   http.sessionManagement()
//	        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	*/
	
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//            http
//            	.authorizeRequests()
//					.antMatchers( "/css/**", "css/**", "/js/**", "/static/**", "/login/**", "/logout/**").permitAll()
//					.antMatchers( "/api/logout").permitAll()
//					.antMatchers( "/api/updateuser", "/api/deluser").hasRole("ADMIN")
//					.anyRequest().authenticated()
//					.and()
//            	.formLogin()
//            		.loginPage("/login")
//            		.defaultSuccessUrl("/", true)
//            		.permitAll()
//            		.and()
//				.httpBasic()
//					.and()
//				.csrf().disable();
////				.logout()
////					.logoutUrl("/logout")                                              
////					.logoutSuccessUrl("/login")
////					.deleteCookies("JSESSIONID")
////					.permitAll();
// 					
//    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	 auth.userDetailsService(userDetailsService);
    }
    

   
}
