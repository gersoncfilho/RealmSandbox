package gersondeveloper.com.br.realmsandbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import io.realm.Realm;

/**
 * Created by gerso on 11/22/2016.
 */

public class ContatosAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<Contato> contatos = null;
    private Realm realm;



    public ContatosAdapter(Context context)
    {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<Contato> contatos){
        this.contatos = contatos;
    }

    @Override
    public int getCount() {
        if(contatos == null){
            return 0;
        }else{
            return contatos.size();
        }

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = layoutInflater.inflate(R.layout.contato_list_item, viewGroup, false);
        }
        Contato contato = contatos.get(i);

        if (contato != null){
            ((TextView)view.findViewById(R.id.nome)).setText(contato.getNome());
            ((TextView)view.findViewById(R.id.telefone)).setText(contato.getTelefone());
        }
        return view;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public Object getItem(int i) {
        if (contatos == null || contatos.get(i) == null){
            return null;
        }else{
            return contatos.get(i);
        }

    }
}
