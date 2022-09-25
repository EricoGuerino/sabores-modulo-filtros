package com.tcc.saboresmodulofiltros.pojo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Peso implements Serializable {

	private static final long serialVersionUID = 3629150344366774100L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private Double valor;
	
	public Peso() {}
	public Peso(Integer id, Double valor) {
		setId(id);
		setDescricao(null);
		setValor(valor);
	}
	public Peso(Integer id, String descricao, Double valor) {
		setId(id);
		setDescricao(descricao);
		setValor(valor);
	}
	
	public Integer getId() 			{ return id; 		}
	public String getDescricao() 	{ return descricao; }
	public Double getValor() 		{ return valor;		}
	
	public void setId(Integer id) 				{ this.id = id; 				}
	public void setDescricao(String descricao) 	{ this.descricao = descricao; 	}
	public void setValor(Double valor) 			{ this.valor = valor;			}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Peso other = (Peso) obj;
		return Objects.equals(id, other.id);
	}
}
