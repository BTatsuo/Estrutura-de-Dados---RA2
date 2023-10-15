public class ArvoreBinaria {
    private Node raiz;

    public ArvoreBinaria() {
        this.raiz=null;
    }

    public Node getRaiz() {
        return raiz;
    }

    private boolean vazia() {
        return raiz == null; // se a raiz estiver vazia retorna verdadeiro.
    }
    public void inserir(Integer info) {
        if (vazia()) {
            raiz = new Node(info);
        } else {
            inserir(info, raiz);
        }
    }
    private void inserir(Integer info,Node noAtual) {
        if (info < noAtual.getInfo()) {
            if (noAtual.getFilhoEsq() == null) { // se o no atual não possuir um filho a esquerda, um novo no sera adicionado
                noAtual.setFilhoEsq(new Node(info));
            } else {
                inserir(info, noAtual.getFilhoEsq()); // chamada recursiva para percorrer o caminho até encontrar a posição correta
            }
        }else if (info >= noAtual.getInfo()){
            if (noAtual.getFilhoDir() == null) { // se o no atual não possuir um filho a direira, um novo no sera adicionado
                noAtual.setFilhoDir(new Node(info));
            } else {
                inserir(info,noAtual.getFilhoDir());
            }
        }
    }

    public void deletar(Integer info) {
        raiz = deletar(info, raiz);
    }
    private Node deletar(Integer info, Node noAtual) {
        if (noAtual == null) {
            System.out.println("Valor não encontrado");
            return  null;
        }
        if (info < noAtual.getInfo()) {
            noAtual.setFilhoEsq(deletar(info,noAtual.getFilhoEsq()));
        } else if (info > noAtual.getInfo()) {
            noAtual.setFilhoDir(deletar(info,noAtual.getFilhoDir()));
        } else {
            if (noAtual.getFilhoEsq() == null) {
                return noAtual.getFilhoDir();
            } else if (noAtual.getFilhoDir() == null) {
                return noAtual.getFilhoEsq();
            }
            noAtual.setInfo(maximo(noAtual.getFilhoEsq())); // Quando um nó tem dois filhos, precisamos escolher o predescessor ou o sucessor, neste caso estamos escolhendo o predescessor.
            noAtual.setFilhoEsq(deletar(noAtual.getInfo(),noAtual.getFilhoEsq()));
        }
        return noAtual;
    }

    public Integer maximo(Node noAtual) {
        if(noAtual.getFilhoDir() != null){
            return maximo(noAtual.getFilhoDir());
        }
        return noAtual.getInfo();
    }
    public void preOrdem(Node noAtual) {
        if(noAtual != null) {
            System.out.print(noAtual.getInfo() + " ");
            preOrdem(noAtual.getFilhoEsq());
            preOrdem(noAtual.getFilhoDir());
        }
    }
    public void buscar(Integer info) {
        if (vazia()) {
            System.out.println("Árvore Vazia");
        } else {
            buscar(info, raiz);
        }
    }
    private void buscar(Integer info, Node noAtual) {
        if( noAtual == null) {
            return;
        }
        if (info != noAtual.getInfo()) {
            if ( info < noAtual.getInfo()) {
                buscar(info,noAtual.getFilhoEsq());
            } else {
                buscar(info,noAtual.getFilhoDir());
            }
        }
        if(info == noAtual.getInfo()){
            System.out.println("Valor  encontrado na Árvore");
            return;
        }
    }

}