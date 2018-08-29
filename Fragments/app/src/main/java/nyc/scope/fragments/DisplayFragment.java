package nyc.scope.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Fragment receives and displays a user message from another fragment
 */

public class DisplayFragment extends Fragment {

    private TextView textView;

    public DisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display, container, false);

        textView = view.findViewById(R.id.fragment_message_display);

        // Retrieves bundle arguments
        Bundle bundle = getArguments();

        // Sets string from bundle with key name
        String message = "Fragment received: "+bundle.getString("message");

        textView.setText(message);

        return view;
    }

}
