import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {
        System.out.println("|^^^^^^^^^^^^^^^^^|" + "\n" + "| Hangman is cool |" + "\n" + "|_________________|");
        String word = choosenWord();
        String unknown = unknown(word);
        char letter = getUserInput();
        int index = getCharacterIndex(letter,word,unknown);
        //insertCharacter(unknown,letter,index);
        
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

    public static char getUserInput() {
        System.out.println("Guess a letter: ");
        Scanner scan = new Scanner(System.in);
        String guess = scan.next();
        char letter = guess.charAt(0);
        return letter;
    }
    public static int getCharacterIndex(char letter, String originalWord, String unknown) {
        int currentIndex = 0;
    
        for (int i = 0;i<=13;i++){
            int index =originalWord.indexOf(letter, currentIndex);
            if (index == -1) {
                break;
            }
            currentIndex = index;
            System.out.println(index);
            String newWord = insertCharacter(unknown, letter, index);
            System.out.println(newWord);
            currentIndex = currentIndex + 1;
            
        }
        
        int index = originalWord.indexOf(letter);
        System.out.println(index);
        return index;
    }

    public static String insertCharacter(String unknown, char letter, int index) {
        StringBuilder myName = new StringBuilder(unknown);
        myName.setCharAt(index, letter);
        System.out.println(myName);
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