import java.util.*;
import java.io.*;

class Country implements Comparable<Country> {
    public int num;
    public int gold;
    public int silver;
    public int bronze;
    
    public Country(int num, int gold, int silver, int bronze) {
        this.num = num;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
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
        
        countries.sort(null);
        
        int rank = 0;
        for (int i = 0; i < countries.size(); i++) {
            Country country = countries.get(i);
            
            if (country.num == k) {
                break;
            }
            
            rank++;
        }
        
        
        System.out.println(rank);
    }
}
