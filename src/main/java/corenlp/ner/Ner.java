package corenlp.ner;

import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;

import java.util.List;


public class Ner {

    static String sentences[] = {"Joe was the last person to see Fred. ",
            "He saw him in Boston at McKenzie's pub at 3:00 where he "
                    + " paid $2.45 for an ale. ",
            "Joe wanted to go to Vermont for the day to visit a cousin who "
                    + "works at IBM, but Sally and he had to look for Fred"};



    public static String concatSentences() {

        String sentence = "";

        for (String element : sentences) {
            sentence += element;
        }

        return sentence;

    }

   public static void findEntities(String text){

       String model ="edu/stanford/nlp/models/ner" +
               "/english.conll.4class.distsim.crf.ser.gz";


       CRFClassifier<CoreLabel> classifier =
               CRFClassifier.getClassifierNoExceptions(model);

       List<List<CoreLabel>> entityList = classifier.classify(text);

       for (List<CoreLabel> internalList: entityList) {
           for (CoreLabel coreLabel : internalList) {
               String word = coreLabel.word();
               String category = coreLabel.get(
                       CoreAnnotations.AnswerAnnotation.class);
               System.out.println(word + ":" + category);
           }
       }


   }





    public static void main(String[] args) {

        String text = concatSentences();

        findEntities(text);


    }

}
