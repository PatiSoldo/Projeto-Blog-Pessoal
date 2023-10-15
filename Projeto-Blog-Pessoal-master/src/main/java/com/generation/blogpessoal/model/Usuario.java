package com.generation.blogpessoal.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="tb_usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo é obrigatorio")
	private String nome;
	
	@Schema(example = "email@email.com.br")
	@NotBlank(message = "O atributo é obrigatorio")
	@Email(message = "O atributo usuario tem que receber um e-mail valido")
	private String usuario;
	
	@NotBlank(message = "O atributo é obrigatorio")
	@Size( message = "a senha tem que ter no minimo 8 caracteres")
	private String senha;
	
	@Size(max = 4000,message = "O link da foto inserida não pode passar dos 4000 caracteres")
	private String foto;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Postagem> postagem;
	
	
// Podemos apagar as anotações do metodo construtor, pois não é obrigatorio mante-las no codigo, pois ja foi digitado na criação da Entidade acima
	public Usuario(Long id, @NotBlank(message = "O atributo é obrigatorio") String nome,
			@NotBlank(message = "O atributo é obrigatorio") @Email(message = "O atributo usuario tem que receber um e-mail valido") String usuario,
			@NotBlank(message = "O atributo é obrigatorio") @Size(min = 8, message = "a senha tem que ter no minimo 8 caracteres") String senha,
			@Size(max = 4000, message = "O link da foto inserida não pode passar dos 4000 caracteres") String foto,
			List<Postagem> postagem) {
		super();
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.foto = foto;
		this.postagem = postagem;
	}
	
	
	
	
	
	public Usuario() {}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
	
	

}
