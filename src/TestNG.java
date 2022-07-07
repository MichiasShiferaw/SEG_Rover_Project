import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.testng.annotations.AfterClass;

public class TestNG {
	private static double grade=0.0;
  @BeforeClass
  public void beforeClass() {
	  System.out.println("\n---------------Test Rover--------------");
		Rover lunar= new Rover();
		assertEquals("Null",lunar.getStateVehiculeOn().toString());
		grade+=1.0;
		assertNotNull(lunar.getState());
		grade+=1.0;
	  
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Michias");
		System.out.println("\nGrade for Test (out of a possible 110): " + grade);
		System.out.println("Number of Failed Tests: "+ (110-grade));
  }


  @Test
  public void RoverTest() {
	  System.out.println("\n---------------Test Rover--------------");
		Rover lunar= new Rover();
		assertEquals("Null",lunar.getStateVehiculeOn().toString());
		grade+=1.0;
		assertNotNull(lunar.getState());
		grade+=1.0;
  }

	/*
	 * @Test public void exitStateTest() { throw new
	 * RuntimeException("Test not implemented"); }
	 * 
	 * @Test public void exitStateVehiculeOnTest() { throw new
	 * RuntimeException("Test not implemented"); }
	 */

	@Test
	public void testGetState() {
		System.out.println("\n---------------Test GetState--------------");
		Rover lunar= new Rover();
		assertEquals("Null",lunar.getStateVehiculeOn().toString());
		grade+=1.0;
		assertNotNull(lunar.getState());
		grade+=1.0;
		lunar.turnKeyPressRightPedal();// turn on rover, into park gear
		assertEquals("vehiculeOn", lunar.getState().toString());
		grade+=1.0;
		lunar.getStateVehiculeOn().toString();
		lunar.pressLeftPedalTwice();//shift to neutral
		assertEquals("neutral", lunar.getStateVehiculeOn().toString());
		lunar.setTime(10);
		lunar.pressLeftPedal();//acceleratebackwards (hold for 5 or more seconds)
		assertFalse(lunar.pressLeftRightPedal());
		grade+=1.0;
		assertTrue(lunar.pressLeftPedalTwice());
		grade+=1.0;
		assertTrue (lunar.pressLeftRightPedal());
		grade+=1.0;
		assertTrue(lunar.releasePedals());
		grade+=1.0;
		assertEquals("neutral", lunar.getStateVehiculeOn().toString());
		grade+=1.0;
		lunar.pressLeftRightPedal();
		assertEquals("vehiculeOn", lunar.getState().toString());
		lunar.releasePedals();
		assertTrue(lunar.pressRightPedal());
		grade+=1.0;
	}
	
	@Test
	public void testGetState2() {
		System.out.println("\n---------------Test GetState--------------");
		Rover lunar= new Rover();
		assertEquals("Null",lunar.getStateVehiculeOn().toString());
		grade+=1.0;
		assertNotNull(lunar.getState());
		grade+=1.0;
		lunar.turnKeyPressRightPedal();// turn on rover, into park gear
		assertEquals("vehiculeOn", lunar.getState().toString());
		grade+=1.0;
		lunar.getStateVehiculeOn().toString();
		lunar.pressLeftPedalTwice();//shift to neutral
		assertEquals("neutral", lunar.getStateVehiculeOn().toString());
		lunar.setTime(1);
		lunar.pressLeftPedal();//acceleratebackwards (hold for less than 5 seconds)
		assertEquals("neutral", lunar.getStateVehiculeOn().toString());
		assertTrue(lunar.pressLeftPedalOnce());
		grade+=1.0;
		assertEquals("accelerateforward", lunar.getStateVehiculeOn().toString());
		grade+=1.0;
		assertTrue(lunar.pressLeftRightPedal());
		grade+=1.0;
		assertTrue(lunar.releasePedals());
		grade+=1.0;
		assertEquals("neutral", lunar.getStateVehiculeOn().toString());
		grade+=1.0;
		lunar.pressLeftRightPedal();
		assertEquals("vehiculeOn", lunar.getState().toString());
		lunar.releasePedals();
		assertTrue(lunar.pressRightPedal());
		grade+=1.0;
	}

  @Test
  public void getStateFullNameTest() {
	  System.out.println("\n---------------Test StateFullName--------------");
		Rover lunar= new Rover();
		assertEquals("Null",lunar.getStateVehiculeOn().toString());
		grade+=1.0;
		assertNotNull(lunar.getState());
		grade+=1.0;
  }

