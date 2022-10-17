package com.esprit.examen.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.esprit.examen.entities.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperateurServiceUnitTest {

  @Autowired
  IOperateurService opService;

  @Test
  public void TestAddOperateur() {
    Operateur operateur = new Operateur();
    operateur.setIdOperateur(2L);
    operateur.setFactures(null);
    operateur.setNom("benchebil22");
    operateur.setPassword("password22");
    operateur.setPrenom("chiheb222");

    Operateur op = new Operateur();
    assertNull(op.getNom());
    assertSame("benchebil22", op.getNom());
    opService.deleteOperateur(op.getIdOperateur());
    /* */
  }

}
