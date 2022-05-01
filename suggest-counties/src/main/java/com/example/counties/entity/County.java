package com.example.counties.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * This class is a JPA entity that represents a county.
 * 
 * @author Manoj SP
 * @since 1.0
 */
@Data
@Entity
@Table
public class County {

	@Id
	private String fips;

	private String state;

	private String name;
}
