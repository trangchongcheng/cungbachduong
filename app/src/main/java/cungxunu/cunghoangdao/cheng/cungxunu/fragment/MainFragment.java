package cungxunu.cunghoangdao.cheng.cungxunu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cungxunu.cunghoangdao.cheng.cungxunu.BaseFragmentToolbar;
import cungxunu.cunghoangdao.cheng.cungxunu.R;

/**
 * Created by chientruong on 6/28/16.
 */
public class MainFragment extends BaseFragmentToolbar implements FragmentDrawer.FragmentDrawerListener {
    private FragmentDrawer drawerFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void setupActionBar() {
        mToolbar.setVisibility(View.VISIBLE);
        mToolbarTilte.setText(getString(R.string.app_name));
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        drawerFragment = new FragmentDrawer();
        switchChildFragment(this, drawerFragment, R.id.navigation_drawer,false);
        drawerFragment.setUp((DrawerLayout)view.findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);
        // display the first navigation drawer view on app launch
        displayView(0);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new FragmentB();
                break;
            case 2:
                fragment = new FragmentB();
                break;
            default:
                break;
        }
        if (fragment != null) {
            switchChildFragment(this, fragment, R.id.container_body,false);
        }
    }
    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

}