  @Test
  public void getStateVehiculeOnTest() {
	  System.out.println("\n---------------Test Get State Vehicule On--------------");
		Rover lunar= new Rover();
		assertEquals("Null",lunar.getStateVehiculeOn().toString());
		grade+=1.00;
		assertNotNull(lunar.getState());
		grade+=1.00;
		lunar.turnKeyPressRightPedal();// turn on rover, into park gear
		assertEquals("vehiculeOn", lunar.getState().toString());
		grade+=1.00;
		assertEquals("park", lunar.getStateVehiculeOn().toString());
		grade+=1.00;
		lunar.pressLeftPedalTwice();//shift to neutral
		assertEquals("neutral", lunar.getStateVehiculeOn().toString());
		grade+=1.00;
		lunar.setTime(4);
		lunar.pressLeftPedal();//acceleratebackwards (hold for 5 or more seconds)
		assertEquals("neutral", lunar.getStateVehiculeOn().toString());
		grade+=1.00;
		assertTrue(lunar.pressLeftPedalOnce());
		grade+=1.00;
		assertTrue(lunar.pressLeftRightPedal());
		grade+=1.00;
		assertEquals("brake", lunar.getStateVehiculeOn().toString());
		grade+=1.00;
		assertTrue(lunar.releasePedals());
		grade+=1.00;
		assertEquals("neutral", lunar.getStateVehiculeOn().toString());
		grade+=1.0;
		assertTrue(lunar.pressRightPedal());
		grade+=1.00;
		assertTrue(lunar.removeKey());
		grade+=1.00;
		assertEquals("engineOff", lunar.getState().toString());
		grade+=1.00;
  }

	/*
	 * @Test public void noChangeTestStateVehiculeOn() { throw new
	 * RuntimeException("Test not implemented"); }
	 */

	/*
	 * @Test public void noChangeTestState() { throw new
	 * RuntimeException("Test not implemented"); }
	 */

  @Test
  public void pressButton1OnceHoldDownBothPedalsTest() {
	  System.out.println("\n---------------Testing Pressing Button 1 and Holding Both Pedals--------------");
		Rover lunar= new Rover();
		assertEquals("Null",lunar.getStateVehiculeOn().toString());
		grade+=1.00;
		assertNotNull(lunar.getState());
		grade+=1.00;
		lunar.turnKeyPressRightPedal();// turn on rover, into park gear
		assertFalse(lunar.pressLeftRightPedal());
		grade+=1.00;
		lunar.pressLeftPedalTwice();
		lunar.pressLeftPedalOnce();
		lunar.setTime(5);
		assertEquals("accelerateforward",lunar.getStateVehiculeOn().toString());
		grade+=1.00;
		assertTrue(lunar.pressRightPedalOnce());
		grade+=1.00;
		assertEquals("constantspeedforward",lunar.getStateVehiculeOn().toString());
		grade+=1.00;
		assertTrue(lunar.pressButton1OnceHoldDownBothPedals());
		grade+=1.00;
		assertFalse(lunar.releasePedals());
		grade+=1.00;
		assertTrue(lunar.releaseRightPedal());
		grade+=1.00;
		assertEquals("constantspeedforward",lunar.getStateVehiculeOn().toString());
		grade+=1.00;
  }

	@Test
	public void testPressLeftPedal() {
		System.out.println("\n---------------Testing Press Left Pedal --------------");
		Rover lunar= new Rover();
		assertEquals("Null",lunar.getStateVehiculeOn().toString());
		grade+=1.00;
		assertNotNull(lunar.getState());
		grade+=1.00;
		lunar.turnKeyPressRightPedal();// turn on rover, into park gear
		assertTrue(lunar.pressLeftPedalTwice());
		grade+=1.00;
		lunar.setTime(100);
		assertTrue(lunar.pressLeftPedal());
		grade+=1.00;
		assertEquals("acceleratebackwards", lunar.getStateVehiculeOn().toString());
		grade+=1.00;
		
	}
  
