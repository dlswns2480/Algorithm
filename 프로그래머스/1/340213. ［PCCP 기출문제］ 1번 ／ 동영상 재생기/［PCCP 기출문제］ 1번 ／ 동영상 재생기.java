import java.util.*;
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        StringBuilder answer = new StringBuilder();
        int opStart = Integer.parseInt(op_start.split(":")[0]) * 100 + Integer.parseInt(op_start.split(":")[1]);
        int opEnd = Integer.parseInt(op_end.split(":")[0]) * 100 + Integer.parseInt(op_end.split(":")[1]);
        int videoLen = Integer.parseInt(video_len.split(":")[0]) * 100 + Integer.parseInt(video_len.split(":")[1]);
        int posInt = Integer.parseInt(pos.split(":")[0]) * 100 + Integer.parseInt(pos.split(":")[1]);
        int finalPos = posInt;
        for(int i = 0; i < commands.length; i++) {
            if(finalPos <= opEnd && finalPos >= opStart) {
                finalPos = opEnd;
            }
            int namu = finalPos % 100;
            
            if(commands[i].equals("prev")) {
                if(finalPos < 10){
                    finalPos = 0;   
                    continue;
                } 
                if(namu - 10 < 0) {
                    finalPos -= 40;
                }
                finalPos -= 10;
            } else if(commands[i].equals("next")) {
                if((videoLen / 100) - (finalPos / 100) == 1) {
                    if((videoLen - 40) - finalPos < 10) {
                        finalPos = videoLen;
                        continue;
                    }
                }
                if(videoLen - finalPos < 10){
                    finalPos = videoLen;
                    continue;
                } 
                if(namu + 10 >= 60) {
                    finalPos += 40; 
                }
                finalPos += 10;
            }
            
        }
        if(finalPos <= opEnd && finalPos >= opStart) {
            finalPos = opEnd;
        }
        int minute = finalPos / 100;
        int second = finalPos % 100;
        String min = "";
        String sec = "";
        if(minute < 10) {
            min = "0";
        }
        min += String.valueOf(minute);
        if(second < 10) {
            sec = "0";
        }
        sec += String.valueOf(second);
        
        answer.append(min).append(":").append(sec);
        return answer.toString();
    }
}