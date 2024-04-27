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
	
	public void addDigitalVideoDisc(DigitalVideoDisc ...dvdList) {
		for (DigitalVideoDisc disc : dvdList) {
			addDigitalVideoDisc(disc);
		}
	}
	
	/*
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		for (DigitalVideoDisc disc : dvdList) {
			addDigitalVideoDisc(disc);
		}
	}
	*/
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		addDigitalVideoDisc(dvd1);
		addDigitalVideoDisc(dvd2);
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
	
	public void displayCart() {
		int index = 0;
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		
		for(DigitalVideoDisc disc : itemsOrdered) {
			if(disc != null) {
				index++;
				System.out.println(index + ". " + disc);
			}
		}
		System.out.println("Total cost: " + this.totalCost());
        System.out.println("***************************************************");
		
	}
	
	public void searchById(int searchId) {
		if(searchId < qtyOrdered) {
			System.out.println(itemsOrdered[searchId]);
		} else {
			System.out.println("No match is found!");
		}
	}
	
	public void searchByTitle(String searchTitle) {
		boolean check = false;
		for(DigitalVideoDisc disc : itemsOrdered) {
			if(disc != null) {
				if(disc.isMatch(searchTitle)) {
					System.out.println(disc);
					check = true;
				}
			}
		}
		if (check == false) {
			System.out.println("No match is found!");
		}
	}
}
