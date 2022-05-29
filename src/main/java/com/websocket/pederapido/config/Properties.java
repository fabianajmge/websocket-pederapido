package com.websocket.pederapido.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Properties {
	
	 private String[] origensPermitidas;
	 
	 	@Autowired
	    public Properties(@Value("${websocket.origenspermitidas}") String[] origens) {
	        this.origensPermitidas = origens;
	    }

}
