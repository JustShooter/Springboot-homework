package com.example.horsedemo.controller;

import com.example.horsedemo.repository.Horse;
import com.example.horsedemo.service.HorseService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class HorseControllerTest {

    public static final String TYPE = "Arabian";
    public static final String AGE = "3";
    public static final String PRICE = "1000";
    public static final int ID = 1;
    @Mock
    private HorseService horseService;

    @Mock
    private Model model;

    @InjectMocks
    private HorseController horseController;

    @Test
    @DisplayName("Should delete the horse when the id is valid")
    void testDeleteHorseWhenIdIsValid() {

        horseController.deleteHorse(ID);

        verify(horseService).delete(ID);
    }

    @Test
    @DisplayName("Should returns the edit_horse view")
    void testShowEditHorsePageShouldReturnsTheEditHorseView() {
        Horse horse = new Horse(ID, TYPE, AGE, PRICE);
        when(horseService.get(ID)).thenReturn(horse);

        String viewName = horseController.showEditHorsePage(ID, model);

        assertEquals("edit_horse", viewName);
    }

    @Test
    @DisplayName("Should returns the horse with the given id")
    void testShowEditHorsePageShouldReturnsTheHorseWithTheGivenId() {
        Horse horse = new Horse(ID, TYPE, AGE, PRICE);
        when(horseService.get(ID)).thenReturn(horse);

        String viewName = horseController.showEditHorsePage(ID, model);

        assertEquals("edit_horse", viewName);
        verify(model).addAttribute("horse", horse);
    }

    @Test
    @DisplayName("Should saves the horse")
    void testSaveHorse() {
        Horse horse = new Horse(TYPE, AGE, PRICE);
        horseController.saveHorse(horse);

        verify(horseService).save(horse);
    }

    @Test
    @DisplayName("Should returns the new_horse view")
    void testShowNewProductPageShouldReturnsTheNewHorseView() {
        String view = horseController.showNewProductPage(model);

        assertEquals("new_horse", view);
    }

    @Test
    @DisplayName("Should returns the index page")
    void testViewHomePageShouldReturnsIndexPage() {
        List<Horse> listHorses = new ArrayList<>();
        listHorses.add(new Horse());
        listHorses.add(new Horse());

        when(horseService.listAll()).thenReturn(listHorses);

        String viewName = horseController.viewHomePage(model);

        assertEquals("index", viewName);
        verify(horseService, times(ID)).listAll();
        verify(model, times(ID)).addAttribute("listHorses", listHorses);
    }

    @Test
    @DisplayName("Should returns the list of horses")
    void testViewHomePageShouldReturnsListOfHorses() {
        List<Horse> listHorses = new ArrayList<>();
        listHorses.add(new Horse());
        listHorses.add(new Horse());

        when(horseService.listAll()).thenReturn(listHorses);

        String viewName = horseController.viewHomePage(model);

        assertEquals("index", viewName);
        verify(horseService, times(ID)).listAll();
        verify(model, times(ID)).addAttribute("listHorses", listHorses);
    }
}