/*
 * package com.esprit.examen.services;
 * 
 * import static org.junit.Assert.*;
 * 
 * import java.text.ParseException;
 * import java.text.SimpleDateFormat;
 * import java.util.Date;
 * import java.util.List;
 * 
 * import org.junit.Test;
 * import org.junit.runner.RunWith;
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.boot.test.context.SpringBootTest;
 * import org.springframework.test.context.junit4.SpringRunner;
 * 
 * import com.esprit.examen.entities.Operateur;
 * 
 * import lombok.extern.slf4j.Slf4j;
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @SpringBootTest
 * 
 * @Slf4j
 * public class OperateurServiceImplTests {
 * 
 * @Autowired
 * IOperateurService operateurService;
 * 
 * @Test
 * public void testAddClient() throws ParseException {
 * 
 * SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
 * Date dateNaissance = dateFormat.parse("30/09/2000");
 * Operateur operateur = new Operateur();
 * operateur.setNom("ben chebil");
 * operateur.setFactures(null);
 * operateur.setPassword("password");
 * operateur.setPrenom("chiheb");
 * 
 * Operateur operateur2 = operateurService.addOperateur(operateur);
 * System.out.print("operateur " + operateur2);
 * assertNotNull(operateur2.getIdOperateur());
 * assertNotNull(operateur2.getNom());
 * assertTrue(operateur2.getPassword().length() > 0);
 * operateurService.deleteOperateur(operateur2.getIdOperateur());
 * }
 * ++++
 * }
 */