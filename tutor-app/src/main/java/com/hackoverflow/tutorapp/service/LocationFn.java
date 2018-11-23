package com.hackoverflow.tutorapp.service;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;

import java.io.FileInputStream;
import java.io.InputStream;

public class LocationFn {


    public static String find(String paragraph) throws Exception {

        InputStream inputStreamTokenizer = new
                FileInputStream("src/main/java/com/hackoverflow/tutorapp/model/en-token.bin");
        TokenizerModel tokenModel = new TokenizerModel(inputStreamTokenizer);

        //String paragraph = "Mike and Smith are classmates";
         //paragraph = "Tutorialspoint is located in Hyderabad";

        //Instantiating the TokenizerME class
        TokenizerME tokenizer = new TokenizerME(tokenModel);
        String tokens[] = tokenizer.tokenize(paragraph);

        //Loading the NER-location moodel
        InputStream inputStreamNameFinder = new
                FileInputStream("src/main/java/com/hackoverflow/tutorapp/model/en-ner-location.bin");
        TokenNameFinderModel model = new TokenNameFinderModel(inputStreamNameFinder);


        //Instantiating the NameFinderME class
        NameFinderME nameFinder = new NameFinderME(model);

        //Finding the names of a location
        Span nameSpans[] = nameFinder.find(tokens);
        //Printing the spans of the locations in the sentence
        String location = null;
        for (Span s : nameSpans) {
            System.out.println(s.toString() + "  " + tokens[s.getStart()]);
            location = tokens[s.getStart()];
        }

        ////////////////////////////////
        InputStream inputStreamNameFinderSubject = new
                FileInputStream("src/main/java/com/hackoverflow/tutorapp/model/en-ner-organization.bin");
        TokenNameFinderModel modelSubject = new TokenNameFinderModel(inputStreamNameFinderSubject);

        //Instantiating the NameFinderME class
        NameFinderME nameFinderSubject = new NameFinderME(modelSubject);

        //Finding the names in the sentence
        Span nameSpansSubject[] = nameFinderSubject.find(tokens);

        String subject = null;
        for(Span s: nameSpansSubject) {
            System.out.println(s.toString() + "  " + tokens[s.getStart()]);
            subject = tokens[s.getStart()];
        }
        return location +","+subject;
    }
}
