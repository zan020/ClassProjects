import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class stores the identity of the player, the action he can make, 
 * the cards he have, and the current score he has. 
 * @author anniland
 *
 */
public class Player {
	
	//1. variables
	private Cards deckOfCards;
	private ArrayList<String> playersCard;
	private int score;
	private String card;
	private Scanner sc = new Scanner(System.in);
	private String name;
	private Boolean softA;

	
	//2. constructor
	public Player(String playerName, Cards newCards) {
		deckOfCards = newCards;
		playersCard = new ArrayList<String> ();
		score = 0;
		card = "";
		name = playerName;
		softA = false;
	}
	//3. methods
	
	/**
	 * The player gets a card from the deck, add it to his cards, 
	 * and computer the score he has. 
	 */
	public void getCard() {
		card = deckOfCards.dealCard();
		playersCard.add(card);
		computeScore();	
	}
	
	
	/**
	 * The player calculates what score his current hand is
	 */
	private void computeScore() {
		char rank = card.charAt(card.length()-1);
		
		if (rank == '0'|| rank == 'J'|| rank =='Q' || rank == 'K') {
			score += 10;	
		} else if (card.charAt(card.length()-1) == 'A') {
			if (score <=10) {
				score += 11; 		//if the total is not going over 21, A = 11, 
				softA = true;		//and it is a soft hand
			} else {
				score += 1;			
			};						
		} else {
			score += (int)rank - 48;
		}
		
		//if it is a soft hand and it's busting, the Ace counts as 1
		if (score>=21 && softA) {
			score -= 10;	
			softA = false;
		}
	
	}
	
	/**
	 * Player shows his current hand
	 */
	public void showCards() {
		System.out.println(name + "'s hand: ");
		System.out.println(playersCard);
		System.out.println(name + "'s current score: " + getScore());
	}
	
	/**
	 * If a player hits, he draws a card and place it face up
	 */
	public void hits() {
		getCard();
		System.out.println(name + " gets " + card);
		System.out.println(name + "'s current score: " + getScore());
		System.out.println();
	}
	
	/**
	 * Player chooses to hit or stand
	 * @return player's response
	 */
	public boolean decideToHit() {
		char response;
		
		System.out.println("Do you want to hit(H) or stand(S)?");
		response = sc.next().charAt(0); 
			
		if (response =='H' || response== 'h') {
			return true;
		} else if (response == 'S' || response =='s') {
			return false;
		} else {
			System.out.println("Invalid response! Try again!");
			return decideToHit();
		}	
	}
	
	/**
	 * @return player's current score
	 */
	public int getScore (){
		return score;
	}
	
	/**
	 * @return player's identity
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the boolean value of whether palyer's hand has a soft A
	 */
	public Boolean getSoftA() {
		return softA;
	}
}
