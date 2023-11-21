
# O que é uma classe em Java e qual é a diferença entre uma classe e um 
# objeto? Dê 5 exemplos mostrando-os em C++ e em Java.

* Em Java, uma classe é uma definição de um tipo de dados abstrato. Ela define os dados e as operações que são comuns a todos os objetos desse tipo.

* A diferença entre uma classe e um objeto é que uma classe é um modelo, enquanto um objeto é uma instância desse modelo. Uma classe define o que um objeto é, enquanto um objeto é uma entidade concreta que existe no mundo real.

## 5 exemplos de classes e objetos em C++ e Java:

### Exemplo 1: Classe Círculo


* C++
class Círculo {
public:
  int raio;
  float área();
};

* Java
public class Círculo {
  int raio;

  public float área() {
    return Math.PI * raio * raio;
  }
}


### Exemplo 2: Classe Pessoa

* C++
class Pessoa {
public:
  string nome;
  int idade;
};

* Java

Java
public class Pessoa {
  String nome;
  int idade;
}

### Exemplo 3: Classe Carro

* C++
class Carro {
public:
  string marca;
  string modelo;
  int ano;
};

* Java
public class Carro {
  String marca;
  String modelo;
  int ano;
}


### Exemplo 4: Classe Conta

* C++
class Conta {
public:
  string número;
  string titular;
  double saldo;
};

* Java
public class Conta {
  String número;
  String titular;
  double saldo;
}


### Exemplo 5: Classe Ponto

* C++
class Ponto {
public:
  int x;
  int y;
};

* Java
public class Ponto {
  int x;
  int y;
}