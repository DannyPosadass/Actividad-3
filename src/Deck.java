import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Card {
    private String suit;
    private String color;
    private String value;

    public Card(String suit, String color, String value) {
        this.suit = suit;
        this.color = color;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public String getColor() {
        return color;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s", suit, color, value);
    }
}

public class Deck {
    private List<Card> cards;

    public Deck() {
        initializeDeck();
    }

    private void initializeDeck() {
        cards = new ArrayList<>();

        String[] suits = {"tréboles", "corazones", "picas", "diamantes"};
        String[] colors = {"negro", "rojo"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

        for (String suit : suits) {
            for (String color : colors) {
                for (String value : values) {
                    cards.add(new Card(suit, color, value));
                }
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
        System.out.println("Se mezcló el Deck. Presiona doble Enter para continuar...");
        new Scanner(System.in).nextLine();
    }

    public void head() {
        if (!cards.isEmpty()) {
            Card card = cards.remove(0);
            System.out.println(card);
            System.out.printf("Quedan %d cartas en el deck. Presiona doble Enter para continuar...\n", cards.size());
        } else {
            System.out.println("El deck está vacío. Presiona Enter para continuar...");
        }
        new Scanner(System.in).nextLine();
    }

    public void pick() {
        if (!cards.isEmpty()) {
            int randomIndex = (int) (Math.random() * cards.size());
            Card card = cards.remove(randomIndex);
            System.out.println(card);
            System.out.printf("Quedan %d cartas en el deck. Presiona doble Enter para continuar...\n", cards.size());
        } else {
            System.out.println("El deck está vacío. Presiona Enter para continuar...");
        }
        new Scanner(System.in).nextLine();
    }

    public void hand() {
        if (cards.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                Card card = cards.remove(0);
                System.out.println(card);
            }
            System.out.printf("Quedan %d cartas en el deck. Presione doble Enter para continuar...\n", cards.size());
        } else {
            System.out.println("No hay suficientes cartas en el deck para repartir una mano. Presiona Enter para continuar...");
        }
        new Scanner(System.in).nextLine();
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        Scanner scanner = new Scanner(System.in);

        // Ejemplo de uso:
        deck.shuffle();
        scanner.nextLine();
        deck.head();
        scanner.nextLine();
        deck.pick();
        scanner.nextLine();
        deck.hand();
        scanner.nextLine();
    }
}