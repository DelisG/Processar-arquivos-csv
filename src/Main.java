import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        String diretorioPendentes = "PENDENTES";
        String diretorioValidado = "VALIDADO";
        String diretorioInvalidado = "INVALIDADO";

        File dir = new File(diretorioPendentes);
        if (!dir.exists() || !dir.isDirectory()) {
            System.err.println("O diretório de PENDENTES não existe ou não é um diretório válido.");
            return;
        }

        File[] arquivosCSV = dir.listFiles((dir1, nome) -> nome.toLowerCase().endsWith(".csv"));

        if (arquivosCSV != null) {
            for (File arquivo : arquivosCSV) {
                if (validarCSV(arquivo)) {
                    moverArquivo(arquivo, diretorioValidado);
                    System.out.println("Arquivo " + arquivo.getName() + " validado e movido para /VALIDADO");
                } else {
                    moverArquivo(arquivo, diretorioInvalidado);
                    System.out.println("Arquivo " + arquivo.getName() + " inválido e movido para /INVALIDADO");
                }
            }
        }
    }

    private static boolean validarCSV(File arquivo) {
        try {
            long linhas = Files.lines(arquivo.toPath()).count();

            if (linhas == 0)
                return false;

            return Files.lines(arquivo.toPath()).allMatch(line -> line.split("\t").length == 4);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void moverArquivo(File arquivo, String diretorioDestino) {
        try {
            Path origemPath = Paths.get(arquivo.getAbsolutePath());
            Path destinoPath = Paths.get(diretorioDestino + "/" + arquivo.getName());
            Files.move(origemPath, destinoPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
