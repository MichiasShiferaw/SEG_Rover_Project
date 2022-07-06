package rover;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;


/**  @author Michias Shiferaw
 *  @version 2.0
 *  @since 2022-05-28
 */

public class RoverTest {
    private static double grade=0.0;
    @BeforeClass
    public static void BeforeClass() {
        System.out.println("Hello Folks");
    }

    @AfterClass
    public static void AfterClass() {
        System.out.println("\nGrade for Test (out of a possible 110): " + grade);
        System.out.println("Number of Failed Tests: "+ (110-grade));

    }
    @Test
    public void testRover() {
        System.out.println("\n---------------Test Rover--------------");
        Rover titantic= new Rover();
        assertEquals("Null",titantic.getStateVehiculeOn().toString());
        grade+=1.0;
        assertNotNull(titantic.getState());
        grade+=1.0;
    }

    @Test
    public void testGetStateFullName() {
        System.out.println("\n---------------Test StateFullName--------------");
        Rover titantic= new Rover();
        assertEquals("Null",titantic.getStateVehiculeOn().toString());
        grade+=1.0;
        assertNotNull(titantic.getState());
        grade+=1.0;
    }

    @Test
    public void testGetState() {
        System.out.println("\n---------------Test GetState--------------");
        Rover titantic= new Rover();
        assertEquals("Null",titantic.getStateVehiculeOn().toString());
        grade+=1.0;
        assertNotNull(titantic.getState());
        grade+=1.0;
        titantic.turnKeyPressRightPedal();// turn on Rover, into park gear
        assertEquals("vehiculeOn", titantic.getState().toString());
        grade+=1.0;
        titantic.getStateVehiculeOn().toString();
        titantic.pressLeftPedalTwice();//shift to neutral
        assertEquals("neutral", titantic.getStateVehiculeOn().toString());
        titantic.pressLeftPedal();//acceleratebackwards (hold for 5 or more seconds)
        assertFalse(titantic.pressLeftRightPedal());
        grade+=1.0;
        assertTrue(titantic.pressLeftPedalTwice());
        grade+=1.0;
        assertTrue (titantic.pressLeftRightPedal());
        grade+=1.0;
        assertTrue(titantic.releasePedals());
        grade+=1.0;
        assertEquals("neutral", titantic.getStateVehiculeOn().toString());
        grade+=1.0;
        titantic.pressLeftRightPedal();
        assertEquals("vehiculeOn", titantic.getState().toString());
        titantic.releasePedals();
        assertTrue(titantic.pressRightPedal());
        grade+=1.0;
    }

    @Test
    public void testGetStateVehiculeOn() {
        System.out.println("\n---------------Test Get State Vehicule On--------------");
        Rover titantic= new Rover();
        assertEquals("Null",titantic.getStateVehiculeOn().toString());
        grade+=1.00;
        assertNotNull(titantic.getState());
        grade+=1.00;
        titantic.turnKeyPressRightPedal();// turn on Rover, into park gear
        assertEquals("vehiculeOn", titantic.getState().toString());
        grade+=1.00;
        assertEquals("park", titantic.getStateVehiculeOn().toString());
        grade+=1.00;
        titantic.pressLeftPedalTwice();//shift to neutral
        assertEquals("neutral", titantic.getStateVehiculeOn().toString());
        grade+=1.00;
        titantic.pressLeftPedal();//acceleratebackwards (hold for 5 or more seconds)
        assertEquals("acceleratebackwards", titantic.getStateVehiculeOn().toString());
        grade+=1.00;
        assertFalse(titantic.pressLeftRightPedal());
        grade+=1.00;
        assertTrue(titantic.pressRightPedalOnce());
        grade+=1.00;
        assertEquals("constantspeedbackwards", titantic.getStateVehiculeOn().toString());
        grade+=1.00;
        titantic.pressLeftRightPedal();
        assertTrue(titantic.releasePedals());
        grade+=1.00;
        assertEquals("neutral", titantic.getStateVehiculeOn().toString());
        grade+=1.0;
        assertTrue(titantic.pressRightPedal());
        grade+=1.00;
        assertTrue(titantic.removeKey());
        grade+=1.00;
        assertEquals("engineOff", titantic.getState().toString());
        grade+=1.00;
    }

    @Test
    public void testTurnKeyPressRightPedal() {
        System.out.println("\n---------------Testing Turn Key and Press Right Pedal--------------");
        Rover titantic= new Rover();
        assertEquals("Null",titantic.getStateVehiculeOn().toString());
        grade+=1.00;
        assertNotNull(titantic.getState());
        grade+=1.00;
        assertTrue(titantic.turnKeyPressRightPedal());
        assertEquals("vehiculeOn", titantic.getState().toString());
        grade+=1.00;
        assertFalse(titantic.turnKeyPressRightPedal());//already in this state
        grade+=1.00;
    }

