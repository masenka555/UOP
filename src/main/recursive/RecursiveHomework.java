package recursive;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecursiveHomework {
    static final String[] conjunction = { "and", "or", "but", "because" };
    static final String[] proper_noun = { "Fred", "Jane", "Richard Nixon", "Miss America" };
    static final String[] common_noun = { "man", "woman", "fish", "elephant", "unicorn" };
    static final String[] determiner = { "a", "the", "every", "some" };
    static final String[] adjective = { "big", "tiny", "pretty", "bald" };
    static final String[] intransitive_verb = { "runs", "jumps", "talks", "sleeps" };
    static final String[] transitive_verb = { "loves", "hates", "sees", "knows", "looks for", "finds" };

    /**
     * Generating strings that follow the syntax rules
     */
    public static void main( String[] args ) {

        List<String[]> arrayList = new ArrayList<>();
        arrayList.add( conjunction );
        arrayList.add( proper_noun );
        arrayList.add( common_noun );
        arrayList.add( determiner );
        arrayList.add( adjective );
        arrayList.add( intransitive_verb );
        arrayList.add( transitive_verb );
        Random random = new Random();

        for ( String[] currentArray : arrayList ) {
            String chosenString = currentArray[ random.nextInt( currentArray.length ) ];
            System.out.print( chosenString );
        }

        while ( true ) {
            randomSentence();
            System.out.print( ".\n\n" );
            try {
                Thread.sleep( 3000 );
            } catch ( InterruptedException e ) {

            }
        }
    }

    /**
     * Choosing a random item
     */
    static String randomItem(String [] listOfStrings){
        return listOfStrings[(int)(Math.random()*listOfStrings.length)];
    }

    /**
     * generating a random sentence
     */
    static void randomSentence() {
        System.out.print( " Once upon a time" );
        if ( Math.random() > 0.2 )
            randomNounPhrase();
        System.out.print( " told me" );
        if ( Math.random() > 0.75 ) {
            System.out.print( " and " +randomItem(conjunction));
            randomSentence();
        }
    }

    /**
     * Generating a random noun phrase
     */
    static void randomNounPhrase() {
        if(Math.random()>0.75)
            System.out.print(" " +randomItem(proper_noun));
        else {
            System.out.print(" " +randomItem(determiner));
            if(Math.random()>0.5)
            System.out.print(" " +randomItem(common_noun));
            System.out.print(" " +randomItem(adjective)+".");

            if(Math.random()>0.5){
                System.out.println(" why ");
                randomVerbPhrase();
            }
        }
    }

    /**
     * Generating a random verb phrase
     */
    static void randomVerbPhrase() {
        if(Math.random()>0.75)
            System.out.print(" " +randomItem(intransitive_verb));
        else if (Math.random()>0.5) {
            System.out.print(" " +randomItem(transitive_verb));
            randomNounPhrase();
        }
        else if (Math.random()>0.25)
            System.out.print(" is "+randomItem(adjective));
        else {
            System.out.print(" like it ");
            randomNounPhrase();
            randomVerbPhrase();
        }
    }
}
