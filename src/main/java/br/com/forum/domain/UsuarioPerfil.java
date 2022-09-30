package br.com.forum.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UsuarioPerfil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long usuario_id;
	private Long perfil_id;
	
	public Long getUsuarioId() {
		return usuario_id;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuario_id = usuarioId;
	}
	public Long getPerfilId() {
		return perfil_id;
	}
	public void setPerfilId(Long perfilId) {
		this.perfil_id = perfilId;
	}
	
}
