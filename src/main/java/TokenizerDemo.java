import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.process.PTBTokenizer;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class TokenizerDemo {

    public static void main(String[] args) throws IOException {

            String arg = "/users/aminnaar/tm_corpus/00a4c740-4484-4055-a166-10fb160d7478.txt";

            // option #1: By sentence.
            DocumentPreprocessor dp = new DocumentPreprocessor(arg);
            for (List<HasWord> sentence : dp) {
                System.out.println(sentence);
            }
            // option #2: By token
            PTBTokenizer<CoreLabel> ptbt = new PTBTokenizer<CoreLabel>(new FileReader(arg),
                    new CoreLabelTokenFactory(), "");
            while (ptbt.hasNext()) {
                CoreLabel label = ptbt.next();
                System.out.println(label);
            }

    }
}