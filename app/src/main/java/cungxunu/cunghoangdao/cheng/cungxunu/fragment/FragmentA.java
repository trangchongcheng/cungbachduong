package cungxunu.cunghoangdao.cheng.cungxunu.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cungxunu.cunghoangdao.cheng.cungxunu.BaseFragment;
import cungxunu.cunghoangdao.cheng.cungxunu.BaseFragmentToolbar;
import cungxunu.cunghoangdao.cheng.cungxunu.R;

/**
 * Created by Welcome on 5/20/2016.
 */
public class FragmentA extends BaseFragment{
    private TextView tv;
    private final String TAG = getClass().getSimpleName();
    private FragmentDrawer drawerFragment;
    @BindView(R.id.btn)
    Button btn;

    @OnClick(R.id.btn)
    public void click(){
        mMainActivity.switchFragment(new FragmentCungXuNu());
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a,container, false);
        ButterKnife.bind(this, view);
        tv = (TextView) view.findViewById(R.id.tv);
        tv.setText("Fragment A");
        return view;
    }


}
