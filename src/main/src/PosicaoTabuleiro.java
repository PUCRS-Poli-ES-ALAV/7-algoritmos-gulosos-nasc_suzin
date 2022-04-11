package main.src;

public class PosicaoTabuleiro {
    //region Attributes
    private boolean estaOcupado;
    private Rainha rainha;
    //endregion

    //region Constructor

    public PosicaoTabuleiro() {
        this.estaOcupado = false;
    }

    //endregion

    //region Methods

    public boolean isEstaOcupado() {
        return estaOcupado;
    }

    public void setEstaOcupado(boolean estaOcupado) {
        this.estaOcupado = estaOcupado;
    }

    public Rainha getRainha() {
        return this.rainha;
    }

    public void setRainha(Rainha rainha) {
        this.rainha = rainha;
    }

    //endregion
}
