import java.util.ArrayList;
import java.util.Random;

/**
 * This class generate a deck of Cards
 * @author Anni Zhu
 *
 */
public class Cards {
	
	//1. variables
	private ArrayList<String> deckOfCards = new ArrayList<String> ();
	private String card;
	
	//2. constructor
	public Cards() {
		populateCards();
	}
	
	//3. methods
	/**
	 * generate a deck of card
	 */
	private void populateCards() {
		String[] suits = {"Heart", "Spade", "Club", "Diamond"};
		String[] rank = {"2","3","4","6","7","8","9","10","J","Q","K","A"};
		
		for (String s: suits) 
			for (String i: rank) {
				deckOfCards.add(s.concat(i));
			}
		}	
	
	/**
	 * Randomly draw a card from the deck, and remove the card from the deck
	 * @return the card drawn
	 */
	String dealCard() {
		Random rand = new Random();
		int len = deckOfCards.size();
		int i = rand.nextInt(len);
		
		card = deckOfCards.get(i);
		deckOfCards.remove(i);
		
		return card;
		
	}

}
