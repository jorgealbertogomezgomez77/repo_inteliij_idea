package CodeSignal;

public class id_desconocido {
    int makeArrayConsecutive2(int[] statues) {
    for (int i = 0; i < statues.length - 1; i++) {
        for (int j = 0; j < estatues.length; j++) {
            if (estatues[i] > estatues[j]) {
                int variableauxiliar = estatues[i];
                estatues[i] = estatues[j];
                estatues[j] = variableauxiliar;
            }
        }
    }
    int contador1 = 0;
    int contador2 = 0;
    for (int i = 0; i < estatues.length; i++) {
        if(estatues[i] + 1 == estatues[i + 1]) {
            contador1 +=1;
        }
        else {
            contador2 += 1;
        }
    }
    return contador2;
}
