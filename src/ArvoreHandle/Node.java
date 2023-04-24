package ArvoreHandle;

public class Node {
    int valor;
    Node direita;
    Node esquerda;
    int altura = 0;

    Node(int valor) {
        this.valor = valor;
        this.altura = 1;
    }
}
