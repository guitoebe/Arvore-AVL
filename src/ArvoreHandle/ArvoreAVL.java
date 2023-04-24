package ArvoreHandle;

public class ArvoreAVL {

    int altura(Node node) {
        if (node == null) {
            return 0;
        }
        return node.altura;
    }

    int balanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return altura(node.esquerda) - altura(node.direita);
    }

    Node rotacaoDireita(Node x) {
        Node y = x.direita;
        Node z = y.esquerda;
        y.esquerda = x;
        x.direita = z;
        x.altura = 1 + Math.max(altura(x.esquerda), altura(x.direita));
        y.altura = 1 + Math.max(altura(y.esquerda), altura(y.direita));
        return y;
    }

    Node rotacaoEsquerda(Node x) {
        Node y = x.esquerda;
        Node z = y.direita;
        y.direita = x;
        x.esquerda = z;
        x.altura = 1 + Math.max(altura(x.esquerda), altura(x.direita));
        y.altura = 1 + Math.max(altura(y.esquerda), altura(y.direita));
        return y;
    }
}