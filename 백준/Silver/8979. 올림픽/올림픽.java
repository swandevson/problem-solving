import java.util.*;
import java.io.*;

class Country implements Comparable<Country> {
    public int num;
    public int gold;
    public int silver;
    public int bronze;
    public int rank;
    
    public Country(int num, int gold, int silver, int bronze) {
        this.num = num;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
        this.rank = 1;
    }
    
    @Override
    public int compareTo(Country country) {
        if (this.gold != country.gold) {
            return this.gold - country.gold;
        }
        if (this.silver != country.silver) {
            return this.silver - country.silver;
        }
        
        return this.bronze - country.bronze;
    }
    
    public boolean isSameRank(Country country) {
        if (this.gold != country.gold) {
            return false;
        }
        if (this.silver != country.silver) {
            return false;
        }
        if (this.bronze != country.bronze) {
            return false;
        }
        
        return true;
    }
}



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        List<Country> countries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            
            Country country = new Country(num, gold, silver, bronze);
            countries.add(country);
        }
        
        countries.sort(Collections.reverseOrder());
        
        // for (int i = 0; i < countries.size(); i++) {
        //     Country country = countries.get(i);
        //     System.out.println(country.num + " " + country.rank);
        // }
        
        int rank = 0;
        for (int i = 1; i < countries.size(); i++) {
            Country country1 = countries.get(i-1);
            Country country2 = countries.get(i);
            
            if (country1.isSameRank(country2)) {
                country2.rank = country1.rank;
                continue;
            }
            
            country2.rank += i;
        }
        
        int ans = 0;
        for (int i = 0; i < countries.size(); i++) {
            Country country = countries.get(i);
            // System.out.println(country.num + " " + country.rank);
            
            if (country.num == k) {
                ans = country.rank;
            }
        }
        
        
        System.out.println(ans);
    }
}
