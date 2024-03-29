package br.com.forum.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	public Page<TopicoDTO> listTopicos(@PageableDefault(sort = "id", direction = Direction.ASC) Pageable pagination) {
		return TopicoDTO.toDtoPage(service.listTopicos(pagination));
	}
	
	@GetMapping
	public List<Topico> listAllTopicos() {
		return service.listAllTopicos();
	}
	
	@GetMapping("/list/filtro")
	public List<TopicoDTO> listTopicos(String nomeCurso) {
		return TopicoDTO.toDtoList(service.listTopicosFilter(nomeCurso));
	}
	
	@PostMapping
	public ResponseEntity<Topico> salvarTopico(@RequestBody @Valid Topico topico ) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.salvarTopico(topico));
	}
	
	@PutMapping
	public ResponseEntity<Topico> atualizarTopico(@RequestBody @Valid Topico topico){
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.atualizarTopico(topico));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarTopico(@PathVariable Long id) {
		service.deletarTopico(id);
	}
	
	
}
