package br.com.forum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.forum.domain.Topico;
import br.com.forum.repository.TopicoRepository;

@Service
public class TopicoService {

	@Autowired
	private TopicoRepository repository;
	
	public List<Topico> listTopicos(){
		return repository.findAll();
	}
	
	public List<Topico> listTopicosFilter(String nomeCurso){
		return repository.findByCursoNome(nomeCurso);
	}
	
	public Topico salvarTopico(Topico topico) {
		return repository.save(topico);
	}
	
	public Topico atualizarTopico(Topico topico) {
		return repository.saveAndFlush(topico);
	}
	
	public void deletarTopico(Long id) {
		repository.deleteById(id);
	}
	
}
