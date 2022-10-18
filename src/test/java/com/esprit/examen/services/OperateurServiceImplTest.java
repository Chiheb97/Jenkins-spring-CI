package com.esprit.examen.services;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.esprit.examen.entities.*;
import com.esprit.examen.repositories.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ContextConfiguration(classes = { OperateurServiceImpl.class })

@RunWith(SpringRunner.class)

@SpringBootTest

public class OperateurServiceImplTest {

  @Mock
  private OperateurRepository opRepository;

  @InjectMocks
  private OperateurServiceImpl opServiceImpl;

  @Autowired
  private IOperateurService opService;

  @Test
  public void testRetriveallOperateur() throws ParseException {
    Operateur operateur = new Operateur();
    operateur.setIdOperateur(5L);
    operateur.setFactures(null);
    operateur.setNom("benchebil");
    operateur.setPassword("password");
    operateur.setPrenom("chiheb");

    Operateur op = new Operateur();
    op.setIdOperateur(3L);
    op.setFactures(null);

    op.setNom("benchebil2");

    op.setPassword("password2");

    op.setPrenom("chiheb2");

    ArrayList<Operateur> operateurs = new ArrayList<>();
    operateurs.add(operateur);
    operateurs.add(op);
    when(opRepository.findAll()).thenReturn(operateurs);
    List<Operateur> output = opService.retrieveAllOperateurs();
    assertEquals(2, output.size());
    assertSame(operateurs, output);
    verify(opRepository).findAll();
  }
}
