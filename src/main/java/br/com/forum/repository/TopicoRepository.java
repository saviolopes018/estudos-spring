package br.com.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.forum.domain.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

}
