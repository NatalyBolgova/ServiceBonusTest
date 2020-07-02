import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @org.junit.jupiter.api.Test
    void calculate() {

        BonusService service = new BonusService();

        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
}


    @Test
    void shouldCalculateForRegisteredAndOverLimit() {

        BonusService service = new BonusService();
        long amount = 3000000_60;
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);

    }

    @Test
    void shouldCalculateNoRegistered() {

        BonusService service = new BonusService();
        long amount = 1550_60;
        boolean registered = false;
        long expected = 15;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateNoRegisteredAndOverLimit() {

        BonusService service = new BonusService();
        long amount = 82000_00;
        boolean registered = false;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
}
