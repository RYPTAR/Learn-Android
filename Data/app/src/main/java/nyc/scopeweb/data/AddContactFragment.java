package nyc.scopeweb.data;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddContactFragment extends Fragment {

    Button BnSave;
    EditText Id, Name, Email;

    public AddContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_contact, container, false);

        BnSave = view.findViewById(R.id.bn_save);
        Id = view.findViewById(R.id.text_contact_id);
        Name = view.findViewById(R.id.text_contact_name);
        Email = view.findViewById(R.id.text_contact_email);

        BnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id = Id.getText().toString();
                String name = Id.getText().toString();
                String email = Id.getText().toString();

                ContactDbHelper contactDbHelper = new ContactDbHelper(getActivity());
                //** WARNING! ** Never actually do a database operation on the main thread
                SQLiteDatabase db = contactDbHelper.getWritableDatabase();
                contactDbHelper.addContact(Integer.parseInt(id), name, email, db);
                contactDbHelper.close();

                Id.setText("");
                Name.setText("");
                Email.setText("");
            }
        });

        return view;
    }

}
