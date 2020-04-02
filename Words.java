import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Words 
{
  private HashSet<String> NON_WORDS = new HashSet<String>()
  {{
      add("the");
      add("and");
      add("to");
      add("of");
      add("the");
      add("a");
      add("is");
      add("it");
      add("in");
      add("or");
      add("is");
      add("as");
      add("so");
      add("but");
      add("be");
  }};

  public Map wordFreq(String words) 
  {
    TreeMap<String, Integer> wordMap = new TreeMap<String, Integer>();
    // Create object to hold words and frequencies.
    Matcher m = Pattern.compile("\\w+").matcher(words);
    // use regex to grab all of the elements that are words ( in this case all of the elements)
    while (m.find()) // initiate pattern matcher finding
    {
      String word = m.group().toLowerCase();
      if (! NON_WORDS.contains(word)) // If the word is not in the list of Non_words
      {
        if (wordMap.get(word) == null) { // if the word isn't in the wordMap
          wordMap.put(word, 1); // add it, and start tracking it's freq
        }
        else // else the word is in the map and we increment the corresponding value
        {
          wordMap.put(word, wordMap.get(word) + 1);
        }
      }
    }
    return wordMap;
  }

  private List<String> regexToList(String words, String regex)
  {
    List wordList = new ArrayList<String>();
    Matcher m = Pattern.compile(regex).matcher(words);
    while (m.find())
    wordList.add(m.group());
    return wordList;
  }

  public Map wordFreq2(String words)
  {
    TreeMap<String, Integer> wordMap2 = new TreeMap<String, Integer>();
    regexToList(words, "\\w+").stream()
      .map(w -> w.toLowerCase())
      .filter(w -> !NON_WORDS.contains(w))
      .forEach(w -> wordMap2.put(w, wordMap2.getOrDefault(w, 0) + 1));
    
    return wordMap2;
  }
}