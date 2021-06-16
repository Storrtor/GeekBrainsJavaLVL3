import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MaxKTest {

    @Test
    void maxKTestMoreThanK () {
        List<String> actual = App.maxK();
        assertNotNull(actual);
        assertEquals(7, actual.size());
        
    }
 }
