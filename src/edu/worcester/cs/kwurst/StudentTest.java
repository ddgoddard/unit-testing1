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
    public void testGetStudentCount() {
        int currentStudentCount = Student.getStudentCount();
        Student tempStudent = new Student("Dale", "Diaz");
        assertEquals(Student.getStudentCount(), currentStudentCount + 1);
    }

	@Test
	public void testGetCurrentEarnedCr() {
		int credits = 120; 
		student1.setCurrentEarnedCr(credits);
		 assertEquals(120, student1.getCurrentEarnedCr());
		}
	@Test
	public void testGetCurrentRemainingCr() {
		int credits = 20;
		student1.setAnticipatedAdditionalCr(credits);
		 assertTrue(student1.getAnticipatedRemainingCr() <= 0);
		}
	
	@Test
	public void testAnticipatedAdditionalCr() {
		int credits = 90;
		student2.setAnticipatedAdditionalCr(credits);
		assertEquals(90, student2.getAnticipatedAdditionalCr());
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
}

