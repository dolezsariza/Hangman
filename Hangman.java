import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {
        System.out.println("|^^^^^^^^^^^^^^^^^|" + "\n" + "| Hangman is cool |" + "\n" + "|_________________|");
        String word = choosenWord();
        String unknown = unknownWord(word);
        char letter = getUserInput();
        findAndReplaceCharacter(letter,word,unknown);
    
        
    }
    public static String choosenWord() {
        String[] words = {"cabbage","moustache","codecool"};
        int x = (int )(Math.random()* words.length);
        String word = words[x];
        return word;
    }

    public static String unknownWord(String originalWord){
        System.out.println(originalWord);
        String unknownWord = "_".repeat(originalWord.length());
        System.out.println(unknownWord);
        return unknownWord;
    }

    public static char getUserInput() {
        System.out.println("Guess a letter: ");
        Scanner scan = new Scanner(System.in);
        String guess = scan.next();
        char letter = guess.charAt(0);
        return letter;
    }

    public static int findAndReplaceCharacter(char letter, String originalWord, String unknown) {
        int currentIndex = 0;
        String newWord = "";
        for (int i = 0; i <= originalWord.length(); i++){
            int index =originalWord.indexOf(letter, currentIndex);
            if (index == -1) {
                break;
            }
            currentIndex = index;
            
            if (i == 0){
                newWord = insertCharacter(unknown, letter, index);
                currentIndex = currentIndex + 1;
            } else {
                newWord = insertCharacter(newWord, letter, index); 
                currentIndex = currentIndex + 1;
            }
        }

        System.out.println(newWord);
        int index = originalWord.indexOf(letter);
        return index;
    }

    public static String insertCharacter(String unknown, char letter, int index) {
        StringBuilder myName = new StringBuilder(unknown);
        myName.setCharAt(index, letter);
        return myName.toString();
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