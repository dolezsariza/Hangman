public class Hangman {

    public static void main(String[] args) {
        System.out.println("|^^^^^^^^^^^^^^^^^|");
        System.out.println("| Hangman is cool |");
        System.out.println("|_________________|");  
        choosenWord();
        
    }
    public static String choosenWord() {
        String[] words = {"cabbage","moustache","codecool"};
        int x = (int )(Math.random()* words.length);
        String word = words[x];
        int wordLength = word.length();
        System.out.println(word);
        System.out.println(" _".repeat(wordLength));
        return word;
    }
}