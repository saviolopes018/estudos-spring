package br.com.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.forum.domain.Curso;
import br.com.forum.domain.Topico;
import br.com.forum.domain.dto.TopicoDTO;

@RestController
@RequestMapping(value = "/topico")
public class TopicoController {

	@GetMapping("/list")
	public List<TopicoDTO> list() {
		Topico topico = new Topico("Dúvida", "Dúvida com Spring", new Curso("Spring", "Programação"));
		
		return TopicoDTO.toEntity(Arrays.asList(topico));
	}
	
}
