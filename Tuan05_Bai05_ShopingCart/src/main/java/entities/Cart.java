package entities;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Cart {
	private Map<String, CartItem> items;

	public Cart() {
		super();
		this.items = new LinkedHashMap<String, CartItem>();
	}
	
	public void addItem(Product prd) {
		CartItem item = items.get(prd.getId());
		if (item == null) {
			items.put(prd.getId(), new CartItem(prd, 1));
		}else {
			item.setQuantity(item.getQuantity() + 1);
		}
	}
	
	public void removeItem(String id) {
		items.remove(id);
	}
	
	 // Get all items in the cart
    public Map<String, CartItem> getItems() {
        return items;
    }
    
    public double getTotal() {
    	double total = 0;
    	
    	for (Entry<String, CartItem> item : items.entrySet()) {
    		total += (item.getValue()).calcTotal();
    	}
    	return total;
    }
	
    public int getTotalItems() {
    	return items.size();
    }
}
