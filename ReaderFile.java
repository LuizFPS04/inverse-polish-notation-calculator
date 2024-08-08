import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.FileReader;

public class ReaderFile {

    public static Stack read(String path, String file) {

        Stack myStack = new Stack();

        try {
            FileReader archive = new FileReader(path);
            BufferedReader reader = new BufferedReader(archive);
            String line = reader.readLine();

            while (line != null) {
                String[] content = line.split(" ");

                for (String instruction : content) {
                    myStack.stackUp(instruction);
                }
                /* myStack.print();
                System.out.println("========================"); */
                line = reader.readLine();
            }

            reader.close();

        } catch (IOException e) {
            System.err.printf("Error opening file: %s\n", e.getMessage());
        }
        


        return myStack;
    }

    public static Stack openDir() {
        Stack fileOpen = new Stack();
        Path dir = Paths.get("docs");

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path archive : stream) {
                if (Files.isRegularFile(archive)) {
                    String fileName = archive.getFileName().toString();

                    fileOpen = read("docs/" + archive.getFileName(), fileName);
                    return fileOpen;
                }
            }

        } catch (IOException | DirectoryIteratorException e) {
            System.err.printf("Error reading files: %s\n", e);
        }
        return fileOpen;
    }
}