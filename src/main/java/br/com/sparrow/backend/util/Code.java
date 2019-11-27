package br.com.sparrow.backend.util;

import java.util.Base64;

import org.springframework.stereotype.Component;

import br.com.sparrow.backend.model.Usuario;

@Component
public class Code {

	public String encode(String texto) {
		byte[] encode = Base64
				.getEncoder()
				.encode(texto.getBytes());
		return new String(encode);
	}
	
	public String decode(String texto) {
		byte[] decode = Base64
				.getDecoder()
				.decode(texto.getBytes());
		return new String(decode);
	}
	
	public Usuario codeManager(Usuario usuario, boolean isEncripted){
		if(isEncripted) {
			usuario.setLogin(decode(usuario.getLogin()));
			usuario.setSenha(decode(usuario.getSenha()));
		}
		else {
			usuario.setLogin(encode(usuario.getLogin()));
			usuario.setSenha(encode(usuario.getSenha()));
		}
		return usuario;
	}
	
	
}
