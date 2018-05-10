package com.timbuchalka;

import java.util.Collections;
import java.util.Map;

public class Basket {

	public Basket(String string) {
		// TODO Auto-generated constructor stub
	}

	public int removeFromBasket(StockItem item, int quantity) {
		if ((item != null) && (quantity > 0)) {
			// check if we already have the item in the basket
			int inBasket = list.getOrDefault(item, 0);
			int newQuantity = inBasket - quantity;

			if (newQuantity > 0) {
				list.put(item, newQuantity);
				return quantity;
			} else if (newQuantity == 0) {
				list.remove(item);
				return quantity;
			}
		}
		return 0;
	}

	public void clearBasket() {
		this.list.clear();
	}

	public Map<StockItem, Integer> Items() {
		return Collections.unmodifiableMap(list);
	}

	@Override
	public String toString() {
		String s = "\nShopping basket " + name + " contains " + list.size() + ((list.size() == 1) ? " item" : " items")
				+ "\n";
		double totalCost = 0.0;
		for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
			s = s + item.getKey() + ". " + item.getValue() + " purchased\n";
			totalCost += item.getKey().getPrice() * item.getValue();
		}
		return s + "Total cost " + totalCost;
	}
}