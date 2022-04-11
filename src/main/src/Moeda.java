package main.src;

public class Moeda {
    //region Attributes

    public static Moeda UM = new Moeda(1);
    public static Moeda CINCO = new Moeda(5);
    public static Moeda DEZ = new Moeda(10);
    public static Moeda VINTE_CINCO = new Moeda(25);
    public static Moeda CEM = new Moeda(100);


    private int qnt;
    private final int valor;
    //endregion

    //region Constructor

    public Moeda(int qnt, int valor) {
        this.qnt = qnt;
        this.valor = valor;
    }

    public Moeda(int valor) {
        this.valor = valor;
    }

    //endregion

    //region Methods
    public static void setQntUM(int qnt){
        Moeda.UM.qnt = qnt;
    }
    public static void setQntCINCO(int qnt){
        Moeda.CINCO.qnt = qnt;
    }
    public static void setQntDEZ(int qnt){
        Moeda.DEZ.qnt = qnt;
    }
    public static void setQntVINTE_CINCO(int qnt){
        Moeda.VINTE_CINCO.qnt = qnt;
    }
    public static void setQntCEM(int qnt){
        Moeda.CEM.qnt = qnt;
    }

    public int getQnt() {
        return qnt;
    }

    public int getValor() {
        return valor;
    }

    public void subtraiQuantidade(double quantidade) {
        this.qnt-=quantidade;
    }

    //endregion
}
