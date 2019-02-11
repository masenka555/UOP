package recursive;

public class RandomSentences { static final String[] conjunction = { "and", "or", "but", "because"};

    static final String[] proper_noun = { "Fred", "Jane", "Richard Nixon",
            "Miss America"};

    static final String[] common_noun = {"man", "woman", "fish", "elephant", "unicorn"};

    static final String[] determiner = {"a","the", "every", "some"};
    static final String[] adjective = {"big", "tiny", "pretty", "bald"};
    static final String[] intransitive_verb = {"runs", "jumps", "talks", "sleeps"};
    static final String[] transitive_verb = { "loves", "hates", "sees", "knows", "looks for", "finds"};


    public static void main(String[] args) {
        while (true) {
            randomSentence();
            System.out.print(".\n\n");
            try {
                Thread.sleep(3000);
            }
            catch (InterruptedException e) {
            }
        }
    }

    /**
     *
     */
    static void randomSentence() {
        randomSimpleSentence();

        if (Math.random() > 0.75) {
            int c = (int)(Math.random()*conjunction.length);
            System.out.print(" "+ conjunction[c]);
            randomSentence();
        }
    }

    /**
     *
     */
    static void randomSimpleSentence(){
        randomNounPhrase();
        randomVerbPhrase();
    }

    /**
     *
     */
    static void randomNounPhrase() {
        int pn = (int)(Math.random()*proper_noun.length);
        int cn = (int)(Math.random()*common_noun.length);
        int adj = (int)(Math.random()*adjective.length);
        int det = (int)(Math.random()*determiner.length);

        if (Math.random() > 0.5){
            System.out.print(" " + proper_noun[pn]);
        }else{
            System.out.print(" "+ determiner[det]);
            if (Math.random() > 0.5){
                System.out.print(" "+ adjective[adj]);
            }

            System.out.print(" "+ common_noun[cn]);
            if (Math.random() > 0.5){
                System.out.print(" who ");
                randomVerbPhrase();
            }

        }

    }

    /**
     *
     */

    static void randomVerbPhrase() {

        int intrv = (int)(Math.random()*intransitive_verb.length);
        int trv = (int)(Math.random()*transitive_verb.length);
        int adj = (int)(Math.random()*adjective.length);

        if (Math.random() > 0.2){
            System.out.print(" "+ intransitive_verb[intrv]);
        }
        else if (Math.random() > 0.4){
            System.out.print(" " + transitive_verb[trv]);
            randomNounPhrase();
        }else if(Math.random() > 0.6){
            System.out.print(" is " + adjective[adj]);
        }else{
            System.out.print(" believes that ");
            randomSentence();
        }

    }

}