    @Test
    public void testPressLeftPedalTwice() {
        System.out.println("\n---------------Testing Press Left Pedal Twice--------------");
        Rover titantic= new Rover();
        assertFalse(titantic.pressLeftPedalTwice());
        grade+=1.00;
        assertEquals("Null",titantic.getStateVehiculeOn().toString());
        grade+=1.00;
        assertNotNull(titantic.getState());
        grade+=1.00;
        assertFalse(titantic.pressLeftPedalTwice());
        grade+=1.00;
        assertEquals("Null", titantic.getStateVehiculeOn().toString());
        grade+=1.00;
        assertFalse(titantic.pressLeftPedalTwice());
        grade+=1.00;
    }

    @Test
    public void testRemoveKey() {
        System.out.println("\n---------------Testing Remove Key--------------");
        Rover titantic= new Rover();
        assertEquals("Null",titantic.getStateVehiculeOn().toString());
        grade+=1.00;
        assertNotNull(titantic.getState());
        grade+=1.00;
        titantic.turnKeyPressRightPedal();
        titantic.pressLeftPedalTwice();
        assertEquals("neutral", titantic.getStateVehiculeOn().toString());
        grade+=1.00;
        assertTrue(titantic.pressRightPedal());
        grade+=1.00;
        assertTrue(titantic.removeKey());
        grade+=1.0;
    }

    @Test
    public void testPressRightPedal() {
        System.out.println("\n---------------Testing Press Right Pedal--------------");
        Rover titantic= new Rover();
        assertEquals("Null",titantic.getStateVehiculeOn().toString());
        grade+=1.00;
        assertNotNull(titantic.getState());
        grade+=1.00;
        assertFalse(titantic.pressRightPedal());
        grade+=1.00;
        assertTrue(titantic.turnKeyPressRightPedal());// turn on Rover, into park gear)
        grade+=1.00;
        assertEquals("vehiculeOn", titantic.getState().toString());
        grade+=1.00;
        assertFalse(titantic.releasePedals());
        grade+=1.00;
        assertTrue(titantic.pressLeftPedalTwice());
        grade+=1.00;
        assertTrue(titantic.pressRightPedal());
        grade+=1.00;
        assertEquals("park", titantic.getStateVehiculeOn().toString());
        grade+=1.00;
    }

    @Test
    public void testPressLeftPedalOnce() {
        System.out.println("\n---------------Testing Press Left Pedal ONCE--------------");
        Rover titantic= new Rover();
        assertEquals("Null",titantic.getStateVehiculeOn().toString());
        grade+=1.00;
        assertNotNull(titantic.getState());
        grade+=1.00;
        titantic.turnKeyPressRightPedal();// turn on Rover, into park gear
        assertTrue(titantic.pressLeftPedalTwice());
        grade+=1.00;
        assertTrue(titantic.pressLeftPedalOnce());
        grade+=1.00;
        assertEquals("accelerateforward",titantic.getStateVehiculeOn().toString());
        grade+=1.00;
    }

    @Test
    public void testPressLeftPedal() {
        System.out.println("\n---------------Testing Press Left Pedal --------------");
        Rover titantic= new Rover();
        assertEquals("Null",titantic.getStateVehiculeOn().toString());
        grade+=1.00;
        assertNotNull(titantic.getState());
        grade+=1.00;
        titantic.turnKeyPressRightPedal();// turn on Rover, into park gear
        assertTrue(titantic.pressLeftPedalTwice());
        grade+=1.00;
        assertTrue(titantic.pressLeftPedal());
        grade+=1.00;
        assertEquals("acceleratebackwards", titantic.getStateVehiculeOn().toString());
        grade+=1.00;

    }

    @Test
    public void testPressLeftRightPedal() {
        System.out.println("\n---------------Testing Press Left Right Pedal--------------");
        Rover titantic= new Rover();
        assertEquals("Null",titantic.getStateVehiculeOn().toString());
        grade+=1.00;
        assertNotNull(titantic.getState());
        grade+=1.00;
        titantic.turnKeyPressRightPedal();// turn on Rover, into park gear
        assertFalse(titantic.pressLeftRightPedal());
        grade+=1.00;
        assertTrue(titantic.pressLeftPedalTwice());
        grade+=1.00;
        assertTrue(titantic.pressLeftPedalOnce());
        grade+=1.00;
        assertEquals("accelerateforward",titantic.getStateVehiculeOn().toString());
        grade+=1.00;
        assertTrue(titantic.pressLeftRightPedal());
        grade+=1.00;
        assertEquals("brake",titantic.getStateVehiculeOn().toString());
        grade+=1.00;
    }

    @Test
    public void testPressRightPedalTwice() {
        System.out.println("\n---------------Testing Press Right Pedal Twice--------------");
        Rover titantic= new Rover();
        assertEquals("Null",titantic.getStateVehiculeOn().toString());
        grade+=1.00;
        assertNotNull(titantic.getState());
        grade+=1.00;
        titantic.turnKeyPressRightPedal();// turn on Rover, into park gear
        assertFalse(titantic.pressLeftRightPedal());
        grade+=1.00;
        assertTrue(titantic.pressLeftPedalTwice());
        grade+=1.00;
        assertTrue(titantic.pressLeftPedalOnce());
        grade+=1.00;
        assertEquals("accelerateforward",titantic.getStateVehiculeOn().toString());
        grade+=1.00;
        assertTrue(titantic.pressRightPedalTwice());
        grade+=1.00;
        assertEquals("deaccelerateforward",titantic.getStateVehiculeOn().toString());
        grade+=1.00;
    }

