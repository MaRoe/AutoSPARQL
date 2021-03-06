package org.aksw.autosparql.tbsl.algorithm;

import java.io.IOException;
import java.util.List;

import org.aksw.autosparql.commons.nlp.pos.ApachePartOfSpeechTagger;
import org.aksw.autosparql.commons.nlp.pos.LingPipePartOfSpeechTagger;
import org.aksw.autosparql.commons.nlp.pos.PartOfSpeechTagger;
import org.aksw.autosparql.commons.nlp.pos.StanfordPartOfSpeechTagger;

public class POStest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		String sentence = "When did Nirvana record Nevermind?";
//		String sentence = "Which rivers does the Brooklyn Bridge cross?";


		//Stanford
		PartOfSpeechTagger tagger = StanfordPartOfSpeechTagger.INSTANCE;
		long startTime = System.currentTimeMillis();
		String tagged = tagger.tag(sentence);
		System.out.format("Tagged sentence with Stanford tagger (%d ms):\n", System.currentTimeMillis()-startTime);
		System.out.println(tagged + "\n");


//		//TreeTagger
//		TreeTagger tt = new TreeTagger();
//		tt.tag(sentence);


		//Apache OpenNLP
		tagger = new ApachePartOfSpeechTagger();
		startTime = System.currentTimeMillis();
		tagged = tagger.tag(sentence);
		System.out.format("Tagged sentence with Apache OpenNLP (%d ms):\n", System.currentTimeMillis()-startTime);
		startTime = System.currentTimeMillis();
		System.out.println(tagged + "\n");

		//Apache OpenNLP Top k
		startTime = System.currentTimeMillis();
		List<String> topKTaggedSentences = tagger.tagTopK(sentence);
		System.out.format("Top k tags with Apache OpenNLP (%d ms):\n", System.currentTimeMillis()-startTime);
		for(String t : topKTaggedSentences){
			System.out.println(t);
		}


		//LingPipe
		tagger = new LingPipePartOfSpeechTagger();
		startTime = System.currentTimeMillis();
		tagged = tagger.tag(sentence);
		System.out.format("\nTagged sentence with LingPipe API (%d ms):\n", System.currentTimeMillis()-startTime);
		startTime = System.currentTimeMillis();
		System.out.println(tagged + "\n");

		//LingPipe Top k
		startTime = System.currentTimeMillis();
		topKTaggedSentences = tagger.tagTopK(sentence);
		System.out.format("Top k tags with LingPipe API (%d ms):\n", System.currentTimeMillis()-startTime);
		for(String t : topKTaggedSentences){
			System.out.println(t);
		}
	}

}