	@Test
	public void testPressLeftPedal2() {
		System.out.println("\n---------------Testing Press Left Pedal --------------");
		Rover lunar= new Rover();
		assertEquals("Null",lunar.getStateVehiculeOn().toString());
		grade+=1.00;
		assertNotNull(lunar.getState());
		grade+=1.00;
		lunar.turnKeyPressRightPedal();// turn on rover, into park gear
		assertTrue(lunar.pressLeftPedalTwice());
		grade+=1.00;
		lunar.setTime(2);
		assertFalse(lunar.pressLeftPedal());
		grade+=1.00;
		assertEquals("neutral", lunar.getStateVehiculeOn().toString());
		grade+=1.00;
		
	}

  @Test
  public void pressLeftPedalOnceTest() {
	  System.out.println("\n---------------Testing Press Left Pedal ONCE--------------");
		Rover lunar= new Rover();
		assertEquals("Null",lunar.getStateVehiculeOn().toString());
		grade+=1.00;
		assertNotNull(lunar.getState());
		grade+=1.00;
		lunar.turnKeyPressRightPedal();// turn on rover, into park gear
		assertTrue(lunar.pressLeftPedalTwice());
		grade+=1.00;
		assertTrue(lunar.pressLeftPedalOnce());
		grade+=1.00;
		assertEquals("accelerateforward",lunar.getStateVehiculeOn().toString());
		grade+=1.00;
  }

  @Test
  public void pressLeftPedalTwiceTest() {
	  System.out.println("\n---------------Testing Press Left Pedal Twice--------------");
		Rover lunar= new Rover();
		assertFalse(lunar.pressLeftPedalTwice());
		grade+=1.00;
		assertEquals("Null",lunar.getStateVehiculeOn().toString());
		grade+=1.00;
		assertNotNull(lunar.getState());
		grade+=1.00;
		assertFalse(lunar.pressLeftPedalTwice());
		grade+=1.00;
		assertEquals("Null", lunar.getStateVehiculeOn().toString());
		grade+=1.00;
		assertFalse(lunar.pressLeftPedalTwice());
		grade+=1.00;
  }

  @Test
  public void pressLeftRightPedalTest() {
	  System.out.println("\n---------------Testing Press Left Right Pedal--------------");
		Rover lunar= new Rover();
		assertEquals("Null",lunar.getStateVehiculeOn().toString());
		grade+=1.00;
		assertNotNull(lunar.getState());
		grade+=1.00;
		lunar.turnKeyPressRightPedal();// turn on rover, into park gear
		assertFalse(lunar.pressLeftRightPedal());
		grade+=1.00;
		assertTrue(lunar.pressLeftPedalTwice());
		grade+=1.00;
		assertTrue(lunar.pressLeftPedalOnce());
		grade+=1.00;
		assertEquals("accelerateforward",lunar.getStateVehiculeOn().toString());
		grade+=1.00;
		assertTrue(lunar.pressLeftRightPedal());
		grade+=1.00;
		assertEquals("brake",lunar.getStateVehiculeOn().toString());
		grade+=1.00;
  }

  @Test
  public void pressRightPedalTest() {
	  System.out.println("\n---------------Testing Press Right Pedal--------------");
		Rover lunar= new Rover();
		assertEquals("Null",lunar.getStateVehiculeOn().toString());
		grade+=1.00;
		assertNotNull(lunar.getState());
		grade+=1.00;
		assertFalse(lunar.pressRightPedal());
		grade+=1.00;
		assertTrue(lunar.turnKeyPressRightPedal());// turn on rover, into park gear)
		grade+=1.00;
		assertEquals("vehiculeOn", lunar.getState().toString());
		grade+=1.00;
		assertFalse(lunar.releasePedals());
		grade+=1.00;
		assertTrue(lunar.pressLeftPedalTwice());
		grade+=1.00;
		assertTrue(lunar.pressRightPedal());
		grade+=1.00;
		assertEquals("park", lunar.getStateVehiculeOn().toString());
		grade+=1.00;
  }

  @Test
  public void pressRightPedalOnceTest() {
	  System.out.println("\n---------------Testing Press Right Pedal ONCE--------------");
		Rover lunar= new Rover();
		assertEquals("Null",lunar.getStateVehiculeOn().toString());
		grade+=1.00;
		assertNotNull(lunar.getState());
		grade+=1.00;
		lunar.setTime(0);
		lunar.turnKeyPressRightPedal();// turn on rover, into park gear
		lunar.pressLeftRightPedal();
		assertTrue(lunar.pressLeftPedalTwice());
		grade+=1.00;
		assertTrue(lunar.pressLeftPedalOnce());
		grade+=1.00;
		assertEquals("accelerateforward",lunar.getStateVehiculeOn().toString());
		grade+=1.00;
		lunar.setTime(6);
		assertTrue(lunar.pressRightPedalOnce());
		grade+=1.00;
		assertEquals("constantspeedforward",lunar.getStateVehiculeOn().toString());
		grade+=1.00;
  }
  
