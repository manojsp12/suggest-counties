package com.example.counties.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.counties.entity.County;

/**
 * This is a Spring Data JPA repository. It is a Java interface that extends the
 * JpaRepository interface. The JpaRepository interface provides methods for
 * performing CRUD operations. The County
 * class is the entity class that is being persisted. The String is the type of
 * the entity's primary
 * key. The @Cacheable annotation is used to cache the results of the methods.
 * 
 * @author Manoj SP
 * @since 1.0
 */
public interface CountiesRepository extends JpaRepository<County, String> {

	/**
	 * Find all counties whose name contains the given county name, ignoring case
	 * 
	 * @param countyName The name of the county to search for.
	 * @return A list of counties
	 */
	@Cacheable("county")
	List<County> findByNameContainingIgnoreCase(String countyName);

	/**
	 * Find all counties whose name contains the given county name, ignoring case,
	 * and whose state
	 * contains the given state name, ignoring case.
	 * 
	 * @param countyName The name of the county you're searching for.
	 * @param state      The state name
	 * @return A list of counties that match the county name and state.
	 */

	@Cacheable("countyAndState")
	List<County> findByNameContainingIgnoreCaseAndStateIgnoreCase(String countyName, String state);

	/**
	 * The function `findAll()` will return a list of counties. The list will be
	 * cached in the cache
	 * named `all`
	 * 
	 * @return A list of all counties.
	 */
	@Cacheable("all")
	List<County> findAll();
}
