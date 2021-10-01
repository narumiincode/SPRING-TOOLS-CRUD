package minhalojagame.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
	@Table(name = "tb_produtos")
	public class Produtos {
		    
		    @Id	
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private long id;
			
			@NotNull(message = "O atributo Descrição deve ser obrigatório")
			private String descricao;
			
			@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
			@JsonIgnoreProperties("produto")
			private List<Categoria> promocao;

			public long getId() {
				return id;
			}

			public void setId(long id) {
				this.id = id;
			}

			public String getDescricao() {
				return descricao;
			}

			public void setDescricao(String descricao) {
				this.descricao = descricao;
			}

			public List<Categoria> getPromocao() {
				return promocao;
			}

			public void setPromocao(List<Categoria> promocao) {
				this.promocao = promocao;
			}
			
			
}
