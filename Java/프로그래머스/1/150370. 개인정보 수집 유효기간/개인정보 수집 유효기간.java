import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> ans = new ArrayList<>();
        Map<String, Integer> m = new HashMap<>();   // 약관별 유효기간
        
        for (int i = 0; i < terms.length; i++) {
            String[] term = terms[i].split(" ");
            m.put(term[0], Integer.valueOf(term[1]));
        }
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate t = LocalDate.parse(today, formatter);
        
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            LocalDate date = LocalDate.parse(privacy[0], formatter);
            String term = privacy[1];
            
            LocalDate expire = date.plusMonths(m.get(term));
            if (expire.isBefore(t) || expire.isEqual(t)) {
                ans.add((i+1));
            }
        }
        
        
        return ans.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}