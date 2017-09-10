import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class EventLogTest {

  private EventLog testEventLog = new EventLog();
  private Event testEvent;

  @Before
  public void setUp() throws Exception {
    System.out.println("Set it up");
  }

  @After
  public void tearDown() throws Exception {
    System.out.println("Tear it down");
  }

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void nullEventTest() throws IllegalArgumentException {
    System.out.println("null event...");
    thrown.expect(IllegalArgumentException.class);
    testEventLog.addEvent(testEvent);
  }


  @Test
  public void oneEventVariableNullTest() throws IllegalArgumentException {
    System.out.println("event with one null variable...");
    testEvent = new Event();
    testEvent.setName("some test event name");
    thrown.expect(IllegalArgumentException.class);
    testEventLog.addEvent(testEvent);
  }

  @Test
  public void bothEventVariablesNullTest() throws IllegalArgumentException {
    System.out.println("event with two null variables...");
    testEvent = new Event();
    thrown.expect(IllegalArgumentException.class);
    testEventLog.addEvent(testEvent);
  }

  @Test
  public void invalidActionVariableTest() throws IllegalArgumentException {
    System.out.println("event with invalid action variable...");
    testEvent = new Event();
    testEvent.setName("Text");
    testEvent.setAction("invalid action");
    thrown.expect(IllegalArgumentException.class);
    testEventLog.addEvent(testEvent);
  }

  @Test
  public void validEventAddedToEventListTest() throws IllegalArgumentException {
    System.out.println("valid event to event list...");
    testEvent = new Event();
    testEvent.setName("test event name");
    testEvent.setAction("TextMessaging");
    assertTrue("Should be true", testEventLog.addEvent(testEvent));
    assertTrue("Should be added to event list", testEventLog.getNumEvents() == 1);
    System.out.println("Great Success");
  }
}