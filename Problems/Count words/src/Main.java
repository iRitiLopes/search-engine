import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            CharBuffer buffer = CharBuffer.allocate(256);
            reader.read(buffer);
            String words = buffer.flip().toString();
            List<String> word_list = new ArrayList<>();

            int index = 0;
            while(index < words.length()){
                StringBuffer strBuffer = new StringBuffer();
                while(index < words.length() && (words.charAt(index) == ' '  || words.charAt(index) == '\n')){
                    index++;
                }
                while(index < words.length() && words.charAt(index) != ' '){
                    strBuffer.append(words.charAt(index));
                    index++;
                    if(index >= words.length() || words.charAt(index) == ' '){
                      word_list.add(strBuffer.toString());
                    }
                }
            }
            System.out.println(word_list.size());
        }
    }

}