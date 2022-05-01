package com.example.counties.service.impl;

import java.util.List;

import com.example.counties.entity.County;
import com.example.counties.logger.CountiesAppLogger;
import com.example.counties.repository.CountiesRepository;
import com.example.counties.service.SuggestCountiesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * This class is an implementation of the SuggestCountiesService interface. It
 * has a method called
 * suggest() which takes in a county name and a state name as parameters. If the
 * state name is not
 * empty, it will return a list of counties whose names contain the county name
 * and whose state name is
 * the same as the state name. If the state name is empty, it will return a list
 * of counties whose
 * names contain the county name
 * 
 * @author Manoj SP
 * @since 1.0
 * @see SuggestCountiesService
 */
@Service
public class SuggestCountiesServiceImpl implements SuggestCountiesService {

	@Autowired
	private CountiesRepository countyRepo;

	/**
	 * If the state is sent as part of the request, then find the counties by name
	 * and state, else find the
	 * counties by name
	 * 
	 * @param countyName The name of the county to search for.
	 * @param state      The state name.
	 * @return A list of counties
	 */
	@Override
	public List<County> suggest(String countyName, String state) {
		if (StringUtils.hasText(state)) {
			CountiesAppLogger.info("State is sent as part of request");
			return countyRepo.findByNameContainingIgnoreCaseAndStateIgnoreCase(countyName, state);
		}
		return countyRepo.findByNameContainingIgnoreCase(countyName);
	}

}
