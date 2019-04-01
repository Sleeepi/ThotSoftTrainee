package readertest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class ReadTest {

    // fields used together with @Parameter must be public
    @Parameter(0)
    String m1;
    @Parameter(1)
    String m2;


    // creates the test data
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { "trak.jpg" ,"C:/Hegga/sample.txt", "" }, { "", "C:/Hegga/copy.txt", "15452" } };
        return Arrays.asList(data);
    }


    @Test
    public void ReaderTestException() {
        ReaderTest tester = new ReaderTest();
        assertEquals(tester.ReaderMethod(m1, m2));
    }



}
