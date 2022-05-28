package com.websocket.pederapido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/websocket")
public class WebSocketController {
	
	@Autowired
	private SimpMessagingTemplate template;
	
	@PostMapping(value = "/emAberto")
	public ResponseEntity<Void> atualizaItensEmAberto(@RequestBody Object pedidos) {
		template.convertAndSend("/emAberto", pedidos);		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/emPreparacao")
	public ResponseEntity<Void> atualizaItensEmPreparacao(@RequestBody Object pedidos) {
		template.convertAndSend("/emPreparacao", pedidos);		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/contaSolicitada")
	public ResponseEntity<Void> atualizaItensContaSolicitada(@RequestBody Object pedidos) {
		template.convertAndSend("/contaSolicitada", pedidos);		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/contaSolicitada")
	public ResponseEntity<String> getInfo() {	
		String mensagem = "WebSocket OK";
		return new ResponseEntity<String>(mensagem, HttpStatus.OK);
	}

}
