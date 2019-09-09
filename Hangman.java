import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {
        System.out.println("|^^^^^^^^^^^^^^^^^|");
        System.out.println("| Hangman is cool |");
        System.out.println("|_________________|");  
        String word = choosenWord();
        char letter = getUserInput();
        insertCharacter(word,letter);
        
    }
    public static String choosenWord() {
        String[] words = {"cabbage","moustache","codecool"};
        int x = (int )(Math.random()* words.length);
        String word = words[x];
        int wordLength = word.length();
        System.out.println(word);
        String unknownWord = "_".repeat(wordLength);
        System.out.println(unknownWord);
        return unknownWord;
    }
    public static void insertCharacter(String word, char letter) {
        StringBuilder myName = new StringBuilder(word);
        myName.setCharAt(4, letter);
        System.out.println(myName);
    }
    public static char getUserInput() {
        System.out.println("Guess a letter: ");
        Scanner scan = new Scanner(System.in);
        String guess = scan.next();
        char letter = guess.charAt(0);
        return letter;
    }
}