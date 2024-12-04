package com.example.demo_1;


import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes=PersonJpaServiceImpl.class)
public class PersonJpaServiceImplTest {
	/*
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Mock
    private PersonJpaRepo personJpaRepository; // Mocked repository

    @Autowired
    private PersonJpaServiceImpl personJpaService; // Service with injected mock

    @BeforeEach
    void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this); 
    }

    @Test
    void testFindPersonById_Found() {
        // Mock behavior for findById
        Optional<Person> mockPerson = Optional.of(new Person(1, "aa", "ind"));
        Person p=personJpaRepository.save(mockPerson.get());
        PowerMockito.when(personJpaRepository.findById(1)).thenReturn(mockPerson);

        // Call the service method
        Person result = personJpaService.findPersonById(1);

        // Assertions
        assertEquals(true, result.isPresent());
        //assertEquals("aa", result.get().getName());
        //assertEquals("ind", result.get().getLocation());
    }
    */
}
