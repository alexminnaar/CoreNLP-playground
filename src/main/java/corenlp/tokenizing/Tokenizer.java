package corenlp.tokenizing;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.process.PTBTokenizer;

import java.io.*;
import java.util.List;

public class Tokenizer {


    public static PTBTokenizer<CoreLabel> tokenizeFromFile(String textFile) throws IOException{

        PTBTokenizer<CoreLabel> ptbt = new PTBTokenizer<CoreLabel>(new FileReader(textFile),
                new CoreLabelTokenFactory(), "");

        return ptbt;
    }

    public static PTBTokenizer<CoreLabel> tokenizeFromString(String textToTokenize) {

        PTBTokenizer<CoreLabel> ptbt = new PTBTokenizer<CoreLabel>(new StringReader(textToTokenize),new CoreLabelTokenFactory(),"");

        return ptbt;
    }


    public static void printTokens(PTBTokenizer<CoreLabel> tokens){

        while (tokens.hasNext()) {
            CoreLabel label = tokens.next();
            System.out.println(label);
        }

    }


    public static void main(String[] args){

        String file = "data/sample_text.txt";
        String text = "the cow jumped over the moon";

        PTBTokenizer<CoreLabel> tokens = tokenizeFromString(text);
        printTokens(tokens);

        /*
        try{
            PTBTokenizer<CoreLabel> tokens =tokenizeFromFile(file);
            printTokens(tokens);



        }catch(IOException e){
            System.out.println("Exception thrown  :" + e);
        }
*/
    }


}