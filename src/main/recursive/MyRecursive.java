package recursive;

public class MyRecursive {
    public static void main( String arg[] ) {
        RandomSentence random = new RandomSentence();
        random.generateSentence();
    }


    /**
     * Generating a random sentence
     *
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
         * Generating a simple sentence
         */
        public void generateSentence() {

            generateSimpleSentence();

            if ( Math.random() > .75 ) {
                System.out.print( "\b, " );
                getRandomItem( conjunction );
                generateSentence();
            }
            System.out.print( "\b. " );
        }

        /**
         * Generating a sentence using a noun and verb phrase
         */
        private void generateSimpleSentence() {
            generateNounPhrase();
            generateVerbPhrase();
        }

        /**
         * Generating a noun phrase
         */
        private void generateNounPhrase() {
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
                    generateVerbPhrase();
                }
            }
        }

        /**
         * Generating a random sentence
         */
        private void generateVerbPhrase() {
            if(Math.random() < .25){
                getRandomItem( intransitive_verb );
            } else if(Math.random() >= .25 && Math.random() < .50){
                getRandomItem( transitive_verb );
                generateNounPhrase();
            } else if(Math.random() >= .50 && Math.random() < .75){
                System.out.print("is ");
                getRandomItem( adjective );
            } else {
                System.out.print( "believes that " );
                generateSimpleSentence();
            }
        }

        /**
         * Printing an array value at a random index
         * @param array String[]
         */
        private void getRandomItem( String[] array ) {
            int randomIndex = (int) ( ( array.length ) * Math.random() );
            System.out.print( array[ randomIndex ] + " " );
        }

    }
}
