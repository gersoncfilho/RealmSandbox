package gersondeveloper.com.br.realmsandbox;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;

/**
 * Created by gerso on 11/22/2016.
 */

public class AddContatoFragment extends Fragment {

    private Fragment contentFragment;
    public static final String FRAG_ID = "adiciona_contato_fragment";

    @BindView(R.id.etNome)
    EditText editTextNome;

    @BindView(R.id.edTelefone)
    EditText editTextTelefone;

    private Realm realm;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Realm.init(getContext());
        realm = Realm.getDefaultInstance();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_contato_fragment, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.btnSalvaContato)
    public void salvaContato()
    {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Contato contato = realm.createObject(Contato.class);
                contato.setNome(editTextNome.getText().toString());
                contato.setTelefone(editTextTelefone.getText().toString());
                Snackbar.make(getView(),"Contato adicionado com sucesso!", Snackbar.LENGTH_SHORT).show();
            }
        });


    }




}
