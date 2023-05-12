import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EnumTest {

    @Test
    void testValueOf() {
        Assertions.assertEquals(
                EnumSample.SOON.getValue(),
//                EnumSample.valueOf("soon".toUpperCase())
                "1"
        );
    }
}
