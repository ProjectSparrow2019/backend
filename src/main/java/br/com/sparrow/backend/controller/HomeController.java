package br.com.sparrow.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sparrow.backend.model.Base;
import br.com.sparrow.backend.model.Produto;
import br.com.sparrow.backend.model.Usuario;
import br.com.sparrow.backend.repository.BaseRepository;
import br.com.sparrow.backend.repository.ProdutoRepository;
import br.com.sparrow.backend.repository.UsuarioRepository;
import br.com.sparrow.backend.util.Code;

@RestController
@CrossOrigin(origins="*",allowCredentials="true",allowedHeaders="true",exposedHeaders="true")
public class HomeController {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private ProdutoRepository produtoRespository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BaseRepository baseRepository;
	
	@Autowired
	private Code code;
	
	@Value("${fila.nome}")
	private String fila;
	
	
	@PostMapping("/fazerFeedback")
	public Base fazerFeedback(@RequestBody Produto produto) {
		return baseRepository.save(new Base(produto));
	}

	@GetMapping("/verProdutosClassificados")
	public List<Produto> verProdutosClassificados() {
		return produtoRespository.findAll();
	}
	
	@PostMapping("/buscarNovosProdutos")
	public String buscarNovosProdutos(@RequestParam String nomeProduto) {
		try {
			jmsTemplate.convertAndSend(fila,nomeProduto);
			return nomeProduto;
		}
		catch(Exception e) {
			return null;
		}
		
	}
	
	@PostMapping("/autenticar")
	public Usuario autenticar(@RequestBody Usuario usuario) {
		usuario = code.codeManager(usuario, false);
		Usuario usuario_ = usuarioRepository
				.findByLoginAndSenha(usuario.getLogin(),usuario.getSenha());
		usuario_ = code.codeManager(usuario_, true);
		return usuario_;
	}
	
	@PostMapping("/cadastrar")
	public Usuario cadastrar(@RequestBody Usuario usuario) {
		usuario = code.codeManager(usuario, false);
		Usuario usuario_ = usuarioRepository.save(usuario);
		usuario_ = code.codeManager(usuario_, true);
		return usuario_;
	}
	
}
