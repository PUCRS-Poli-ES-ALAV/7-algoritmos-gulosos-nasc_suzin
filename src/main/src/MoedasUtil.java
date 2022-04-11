package main.src;

import java.util.ArrayList;
import java.util.List;

import static main.src.Moeda.*;

public class MoedasUtil {
    //region Attributes

    //endregion

    //region Constructor

    //endregion

    //region Methods

    public static ArrayList<Integer> melhorCombinacao(int troco) {

        var copiaTroco = troco;
        int qnt1=0;
        int qnt5=0;
        int qnt10=0;
        int qnt25=0;
        int qnt100=0;

        while(copiaTroco > 0){

            if(UM.getQnt()==0){
                break;
            }

            if(copiaTroco>= CEM.getValor()){
                qnt100 = copiaTroco/CEM.getValor();
                if(qnt100<= CEM.getQnt()){
                    copiaTroco -= qnt100* CEM.getValor();
                    CEM.subtraiQuantidade(qnt100);
                }
                else{
                    copiaTroco-= CEM.getQnt()*CEM.getValor();
                    CEM.subtraiQuantidade(CEM.getQnt());
                }
            }
            else if(copiaTroco>= VINTE_CINCO.getValor()){
                qnt25 = copiaTroco / VINTE_CINCO.getValor();
                if(qnt25<= VINTE_CINCO.getQnt()){
                    copiaTroco -= qnt25* VINTE_CINCO.getValor();
                    VINTE_CINCO.subtraiQuantidade(qnt25);
                }
                else{
                    copiaTroco-= VINTE_CINCO.getQnt()*VINTE_CINCO.getValor();
                    VINTE_CINCO.subtraiQuantidade(VINTE_CINCO.getQnt());
                }
            }
            else if(copiaTroco>= DEZ.getValor()){
                qnt10 = copiaTroco / DEZ.getValor();
                if(qnt10<= DEZ.getQnt()){
                    copiaTroco -= qnt10* DEZ.getValor();
                    DEZ.subtraiQuantidade(qnt10);
                }
                else{
                    copiaTroco-= DEZ.getQnt()*DEZ.getValor();
                    DEZ.subtraiQuantidade(DEZ.getQnt());
                }
            }
            else if(copiaTroco>= CINCO.getValor()){
                qnt5 = copiaTroco / CINCO.getValor();
                if(qnt5<= CINCO.getQnt()){
                    copiaTroco -= qnt5* CINCO.getValor();
                    CINCO.subtraiQuantidade(qnt5);
                }
                else{
                    copiaTroco-= CINCO.getQnt()*CINCO.getValor();
                    CINCO.subtraiQuantidade(CINCO.getQnt());
                }
            }
            else {
                qnt1 = copiaTroco / UM.getValor();
                if(qnt1<= UM.getQnt()){
                    copiaTroco -= qnt1* UM.getValor();
                    UM.subtraiQuantidade(qnt1);
                }
                else{
                    copiaTroco-= UM.getQnt()*UM.getValor();
                    UM.subtraiQuantidade(UM.getQnt());
                    break;
                }
            }
        }

        return new ArrayList<>(List.of(qnt1,qnt5,qnt10,qnt25,qnt100));
    }

    //endregion
}
