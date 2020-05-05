import java.util.Scanner;
import java.util.Random;

public class ElfNameGenerator{

/* Creates random object and an array of three-lettered syllables
* Assigns the syllables pseudo-randomly to make the first and last name
* Returns them both concatenated together by a space
*/

  public static String names(int first, int second){
    Random rnd = new Random();
    String[] syllables = new String[] {"xun","bel","ter","dora","fel","gor","lah","fa","kel","ze","za","len","a\'e","b\'e","ren","tor","lea","rah","kel"};
    String name1 = "";
    String name2 = "";
    for(int i = 0; i < first; i++){
      name1 = name1 + syllables[rnd.nextInt(syllables.length - 1)];
    }
    for(int i = 0; i < second; i++){
      name2 = name2 + syllables[rnd.nextInt(syllables.length - 1)];
    }
    String name = name1 + " " + name2;
    return name;
  }

/* Checks for incorrect input.
* Given the needs of this program, it just needs to check if the string is between 1 and 9. (This can be changed easily by adding to the array.)
* If it meets the requirements, it will parse the string and convert it to an integer.
* Otherwise, it will ask for a different number, then repeat until you follow the rules.
*/

  public static int checker(String syllable){
    Scanner scnr = new Scanner(System.in);
    String nums[] = new String[] {"1","2","3","4","5","6","7","8","9"};
    int correctSyllable = -1;
    do {
      for(String num: nums){
        if(syllable.equals(num)){
          correctSyllable = Integer.parseInt(syllable);
          break;
        }
        else
          correctSyllable = -1;
      }
      if (correctSyllable == -1){
        System.out.println("Incorrect input. Try again.");
        syllable = scnr.nextLine();
      }
  }while(correctSyllable == -1);
  return correctSyllable;
  }

  public static void main(String [] args){
    Scanner scnr = new Scanner(System.in);
    boolean another = true;
    int firstSyllableInt = -1;
    int secondSyllableInt = -2;

/* Finds how many syllables you want
* Runs the methods described above
* Asks if you like the name, makes sure you follow the rules
* If you do like it, the end. If you don't, it tries again
*/

    while (another){
      System.out.println("How many syllables in the first name? (1-9)");
      String firstSyllable = scnr.nextLine();
      firstSyllableInt = checker(firstSyllable);
      System.out.println("How many syllables in the last name? (1-9)");
      String secondSyllable = scnr.nextLine();
      secondSyllableInt = checker(secondSyllable);
      String name = names(firstSyllableInt, secondSyllableInt);
      String cont = "";
      do{
        System.out.println("--------------------------------------\n" + name + "\n--------------------------------------\nIs that alright? (y/n)");
        cont = scnr.nextLine();
      }while (!cont.equals("y") && !cont.equals("n"));
      if (cont.equals("y"))
        another = false;
      System.out.println("--------------------------------------");
    }
  }
}
