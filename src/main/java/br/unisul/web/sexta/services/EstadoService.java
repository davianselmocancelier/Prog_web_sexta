package br.unisul.web.sexta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.web.sexta.domain.Estado;
import br.unisul.web.sexta.repositories.EstadoRepository;

@Service
public class EstadoService {


	@Autowired
	private EstadoRepository rep1;

	// BUSCA POR ID
	public Estado find(Integer id) {
		Optional<Estado> obj = rep1.findById(id);
		return obj.orElse(null);
	}

	// FAZ INSERÇÃO
	public Estado insert(Estado obj) {
		obj.setId(null);
		return rep1.save(obj);
	}

	// ATUALIZAR
	public Estado update(Estado obj) {
		find(obj.getId());
		return rep1.save(obj);
	}

	// DELETAR
	public void delete(Integer id) {
		find(id);
		rep1.deleteById(id);
	}

	// LISTAR TODAS
	public List<Estado> findAll() {
		return rep1.findAllByOrderByUf();
	}
}


