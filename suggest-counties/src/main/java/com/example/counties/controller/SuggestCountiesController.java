package com.example.counties.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.counties.entity.County;
import com.example.counties.exception.CountiesAppException;
import com.example.counties.service.SuggestCountiesService;
import com.example.counties.validator.SuggestCountiesInputValidator;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * It's a REST controller that exposes a GET endpoint to suggest counties based
 * on the keyword
 * 
 * @author Manoj SP
 * @since 1.0
 */
@RestController
@Tag(name = "suggest-counties-controller", description = "Suggest Counties Controller")
public class SuggestCountiesController {

	@Autowired
	private SuggestCountiesInputValidator validator;

	@Autowired
	private SuggestCountiesService countyService;

	/**
	 * It takes a query string, validates it, splits it into county name and state,
	 * validates the county
	 * name and state, and then calls the county service to get the suggestions
	 * 
	 * @param keyword The keyword to search for.
	 * @return A list of counties.
	 * @throws CountiesAppException exception thrown
	 */
	@GetMapping(path = "/suggest", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Suggest Counties based on input", description = "It takes a query string, validates it, splits it into county name and state, validates the county name and state, and then calls the county service to get the suggestions", tags = {
			"suggest-counties-controller" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "OK")
	})
	public ResponseEntity<List<County>> getSuggestions(@RequestParam(value = "q", required = false) String keyword)
			throws CountiesAppException {
		validator.validateQueryKeyword(keyword);
		String[] splitKeyword = StringUtils.split(keyword, ',');
		String countyName = splitKeyword[0].trim();
		validator.validateCounty(countyName);
		String state = splitKeyword.length == 2
				? StringUtils.isNotBlank(splitKeyword[1]) ? splitKeyword[1].trim() : null
				: null;
		validator.validateState(state);
		return ResponseEntity.ok(countyService.suggest(countyName, state));
	}
}
