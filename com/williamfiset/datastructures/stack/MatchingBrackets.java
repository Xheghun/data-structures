import com.williamfiset.datastructures.stack.Stack;

public class MatchingBrackets {

    char[] brackets;

    Stack<Character> sortStack = new Stack<>();

    Character getReverseBracket(char bracket) {
        switch (bracket) {
            case '(':
                return ')';
            case '{':
                return '}';
            case '[':
                return  ']';
            case '<':
                return '>';
            default: return 'n';
        }
    }



    boolean isLeftBracket(char bracket) {
       String x = "<{[(";
      return x.contains(String.valueOf(bracket));
    }

    void populateBrackets() {
        String x = "(({}<>[]))";
        brackets = new char[x.length()];
        for (int i = 0; i < brackets.length; i++) {
            brackets[i] = x.charAt(i);
        }
        System.out.println(checkValidity());
    }


    String checkValidity() {
        for(char bracket: brackets) {
            if (isLeftBracket(bracket)) {
                sortStack.push(bracket);
            } else if(sortStack.isEmpty() || bracket != getReverseBracket(sortStack.pop())) {
                return  "invalid";
            }
        }
        return "valid sequence";
    }


    public static void main(String[] args) {
        //System.out.println(new MatchingBrackets().getReverseBracket('}'));
        new MatchingBrackets().populateBrackets();
    }
}
