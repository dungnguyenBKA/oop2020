package hust.soict.hedspi.test.utils;//package hedspi.test.utils;
//
//import hedspi.aims.media.DigitalVideoDisc;
//import hedspi.aims.order.Order;
//import org.testng.annotations.Test;
//
//import static org.junit.Assert.*;
//import static org.junit.Assert.assertEquals;
//
//public class OrderTest {
//    //   Sai so
//    private static final double DELTA = 0.02;
//
//    @Test
//    public void testTotalCost() {
//        Order anOrder = new Order();
//        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
//        dvd1.setCost(19.95f);
//        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Start wars");
//        dvd2.setCost(24.95f);
//        anOrder.addDigitalVideoDisc(dvd1);
//        anOrder.addDigitalVideoDisc(dvd2);
//        float cost = anOrder.totalCost();
//        System.out.println("cost" + cost);
//        assertEquals(44.9, cost, DELTA);
//        assertEquals(true, anOrder.search("The Lion King"));
//        assertEquals(false, anOrder.search("123123"));
//    }
//}