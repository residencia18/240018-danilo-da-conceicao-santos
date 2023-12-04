# O que é o bloco "try-catch" em Java? Como ele funciona e por que é importante usá-lo ao lidar com exceções?

Em Java, um bloco try-catch é uma estrutura de controle que é usada para lidar com exceções. 
O bloco try contém o código que pode gerar uma exceção. Se uma exceção for lançada, ela será capturada pela cláusula catch. 
O código dentro do bloco catch pode ser usado para tratar a exceção.
try {
  // código que pode gerar uma exceção
} catch (Exception e) {
  // tratar a exceção
}