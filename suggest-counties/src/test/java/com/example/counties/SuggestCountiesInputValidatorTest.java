package com.example.counties;

import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.annotation.PostConstruct;

import com.example.counties.exception.CountiesAppException;
import com.example.counties.validator.SuggestCountiesInputValidator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.context.WebApplicationContext;

@ContextConfiguration(classes = { TestContext.class, WebApplicationContext.class })
@ExtendWith(SpringExtension.class)
@WebMvcTest
@ActiveProfiles("test")
public class SuggestCountiesInputValidatorTest {

    @InjectMocks
    private SuggestCountiesInputValidator validator;

    @Autowired
    private Environment env;

    @PostConstruct
    public void init() {
        ReflectionTestUtils.setField(validator, "env", env);
    }

    @Test
    public void testValidateQueryKeywordEmptyData() throws CountiesAppException {
        assertThrows(CountiesAppException.class, () -> validator.validateQueryKeyword(""));
    }

    @Test
    public void testValidateQueryKeywordMultipleSeperator() throws CountiesAppException {
        assertThrows(CountiesAppException.class, () -> validator.validateQueryKeyword(",,,"));
    }

    @Test
    public void testValidateQueryKeywordValidData() throws CountiesAppException {
        validator.validateQueryKeyword("abcd");
    }

    @Test
    public void testValidateCountyKeywordEmptyData() throws CountiesAppException {
        assertThrows(CountiesAppException.class, () -> validator.validateCounty(""));
    }

    @Test
    public void testValidateCountyKeywordValidData() throws CountiesAppException {
        validator.validateCounty("abcd");
    }

    @Test
    public void testValidateCountyKeywordInvalidData() throws CountiesAppException {
        assertThrows(CountiesAppException.class, () -> validator.validateCounty("a"));
    }

    @Test
    public void testValidateStateKeywordEmptyData() throws CountiesAppException {
        validator.validateState("");
    }

    @Test
    public void testValidateStateKeywordValidData() throws CountiesAppException {
        validator.validateState("abcd");
    }

    @Test
    public void testValidateStateKeywordInvalidData() throws CountiesAppException {
        assertThrows(CountiesAppException.class, () -> validator.validateState("a"));
    }

}
