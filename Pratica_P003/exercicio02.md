# Como você pode lidar com exceções em Java? Quais são as palavras-chave e as práticas comuns para tratamento de exceções? 

Para lidar com exceções em Java, você pode usar os blocos try, catch e finally.

try: O bloco try contém o código que pode gerar uma exceção.
catch: A cláusula catch fornece um bloco de código que é executado quando a exceção é lançada.
finally: O bloco finally é executado sempre, independentemente de uma exceção ter ocorrido ou não.
try {
  // código que pode gerar uma exceção
} catch (Exception e) {
  // tratar a exceção
} finally {
  // código que deve ser executado sempre
}