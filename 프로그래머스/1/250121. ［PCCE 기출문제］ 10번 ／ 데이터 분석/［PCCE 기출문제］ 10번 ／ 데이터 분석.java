import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        Map<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        int col = map.get(ext);
        int sortCol = map.get(sort_by);
        List<int[]> answers = new ArrayList<>();
        for(int i = 0; i < data.length; i++) {
            if(data[i][col] < val_ext){
                answers.add(data[i]);
            }
        }
        int[][] answer = new int[answers.size()][4];
        for(int i = 0; i < answers.size(); i++) {
            answer[i] = answers.get(i).clone();
        }
        Arrays.sort(answer, new Comparator<>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[sortCol] - o2[sortCol];
            }
        });
        return answer;
    }
}