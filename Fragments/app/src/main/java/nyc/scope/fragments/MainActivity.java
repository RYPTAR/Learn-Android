package nyc.scope.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Display a screen consisting of 2 static fragments and a single dynamic fragment container
 *
 * Instead of creating a new application for every section I combined Static and Dynamic Fragments into 1 Activity
 */
public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    // Fragment manager place holder
    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Gets the fragment manager
        fragmentManager = getSupportFragmentManager();

        // Proper fragment checking
        if(findViewById(R.id.fragment_container) != null){

            if(savedInstanceState!=null){
                return;
            }

            // Sets up dynamic container to recieve first fragment
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            HomeFragment homeFragment = new HomeFragment();
            fragmentTransaction.add(R.id.fragment_container, homeFragment, null);
            fragmentTransaction.commit();
        }

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