  @Test
  public void pressRightPedalOnceTest2() {
	  System.out.println("\n---------------Testing Press Right Pedal ONCE--------------");
		Rover lunar= new Rover();
		assertEquals("Null",lunar.getStateVehiculeOn().toString());
		grade+=1.00;
		assertNotNull(lunar.getState());
		grade+=1.00;
		lunar.setTime(6);
		lunar.turnKeyPressRightPedal();// turn on rover, into park gear
		lunar.pressLeftRightPedal();
		assertTrue(lunar.pressLeftPedalTwice());
		grade+=1.00;
		assertTrue(lunar.pressLeftPedalOnce());
		grade+=1.00;
		assertEquals("accelerateforward",lunar.getStateVehiculeOn().toString());
		grade+=1.00;
		lunar.setTime(0);
		assertFalse(lunar.pressRightPedalOnce());
		grade+=1.00;
		assertEquals("accelerateforward",lunar.getStateVehiculeOn().toString());
		grade+=1.00;
  }

  @Test
  public void pressRightPedalTwiceTest() {
	  System.out.println("\n---------------Testing Press Right Pedal Twice--------------");
		Rover lunar= new Rover();
		assertEquals("Null",lunar.getStateVehiculeOn().toString());
		grade+=1.00;
		assertNotNull(lunar.getState());
		grade+=1.00;
		lunar.turnKeyPressRightPedal();// turn on rover, into park gear
		assertFalse(lunar.pressLeftRightPedal());
		grade+=1.00;
		assertTrue(lunar.pressLeftPedalTwice());
		grade+=1.00;
		assertTrue(lunar.pressLeftPedalOnce());
		grade+=1.00;
		assertEquals("accelerateforward",lunar.getStateVehiculeOn().toString());
		grade+=1.00;
		assertTrue(lunar.pressRightPedalTwice());
		grade+=1.00;
		assertEquals("deaccelerateforward",lunar.getStateVehiculeOn().toString());
		grade+=1.00;
  }

  @Test
  public void releasePedalsTest() {
	  System.out.println("\n---------------Testing Release Pedals--------------");
		Rover lunar= new Rover();
		assertEquals("Null",lunar.getStateVehiculeOn().toString());
		grade+=1.0;
		assertNotNull(lunar.getState());
		grade+=1.0;
		lunar.turnKeyPressRightPedal();// turn on rover, into park gear
		assertEquals("vehiculeOn", lunar.getState().toString());
		grade+=1.0;
		lunar.getStateVehiculeOn().toString();
		lunar.pressLeftPedalTwice();//shift to neutral
		assertEquals("neutral", lunar.getStateVehiculeOn().toString());
		lunar.setTime(6);
		lunar.pressLeftPedal();//acceleratebackwards (hold for 5 or more seconds)
		assertFalse(lunar.pressLeftRightPedal());
		grade+=1.0;
		assertTrue(lunar.pressLeftPedalTwice());
		grade+=1.0;
		assertTrue (lunar.pressLeftRightPedal());
		grade+=1.0;
		assertTrue(lunar.releasePedals());
		grade+=1.0;
		assertEquals("neutral", lunar.getStateVehiculeOn().toString());
		grade+=1.0;
  }
  
  @Test
  public void releasePedalsTest2() {
	  System.out.println("\n---------------Testing Release Pedals--------------");
		Rover lunar= new Rover();
		assertEquals("Null",lunar.getStateVehiculeOn().toString());
		grade+=1.0;
		assertNotNull(lunar.getState());
		grade+=1.0;
		lunar.turnKeyPressRightPedal();// turn on rover, into park gear
		assertEquals("vehiculeOn", lunar.getState().toString());
		grade+=1.0;
		lunar.getStateVehiculeOn().toString();
		lunar.pressLeftPedalTwice();//shift to neutral
		assertEquals("neutral", lunar.getStateVehiculeOn().toString());
		lunar.setTime(4);
		//lunar.pressLeftPedal();//acceleratebackwards (hold for 5 or more seconds)
		assertFalse(lunar.pressLeftPedal());
		grade+=1.0;
		assertTrue(lunar.pressLeftPedalOnce());
		grade+=1.0;
		assertTrue (lunar.pressLeftRightPedal());
		grade+=1.0;
		assertTrue(lunar.releasePedals());
		grade+=1.0;
		assertEquals("neutral", lunar.getStateVehiculeOn().toString());
		grade+=1.0;
  }

