package gersondeveloper.com.br.realmsandbox;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gerso on 11/22/2016.
 */

public class MainFragment extends Fragment {

    private Fragment contentFragment;
    public static final String FRAG_ID = "main_fragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);

        ButterKnife.bind(this, view);

        return view;

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
