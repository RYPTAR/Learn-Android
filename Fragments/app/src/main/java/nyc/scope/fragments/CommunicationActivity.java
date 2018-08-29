package nyc.scope.fragments;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Passes a User message from fragment to an activity and another fragment.
 *
 * Instead of creating a new application for every section I combined Fragment Activity and Fragment to Fragment communication into 1 Activity
 */

// You must implement created interfaces to receive fragment communication
public class CommunicationActivity extends AppCompatActivity implements MessageFragment.OnMessageReadListener{

    // Activity's textview placeholder
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication);

        // Proper fragment checking
        if(findViewById(R.id.fragment_container) != null){
            if(savedInstanceState != null){
                return;
            }

            // Creates Fragment
            MessageFragment messageFragment = new MessageFragment();

            // Attaches the messageFragment
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, messageFragment, null);
            // You must always commit you fragment changes
            fragmentTransaction.commit();
        }
    }

    // All methods must be included and "overrid" from the implemented interfaces.
    @Override
    public void onMessageRead(String message){

        // **** Fragment to Activity communication ****

        // Sets Activity's textview
        textView = findViewById(R.id.text_display_message);
        String activityMessage = "Activity received: " +message;
        textView.setText(activityMessage);

        // ***********************************************************************************************
        // **** Fragment to Fragment communication ****

        // Create the new fragment
        DisplayFragment displayFragment = new DisplayFragment();

        //Create the bundle
        Bundle bundle = new Bundle();

        // Bundle consists of a "key" and variable
        bundle.putString("message", message);

        // Attaches bundle to the fragment
        displayFragment.setArguments(bundle);

        // Swaps Fragment
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, displayFragment, null);

        // Adds fragment back navigation
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        // ***********************************************************************************************
    }
}
