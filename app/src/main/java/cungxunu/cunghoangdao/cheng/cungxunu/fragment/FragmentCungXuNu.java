package cungxunu.cunghoangdao.cheng.cungxunu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cungxunu.cunghoangdao.cheng.cungxunu.BaseFragmentToolbar;
import cungxunu.cunghoangdao.cheng.cungxunu.R;

/**
 * Created by chientruong on 6/28/16.
 */
public class FragmentCungXuNu extends BaseFragmentToolbar {
    private final String TAG = getClass().getSimpleName();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cungxunu,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void setupActionBar() {
        mToolbar.setVisibility(View.VISIBLE);
        mToolbarTilte.setText(TAG);
        mLeftToolbar.setImageResource(R.drawable.ic_back);

    }
}
