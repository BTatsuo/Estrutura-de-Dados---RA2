public class Node {
    private Integer info;
    private Node filhoEsq;
    private Node filhoDir;
    private int altura = 1;

    public Node(Integer info){
        this.info = info;
    }

    public Integer getInfo() {
        return info;
    }

    public void setInfo(Integer info) {
        this.info = info;
    }

    public Node getFilhoEsq() {
        return filhoEsq;
    }

    public void setFilhoEsq(Node filhoEsq) {
        this.filhoEsq = filhoEsq;
    }

    public Node getFilhoDir() {
        return filhoDir;
    }

    public void setFilhoDir(Node filhoDir) {
        this.filhoDir = filhoDir;
    }

    public int getAltura() {
        if (this == null){
            return 0;
        }
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
