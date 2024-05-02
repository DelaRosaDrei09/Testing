package filehandlingactivity3;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
public class FileHandlingActivity3 {
    public static void main(String[] args) {
        String fileName = "DelaRosa.txt";
        String content = "I love the claw machine";
        
        writeFile(fileName, content);
        
        String readContent = readFile(fileName);
        System.out.println("Content read from file:");
        System.out.println(readContent);
    }
    
    public static void writeFile(String fileName, String content) {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            byte[] bytes = content.getBytes();
            fos.write(bytes);
            System.out.println("Content successfully written to file: " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static String readFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(fileName);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file: " + e.getMessage());
            e.printStackTrace();
        }
        return sb.toString();
    }
}
