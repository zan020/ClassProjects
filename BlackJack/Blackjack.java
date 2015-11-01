//import java.util.ArrayList;
//import java.util.Scanner;

public class Blackjack {
	
	//1. variables
	private Cards deckOfCards;
	private Player computer; 
	private Player human; 
	private Boolean humanBusts;
	
	//2. constructor
	public Blackjack() {
		deckOfCards = new Cards();
		computer = new Player("Computer", deckOfCards);
		human = new Player("Player", deckOfCards);
		humanBusts = false;
		
	}

	//3. methods
	
	public void gamePlay() {		
		initialRound();
		humanPlay();
		if (! humanBusts) {
			computerPlay();
		}
	}
	
	/**
	 * First round where the player and the computer each gets two cards
	 */
	public void initialRound () {
		System.out.println("Let's play Blackjack!");
		System.out.println("------Player and the Computer each gets two cards------");
		computer.getCard();
		computer.showCards();
		computer.getCard();
		System.out.println();
		
		human.getCard();
		human.getCard();
		human.showCards();		
		
	}
	
	/**
	 * After first round, human player chooses to hit or stand
	 * if human busts, computer wins
	 */
	public void humanPlay() {

		System.out.println("----------Player's turn!-----------");
		
		while (! busts(human) && human.decideToHit()) {
			human.hits();
		}
		
		humanBusts = busts(human);
		
		if (humanBusts) {
			System.out.println("Busts! Player Loses! Computer Wins!");
		} else {
			System.out.println("Player Stand");
		}
					
	}
	
	/**
	 * if human did not bust, computer hits until the score is over or equal to 17
	 * if computer busts, human wins
	 */
	public void computerPlay () {
		System.out.println("----------Computer's turn-----------");
		System.out.println("Computer turned over the face down card.");
		computer.showCards();
		System.out.println();
		
		while (computer.getScore() < 17){
			computer.hits();
		}
		
		if (busts(computer)) {
			System.out.println("Computer Busts! Computer Loses! You Win!");
		} else {
			System.out.println("Computer Stands");
			whoWins();
		}
	}
		
	
	/**
	 * When both stands, decide who wins the game
	 */
	private void whoWins() {
		if (computer.getScore() > human.getScore()) {
			System.out.println("!!!!!Computer wins!!!!!!");
		} else if (computer.getScore() < human.getScore()) {
			System.out.println("!!!!!Human wins!!!!!!");
		} else {
			System.out.println("------Push------");
		}
		
	}
	
	/**
	 * decide whether player p busts
	 * @param player p
	 * @return the boolean value whether this player p busts
	 */
	private Boolean busts(Player p) {
		if (p.getScore() > 21) {
			return true;
		} else {
			return false;
		}
	}
	
}
