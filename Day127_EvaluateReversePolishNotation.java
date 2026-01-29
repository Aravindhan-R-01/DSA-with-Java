// Evaluate Reverse Polish Notation:
// You are given an array of strings tokens that represents a valid arithmetic expression in Reverse Polish Notation.
// Return the integer that represents the evaluation of the expression.
// The operands may be integers or the results of other operations.
// The operators include '+', '-', '*', and '/'.
// Assume that division between integers always truncates toward zero.
// Example 1:
// Input: tokens = ["1","2","+","3","*","4","-"]
// Output: 5
// Explanation: ((1 + 2) * 3) - 4 = 5
// Constraints:
// 1 <= tokens.length <= 1000.
// tokens[i] is "+", "-", "*", or "/", or a string representing an integer in the range [-100, 100].


class Day127_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        List<String> inputList = new ArrayList<>(Arrays.asList(tokens));
        while(inputList.size() > 1){
            for(int x = 0; x < inputList.size(); x++){
                String current = inputList.get(x);
                if("+-/*".contains(current)){
                    int i = Integer.parseInt(inputList.get(x - 2));
                    int j = Integer.parseInt(inputList.get(x - 1));
                    int output = 0;
                    switch (current){
                        case "+": output = i + j; break;
                        case "-": output = i - j; break;
                        case "/": output = i / j; break;
                        case "*": output = i * j; break;
                    }
                    inputList.set(x - 2, String.valueOf(output));
                    inputList.remove(x);
                    inputList.remove(x - 1);
                    break;
                }
            }
        }
        return Integer.parseInt(inputList.get(0));
    }
}
