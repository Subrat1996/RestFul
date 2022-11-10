package com.boot;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="std_data")
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	@Id
	private Integer sid;
	private String sname;
	private String clgname;
}
