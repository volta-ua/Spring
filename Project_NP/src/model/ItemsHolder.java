package model;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ItemsHolder {	
	
	private List<Item> items;	
	
	public ItemsHolder(){
		items=new LinkedList<Item>();
	}
		
	public void add(Item item) {		
		if (item==null)
			return;
		items.add(item);
	}
		
	public List<Item> getItemsByName(String name) {		
		List<Item> items=new ArrayList<>();		
		for(Item item : items) {
			if (item.getName().equals(name)) {
				items.add(item);
			}
		}		
		return items;		
	}
		
}
