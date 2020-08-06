import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.CharBuffer;

class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            CharBuffer chars = CharBuffer.allocate(256);
            reader.read(chars);
            String chs = chars.flip().toString();
            StringBuilder reversed = new StringBuilder();
            for (int index = chs.length() - 1; index >= 0; index--){
                reversed.append(chs.charAt(index));
            }
            System.out.println(reversed);
        }
    }
}