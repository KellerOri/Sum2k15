/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.time.LocalDate;
import java.util.List;
import model.Aktivitet;
import model.Beboer;
import model.Medarbejder;
import model.PersonResource;
import model.Resource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.primefaces.model.DefaultScheduleEvent;

/**
 *
 * @author Arthur
 */
public class ServiceTest {
    
    public ServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
//
//    /**
//     * Test of getAktiviteter method, of class Service.
//     */
//    @Test
//    public void testGetAktiviteter() {
////        System.out.println("getAktiviteter");
//        Service instance = new Service();
//        List<Aktivitet> expResult = null;
//        List<Aktivitet> result = instance.getAktiviteter();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createAktivitet method, of class Service.
//     */
//    @Test
//    public void testAddAktivitet() {
////        System.out.println("createAktivitet");
//        DefaultScheduleEvent event = null;
//        Service instance = new Service();
//        instance.createAktivitet(event);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addBeboer method, of class Service.
//     */
//    @Test
//    public void testAddBeboer() {
////        System.out.println("addBeboer");
//        String navn = "";
//        Service instance = new Service();
//        Beboer expResult = null;
//        Beboer result = instance.addBeboer(navn);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getBeboere method, of class Service.
//     */
//    @Test
//    public void testGetBeboere() {
////        System.out.println("getBeboere");
//        Service instance = new Service();
//        List<Beboer> expResult = null;
//        List<Beboer> result = instance.getBeboere();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getMedarbejdere method, of class Service.
//     */
//    @Test
//    public void testGetMedarbejdere() {
////        System.out.println("getMedarbejdere");
//        Service instance = new Service();
//        List<Medarbejder> expResult = null;
//        List<Medarbejder> result = instance.getMedarbejdere();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addMedarbejder method, of class Service.
//     */
//    @Test
//    public void testAddMedarbejder() {
////        System.out.println("addMedarbejder");
//        String navn = "";
//        Service instance = new Service();
//        Medarbejder expResult = null;
//        Medarbejder result = instance.addMedarbejder(navn);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getResourcer method, of class Service.
//     */
//    @Test
//    public void testGetResourcer() {
////        System.out.println("getResourcer");
//        Service instance = new Service();
//        List<Resource> expResult = null;
//        List<Resource> result = instance.getResourcer();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPersonResourcer method, of class Service.
//     */
//    @Test
//    public void testGetPersonResourcer() {
////        System.out.println("getPersonResourcer");
//        Service instance = new Service();
//        List<PersonResource> expResult = null;
//        List<PersonResource> result = instance.getPersonResourcer();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getAktiviterPaaDag method, of class Service.
     */
    @Test
    public void testGetAktiviterPaaDag() {
//        System.out.println("getAktiviterPaaDag");
        LocalDate ldt = LocalDate.now();
        Service instance = new Service();
        List<Aktivitet> res = instance.getAktiviterPaaDag(ldt);
        System.out.println(ldt + " " + res);
        assertEquals(2, res.size());
    }
    
    @Test
    public void testGetAktiviteter(){
         Service instance = new Service();
        List<Aktivitet> res = instance.getAktiviteter();
        assertEquals(2, res.size());
    }
    
}
