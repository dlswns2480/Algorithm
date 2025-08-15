import java.util.*;
class Solution {
    static class Route implements Comparable<Route> {
        int start, end;
        Route(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Route o) {
            if (this.end == o.end) return this.start - o.start;
            return this.end - o.end;
        }
    }
    public int solution(int[][] routes) {
        int answer = 0;
        
        List<Route> route = new ArrayList<>();
        for (int i = 0; i < routes.length; i++) {
            route.add(new Route(routes[i][0], routes[i][1]));
        }
        Collections.sort(route);
        int size = route.size();
        int end = route.get(0).end;
        answer = 1;
        
        for (int i = 1; i < size; i++) {
            if (route.get(i).start > end) {
                answer++;
                end = route.get(i).end;
            }
        }
        
        return answer;
    }
}