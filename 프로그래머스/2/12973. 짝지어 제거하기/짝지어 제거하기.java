import java.util.Stack;
class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        if(s.length() == 1)
            return 0;
        // stack.push(s.charAt(0));
        for(int i = 0; i < s.length(); i++){
            if(stack.size() == 0){
                stack.push(s.charAt(i));
                continue;
            }
            if(s.charAt(i) == stack.peek()){
                stack.pop();
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        if(stack.size() == 0){
            answer = 1;
        }
        return answer;
    }
}