package jp.co.sss.game.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "stations")
public class Station {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_stations_gen")
	@SequenceGenerator(name = "seq_stations_gen", sequenceName = "seq_stations", allocationSize = 1)
	private Integer id;
	@Column
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
