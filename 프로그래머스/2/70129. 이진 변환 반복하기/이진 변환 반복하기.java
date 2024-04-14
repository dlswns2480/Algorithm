class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int count0 = 0;
        int index = 0;
        while(s != "1"){
            index += 1;
            count0 += s.length() - s.replace("0", "").length();
            s = s.replaceAll("0", "");
            String bin = Integer.toBinaryString(s.length());
            if(bin.length() == 1)
                break;
            s = bin;
        }
        answer[0] = index;
        answer[1] = count0;
        return answer;
    }
}