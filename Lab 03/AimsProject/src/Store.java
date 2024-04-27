import java.util.ArrayList;
import java.util.List;

public class Store {
	private List<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();
	
	public void addDVD(DigitalVideoDisc disc) {
		itemsInStore.add(disc);
		System.out.println("The disc has been added");
	}
	
	public void removeDVD(DigitalVideoDisc disc) {
		if(itemsInStore.contains(disc)) {
			itemsInStore.remove(disc);
			System.out.println("The DVD has been removed from the store");
		} else {
			System.out.println("The DVD is not in the store");
		}
	}
	
	public void print() {
		int index = 0;
		System.out.println("***********************Store***********************");
		System.out.println("Store Items:");
		
		for(DigitalVideoDisc disc : itemsInStore) {
			if(disc != null) {
				index++;
				System.out.println(index + ". " + disc);
			}
		}
        System.out.println("***************************************************");
		
	}
}
