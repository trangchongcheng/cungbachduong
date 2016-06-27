package cungxunu.cunghoangdao.cheng.cungxunu.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cungxunu.cunghoangdao.cheng.cungxunu.R;

/**
 * Created by Welcome on 5/20/2016.
 */
public class FragmentB extends Fragment {
    private TextView tv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_a,
                container, false);
        tv = (TextView) view.findViewById(R.id.tv);
        tv.setText("Fragment B");
        return view;
    }
}
