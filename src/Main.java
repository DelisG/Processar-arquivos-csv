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

}
