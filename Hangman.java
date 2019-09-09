import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {
        System.out.println("|^^^^^^^^^^^^^^^^^|");
        System.out.println("| Hangman is cool |");
        System.out.println("|_________________|");  
        String word = choosenWord();
        String unknown = unknown(word);
        char letter = getUserInput();
        int index = getCharacterIndex(letter,word);
        insertCharacter(unknown,letter,index);
        
    }
    public static String choosenWord() {
        String[] words = {"cabbage","moustache","codecool"};
        int x = (int )(Math.random()* words.length);
        String word = words[x];
        return word;
    }

    public static String unknown(String originalWord){
        System.out.println(originalWord);
        String unknownWord = "_".repeat(originalWord.length());
        System.out.println(unknownWord);
        return unknownWord;
    }
    public static void insertCharacter(String unknown, char letter, int index) {
        StringBuilder myName = new StringBuilder(unknown);
        myName.setCharAt(index, letter);
        System.out.println(myName);
    }
    public static char getUserInput() {
        System.out.println("Guess a letter: ");
        Scanner scan = new Scanner(System.in);
        String guess = scan.next();
        char letter = guess.charAt(0);
        return letter;
    }
    public static int getCharacterIndex(char letter, String originalWord) {
        int index = originalWord.indexOf(letter);
        System.out.println(index);
        return index;
    }
}