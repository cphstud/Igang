import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CPRNumberTest {

    @org.junit.jupiter.api.Test
    void getCPRNumberString() {
        assertEquals(new CPRNumber(LocalDate.of(2010,11,23), 231).getCPRNumberString(),
                "231110-0231"
                );
    }
}