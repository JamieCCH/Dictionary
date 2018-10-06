package game2014.as1;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class GamePlay{

    int wordNums = 50;
    String[] words = new String[wordNums];
    String[] definitions = new String[wordNums];
    int score;
    int playTimes = 0;
    int highScore;

    public void initialize() throws IOException {

        Dictionary Dict = new Dictionary();

        Set<String> keys = Dict.dictionary.keySet();

        words = keys.toArray(new String[keys.size()]);
        definitions = Dict.dictionary.values().toArray(new String[keys.size()]);

//        System.out.println(words[0]);
//        System.out.println(definitions[1]);

        ResultTrack result = new ResultTrack();
        score = result.point;
        highScore = result.highScore;

        System.out.println("\nThis is a dictionary game, the purpose is to guess the word from the definition provided.");
        System.out.println("Play the game?  (Y/y)Yes  (N/n)No : ");
        startGame();

    }

    public void startGame() {

        Scanner s = new Scanner(System.in);

        boolean quit = false;
        do{
            boolean choiceIsOK = false;
            do{
                String userinput = s.next();
                switch(userinput){
                    case "y":
                    case "Y":
                    case "yes":
                    case "Yes":
                        playTimes++;
                        choiceIsOK = true;
                        playing();
                        break;
                    case "n":
                    case "N":
                    case "No":
                    case "no":
                        // case n, do something here
                        choiceIsOK = false;
                        quit = true;
                        quitGame();
                        break;
                    default:
                        System.out.println("\nPlease only input Yes(Y/y) or No(N/n).\nPlay the game? ");
                        break;
                }
            }while(!choiceIsOK);
        }while (!quit);

    }

    void playing(){

        wordNums--;


        if(wordNums>0) {
            System.out.println("\nHere's the meanning of the word: ");
            System.out.println("[[[" + definitions[wordNums] + "]]]");
            System.out.println("\nWhat is this word?");
//            System.out.println("word: "+words[wordNums]);

            Scanner s = new Scanner(System.in);
            String ans = s.nextLine();

            if(ans.equals(words[wordNums])){
                System.out.println("\nGreat, Your answer is correct!!");
                score += 20;
                System.out.println("Your score is: " + score);
                System.out.println("\nPlay again?  (Y/y)Yes  (N/n)No : ");
                startGame();
            }else {
                System.out.println("\nYour answer is wrong." + " The correct answer is: [[["+ words[wordNums]+"]]]");
                System.out.println("Your score is: " + score);
                System.out.println("\nPlay again?  (Y/y)Yes  (N/n)No : ");
                startGame();
            }

        }

        if(wordNums==0){
            int finalScores = score;
            if(finalScores > highScore) highScore = finalScores;

            System.out.println("\nAll the words are running out.\nYour final score is: " + finalScores +"\nYour highest score is: " + highScore);

            System.out.println("\nReplay the game?  (Y/y)Yes  (N/n)No : ");

            wordNums = 6;
            score = 0;
            startGame();
        }

    }

    void quitGame(){

        if(playTimes == 0){
            System.out.println("Okay. Goodbye");
        }else{
            System.out.println("See you next time.\nYou've got the score at: " + score);
        }
        System.exit(0);
    }


}
