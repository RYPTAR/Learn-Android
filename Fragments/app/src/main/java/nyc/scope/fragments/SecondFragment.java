package nyc.scope.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * Demos Dynamic Fragments and utilizing fragment swapping. This is the second fragment swapped to
 * Also switches to the communication activity to demo the fragment communication
 */
public class SecondFragment extends Fragment {

    // Button placeholder
    Button button;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        // Sets Fragment button
        button = view.findViewById(R.id.b3);

        // You must set fragment buttons' onClickListener and onClick method
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getActivity(), CommunicationActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
