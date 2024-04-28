class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String compare = "";
        for(int i = 0; i < skill_trees.length; i++){
            String str = skill_trees[i].replaceAll("[^" + skill + "]", "");
            System.out.println(str);
            if(str.equals("")){
                answer++;
                continue;
            }
            for(int j = 1; j < skill.length() + 1; j++){
                if(skill.substring(0, j).equals(str)){
                    System.out.println("실행");
                    answer++;
                }
            }
        }
        
        return answer;
    }
}