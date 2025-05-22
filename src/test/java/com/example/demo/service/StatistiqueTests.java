package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StatistiqueTests {

    @Test
public void testCalculePrixMoyen() {

    Voiture voiture1 = mock(Voiture.class);
    Voiture voiture2 = mock(Voiture.class);


    when(voiture1.getPrix()).thenReturn(50);
    when(voiture2.getPrix()).thenReturn(1000);

    StatistiqueImpl statistiqueImpl = new StatistiqueImpl();

    statistiqueImpl.ajouter(voiture1);
    statistiqueImpl.ajouter(voiture2);


    Echantillon echantillon = statistiqueImpl.prixMoyen();


    assertNotNull(echantillon); 
    assertEquals(2, echantillon.getNombreDeVoitures());  
    assertEquals(525, echantillon.getPrixMoyen()); 
}
    

}