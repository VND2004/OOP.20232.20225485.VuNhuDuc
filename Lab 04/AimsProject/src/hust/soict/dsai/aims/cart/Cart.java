package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.Collections;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full");
        } else {
            itemsOrdered.add(media);
            System.out.println("The disc has been added");
        }
	}
	
	public void addMedia(Media ...mediaList) {
		for (Media media : mediaList) {
			addMedia(media);
		}
	}
	
	public void addMedia(Media media1, Media media2) {
		addMedia(media1);
		addMedia(media2);
	}
	
	public void removeMedia(Media media) {
		if(itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println("The media has been remove!");
		} else {
			System.out.println("The media is not in the cart!");
		}
	}
	
	public float totalCost() {
		double total = 0;
		for(Media item : itemsOrdered) {
			total += item.getCost();
		}
		return (float)Math.round(total * 100) / 100;
	}
	
	public int numberDVDsInCart(){
        int count = 0;
        for (Media m : itemsOrdered){
            if (m instanceof DigitalVideoDisc){
                count++;
            }
        }
        return count;
    }
	
	public void print() {
		int index = 0;
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		
		for(Media media : itemsOrdered) {
			if(media != null) {
				index++;
				System.out.println(index + ". " + media);
			}
		}
		System.out.println("Total cost: " + this.totalCost());
        System.out.println("***************************************************");
		
	}
	
	public Media searchInCart(int id){
        for (Media m: itemsOrdered){
            if(m.getId() == id){
                return m;
            }
        }
        return null;
    }

    public Media searchInCart(String title) {
        for (Media m: itemsOrdered){
            if(m.isMatch(title)){
                return m;
            }
        }
        return null;
    }
    
    /**
     * Sort the items in the cart by title and cost.
     */
    public void sortCartByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    /**
     * Sort the items in the cart by cost, then by title.
     */
    public void sortCartByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }
}
