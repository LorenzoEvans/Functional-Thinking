import java.util.HashSet;
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
    TreeMap<String, Integer> wordMap = new TreeMap<String, Integer>()
    Matcher m = Pattern.compile("\\w+").matcher(words);
    while (m.find()) 
    {
      String word = m.group().toLowerCase();
      if (! NON_WORDS.contains(word))
      {
        if (wordMap.get(word) == null) {
          wordMap.put(word, 1);
        }
        else 
        {
          wordMap.put(word, wordMap.get(word) + 1);
        }
      }
    }
    return wordMap;
  }

}