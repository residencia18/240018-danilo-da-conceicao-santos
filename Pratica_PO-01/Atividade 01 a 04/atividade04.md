# Quando declaramos uma variável em Java, temos, na verdade, um ponteiro. 
# Em C++ é diferente. Discorra sobre esse aspecto.

* Em Java, quando declaramos uma variável, na verdade, estamos declarando uma referência a um objeto. Essa referência é armazenada em um ponteiro interno, que é gerenciado pelo coletor de lixo. Isso significa que o programador não precisa se preocupar com a alocação e liberação de memória para as variáveis.

* Em C++, quando declaramos uma variável, estamos declarando um ponteiro diretamente. O programador é responsável pela alocação e liberação de memória para as variáveis.

### Aqui estão alguns exemplos de como isso se manifesta em Java e C++:

* Java
 Declarando uma variável em Java
    int idade;

 Atribuindo um valor à variável
    idade = 30;

 Obtendo o valor da variável
System.out.println(idade); // Imprime 30

Nesse exemplo, a variável idade é uma referência a um objeto de tipo int. O valor atribuído à variável é 30. O coletor de lixo é responsável por liberar a memória alocada para a variável quando ela não for mais necessária.

* C++
 Declarando uma variável em C++
    int* idade;

Alocando memória para a variável
    idade = new int(30);

Obtendo o valor da variável
    cout << *idade; // Imprime 30

Liberando a memória alocada para a variável
    delete idade;