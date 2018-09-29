package nyc.scopeweb.data;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteContactFragment extends Fragment {

    private Button BnDelete;
    private EditText Id;

    public DeleteContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_contact, container, false);

        Id = view.findViewById(R.id.text_delete_id);

        BnDelete = view.findViewById(R.id.bn_delete);
        BnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteContact();
            }
        });


        return view;
    }

    private void deleteContact(){
        int id = Integer.parseInt(Id.getText().toString());

        ContactDbHelper contactDbHelper = new ContactDbHelper(getActivity());
        //** WARNING! ** Never actually do a database operation on the main thread
        SQLiteDatabase db = contactDbHelper.getWritableDatabase();

        contactDbHelper.deleteContact(id, db);
        contactDbHelper.close();

        Id.setText("");

        Toast.makeText(getActivity(), "Contact Successfully Removed...", Toast.LENGTH_SHORT).show();
    }

}
