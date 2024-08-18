import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Classe responsável por acessar e ler arquivos de notação polonesa inversa
 * a partir do diretório corrente "docs".
 * Realiza a leitura dos arquivos e o cálculo das expressões usando uma pilha.
 */
public class ReaderFile {

    /**
     * Instância da classe {@link Result} utilizada para processar instruções lidas
     * do arquivo.
     */
    static Result result = new Result();

    /**
     * Lê o arquivo especificado pelo caminho e nome, processa seu conteúdo e
     * retorna uma pilha contendo as instruções lidas.
     * 
     * @param path Caminho para o arquivo a ser lido.
     * @param file Nome do arquivo a ser lido.
     * @return Uma instância de {@link Stack} contendo as instruções lidas do
     *         arquivo.
     */
    public static Stack read(String path, String file) {
        Stack poloneseStack = new Stack();

        try {
            FileReader archive = new FileReader(path);
            BufferedReader reader = new BufferedReader(archive);
            String line = reader.readLine();

            while (line != null) {
                String[] content = line.split(" ");

                for (String instruction : content) {
                    poloneseStack.stackUp(instruction);
                    result.proccessInstrucion(instruction);
                }

                line = reader.readLine();
            }

            reader.close();

        } catch (IOException e) {
            System.err.printf("Error opening file: %s\n", e.getMessage());
        }

        return poloneseStack;
    }

    /**
     * Percorre o diretório "docs", lê o primeiro arquivo encontrado e
     * retorna uma pilha contendo as instruções lidas desse arquivo.
     * 
     * @return Uma instância de {@link Stack} contendo as instruções lidas do
     *         primeiro arquivo encontrado no diretório.
     */
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