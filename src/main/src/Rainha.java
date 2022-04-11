package main.src;

public class Rainha {
    //region Attributes
    private int id;
    private int coluna;
    private int linha;
    //endregion

    //region Constructor

    public Rainha(int id) {
        this.id = id;
    }

    //endregion

    //region Methods

    public int getId() {
        return id;
    }

    public int getColuna() {
        return coluna;
    }

    public void setPosicao(int linha, int coluna) {
        this.coluna = coluna;
        this.linha = linha;
    }

    public int getLinha() {
        return linha;
    }

    //endregion
}
