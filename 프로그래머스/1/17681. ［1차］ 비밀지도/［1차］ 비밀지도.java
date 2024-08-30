class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < n; j++) {
                String s1 = (arr1[i] >> (n-j-1)) % 2 == 1 ? "#" : " ";
                String s2 = (arr2[i] >> (n-j-1)) % 2 == 1 ? "#" : " ";
                if (s1.equals("#") || s2.equals("#")) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
                answer[i] = sb.toString();
            }
        }
        
        return answer;
    }
}