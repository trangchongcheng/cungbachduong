package cungxunu.cunghoangdao.cheng.cungxunu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by chientruong on 6/28/16.
 */
public abstract class BaseFragmentToolbar extends BaseFragment {
    protected Toolbar mToolbar;
    protected TextView mToolbarTilte;
    protected ImageView mLeftToolbar;
    protected ImageView mRightToolbar;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mToolbar = (Toolbar)view.findViewById(R.id.toolbar);
        mToolbarTilte = (TextView) view.findViewById(R.id.title_toolbar);
        mLeftToolbar = (ImageView) view.findViewById(R.id.left_too_bar);
        mRightToolbar = (ImageView) view.findViewById(R.id.right_tool_bar);
        setupActionBar();
    }

    public abstract void setupActionBar();
}
