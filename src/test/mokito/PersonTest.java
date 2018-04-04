package mokito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class PersonTest {


    @Mock
    private Person p;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void example() {
        Person p = mock(Person.class);
        assertTrue(p != null);
    }

    @Test
    public void example1(){
        assertTrue(p != null);
    }

    @Test
    public void example22(){
        Person p = mock(Person.class);
        when(p.getName()).thenReturn("JDM");
        when(p.getAge()).thenReturn(20);
        assertTrue("JDM".equals(p.getName()));
        assertTrue(20 == p.getAge());
    }

    @Test
    public void testtt() {


    }
}