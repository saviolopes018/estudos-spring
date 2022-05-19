package br.com.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}
