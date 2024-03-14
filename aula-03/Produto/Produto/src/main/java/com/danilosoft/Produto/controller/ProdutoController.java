package com.danilosoft.Produto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danilosoft.Produto.controller.dto.ProdutoDTO;
import com.danilosoft.Produto.model.Produto;
import com.danilosoft.Produto.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public ArrayList<ProdutoDTO> listarProdutos(String name) {
			List<Produto> lista;
			if(name != null) {
				lista = (ArrayList<Produto>) produtoRepository.findByDescricao( name);
			}
			else {
				lista = (ArrayList<Produto>) produtoRepository.findAll();
			}
			
			ArrayList<ProdutoDTO> listaDTO = new ArrayList<ProdutoDTO>();
			for(Produto p : lista) {
				ProdutoDTO pDTO = new ProdutoDTO(p.getId(),p.getDescricao(),p.getPrecoCusto(), p.getPrecoVista(), p.getPrecoPrazo(), p.getQuantidade());
				listaDTO.add(pDTO);
			}
			return listaDTO;
	}
}
