package gersondeveloper.com.br.realmsandbox;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by gerso on 11/22/2016.
 */

public class MainFragment extends Fragment {

    private Fragment contentFragment;
    public static final String FRAG_ID = "main_fragment";
    private ContatosAdapter mAdapter;
    private Realm realm;
    private Activity activity;


    @BindView(R.id.contatos_list)
    ListView contatosListView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        activity = getActivity();

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();

        //Clear realm from the last time
        Realm.deleteRealm(realmConfiguration);

        //Create a new empty instance of realm
        realm = Realm.getInstance(realmConfiguration);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        ButterKnife.bind(this, view);

        List<Contato> contatos = getContatos();
        contatosListView.setAdapter(new ContatosAdapter(activity));
        return view;

    }

    public RealmResults<Contato> getContatos(){
        RealmResults<Contato> contatos = realm.where(Contato.class)
                .findAll();
        return contatos;
    }

    @OnClick(R.id.btnAddContato)
    public void addContato()
    {
        contentFragment  = new AddContatoFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();

        ft.replace(R.id.content_frame, contentFragment, AddContatoFragment.FRAG_ID);
        ft.commit();
    }

}
