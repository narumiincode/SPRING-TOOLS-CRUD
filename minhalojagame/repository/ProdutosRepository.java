package minhalojagame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import minhalojagame.model.Produtos;


@Repository
	public interface ProdutosRepository extends JpaRepository<Produtos, Long>{
	    
	    public List <Produtos> findAllByDescricaoContainingIgnoreCase 
	    (String descricao);
	}

