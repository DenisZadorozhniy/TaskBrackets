import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalanceVerificatorTests {

    private BalanceVerificator balanceVerificator = new BalanceVerificator();

    @Test
    void checkingForEmptyString(){
        String input = "";
        Exception exception = assertThrows(RuntimeException.class, () ->
                balanceVerificator.checkBalanceBrackets(input) );
        assertEquals("Value cannot be empty.", exception.getMessage());
    }

    @Test
    void checkingForBalancedResult(){
        String input = "{{[[(())]]}}";
        int result = balanceVerificator.checkBalanceBrackets(input);
        assertEquals(-1, result);
    }

    @Test
    void checkingForNotBalancedResult(){
        String input = "{[(]}}";
        int result = balanceVerificator.checkBalanceBrackets(input);
        assertEquals(3, result);
    }

    @Test
    void checkingForLetter() {
        String input = "{a}}";
        Exception exception = assertThrows(RuntimeException.class, () ->
                balanceVerificator.checkBalanceBrackets(input) );
        assertEquals("the character 'a' does not belong to any of the known types of brackets", exception.getMessage());
    }

    @Test
    void checkingForNotEven() {
        String input = "{(}";
        Exception exception = assertThrows(RuntimeException.class, () ->
                balanceVerificator.checkBalanceBrackets(input) );
        assertEquals("Not balanced. The number of brackets must be even.", exception.getMessage());
    }

}
