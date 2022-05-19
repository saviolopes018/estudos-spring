package br.com.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.forum.domain.Topico;
import br.com.forum.domain.dto.TopicoDTO;
import br.com.forum.service.TopicoService;

@RestController
@RequestMapping(value = "/topico")
public class TopicoController {
	
	@Autowired
	private TopicoService service;

	@GetMapping("/list")
	public List<TopicoDTO> listTopicos() {
		return TopicoDTO.toEntity(service.listTopicos());
	}
	
	@GetMapping("/list/filtro")
	public List<TopicoDTO> listTopicos(String nomeCurso) {
		return TopicoDTO.toEntity(service.listTopicosFilter(nomeCurso));
	}
	
	@PostMapping
	public ResponseEntity<Topico> salvarTopico(@RequestBody Topico topico ) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.salvarTopico(topico));
	}
	
}
