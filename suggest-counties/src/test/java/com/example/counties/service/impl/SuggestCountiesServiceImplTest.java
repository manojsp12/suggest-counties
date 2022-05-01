package com.example.counties.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import com.example.counties.entity.County;
import com.example.counties.repository.CountiesRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

@ContextConfiguration(classes = { TestContext.class, WebApplicationContext.class })
@ExtendWith(SpringExtension.class)
@WebMvcTest
@ActiveProfiles("test")
public class SuggestCountiesServiceImplTest {

    @InjectMocks
    private SuggestCountiesServiceImpl service;

    @Mock
    private CountiesRepository countyRepo;

    @Test
    public void testSuggestOnlyCounty() {
        County county = new County();
        when(countyRepo.findByNameContainingIgnoreCase("countyName")).thenReturn(List.of(county));
        List<County> response = service.suggest("countyName", null);
        assertEquals(response.get(0), county);
    }

    @Test
    public void testSuggestOnlyCountyAndState() {
        County county = new County();
        when(countyRepo.findByNameContainingIgnoreCaseAndStateIgnoreCase("countyName", "state"))
                .thenReturn(List.of(county));
        List<County> response = service.suggest("countyName", "state");
        assertEquals(response.get(0), county);
    }
}
