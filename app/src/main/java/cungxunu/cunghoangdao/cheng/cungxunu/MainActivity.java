package cungxunu.cunghoangdao.cheng.cungxunu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import cungxunu.cunghoangdao.cheng.cungxunu.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {
    private String TAG = getClass().getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switchFragment(new MainFragment());
    }

    public void switchFragment(Fragment fragment) {
        String FRAGMENT_TAG = fragment.getClass().getSimpleName();
        this.getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.fragment_container, fragment, FRAGMENT_TAG)
                .addToBackStack(FRAGMENT_TAG)
               // .commit();
                .commitAllowingStateLoss();
    }

    public void switchFragmentWithoutAddToBackstack(Fragment fragment) {
        String FRAGMENT_TAG = fragment.getClass().getSimpleName();
        this.getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.fragment_container, fragment, FRAGMENT_TAG)
                .commitAllowingStateLoss();
    }
    public boolean popFragment() {
        Log.d("Tag", "popFragment: "+getSupportFragmentManager().getBackStackEntryCount());
        boolean isPop = false;
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            isPop = true;
            getSupportFragmentManager().popBackStack();
        }
        return isPop;
    }
}
