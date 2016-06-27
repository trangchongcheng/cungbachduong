package cungxunu.cunghoangdao.cheng.cungxunu;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cungxunu.cunghoangdao.cheng.cungxunu.fragment.FragmentA;
import cungxunu.cunghoangdao.cheng.cungxunu.fragment.FragmentB;

public class MainActivity extends AppCompatActivity {
    private String TAG = getClass().getSimpleName();
    private Button btnClick, btnCall;
    private TextView tvContent;
  //  private FragmentTransaction fragmentTransaction;
    int i = 1;
    private FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClick = (Button) findViewById(R.id.btnClick);
        btnCall = (Button) findViewById(R.id.btnCall);
        final FragmentManager fm = getSupportFragmentManager();
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction = fm.beginTransaction();
                Fragment fragment = null;
                ++i;
                if (i % 2 == 0) {
                    fragment = new FragmentA();
                }else {
                    fragment = new FragmentB();
                }
                fragmentTransaction.add(R.id.fragment_container, fragment, fragment.getClass().getSimpleName());
                Log.d(TAG, "onClick: "+fragment.getClass().getSimpleName());
                //fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                Log.d(TAG, "onClick:" +fm.getBackStackEntryCount());
            }
        });
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fm.findFragmentByTag("FragmentA"));
                //fragmentTransaction.commit();
                Log.d(TAG, "onClick btnCall" +fm.getBackStackEntryCount());
            }
        });
    }


}
