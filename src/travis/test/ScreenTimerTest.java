package travis.test;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ScreenTimerTest {
	
	static ScreenTimer screenTimer1;
	static ScreenTimer screenTimer2;
	static ScreenTimer screenTimer3;

	public ScreenTimerTest() {
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		GregorianCalendar timeToOpenScreen1 = new GregorianCalendar(2014,1,1,10,0); 
		GregorianCalendar timeToCloseScreen1 = new GregorianCalendar(2014,1,1,20,0);
		screenTimer1 = new ScreenTimer(timeToOpenScreen1, timeToCloseScreen1);
		
		GregorianCalendar timeToOpenScreen2 = new GregorianCalendar(2014,1,1,11,0); 
		GregorianCalendar timeToCloseScreen2 = new GregorianCalendar(2014,1,1,11,0);
		screenTimer2 = new ScreenTimer(timeToOpenScreen2, timeToCloseScreen2);
		
		GregorianCalendar timeToOpenScreen3 = new GregorianCalendar(2014,1,1,0,0); 
		GregorianCalendar timeToCloseScreen3 = new GregorianCalendar(2014,1,1,0,0);
		screenTimer3 = new ScreenTimer(timeToOpenScreen3, timeToCloseScreen3);
		
		System.out.println("beforeclass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("afterclass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("teardown");
	}

	@Test
	public void test1Pre() {
		assertTrue(screenTimer1.isTimeToCloseScreen(new GregorianCalendar(2014,1,1,1,0)));
		assertFalse(screenTimer1.isTimeToOpenScreen(new GregorianCalendar(2014,1,1,1,0)));
	}
	
	@Test
	public void test1Mid() {
		assertTrue(screenTimer1.isTimeToOpenScreen(new GregorianCalendar(2014,1,1,11,0)));
		assertFalse(screenTimer1.isTimeToCloseScreen(new GregorianCalendar(2014,1,1,11,0)));
	}
	
	@Test
	public void test1Post() {		
		assertTrue(screenTimer1.isTimeToCloseScreen(new GregorianCalendar(2014,1,1,21,0)));
		assertFalse(screenTimer1.isTimeToOpenScreen(new GregorianCalendar(2014,1,1,21,0)));
	}
	
	@Test
	public void test2Pre() {
		assertFalse(screenTimer2.isTimeToCloseScreen(new GregorianCalendar(2014,1,1,1,0)));
		assertTrue(screenTimer2.isTimeToOpenScreen(new GregorianCalendar(2014,1,1,1,0)));
	}
	
	@Test
	public void test2Boundary() {
		assertFalse(screenTimer2.isTimeToCloseScreen(new GregorianCalendar(2014,1,1,11,0)));
		assertTrue(screenTimer2.isTimeToOpenScreen(new GregorianCalendar(2014,1,1,11,0)));
	}
	
	@Test
	public void test2Boundary2359() {
		assertFalse(screenTimer2.isTimeToCloseScreen(new GregorianCalendar(2014,1,1,23,59)));
		assertTrue(screenTimer2.isTimeToOpenScreen(new GregorianCalendar(2014,1,1,23,59)));
	}
	
	@Test
	public void test2Boundary2400() {
		assertFalse(screenTimer2.isTimeToCloseScreen(new GregorianCalendar(2014,1,1,24,0)));
		assertTrue(screenTimer2.isTimeToOpenScreen(new GregorianCalendar(2014,1,1,24,0)));
	}
	
	@Test
	public void test2Post() {		
		assertFalse(screenTimer2.isTimeToCloseScreen(new GregorianCalendar(2014,1,1,21,0)));
		assertTrue(screenTimer2.isTimeToOpenScreen(new GregorianCalendar(2014,1,1,21,0)));
	}
	
	@Test
	public void test3Boundary() {
		assertFalse(screenTimer3.isTimeToCloseScreen(new GregorianCalendar(2014,1,1,0,0)));
		assertTrue(screenTimer3.isTimeToOpenScreen(new GregorianCalendar(2014,1,1,0,0)));
	}
	
	@Test
	public void test3Post() {		
		assertFalse(screenTimer3.isTimeToCloseScreen(new GregorianCalendar(2014,1,1,21,0)));
		assertTrue(screenTimer3.isTimeToOpenScreen(new GregorianCalendar(2014,1,1,21,0)));
	}
	
	@Test
	public void test3Boundary2359() {
		assertFalse(screenTimer3.isTimeToCloseScreen(new GregorianCalendar(2014,1,1,23,59)));
		assertTrue(screenTimer3.isTimeToOpenScreen(new GregorianCalendar(2014,1,1,23,59)));
	}
	
	@Test
	public void test3Boundary2400() {
		assertFalse(screenTimer3.isTimeToCloseScreen(new GregorianCalendar(2014,1,1,24,0)));
		assertTrue(screenTimer3.isTimeToOpenScreen(new GregorianCalendar(2014,1,1,24,0)));
	}
	
//	@Test
//	public void test() {
//		assertTrue(screenTimer.isTimeToCloseScreen(new GregorianCalendar(2014,1,1,1,0)));
//		assertTrue(screenTimer.isTimeToOpenScreen(new GregorianCalendar(2014,1,1,11,0)));
//		assertTrue(screenTimer.isTimeToCloseScreen(new GregorianCalendar(2014,1,1,21,0)));
//		
//		assertFalse(screenTimer.isTimeToOpenScreen(new GregorianCalendar(2014,1,1,1,0)));
//		assertFalse(screenTimer.isTimeToCloseScreen(new GregorianCalendar(2014,1,1,11,0)));
//		assertFalse(screenTimer.isTimeToOpenScreen(new GregorianCalendar(2014,1,1,21,0)));
//	}

}

