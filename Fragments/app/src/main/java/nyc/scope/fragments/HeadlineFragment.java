package nyc.scope.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Ray De Jesus aka RYPTAR 8/18/18
 *
 * Demos the use of a static fragment
 */
public class HeadlineFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Creating the view in a variable before inflating for possible manipulation
        View view = inflater.inflate(R.layout.headline_fragment_layout, container, false);
        return view;
    }
}
