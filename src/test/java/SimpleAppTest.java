import lesson7.SimpleTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleAppTest {

    SimpleTask simpleTask;

    @BeforeEach
    void init() {
        simpleTask = new SimpleTask();
    }

    @Test
    @DisplayName("Отрицательный максимум")
    void negativeMax() {
        int[] arr = new int[]{-1, -2, -3};
        IllegalStateException illegalStateException = assertThrows(IllegalStateException.class, () -> simpleTask.findMax(arr));
        assertEquals("Max is less than zero", illegalStateException.getMessage());
    }

    @Test
    @DisplayName("Нормальный сценарий")
    void testAsExpected(){
        int[] arr = new int[]{-1, -2, 3};
        assertEquals(3,simpleTask.findMax(arr));
    }
}
