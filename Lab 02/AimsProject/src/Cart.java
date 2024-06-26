public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is almost full");
		}
		else {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered += 1;
			System.out.println("The disc has been added");
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for(int i = 0; i < qtyOrdered; i++) {
			if(itemsOrdered[i].equals(disc)) {
				for(int j = i; j < qtyOrdered - 1; j++) {
					itemsOrdered[j] = itemsOrdered[j+1];
				}
				qtyOrdered -= 1;
				break;
			}
		}
	}
	
	public float totalCost() {
		double total = 0;
		for(int i = 0; i < qtyOrdered; i++) {
			total += itemsOrdered[i].getCost();
		}
		return (float)Math.round(total * 100) / 100;
	}
}
