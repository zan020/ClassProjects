Implement BlackJackTester to play BlackJack

1. Cards
This class represents a deck of cards. It is implemented by using an ArrayList, in which each card is a String telling the suit and the rank of the card. The deck deals a card by randomly drawing a card from the deck. 

2. Player
This class represents a general player of a BlackJack game. The player can get a card from the deck, add the card to his hand, show his hand/card, compute his score, decides the score of an Ace, and chooses whether to hit or stand through keyboard input. These rules applies to both the human and the computer player. To ensure different players in one game are using the same deck of card, a Cards object must be passed in the argument. 

3. Blackjack
This class represents a Blackjack game with basic rules. There are one deck of cards and two players in the game, the computer and the human player, initiated using the Player class. The game consists of 3 parts: initial round where two players each get two cards, the humanPlay round where the human player hits until he busts or decides to stand, and if the human does not bust, the computerPlay round where the computer hits until it busts or decides to stand. The game decides whether a player busts (score > 21) or wins. Since the computer cannot decide whether to hit or not through keyboard, in the game, we tells it to hit until the score goes over 16.

4. Blackjack Tester
This is simply a tester class to call and play the BlackJack game.