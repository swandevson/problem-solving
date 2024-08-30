class Solution {
    static String[] str = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    
    public int solution(String s) {
        for (int i = 0; i <= 9; i++) {
            s = s.replaceAll(str[i], String.valueOf(i));
        }
        
        
        return Integer.parseInt(s);
    }
}