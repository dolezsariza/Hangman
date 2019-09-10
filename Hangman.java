import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {
        System.out.println("|^^^^^^^^^^^^^^^^^|" + "\n" + "| Hangman is cool |" + "\n" + "|_________________|");
        String word = choosenWord();
        String unknown = unknownWord(word);
        System.out.println(word);
        int triesLeft = 6;
        String usedLetters = "You've already tried these letters: ";
        do {
            System.out.println(unknown);
            if (unknown.equals(word)) {
                System.out.println("You didn't die :(");
                break;
            } else {
                char letter = getUserInput();
                
                usedLetters = usedLetters + " " + String.valueOf(letter) + ",";
                System.out.println(usedLetters);
                if (isCharacterInWord(word, letter) == true) {
                    unknown = findAndReplaceCharacter(letter,word,unknown);
                } else {
                    triesLeft -= 1;
                    System.out.println("Wrong letter! :)");
                }
                
            }
        } while (triesLeft != 0);
        System.out.println("U ded");
    
        
    }
    public static String choosenWord() {
        String[] words = {"cabbage","moustache","codecool"};
        int x = (int )(Math.random()* words.length);
        String word = words[x];
        return word;
    }

    public static String unknownWord(String originalWord){
        
        String unknownWord = "_".repeat(originalWord.length());
        return unknownWord;
    }

    public static char getUserInput() {
        System.out.println("Guess a letter: ");
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
- minden indexet megtaláljon, ne csak az elsőt
- kiírja melyik betűket néztük már meg
- próbálkozások száma
- do while amíg nem nyersz vagy nem fogy el a próbálkozás
- összehasonlítsa mindig az unknown-t az originallal, és ha egyenlők, akkor vége a játéknak.
*/