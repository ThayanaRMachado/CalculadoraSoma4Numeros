package br.com.calculadorasoma.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Numeros {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Long num1;

	@NotNull
	private Long num2;

	@NotNull
	private Long num3;

	@NotNull
	private Long num4;
	private Long soma;

	public Numeros(Long num1, Long num2, Long num3, Long num4) {
		super();
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.num4 = num4;
		this.soma = num1 + num2 + num3 + num4;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNum1() {
		return num1;
	}

	public void setNum1(Long num1) {
		this.num1 = num1;
	}

	public Long getNum2() {
		return num2;
	}

	public void setNum2(Long num2) {
		this.num2 = num2;
	}

	public Long getNum3() {
		return num3;
	}

	public void setNum3(Long num3) {
		this.num3 = num3;
	}

	public Long getNum4() {
		return num4;
	}

	public void setNum4(Long num4) {
		this.num4 = num4;
	}

	public Long getSoma() {
		return soma;
	}

	public void setSoma(Long soma) {
		this.soma = soma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Numeros other = (Numeros) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
