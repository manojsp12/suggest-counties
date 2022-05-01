package com.example.counties.service;

import java.util.List;

import com.example.counties.entity.County;

/**
 * An interface that is used to define the method that will be used to suggest
 * counties.
 * 
 * @author Manoj SP
 * @since 1.0
 */
public interface SuggestCountiesService {

	/**
	 * "Given a county name and a state, return a list of counties that match the
	 * given county name and
	 * state."
	 * 
	 * The function is defined as returning a list of County objects. The County
	 * class is defined as
	 * follows:
	 * 
	 * // Java
	 * public class County {
	 * private String name;
	 * private String state;
	 * private int population;
	 * // ...
	 * }
	 * 
	 * @param countyName The name of the county you want to search for.
	 * @param state      The state name.
	 * @return A list of counties that match the county name and state.
	 */
	List<County> suggest(String countyName, String state);
}
