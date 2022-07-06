package calculator;
//
//import org.junit.Assert;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//public class CalculatorTest {
//
//    private static Calculator calculator;
//
//    @BeforeClass
//    public static void init() {
//        calculator = new Calculator();
//    }
//
//    @Test
//    public void addTwoNumbersTest() {
//        Assert.assertEquals(3, calculator.addTwoNumbers("2","1"));
//    }
//
//    @Test
//    public void subTwoNumbersTest() {
//        Assert.assertEquals(4, calculator.subTwoNumbers(5, 1));
//    }
//
//    @Test
//    public void multiplyTwoNumbersTest() {
//        Assert.assertEquals(6, calculator.multiplyTwoNumbers(3, 2));
//    }
//
//    @Test
//    public void divTwoNumbersTest() {
//        Assert.assertEquals(2, calculator.divTwoNumbers(6, 3));
//    }
//
//
//}


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    private static double grade=0;

    @BeforeClass
    public static void BeforeClass() {

        System.out.println("class tested;\n calculator");
    }

    @AfterClass
    public static void AfterClass() {
        System.out.println(" Grade for Test (out of a possible 49.0 ): " + grade);
    }

    @Test // weight: 7
    public void nullTest() {
        Calculator calc=new Calculator();
        String op1="null";
        String op2 ="null";
        double expected=-1;
        double actual = calc.add(op1,op2);
        assertEquals(expected,actual,0.001);
        grade+=1;
        actual = calc.diff(op1,op2);
        assertEquals(expected,actual,0.001);
        grade+=1;
        actual = calc.div(op1,op2);
        assertEquals(expected,actual,0.001);
        grade+=1;
        actual = calc.mul(op1,op2);
        assertEquals(expected,actual,0.001);
        grade+=1;
        actual = calc.expon(op1,op2);
        assertEquals(expected,actual,0.001);
        grade+=1;
        actual = calc.log10(op1);
        assertEquals(expected,actual,0.001);
        grade+=1;
        actual = calc.ceilingval(op1);
        assertEquals(expected,actual,0.001);
        grade+=1;
        actual = calc.ln(op1);
        assertEquals(expected,actual,0.001);
        grade+=1;
        actual = calc.root1(op1, op2);
        assertEquals(expected,actual,0.001);
        grade+=1;
        actual = calc.areaOfCircle(op1);
        assertEquals(expected,actual,0.001);
        grade+=1;
        actual = calc.inverse(op1);
        assertEquals(expected,actual,0.001);
        grade+=1;
        actual = calc.hypotenuse(op1, op2);
        assertEquals(expected,actual,0.001);
        grade+=1;
    }

    @Test // weight: 3
    public void addTest() {
        Calculator calc=new Calculator();

        String op1="3";
        String op2 ="5";
        double expected=8;
        double actual = calc.add(op1,op2);
        assertEquals(expected,actual,0.001);
        grade+=1;

        op1="-123";
        op2 ="-531";
        expected=-654;
        actual = calc.add(op1,op2);
        assertEquals(expected,actual,0.001);
        grade+=1;

        op1="123";
        op2 ="-531";
        expected=-408;
        actual = calc.add(op1,op2);
        assertEquals(expected,actual,0.001);
        grade+=1;
    }

    @Test // weight: 4
    public void diffTest() {
        Calculator calc=new Calculator();

        String op1="20";
        String op2 ="14";
        double expected=6;
        double actual = calc.diff(op1,op2);
        assertEquals(expected,actual,0.001);
        grade+=1;

        op1="-20";
        op2 ="5";
        expected=-25;
        actual = calc.diff(op1,op2);
        assertEquals(expected,actual,0.001);
        grade+=1;

        op1="20";
        op2 ="-5";
        expected=25;
        actual = calc.diff(op1,op2);
        assertEquals(expected,actual,0.001);
        grade+=1;

        op1="-25";
        op2 ="-5";
        expected=-20;
        actual = calc.diff(op1,op2);
        assertEquals(expected,actual,0.001);
        grade+=1;
    }

    @Test // weight: 4
    public void divTest() {
        Calculator calc=new Calculator();

        String op1="100";
        String op2 ="100";
        double expected=1;
        double actual = calc.div(op1,op2);
        assertEquals(expected,actual,0.001);
        grade+=1;

        op1="100";
        op2 ="-100";
        expected=-1;
        actual = calc.div(op1,op2);
        assertEquals(expected,actual,0.001);
        grade+=1;

        op1="0";
        op2 ="-100";
        expected=0;
        actual = calc.div(op1,op2);
        assertEquals(expected,actual,0.001);
        grade+=1;

        op1="-100";
        op2 ="-100";
        expected=1;
        actual = calc.div(op1,op2);
        assertEquals(expected,actual,0.001);
        grade+=1;
    }

    @Test // weight: 4
    public void mulTest() {
        Calculator calc=new Calculator();

        String op1="2";
        String op2 ="100";
        double expected=200;
        double actual = calc.mul(op1,op2);
        assertEquals(expected,actual,0.001);
        grade+=1;

        op1="0";
        op2 ="100";
        expected=0;
        actual = calc.mul(op1,op2);
        assertEquals(expected,actual,0.001);
        grade+=1;

        op1="-100";
        op2 ="-1";
        expected=100;
        actual = calc.mul(op1,op2);
        assertEquals(expected,actual,0.001);
        grade+=1;

        op1="-100";
        op2 ="1";
        expected=-100;
        actual = calc.mul(op1,op2);
        assertEquals(expected,actual,0.001);
        grade+=1;
    }

    @Test // weight: 4
    public void exponTest() {
        Calculator calc=new Calculator();

        String op1="100";
        String op2 ="3";
        double expected=1000000;
        double actual = calc.expon(op1,op2);
        assertEquals(expected,actual,0.001);
        grade+=1;

        op1="100";
        op2 ="-3";
        expected=0.000001;
        actual = calc.expon(op1,op2);
        assertEquals(expected,actual,0.001);
        grade+=1;

        op1="-100";
        op2 ="-2";
        expected=0.0001;
        actual = calc.expon(op1,op2);
        assertEquals(expected,actual,0.001);
        grade+=1;

        op1="100";
        op2 ="0";
        expected=1;
        actual = calc.expon(op1,op2);
        assertEquals(expected,actual,0.001);
        grade+=1;
    }

    @Test // weight: 2
    public void log10Test() {
        Calculator calc=new Calculator();

        String op1="100";
        double expected=2;
        double actual = calc.log10(op1);
        assertEquals(expected,actual,0.001);
        grade+=1;

        op1="1";
        expected=0;
        actual = calc.log10(op1);
        assertEquals(expected,actual,0.001);
        grade+=1;
    }

    @Test // weight: 2
    public void ceilingvalTest() {
        Calculator calc=new Calculator();

        String op1="0.7";
        double expected=1;
        double actual = calc.ceilingval(op1);
        assertEquals(expected,actual,0.001);
        grade+=1;

        op1="-0.12";
        expected=0;
        actual = calc.ceilingval(op1);
        assertEquals(expected,actual,0.001);
        grade+=1;

        op1="0.102";
        expected=1;
        actual = calc.ceilingval(op1);
        assertEquals(expected,actual,0.001);
        grade+=1;
    }

    @Test // weight: 5
    public void illegalCalculationErrorTest() {
        Calculator calc=new Calculator();
        // Division by 0
        String op1="1";
        String op2="0";
        double expected=-1.1;
        double actual = calc.div(op1, op2);
        assertEquals(expected,actual,0.001);
        grade+=1;

        // Exponentiation where op1 && op2 == 0
        op1="0";
        op2="0";
        expected=1;
        actual = calc.expon(op1, op2);
        assertEquals(expected,actual,0.001);
        grade+=1;



        // Log10 where either op1 < 0
        op1="-1";
        expected=-1.1;
        actual = calc.log10(op1);
        assertEquals(expected,actual,0.001);
        grade+=1;

        // Log10 where either op1 == 0
        op1="0";
        expected=-1.2;
        actual = calc.log10(op1);
        assertEquals(expected,actual,0.001);
        grade+=1;
    }


    @Test // weight: 2
    public void rootTest() {
        Calculator calc=new Calculator();

        String op1="100";
        String op2="2";
        double expected=10;
        double actual = calc.root1(op1,op2);
        assertEquals(expected,actual,0.001);
        grade+=1;

        op1="81";
        expected=9;
        actual = calc.root1(op1,op2);
        assertEquals(expected,actual,0.001);
        grade+=1;
    }


    @Test // weight: 2
    public void areaCircleTest1() {
        Calculator calc=new Calculator();

        String op1="2";
        double expected=12.566;
        double actual = calc.areaOfCircle(op1);
        assertEquals(expected,actual,0.001);
        grade+=1;

        op1="-1";
        expected=3.141592653589793;
        actual = calc.areaOfCircle(op1);
        assertEquals(expected,actual,0.1);
        grade+=1;


        op1="6";
        expected=113.1;
        actual = calc.areaOfCircle(op1);
        assertEquals(expected,actual,0.1);
        grade+=1;
    }


    @Test // weight: 2
    public void hypotenuseTest() {
        Calculator calc=new Calculator();

        String op1="3";
        String op2="4";
        double expected=5;
        double actual = calc.hypotenuse(op1,op2);
        assertEquals(expected,actual,0.001);
        grade+=1;
    }

    @Test // weight: 2
    public void inverseTest() {
        Calculator calc=new Calculator();

        String op1="4";
        //String op2="1/4";
        double expected=0.25;
        double actual = calc.inverse(op1);
        assertEquals(expected,actual,0.001);
        grade+=1;
    }

    @Test // weight: 2
    public void lnTest() {
        Calculator calc=new Calculator();

        String op1="1";
        double expected=0;
        double actual = calc.ln(op1);
        assertEquals(expected,actual,0.001);
        grade+=1;

        op1="5";
        expected=1.60943479124341;
        actual = calc.ln(op1);
        assertEquals(expected,actual,0.001);
        grade+=1;
    }
}