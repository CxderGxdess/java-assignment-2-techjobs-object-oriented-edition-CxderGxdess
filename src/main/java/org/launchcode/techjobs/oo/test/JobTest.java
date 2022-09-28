package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
    Job jobTestOne = new Job();
    Job jobTestTwo = new Job();

    assertNotEquals(jobTestOne.getId(), jobTestTwo.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job jobTestThree = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertTrue(jobTestThree.getName() instanceof String);
        assertEquals(jobTestThree.getName(), "Product tester");

        assertTrue(jobTestThree.getEmployer() instanceof Employer);
        assertEquals(jobTestThree.getEmployer().getValue(), "ACME");

        assertTrue(jobTestThree.getLocation() instanceof Location);
        assertEquals(jobTestThree.getLocation().getValue(), "Desert");

        assertTrue(jobTestThree.getPositionType() instanceof PositionType);
        assertEquals(jobTestThree.getPositionType().getValue(), "Quality control");

        assertTrue(jobTestThree.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(jobTestThree.getCoreCompetency().getValue(), "Persistence");

    }

    @Test
    public void testJobsForEquality() {
        Job jobTestFour = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        Job jobTestFive = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertFalse(jobTestFour.equals(jobTestFive));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job jobTestSix = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testString = jobTestSix.toString();

        assertEquals(testString.charAt(0), '\n');
        assertEquals(testString.charAt(testString.length() - 1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job jobTestSeven = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(jobTestSeven.toString(), "\n" + "ID: " + jobTestSeven.getId() + "\n" +
                "Name: " + jobTestSeven.getName() + "\n" +
                "Employer: " + jobTestSeven.getEmployer() + "\n" +
                "Location: " + jobTestSeven.getLocation() + "\n" +
                "Position Type: " + jobTestSeven.getPositionType() + "\n" +
                "Core Competency: " + jobTestSeven.getCoreCompetency() + "\n");
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job jobTestEight = new Job("", new Employer("ACME"), new Location(""),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(jobTestEight.toString(), "\n" + "ID: " + jobTestEight.getId() + "\n" +
                "Name: " + "Data not available" + "\n" +
                "Employer: " + jobTestEight.getEmployer() + "\n" +
                "Location: " + jobTestEight.getLocation() + "\n" +
                "Position Type: " + jobTestEight.getPositionType() + "\n" +
                "Core Competency: " + jobTestEight.getCoreCompetency() + "\n");

    }

}