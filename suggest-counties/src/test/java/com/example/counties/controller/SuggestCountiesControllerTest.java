package com.example.counties.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import com.example.counties.entity.County;
import com.example.counties.exception.CountiesAppException;
import com.example.counties.service.SuggestCountiesService;
import com.example.counties.validator.SuggestCountiesInputValidator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

@ContextConfiguration(classes = { TestContext.class, WebApplicationContext.class })
@ExtendWith(SpringExtension.class)
@WebMvcTest
@ActiveProfiles("test")
public class SuggestCountiesControllerTest {

    @InjectMocks
    private SuggestCountiesController controller;

    @Mock
    private SuggestCountiesInputValidator validator;

    @Mock
    private SuggestCountiesService countyService;

    @Test
    public void testGetSuggestionsOnlyCounty() throws CountiesAppException {
        County county = new County();
        when(countyService.suggest("keyword", null)).thenReturn(List.of(county));
        ResponseEntity<List<County>> suggestions = controller.getSuggestions("keyword");
        assertEquals(suggestions.getBody().get(0), county);
    }

    @Test
    public void testGetSuggestionsCountyAndState() throws CountiesAppException {
        County county = new County();
        when(countyService.suggest("keyword", "state")).thenReturn(List.of(county));
        ResponseEntity<List<County>> suggestions = controller.getSuggestions("keyword,state");
        assertEquals(suggestions.getBody().get(0), county);
    }
}