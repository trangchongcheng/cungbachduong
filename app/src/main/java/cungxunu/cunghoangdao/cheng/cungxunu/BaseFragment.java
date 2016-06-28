package cungxunu.cunghoangdao.cheng.cungxunu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import cungxunu.cunghoangdao.cheng.cungxunu.ultils.LogUtil;

/**
 * Created by chientruong on 6/28/16.
 */
public class BaseFragment extends Fragment {

    protected MainActivity mMainActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainActivity = (MainActivity) getActivity();

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LogUtil.d(getClass().getName(), "onViewCreated : " + savedInstanceState);
        initBase(view);
        executeBase();
    }

    protected void executeBase() {
    }

    protected void initBase(View view) {

    }

    public void switchChildFragment(Fragment parentFragment, Fragment childFragment, int viewContainer, boolean isBackStack) {
        String FRAGMENT_TAG = childFragment.getClass().getSimpleName();
        FragmentTransaction transaction = parentFragment.getChildFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        transaction.replace(viewContainer, childFragment, FRAGMENT_TAG);
        if (isBackStack) {
            transaction.addToBackStack(FRAGMENT_TAG);
        }
        transaction.commitAllowingStateLoss();
    }

}
