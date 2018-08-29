package nyc.scope.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * Sends a user message to the communication activity
 */
public class MessageFragment extends Fragment {

    // Text input and button placeholders
    EditText editText;
    Button button;

    // Interface placeholder
    OnMessageReadListener messageReadListener;

    public MessageFragment() {
        // Required empty public constructor
    }

    // Interface for fragment communication
    public interface OnMessageReadListener{
        //Interfaces abstract away the details of function behavior, similar to a header file's prototype functions
        public void onMessageRead(String message);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);

        // Sets text input and button
        editText = view.findViewById(R.id.text_message);
        button = view.findViewById(R.id.bn);

        // Sets onClick
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                String message = editText.getText().toString();

                messageReadListener.onMessageRead(message);
            }
        });

        return view;
    }

    // On Attach gets when the fragment is attached to the container
    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        // Get the activity context for utilization and binding
        Activity activity = (Activity) context;
        
        try{

            // Declares the listener to the activity's scope
            messageReadListener = (OnMessageReadListener) activity;

        } catch(ClassCastException e){
            throw new ClassCastException(activity.toString()+" must override onMessageRead...");
        }
    }

    // On Resume gets calls every time the fragment is returned to
    @Override
    public void onResume(){
        super.onResume();
        // Resets the input text field
        editText.setText("");
    }

}
