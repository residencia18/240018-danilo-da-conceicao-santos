# Explique o conceito de herança em Java e como você pode criar uma 
# subclasse a partir de uma classe existente. Faça um paralelo com C++, apresentando 5 exemplos.

## A herança é um conceito da programação orientada a objetos que permite que uma classe herde atributos e métodos de outra classe. A classe que herda é chamada de subclasse, enquanto a classe da qual ela herda é chamada de superclasse.

Em Java, para criar uma subclasse a partir de uma classe existente, usamos a palavra-chave extends. Para criar uma subclasse chamada Carro a partir da classe Veículo.

* Java
public class Carro extends Veículo {

  // atributos e métodos da classe Carro

}

A subclasse Carro herda todos os atributos e métodos públicos e protegidos da classe Veículo. Ela também pode adicionar novos atributos e métodos próprios.

* C++
class Carro : public Veículo {

  // atributos e métodos da classe Carro

};

## Aqui estão 5 exemplos de herança em Java e C++:

### Exemplo 1: Classe Círculo

* Java
public class Círculo extends Figura {

  int raio;

  public float área() {
    return Math.PI * raio * raio;
  }

}

* C++
class Círculo : public Figura {

  int raio;

  public:
    float área() {
      return M_PI * raio * raio;
    }
};

## Exemplo 2: Classe Pessoa

* Java
public class Pessoa extends SerVivo {

  String nome;
  int idade;

}

* C++
class Pessoa : public SerVivo {

  string nome;
  int idade;
};

## Exemplo 3: Classe Carro

* Java
public class Carro extends Veículo {

  String marca;
  String modelo;
  int ano;

}

* C++
class Carro : public Veículo {

  string marca;
  string modelo;
  int ano;
};

## Exemplo 4: Classe Conta

* Java
public class Conta extends Cliente {

  String número;
  double saldo;

}

* C++
class Conta : public Cliente {

  string número;
  double saldo;
};

## Exemplo 5: Classe Ponto

* Java
public class Ponto extends FormaGeométrica {

  int x;
  int y;

}

* C++
class Ponto : public FormaGeométrica {

  int x;
  int y;
};