  @Test
  public void releaseRightPedalTest() {
	  System.out.println("\n---------------Testing Release Right Pedal--------------");
		Rover lunar= new Rover();
		assertEquals("Null",lunar.getStateVehiculeOn().toString());
		grade+=1.00;
		assertNotNull(lunar.getState());
		grade+=1.00;
		lunar.turnKeyPressRightPedal();// turn on rover, into park gear
		assertFalse(lunar.pressLeftRightPedal());
		grade+=0.50;
		lunar.pressLeftPedalTwice();
		lunar.pressLeftPedalOnce();
		assertEquals("accelerateforward",lunar.getStateVehiculeOn().toString());
		grade+=0.50;
		lunar.setTime(25);
		assertTrue(lunar.pressRightPedalOnce());
		grade+=0.50;
		assertEquals("constantspeedforward",lunar.getStateVehiculeOn().toString());
		grade+=0.50;
		assertTrue(lunar.pressButton1OnceHoldDownBothPedals());
		grade+=1.00;
		assertFalse(lunar.releasePedals());
		grade+=1.00;
		assertTrue(lunar.releaseRightPedal());
		grade+=1.00;
		assertEquals("constantspeedforward",lunar.getStateVehiculeOn().toString());
		grade+=1.00;
  }
  
  
  @Test
  public void releaseRightPedalTest2() {
	  System.out.println("\n---------------Testing Release Right Pedal--------------");
		Rover lunar= new Rover();
		assertEquals("Null",lunar.getStateVehiculeOn().toString());
		grade+=1.00;
		assertNotNull(lunar.getState());
		grade+=1.00;
		lunar.turnKeyPressRightPedal();// turn on rover, into park gear
		assertFalse(lunar.pressLeftRightPedal());
		grade+=0.50;
		lunar.pressLeftPedalTwice();
		lunar.pressLeftPedalOnce();
		assertEquals("accelerateforward",lunar.getStateVehiculeOn().toString());
		grade+=0.50;
		lunar.setTime(0);
		assertFalse(lunar.pressRightPedalOnce());
		grade+=0.50;
  }

  @Test
  public void removeKeyTest() {
	  System.out.println("\n---------------Testing Remove Key--------------");
		Rover lunar= new Rover();
		assertEquals("Null",lunar.getStateVehiculeOn().toString());
		grade+=1.00;
		assertNotNull(lunar.getState());
		grade+=1.00;
		lunar.turnKeyPressRightPedal();
		lunar.pressLeftPedalTwice();
		assertEquals("neutral", lunar.getStateVehiculeOn().toString());
		grade+=1.00;
		assertTrue(lunar.pressRightPedal());
		grade+=1.00;
		assertTrue(lunar.removeKey());
		grade+=1.0;
  }

	/*
	 * @Test public void setStateTest() { throw new
	 * RuntimeException("Test not implemented"); }
	 * 
	 * @Test public void setStateVehiculeOnTest() { throw new
	 * RuntimeException("Test not implemented"); }
	 * 
	 * @Test public void setTimeTestint() { throw new
	 * RuntimeException("Test not implemented"); }
	 * 
	 * @Test public void setTimeTest() { throw new
	 * RuntimeException("Test not implemented"); }
	 */

  @Test
  public void turnKeyPressRightPedalTest() {
	  System.out.println("\n---------------Testing Turn Key and Press Right Pedal--------------");
		Rover lunar= new Rover();
		assertEquals("Null",lunar.getStateVehiculeOn().toString());
		grade+=1.00;
		assertNotNull(lunar.getState());
		grade+=1.00;
		assertTrue(lunar.turnKeyPressRightPedal());
		assertEquals("vehiculeOn", lunar.getState().toString());
		grade+=1.00;
		assertFalse(lunar.turnKeyPressRightPedal());//already in this state
		grade+=1.00;
  }
}
