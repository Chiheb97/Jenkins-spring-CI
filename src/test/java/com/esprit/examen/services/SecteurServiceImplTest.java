package com.esprit.examen.services;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Optional;
import static org.mockito.Mockito.verify;
import com.esprit.examen.repositories.SecteurActiviteRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.esprit.examen.entities.SecteurActivite;

import lombok.extern.slf4j.Slf4j;
@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SecteurServiceImplTest {
  @Autowired
  @InjectMocks
  ISecteurActiviteService SecteurService;
  @Mock
  SecteurActiviteRepository secteurRepo ;

  @Test
  public void testAddSecteur() throws ParseException {

    SecteurActivite sec = new SecteurActivite((long) 1, "122", "secteur 1", null);
    SecteurActivite secteur = SecteurService.addSecteurActivite(sec);
    System.out.print("secteur " + secteur);
    assertNotNull(secteur.getCodeSecteurActivite());
    assertNotNull(secteur.getIdSecteurActivite());
    SecteurService.deleteSecteurActivite(secteur.getIdSecteurActivite());

  }

  @Test
  public void testDeleteSecteur() {
    SecteurActivite s = new SecteurActivite((long) 1, "122", "secteur2", null);
    SecteurActivite savedService = SecteurService.addSecteurActivite(s);
    SecteurService.deleteSecteurActivite(savedService.getIdSecteurActivite());
    assertNull(SecteurService.retrieveSecteurActivite(savedService.getIdSecteurActivite()));
  }
  @Test
  public void testRetreiveAllSecteurs(){
    SecteurService.retrieveAllSecteurActivite();
    verify(secteurRepo).findAll();
  }
  @Test
  public void testRetreiveSecteurById(){
    SecteurActivite s = new SecteurActivite((long) 12, "12", "secteur2", null);
    SecteurService.retrieveSecteurActivite((long)12);
    verify(secteurRepo).findById((long)12);
    
  }
}