package db;

import models.Conta;

import java.util.HashMap;
import java.util.Map;

public class ContasDB {

    private Map<Integer, Conta> contasDBMap = new HashMap<>();

    public void addNovaConta(Conta conta) {
        int numero = contasDBMap.size() + 1;
        contasDBMap.put(numero, conta);
    }

    public Map<Integer, Conta> getContasMap() {
        return contasDBMap;
    }

    public Conta getContaPorNumero(int numero) {
        return contasDBMap.get(numero);
    }
}
