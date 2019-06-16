package com.seugoverno.seugoverno.auxiliar;

import java.util.List;

public class SQLUtil {

    public static String stringsParametros(List<Integer> anos) {
        String anosPreprados = "";
        for (Integer each = 0; each < anos.size();each++) {
            anosPreprados += "'" + anos.get(each) + "'";

            if (each + 1 < anos.size()) {
                anosPreprados += ",";
            }
        }

        return anosPreprados;
    }
}
