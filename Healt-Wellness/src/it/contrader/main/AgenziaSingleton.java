package it.contrader.main;

import it.contrader.model.Agenzia;

public class AgenziaSingleton {

    private static Agenzia agenzia = null;

    private int id;
    private String nome, descrizione, provincia, citta, indirizzo;

    private int admin_id;

    private AgenziaSingleton(){}

    public static Agenzia getInstance(){
        if(agenzia == null){
            agenzia = new Agenzia();
            return agenzia;
        }
        else return agenzia;
    }
    @Override
    public String toString() {
        return "AgenziaSingleton{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", provincia='" + provincia + '\'' +
                ", citta='" + citta + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", admin_id=" + admin_id +
                '}';
    }
}
