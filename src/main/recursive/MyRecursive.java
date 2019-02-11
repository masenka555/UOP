package recursive;

public class MyRecursive {
    public static void main( String arg[] ) {
        RandomSentence random = new RandomSentence();
        random.makeSentence();
    }


    /**
     * this class will help generate a random sentence.
     * Call makeSentence() to generate a random sentence.
     */
    private static class RandomSentence {
        String[] conjunction = { "and", "or", "but", "because" };
        String[] proper_noun = { "Fred", "Jane", "Richard Nixon", "Miss America" };
        String[] common_noun = { "man", "woman", "fish", "elephant", "unicorn" };
        String[] determiner = { "a", "the", "every", "some" };
        String[] adjective = { "big", "tiny", "pretty", "bald" };
        String[] intransitive_verb = { "runs", "jumps", "talks", "sleeps" };
        String[] transitive_verb = { "loves", "hates", "sees", "knows", "looks for", "finds" };

        /**
         * Makes a simple sentence.
         * has a 25% chance of adding conjunction and generating another sentence.
         */
        public void makeSentence() {

            makeSimpleSentence();

            if ( Math.random() > .75 ) {
                System.out.print( "\b, " );
                getRandomItem( conjunction );
                makeSentence();
            }
            System.out.print( "\b. " );
        }

        /**
         * generates a sentence using a noun and verb phrase
         */
        private void makeSimpleSentence() {
            makeNounPhrase();
            makeVerbPhrase();
        }

        /**
         * creates a noun phrase
         * <proper_noun> | <determiner> [ <adjective> ]. <common_noun> [ who <verb_phrase> ]
         * 74% chance to generate a proper noun
         * 26% chance in generating <determiner> [ <adjective> ]. <common_noun> [ who <verb_phrase> ]
         * 		24% chance to add an adjective
         * 		49% chance to add a verb phrase
         */
        private void makeNounPhrase() {
            if ( Math.random() > .25 ) {
                getRandomItem( proper_noun );
            } else {
                getRandomItem( determiner );
                while ( Math.random() > .75 ) {
                    getRandomItem( adjective );
                }
                getRandomItem( common_noun );
                if(Math.random() > .50) {
                    System.out.print( "who " );
                    makeVerbPhrase();
                }
            }
        }

        /**
         * roughly 25% chance to do one of the following sets
         * <intransitive_verb> |
         * <transitive_verb> <noun_phrase> |
         * is <adjective> |
         * believes that <simple_sentence>
         */
        private void makeVerbPhrase() {
            if(Math.random() < .25){
                getRandomItem( intransitive_verb );
            } else if(Math.random() >= .25 && Math.random() < .50){
                getRandomItem( transitive_verb );
                makeNounPhrase();
            } else if(Math.random() >= .50 && Math.random() < .75){
                System.out.print("is ");
                getRandomItem( adjective );
            } else {
                System.out.print( "believes that " );
                makeSimpleSentence();
            }
        }

        /**
         * prints the array value at a random index.
         * @param array String[]
         */
        private void getRandomItem( String[] array ) {
            int randomIndex = (int) ( ( array.length ) * Math.random() );
            System.out.print( array[ randomIndex ] + " " );
        }

    }
}
