# CardGame - Poker Hand Evaluation System

A Java-based poker game simulator that deals cards to multiple players, evaluates poker hands, and determines hand rankings.

## 🎯 Project Overview

This project implements a complete poker hand evaluation system using object-oriented programming principles in Java. The game simulates dealing cards to multiple players and automatically evaluates each player's hand to determine poker rankings.

## 📁 Project Structure

```
POKER/
├── Card.java          # Card representation and deck management
├── CardGame.java      # Main entry point
├── Poker.java         # Individual poker hand logic
├── PokerGame.java     # Game management and dealing
├── Ranking.java       # Poker hand rankings enumeration
└── README.md          # Project documentation
```

## 🎮 Features

- **Standard 52-Card Deck**: Complete deck with all suits (Clubs, Diamonds, Hearts, Spades)
- **Multiple Players**: Support for configurable number of players
- **Hand Evaluation**: Automatic poker hand ranking detection
- **Card Dealing**: Realistic card dealing simulation
- **Hand Rankings**: Support for common poker hands:
  - Four of a Kind
  - Full House
  - Three of a Kind
  - Two Pair
  - One Pair
  - High Card (None)

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- Java compiler (javac)

### Running the Game

1. **Compile the Java files:**
   ```bash
   javac *.java
   ```

2. **Run the game:**
   ```bash
   java CardGame
   ```

### Default Configuration

The game is currently configured to:
- Deal cards to **6 players**
- Give each player **5 cards**

## 🎲 How It Works

1. **Deck Creation**: A standard 52-card deck is generated
2. **Shuffling**: The deck is shuffled randomly
3. **Rotation**: Additional randomization through deck rotation
4. **Dealing**: Cards are dealt to players in round-robin fashion
5. **Evaluation**: Each hand is evaluated for poker rankings
6. **Display**: Results show player hands, rankings, and remaining cards

## 🃏 Card Representation

Each card has:
- **Suit**: Club (C), Diamond (D), Heart (H), Spade (S)
- **Face**: 2-10, J, Q, K, A
- **Rank**: Numerical value for comparison (0-12)

### Card Display Format
Cards are displayed as: `Face Suit(Rank)`
Example: `K H(11)` represents King of Hearts with rank 11

## 🏆 Poker Hand Rankings

| Ranking | Description | Score |
|---------|-------------|-------|
| FOUR_OF_A_KIND | Four cards of the same rank | 5 |
| FULL_HOUSE | Three of a kind + One pair | 4 |
| THREE_OF_A_KIND | Three cards of the same rank | 3 |
| TWO_PAIR | Two different pairs | 2 |
| ONE_PAIR | Two cards of the same rank | 1 |
| NONE | High card only | 0 |

## 📊 Sample Output

```
------------------------------------------------------------------------------------------------------------------------
Current Deck
Q S(10) 9 C(7) 2 H(0) Q C(10) 4 C(2) 9 D(7) J H(9) J D(9) 6 H(4) 4 H(2) 2 D(0) 10 C(8) 7 H(5)
8 H(6) 8 S(6) 10 D(8) 10 H(8) 5 H(3) 7 C(5) 3 D(1) 9 H(7) 6 S(4) 5 C(3) J S(9) Q D(10) 5 S(3)
...
----------------------------------------------------------------------------------------------------
1: ONE PAIR         Rank- 1 [Q S(10), 8 C(6), 8 D(6), 7 S(5), 6 H(4)]
2: NONE             Rank- 0 [A D(12), 9 C(7), 6 D(4), 4 H(2), 3 H(1)]
3: TWO PAIR         Rank- 2 [K C(11), K H(11), 7 D(5), 2 D(0), 2 H(0)]
...
```

## ⚙️ Customization

### Changing Game Parameters

To modify the number of players or cards per hand, edit `CardGame.java`:

```java
// Current: 6 players, 5 cards each
PokerGame fiveCards = new PokerGame(6, 5);

// Example: 4 players, 7 cards each
PokerGame sevenCards = new PokerGame(4, 7);
```

### Adding New Features

The modular design allows for easy extensions:
- Add new poker hand rankings in `Ranking.java`
- Implement additional game rules in `PokerGame.java`
- Extend card functionality in `Card.java`

## 🛠️ Technical Details

### Key Classes

**Card.java**
- Manages individual card properties
- Provides deck generation and manipulation
- Handles card sorting and display formatting

**Poker.java**
- Represents a single player's hand
- Evaluates hand rankings
- Manages card keeping and discarding logic

**PokerGame.java**
- Controls overall game flow
- Handles card dealing mechanics
- Manages multiple players

**Ranking.java**
- Defines poker hand hierarchy
- Provides string representation for rankings

## 🔍 Algorithm Highlights

- **Hand Evaluation**: Uses frequency analysis to detect matching cards
- **Card Sorting**: Implements custom comparators for rank-based sorting
- **Dealing Logic**: Round-robin distribution ensures fair dealing
- **Randomization**: Multiple shuffle and rotation steps for true randomness

## 🤝 Contributing

Feel free to fork this project and submit pull requests for:
- Additional poker variants
- UI improvements
- Performance optimizations
- Bug fixes

## ps. I did this while learning hence it resembles the code form Java Masterclass on Udemy by Tim 

---

*Happy Gaming! 🎰*