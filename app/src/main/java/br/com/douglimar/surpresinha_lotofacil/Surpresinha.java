package br.com.douglimar.surpresinha_lotofacil;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Douglimar Moraes on 02/12/17.
 *
 *
 */

class Surpresinha {


    public int[] getBackgroundColors() {
        
        int[] values = new int[]{0,0};

        values[0] = R.color.colorLotofacil;
        values[1] = R.drawable.degrade_radial_lotofacil;

        return values;
    }


    public String generateLotofacilGame() {

        /* Regra do Jogo:
	    * O apostador pode escolher 15 numeros entre 25 numeros disponiveis
	    */

        int numsLotofacil[] = new int[15];

        int j = 0;
        int indice;
        Random random = new Random();
        StringBuilder Retorno = new StringBuilder();

        for (int i = 0 ; i < 15; i++) {
            indice = random.nextInt(26);

            for (int k = 0; k <= 25; k++) {
                if (consisteJogo(numsLotofacil, indice) || indice == 0 ) {
                    indice = random.nextInt(26);
                }
            }

            numsLotofacil[i] = indice;
        }

        Arrays.sort(numsLotofacil);

        for (int i = 0; i < 15; i++) {
            j++;

            if (numsLotofacil[i] < 10)
                Retorno.append(" 0").append(numsLotofacil[i]);
            else
                Retorno.append(" ").append(numsLotofacil[i]);

            if (j == 5 )  {
                Retorno.append('\n');
                j = 0 ;
            }

        }

        return Retorno.toString();

    }


    private boolean consisteJogo(int pArray[], int PNumero) {

        boolean Retorno = false;

        for (int aPArray : pArray) {
            if (aPArray == PNumero) {
                Retorno = true;
                break;
            }
        }

        return Retorno;
    }

}
