import java.util.*;

public class Word implements Comparable<Word>{ 
	private String data;

	public Word(String word){
		data = word;
	}

	public String getWord(){
		return data;
	}	
	
	public void setWord(String word){
		data = word;
	}
	
	public int compareTo(Word word){
		return this.data.compareTo(word.getWord());
	}

	public String toString(){
		return data;
	}
}
