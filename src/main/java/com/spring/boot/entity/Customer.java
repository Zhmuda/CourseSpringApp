package com.spring.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//генерирует конструктор с одним параметром для каждого поля
import lombok.AllArgsConstructor;

//генерирует методы-гет-сет для каждого поля
import lombok.Getter;
import lombok.Setter;

//генерирует конструктор без параметров. Если невозможно, то возникает ошибка
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String itemname;

	@Column(name = "gender")
	private String itemgender;

	@Column(name = "spent")
	private Integer itemspent;

	public Customer(String itemname, String itemgender, Integer itemspent) {
		super();
		this.itemname = itemname;
		this.itemgender = itemgender;
		this.itemspent = itemspent;
	}

}
