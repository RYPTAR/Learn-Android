package nyc.scope.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Demos Dynamic Fragments and utilizing fragment swapping. This is the first fragment swapped to
 */
public class FirstFragment extends Fragment {

    // Button placeholder
    private Button button;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        // Sets Fragment button
        button = view.findViewById(R.id.b2);

        // You must set fragment buttons' onClickListener and onClick method
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Swaps first fragment to the second
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new SecondFragment(), null).addToBackStack(null).commit();
            }
        });

        return view;
    }

}
