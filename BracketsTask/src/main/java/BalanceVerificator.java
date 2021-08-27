import java.util.Stack;

public class BalanceVerificator {
    private static final String BALANCED = "BALANCED";
    private static final String NOTBALANCED = "NOT BALANCED";

    public int checkBalanceBrackets(String userInput) {

        // Checking for an empty string
        if(userInput.isEmpty()){
            // NullPointerException can also use.
            throw new RuntimeException("Value cannot be empty.");
        }

        // Checking for an even number of characters
        if(userInput.length()%2 != 0){
            throw new RuntimeException("Not balanced. The number of brackets must be even.");
        }

        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < userInput.length(); i++) {
            char element = userInput.charAt(i);

            if(element =='[' || element == '(' || element == '{') {
                stack.push(element);
            }else if(element == ']') {
                if(stack.pop() != '[') {
                    System.out.println(NOTBALANCED +"(" +i +")" );
                    return i;
                }
            }else if(element == ')') {
                if(stack.pop() != '(') {
                    System.out.println(NOTBALANCED +"(" +i +")" );
                    return i;
                }
            }else if(element == '}') {
                if(stack.pop() != '{') {
                    System.out.println(NOTBALANCED +"(" +i +")" );
                    return i;
                }
            } else {
                // IllegalArgumentException can also use.
                throw new RuntimeException("the character " +"'" +element +"'"  +" does not belong to any of the known types of brackets");
            }
        }
            System.out.println(BALANCED);
            return -1;
        }
    }
