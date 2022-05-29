package com.websocket.pederapido.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.headers().cacheControl();
		http.csrf().disable()
				.authorizeRequests()
				.antMatchers("*").permitAll()
	            .and().csrf().and()
//	            .disable()
//				.cors().configurationSource(request -> corsConfiguration)
				.addFilterBefore(new CorsFilter(), ChannelProcessingFilter.class);
	}
}
