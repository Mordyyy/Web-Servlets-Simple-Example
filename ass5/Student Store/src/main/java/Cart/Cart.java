package Cart;

import java.util.ArrayList;
import java.util.HashMap;

public class Cart{
    private HashMap<String, Integer> cart;   //key is product id, value is quantity

    public Cart(){
        cart = new HashMap<>();
    }

    public void addItem(String id){
        if(cart.containsKey(id)){
            int cnt = cart.get(id);
            cnt++;
            cart.put(id,cnt);
        }else{
            cart.put(id,1);
        }
    }
    public int getItemQuantity(String id){
        return cart.get(id);
    }
    public ArrayList<String> getAll(){
        ArrayList<String> res = new ArrayList<>();
        for(String s : cart.keySet()){
            res.add(s);
        }
        return res;
    }

    public void updateCart(String id, int quantity){
        if(quantity == 0){
            cart.remove(id);
        }else{
            cart.put(id, quantity);
        }
    }
}
