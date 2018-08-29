package nyc.scope.fragments;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CommunicationActivity extends AppCompatActivity implements MessageFragment.OnMessageReadListener{

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication);

        if(findViewById(R.id.fragment_container) != null){
            if(savedInstanceState != null){
                return;
            }

            MessageFragment messageFragment = new MessageFragment();

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, messageFragment, null);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onMessageRead(String message){
        textView = findViewById(R.id.text_display_message);
        String activityMessage = "Activity received: " +message;
        textView.setText(activityMessage);



        DisplayFragment displayFragment = new DisplayFragment();
        Bundle bundle = new Bundle();
        bundle.putString("message", message);
        displayFragment.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, displayFragment, null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
