package edu.worcester.cs.kwurst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StudentTest {

	private Student student1;
	private Student student2;
	
	@Before
	public void setUp() throws Exception {
		student1 = new Student("Jane", "Smith");
		student1.setCurrentEarnedCr(100);
		student1.setGpa(1.9);		
		student1.setLascComplete(false);
		student1.setMajorComplete(false);
		
		student2 = new Student("Jonathan", "Shatos");
		student2.setCurrentEarnedCr(130);
		student2.setGpa(3.8);
		student2.setLascComplete(true);
		student2.setMajorComplete(true);
	}

	@Test
	 public void testGetStudentCount(){
	         int current = Student.getStudentCount();
	          Student student3 = new Student ("Bill", "Nye");
	           assertEquals(current +1, Student.getStudentCount());
	 }
	
	@Test
	public void testGetCurrentEarnedCr() {
		int credits = 120; 
		student1.setCurrentEarnedCr(credits);
		 assertEquals(120, student1.getCurrentEarnedCr());
		}
	
	@Test
	public void testCurrentEarnedCredits(){
		student1.setCurrentEarnedCr(-5);
		assertTrue(student1.getCurrentEarnedCr() >= 0);
	}//Prevents faulty error on admins account
	
	@Test
	public void testGetCurrentRemainingCr() {
		student1.setCurrentEarnedCr(20);
		 assertTrue(student1.getCurrentRemainingCr() == 100);
		}
	
	@Test
	public void testGetCurrentRemainingCrOver() {
		student1.setCurrentEarnedCr(125);
		 assertTrue(student1.getCurrentRemainingCr() == 0);
		}//If a Student earns more than 120 credits, they did not graduate according to code.
	
	@Test
	public void testGetCurrentRemainingCrNone() {
		student1.setCurrentEarnedCr(0);
		 assertTrue(student1.getCurrentRemainingCr() == 120);
		}
	
	@Test
	public void testAnticipatedRemainingCrLow() {
		student2.setCurrentEarnedCr(0);
		student2.setAnticipatedAdditionalCr(0);
		assertEquals(120, student2.getAnticipatedRemainingCr());
	}
	
	@Test
	public void testAnticipatedRemainingCrHigh() {
		student2.setCurrentEarnedCr(100);
		student2.setAnticipatedAdditionalCr(20);
		assertEquals(0, student2.getAnticipatedRemainingCr());
	}
	
	
	
	@Test
	public void testReadyToGraduate(){
		assertTrue(student2.getCurrentEarnedCr() >= 120 && student2.getGpa() >= 2.0);
		assertTrue(student2.getLascComplete()&&student2.getMajorComplete());
	}
	
	@Test
	public void testNotReadyToGraduate(){
		assertFalse(student1.getCurrentEarnedCr() >= 120 || student1.getGpa() >= 2.0);
		assertFalse(student1.getLascComplete() || student1.getMajorComplete());
	}
	
	@Test
	public void testGpaValid(){
		student1.setGpa(4.3);
		assertTrue(student1.getGpa() >= 0 && student1.getGpa() <= 4.0);
	}
	
}