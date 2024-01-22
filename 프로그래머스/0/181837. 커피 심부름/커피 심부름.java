import java.util.HashMap;

class Solution {
    public int solution(String[] order) {
        int answer = 0;
        
        for(String coffee : order){
            Menu menu = new Menu(coffee);
            answer+= menu.getPrice();
        }
        
        
        return answer;
    }
}

class Menu{
    private String name;
    private int price;
    
    public Menu(String name){
        this.name = name;
        this.price = MENU_PRICES.get(name);
    }
    
    public int getPrice(){
        return price;
    }
    
    private static final HashMap<String, Integer> MENU_PRICES = new HashMap<>();

    static {
        MENU_PRICES.put("iceamericano", 4500);
        MENU_PRICES.put("americanoice", 4500);
        MENU_PRICES.put("hotamericano", 4500);
        MENU_PRICES.put("americanohot", 4500);
        MENU_PRICES.put("icecafelatte", 5000);
        MENU_PRICES.put("cafelatteice", 5000);
        MENU_PRICES.put("hotcafelatte", 5000);
        MENU_PRICES.put("cafelattehot", 5000);
        MENU_PRICES.put("americano", 4500);
        MENU_PRICES.put("cafelatte", 5000);
        MENU_PRICES.put("anything", 4500); 
    }
    
}