    @Test
    public void testPressRightPedalOnce() {
        System.out.println("\n---------------Testing Press Right Pedal ONCE--------------");
        Rover titantic= new Rover();
        assertEquals("Null",titantic.getStateVehiculeOn().toString());
        grade+=1.00;
        assertNotNull(titantic.getState());
        grade+=1.00;
        titantic.turnKeyPressRightPedal();// turn on Rover, into park gear
        titantic.pressLeftRightPedal();
        assertTrue(titantic.pressLeftPedalTwice());
        grade+=1.00;
        assertTrue(titantic.pressLeftPedalOnce());
        grade+=1.00;
        assertEquals("accelerateforward",titantic.getStateVehiculeOn().toString());
        grade+=1.00;
        assertTrue(titantic.pressRightPedalOnce());
        grade+=1.00;
        assertEquals("constantspeedforward",titantic.getStateVehiculeOn().toString());
        grade+=1.00;
    }

    @Test
    public void testPressButton1OnceHoldDownBothPedals() {
        System.out.println("\n---------------Testing Pressing Button 1 and Holding Both Pedals--------------");
        Rover titantic= new Rover();
        assertEquals("Null",titantic.getStateVehiculeOn().toString());
        grade+=1.00;
        assertNotNull(titantic.getState());
        grade+=1.00;
        titantic.turnKeyPressRightPedal();// turn on Rover, into park gear
        assertFalse(titantic.pressLeftRightPedal());
        grade+=1.00;
        titantic.pressLeftPedalTwice();
        titantic.pressLeftPedalOnce();
        assertEquals("accelerateforward",titantic.getStateVehiculeOn().toString());
        grade+=1.00;
        assertTrue(titantic.pressRightPedalOnce());
        grade+=1.00;
        assertEquals("constantspeedforward",titantic.getStateVehiculeOn().toString());
        grade+=1.00;
        assertTrue(titantic.pressButton1OnceHoldDownBothPedals());
        grade+=1.00;
        assertFalse(titantic.releasePedals());
        grade+=1.00;
        assertTrue(titantic.releaseRightPedal());
        grade+=1.00;
        assertEquals("constantspeedforward",titantic.getStateVehiculeOn().toString());
        grade+=1.00;
    }

    @Test
    public void testReleaseRightPedal() {
        System.out.println("\n---------------Testing Release Right Pedal--------------");
        Rover titantic= new Rover();
        assertEquals("Null",titantic.getStateVehiculeOn().toString());
        grade+=1.00;
        assertNotNull(titantic.getState());
        grade+=1.00;
        titantic.turnKeyPressRightPedal();// turn on Rover, into park gear
        assertFalse(titantic.pressLeftRightPedal());
        grade+=0.50;
        titantic.pressLeftPedalTwice();
        titantic.pressLeftPedalOnce();
        assertEquals("accelerateforward",titantic.getStateVehiculeOn().toString());
        grade+=0.50;
        assertTrue(titantic.pressRightPedalOnce());
        grade+=0.50;
        assertEquals("constantspeedforward",titantic.getStateVehiculeOn().toString());
        grade+=0.50;
        assertTrue(titantic.pressButton1OnceHoldDownBothPedals());
        grade+=1.00;
        assertFalse(titantic.releasePedals());
        grade+=1.00;
        assertTrue(titantic.releaseRightPedal());
        grade+=1.00;
        assertEquals("constantspeedforward",titantic.getStateVehiculeOn().toString());
        grade+=1.00;
    }

    @Test
    public void testReleasePedals() {
        System.out.println("\n---------------Testing Release Pedals--------------");
        Rover titantic= new Rover();
        assertEquals("Null",titantic.getStateVehiculeOn().toString());
        grade+=1.0;
        assertNotNull(titantic.getState());
        grade+=1.0;
        titantic.turnKeyPressRightPedal();// turn on Rover, into park gear
        assertEquals("vehiculeOn", titantic.getState().toString());
        grade+=1.0;
        titantic.getStateVehiculeOn().toString();
        titantic.pressLeftPedalTwice();//shift to neutral
        assertEquals("neutral", titantic.getStateVehiculeOn().toString());
        titantic.pressLeftPedal();//acceleratebackwards (hold for 5 or more seconds)
        assertFalse(titantic.pressLeftRightPedal());
        grade+=1.0;
        assertTrue(titantic.pressLeftPedalTwice());
        grade+=1.0;
        assertTrue (titantic.pressLeftRightPedal());
        grade+=1.0;
        assertTrue(titantic.releasePedals());
        grade+=1.0;
        assertEquals("neutral", titantic.getStateVehiculeOn().toString());
        grade+=1.0;

    }

}

