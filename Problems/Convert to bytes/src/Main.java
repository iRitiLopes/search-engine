import java.io.InputStream;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        byte[] b = new byte[256];
        inputStream.read(b);
        for(int index=0; index < 256; index++){
            if(b[index] != 0){
                System.out.print(b[index]);
            }
        }
    }
}