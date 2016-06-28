package cungxunu.cunghoangdao.cheng.cungxunu.fragment;


import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cungxunu.cunghoangdao.cheng.cungxunu.R;
import cungxunu.cunghoangdao.cheng.cungxunu.adapter.NavigationDrawerAdapter;
import cungxunu.cunghoangdao.cheng.cungxunu.model.NavDrawerItem;

/**
 * Created by chientruong on 6/28/16.
 */
public class FragmentDrawer extends Fragment {
    private static String[] titles = null;
    private static TypedArray imgs;
    @BindView(R.id.fragment_navigation_rcvItemMenu)
    RecyclerView rcvItemMenu;
    private NavigationDrawerAdapter navigationDrawerAdapter;
    protected FragmentDrawerListener drawerListener;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        titles = getActivity().getResources().getStringArray(R.array.item_drawer);
        imgs = getResources().obtainTypedArray(R.array.icon_drawer);
    }
    public void setDrawerListener(FragmentDrawerListener listener) {
        this.drawerListener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation_drawer,container,false);
        ButterKnife.bind(this,view);
        navigationDrawerAdapter = new NavigationDrawerAdapter(getActivity(),initDrawerItem());
        rcvItemMenu.setHasFixedSize(true);
        rcvItemMenu.setAdapter(navigationDrawerAdapter);
        rcvItemMenu.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcvItemMenu.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), rcvItemMenu, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                drawerListener.onDrawerItemSelected(view, position);
                mDrawerLayout.closeDrawers();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        return view;
    }

    public void setUp(DrawerLayout drawerLayout, final Toolbar toolbar) {
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                toolbar.setAlpha(1 - slideOffset / 2);
            }
        };
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

    }

    private List<NavDrawerItem> initDrawerItem() {
        List<NavDrawerItem> arr = new ArrayList<>();

        for(int i = 0; i < titles.length; i++) {
          arr.add(new NavDrawerItem(titles[i],imgs.getResourceId(i, -1)));
        }
        return arr;
    }

    public interface FragmentDrawerListener {
        public void onDrawerItemSelected(View view, int position);
    }

    public static interface ClickListener {
        public void onClick(View view, int position);

        public void onLongClick(View view, int position);
    }

    static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }


    }
}
