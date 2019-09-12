import java.util.Scanner;
import com.codecool.termlib.*;

public class Hangman {

    public static void main(String[] args) {
        Terminal terminal = new Terminal();
        System.out.println("|^^^^^^^^^^^^^^^^^^^|" + "\n" + "| HangMeMan is cool |" + "\n" + "|___________________| \n\n\n\n");
        String word = choosenWord();
        String unknown = unknownWord(word);
        //System.out.println(word);
        int triesLeft = 8;
        String usedLetters = "";
        do {
            
            System.out.println(unknown + "\n");
            if (unknown.equals(word)) {
                
                break;
            } else {
                char letter = getUserInput();
                if (usedLetters.contains(String.valueOf(letter)) == false){
                    usedLetters = usedLetters + " " + String.valueOf(letter) + ",";
                }
                
                if (isCharacterInWord(word, letter) == true) {
                    unknown = findAndReplaceCharacter(letter,word,unknown);
                } else {
                    triesLeft -= 1;
                    System.out.println("\n Wrong letter! :) \n");
                }
                terminal.clearScreen();
                System.out.println("|^^^^^^^^^^^^^^^^^^^|" + "\n" + "| HangMeMan is cool |" + "\n" + "|___________________| \n\n\n\n");
                System.out.println("You've already tried these letters: \n");
                System.out.println(usedLetters + "\n");
                System.out.println("You've got " + triesLeft + " tries left \n");
            }
            
        } while (triesLeft != 0);
        if (triesLeft == 0){
            terminal.setColor(Color.RED);
            System.out.println("|^^^^^^^^^^^^^^^^^^^|" + "\n" + "|      U ded  :)    |" + "\n" + "|___________________| \n\n");
            System.out.println("The original word was: " + word);
            }
        else {
            terminal.setColor(Color.GREEN);
            System.out.println("|^^^^^^^^^^^^^^^^^^^|" + "\n" + "| You didn't die :( |" + "\n" + "|___________________| \n\n");
        }
        
    }
    public static String choosenWord() {
        String[] words = {"greenbob","illuminati","supercalifragilisticexpialidocious","subdermatoglyphic"};
        int x = (int )(Math.random()* words.length);
        String word = words[x];
        return word;
    }

    public static String unknownWord(String originalWord){
        
        String unknownWord = "_".repeat(originalWord.length());
        return unknownWord;
    }

    public static char getUserInput() {
        System.out.println("Guess a letter: \n");
        Scanner scan = new Scanner(System.in);
        String guess = scan.next();
        char letter = guess.charAt(0);
        return letter;
    }

    public static String findAndReplaceCharacter(char letter, String originalWord, String unknown) {
        int currentIndex = 0;
        String newWord = unknown;
        for (int i = 0; i <= originalWord.length(); i++){
            int index =originalWord.indexOf(letter, currentIndex);
            if (index == -1) {
                break;
            } else {
                currentIndex = index;
                
                if (i == 0){
                    newWord = insertCharacter(unknown, letter, index);
                    currentIndex = currentIndex + 1;
                } else {
                    newWord = insertCharacter(newWord, letter, index); 
                    currentIndex = currentIndex + 1;
                }
            }   
        }
        return newWord;
        
    }

    public static String insertCharacter(String unknown, char letter, int index) {
        StringBuilder myName = new StringBuilder(unknown);
        myName.setCharAt(index, letter);
        return myName.toString();
    }

    public static boolean isCharacterInWord(String word, char letter) {
        String character = String.valueOf(letter);
        return word.contains(character);
    }

}
/*
things to do:

- kiírja melyik betűket néztük már meg
- próbálkozások száma

*/