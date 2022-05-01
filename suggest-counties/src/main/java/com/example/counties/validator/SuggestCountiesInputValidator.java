package com.example.counties.validator;

import com.example.counties.exception.CountiesAppException;
import com.example.counties.exception.SuggestCountiesErrorConstants;
import com.example.counties.logger.CountiesAppLogger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * SuggestCountiesInputValidator validates the input parameters for the suggest
 * API
 * 
 * @author Manoj SP
 * @since 1.0
 */
@Component
public class SuggestCountiesInputValidator {

    @Autowired
    private Environment env;

    /**
     * It checks if the keyword is not empty and if it has more than one comma
     * 
     * @param keyword The keyword that the user has entered in the search box.
     * @throws CountiesAppException exception thrown
     */
    public void validateQueryKeyword(String keyword) throws CountiesAppException {
        if (!StringUtils.hasText(keyword) || StringUtils.countOccurrencesOf(keyword, ",") > 1) {
            CountiesAppLogger.debug("Invalid query keyword sent");
            throw new CountiesAppException(SuggestCountiesErrorConstants.INVALID_KEYWORD);
        }
    }

    /**
     * It validates the county name sent by the user and throws an exception if the
     * county name is not valid
     * 
     * @param county The county to be validated
     * @throws CountiesAppException exception thrown
     */
    public void validateCounty(String county) throws CountiesAppException {
        Integer minLength = env.getProperty("counties.min-length", Integer.class, 0);
        if (!StringUtils.hasText(county)
                || county.length() <= minLength) {
            CountiesAppLogger.debug(String.format("County sent with length %s", county.length()));
            throw new CountiesAppException(
                    String.format(SuggestCountiesErrorConstants.MIN_LENGTH_ERROR, minLength, "County"));
        }
    }

    /**
     * It validates the state parameter and throws an exception if the state
     * parameter is not valid
     * 
     * @param state The state to validate
     * @throws CountiesAppException exception thrown
     */
    public void validateState(String state) throws CountiesAppException {
        Integer minLength = env.getProperty("state.min-length", Integer.class, 0);
        if (StringUtils.hasText(state)
                && state.length() <= minLength) {
            CountiesAppLogger.debug(String.format("State sent with length %s", state.length()));
            throw new CountiesAppException(
                    String.format(SuggestCountiesErrorConstants.MIN_LENGTH_ERROR, minLength, "State"));
        }
    }
}
