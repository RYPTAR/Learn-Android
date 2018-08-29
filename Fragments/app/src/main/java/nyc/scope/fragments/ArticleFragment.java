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
 * Demos the use of a static Fragment
 */
public class ArticleFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflates fragment within prescribed container
        return inflater.inflate(R.layout.article_fragment_layout, container, false);
    }
}
