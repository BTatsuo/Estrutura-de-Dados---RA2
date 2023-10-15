public class ArvoreAVL {
    private Node raiz;

    public ArvoreAVL(){
        this.raiz = null;
    }

    public Node getRaiz() {
        return raiz;
    }

    private boolean vazia() {
        return raiz == null;
    }

    public void inserir(Integer info) {
            raiz = inserir(info, raiz);
    }

    private Node inserir(Integer info, Node noAtual) {
        if (noAtual == null) {
            return new Node(info);
        }
        if (info < noAtual.getInfo()) {
            noAtual.setFilhoEsq(inserir(info, noAtual.getFilhoEsq()));
        } else if (info >= noAtual.getInfo()) {
            noAtual.setFilhoDir(inserir(info, noAtual.getFilhoDir()));
        } else {
            return noAtual;
        }
        ajustarAltura(noAtual);
        return rotacao(noAtual);
    }

    public void deletar(Integer info) {
        raiz = deletar(info, raiz);
    }
    private Node deletar(Integer info, Node noAtual) {
        if (noAtual == null) {
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
        ajustarAltura(noAtual);
        return rotacao(noAtual);
    }

    public Integer maximo(Node noAtual) {
        if(noAtual.getFilhoDir() != null){
            return maximo(noAtual.getFilhoDir());
        }
        return noAtual.getInfo();
    }

    private void ajustarAltura(Node noAtual) {
        int altura;
        if ( altura(noAtual.getFilhoEsq()) > altura(noAtual.getFilhoDir()) ) {
            altura = altura(noAtual.getFilhoEsq());
        } else {
            altura = altura(noAtual.getFilhoDir());
        }
        noAtual.setAltura(altura + 1);
    }
    private int altura(Node noAtual) {
        return noAtual != null ? noAtual.getAltura() : 0;
    }

    private Node rotacao(Node noAtual) {
        int balanceamento = balanceamento(noAtual);
        if (balanceamento > 1) { // valor 2
            if (balanceamento(noAtual.getFilhoEsq()) < 0) {
                noAtual.setFilhoEsq(rotacaoEsq(noAtual.getFilhoEsq()));
            }
            return rotacaoDir(noAtual);
        }
        if (balanceamento < -1) { // valor -2
            if (balanceamento(noAtual.getFilhoDir()) > 0) {
                noAtual.setFilhoDir(rotacaoDir(noAtual.getFilhoDir()));
            }
            return rotacaoEsq(noAtual);
        }
        return noAtual;
    }

    private int balanceamento(Node noAtual) {
        return  noAtual != null ? (altura(noAtual.getFilhoEsq()) - altura(noAtual.getFilhoDir())) : 0;
    }

    private Node rotacaoDir(Node noAtual) {
        Node noEsq = noAtual.getFilhoEsq();
        Node noCentral = noEsq.getFilhoDir();
        noEsq.setFilhoDir(noAtual);
        noAtual.setFilhoEsq(noCentral);
        ajustarAltura(noAtual);
        ajustarAltura(noEsq);
        return noEsq;
    }

    private Node rotacaoEsq(Node noAtual) {
        Node noDir = noAtual.getFilhoDir();
        Node noCentral = noDir.getFilhoEsq();
        noDir.setFilhoEsq(noAtual);
        noAtual.setFilhoDir(noCentral);
        ajustarAltura(noAtual);
        ajustarAltura(noDir);
        return noDir;
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
            System.out.println("Valor encontrado na Árvore");
        }
    }
}