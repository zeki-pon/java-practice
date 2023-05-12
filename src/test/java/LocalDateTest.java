import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAdjusters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LocalDateTest {

    /**
     * nazeka mojibake de nihongo no comment ga kakenai
     */
    @ParameterizedTest
    @MethodSource()
    void getLengthOfMonthTest() {
        LocalDate target1 = LocalDate.of(2022, 2, 1);
        LocalDate target2 = LocalDate.of(2023, 2, 1);
        LocalDate target3 = LocalDate.of(2024, 2, 1);

        assertEquals(28, target1.lengthOfMonth());
        assertEquals(28, target2.lengthOfMonth());
        assertEquals(28, target3.lengthOfMonth());
    }

    @Test
    void getLastDayOfMonth() {
        LocalDate target = LocalDate.of(2022, 5, 1);
        LocalDate expected = LocalDate.of(2022, 5, 31);
        assertEquals(expected, target.with(TemporalAdjusters.lastDayOfMonth()));
    }

    @Test
    void plusMonthsTest() {
        LocalDate localDate = LocalDate.of(2022, 1, 30).plusMonths(1);
        LocalDate expected = LocalDate.of(2022, 3, 28);
        assertEquals(expected, localDate.plusMonths(1));
    }

    @Test
    void withDayOfMonthTest() {
        LocalDate localDate = LocalDate.of(2022, 2, 28);
        assertThrows(DateTimeException.class, () -> localDate.withDayOfMonth(30));
    }

    @Test
    void lengthOfMonthTest() {
        LocalDate localDate = LocalDate.of(2022, 2, 15);
        LocalDate expected = LocalDate.of(2022, 2, 28);
        assertEquals(expected, localDate.withDayOfMonth(localDate.lengthOfMonth()));
    }

    @Test
    void parseTest() {
        String target = "20221212";
        LocalDate targetDate = LocalDate.parse(target, DateTimeFormatter.ofPattern("yyyyMMdd"));
        assertEquals(LocalDate.of(2022, 12, 12), targetDate);
    }

    @Test
    void toStringTest() {
        LocalDate localDate = LocalDate.of(2023, 2, 3);
        assertEquals("20230203", localDate.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
    }
}