

import java.io.*;
import java.util.*;

public class Main {

    /**
     * 극지 연구소에서 연구 중인 협이는 새로운 북극곰의 특성을 발견했다. 그것은 바로 북극곰이 O와 X를 보면()와 )(로 찢어버린다는 것이다.
     *
     * 협이는 이러한 북극곰의 특성을 이용하여 길이 N의 괄호 문자열 S를 만들고자 한다. 북극곰은 낮에 활동을 하기 때문에 낮에 돌아다니는 것은 위험하다.
     * 때문에 협이는 매일 밤마다 활동할 수 있다.
     * 밤에 협이는 문자열이 있으면 그 위에 O또는X를 원하는 만큼 놓을 수 있다. 그러면 낮에 북극곰이 와서 문자들을 모두 찢어 놓는다.
     *
     * 예를 들어 이미 문자열 ()()가 있다고 생각해보자. 밤에 문자를 (O)X(O)다음과 같이 놓아둔다면 하루가 지나(()))((())와 같은 문자열이 된다.
     *
     * 이때 원하는 문자열을 만들려면 최소 며칠이 걸리는지 계산해보자.
     * (()))((()) -> 2
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split("");
        Stack<String> stack = new Stack<>();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, stack.size());
            if (stack.isEmpty()) {
                stack.push(arr[i]);
                continue;
            }
            String peek = stack.peek();
            if (!peek.equals(arr[i])) {
                stack.pop();
            } else {
                stack.push(arr[i]);
            }

        }
        if (!stack.isEmpty()) {
            System.out.print(-1);
            return;
        }

        System.out.print(max);
    }



}
