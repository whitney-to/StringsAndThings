package io.zipcoder;


import java.util.List;

/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case-sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
        // var to keep track of number of words
        int count = 0;

        // create a list of all words in string
        List<String> words = List.of(input.split(" "));

        // Loop through the list and check the end character
        for(String word : words){
            if(word.endsWith("y") || word.endsWith("z")){
                count++;
            }
        }
        return count;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case-sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        return (base.contains(remove)) ? base.replace(remove,"") : base;
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case-sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
        int countIS = 0;
        int countNOT = 0;

        for(int i = 0; i<input.length()-1;i++){
            if(input.charAt(i)=='i' && input.charAt(i+1)=='s'){
                countIS++;
            }
        }

        for(int i = 0; i<input.length()-2;i++){
            if(input.charAt(i)=='n' && input.charAt(i+1)=='o'&& input.charAt(i+2)=='t'){
                countNOT++;
            }
        }
        /* Alternative way to count pattern with regex and split() and length()
            countIS = input.split("is",-1).length;
            countNOT = input.split("not",-1).length;

           second parameter in split() include "" for same pattern next
           to each other. example split("not",-2) account for notnot correctly.
         */

        return countIS==countNOT;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        // matches (any char 0 - any times) (g at least 2 times) (any char 0 - any times)
        return input.matches("(.)*(g){2,}(.)*");
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        int count = 0;
        for(int i = 0; i<input.length()-2;i++){
            if(input.charAt(i)==input.charAt(i+1) && input.charAt(i+1)==input.charAt(i+2)){
                count++;
            }
        }
        return count;
    }
}
