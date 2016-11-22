package gersondeveloper.com.br.realmsandbox;

import io.realm.RealmObject;

/**
 * Created by gerso on 11/22/2016.
 */

public class Contato extends RealmObject {

    private String Nome;
    private String Telefone;

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }
}
