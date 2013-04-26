package controller;

import view.ItemView;
import model.Item;

public class ItemController {
	
	private InGameController inGameController;
	private Item item;
	private ItemView itemView;
	
	public ItemController(InGameController inGameController, int candyNumber) {
		this.inGameController = inGameController;
		this.item = new Item(200, 100, candyNumber); //x, y, candyNumber TODO fix x, y
		this.itemView = new ItemView(item, candyNumber); 
		
	}
	
	public Item getItem(){
		return item;
	}
	
	public ItemView getItemView(){
		return itemView;
	}

}