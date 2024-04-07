## Funções de Manipulação de Arquivos

---

**Introdução:**

Este documento descreve as funções desenvolvidas para manipulação de arquivos em um ambiente Java, com foco em operações de validação e movimentação de arquivos CSV. As funções aqui documentadas são parte de um sistema backend destinado a processamento e gerenciamento de arquivos de dados.

---

**1. Função `validarCSV(File arquivo)`**

- **Descrição:** Esta função valida arquivos CSV, verificando se cada linha do arquivo possui exatamente 4 campos separados por tabulação e se o arquivo contém pelo menos uma linha.

- **Assinatura:**
  ```java
  private static boolean validarCSV(File arquivo)
  ```

- **Parâmetros:**
  - `arquivo`: O arquivo CSV a ser validado.

- **Retorno:**
  - `true`: Se o arquivo for válido.
  - `false`: Se o arquivo for inválido ou ocorrer um erro durante a validação.

- **Comportamento:**
  - A função conta o número de linhas do arquivo.
  - Verifica se o arquivo está vazio.
  - Verifica se todas as linhas possuem 4 campos separados por tabulação.

---

**2. Função `moverArquivo(File arquivo, String diretorioDestino)`**

- **Descrição:** Esta função move um arquivo de um diretório para outro.

- **Assinatura:**
  ```java
  private static void moverArquivo(File arquivo, String diretorioDestino)
  ```

- **Parâmetros:**
  - `arquivo`: O arquivo a ser movido.
  - `diretorioDestino`: O diretório de destino para onde o arquivo será movido.

- **Comportamento:**
  - A função utiliza a API `java.nio.file` para mover o arquivo especificado para o diretório de destino.
  - Caso ocorra uma exceção durante o processo de movimentação do arquivo, o erro é tratado e impresso no fluxo de erro.

---
**arquitetura das pastas**
🗂️Processar-arquivos-csv/
│
├── 🗂️src/
│   └── 📃 Main.java
│
├── 🗂️PENDENTES/
│   └── 📃 dados.csv
│
├── 🗂️VALIDADO/       
│
└── 🗂️INVALIDADO/     
│
🗂️README.md/ 



---
