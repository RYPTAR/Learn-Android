package nyc.scopeweb.data;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewContactsFragment extends Fragment {

    TextView Txt_View_Contacts;

    public ViewContactsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_contacts, container, false);

        Txt_View_Contacts = view.findViewById(R.id.txt_view_contacts);
        getContacts();
        return view;
    }

    public void getContacts(){
        ContactDbHelper contactDbHelper = new ContactDbHelper(getActivity());
        //** WARNING! ** Never actually do a database operation on the main thread
        SQLiteDatabase db = contactDbHelper.getReadableDatabase();
        Cursor cursor = contactDbHelper.getContacts(db);

        String info = "";

        while(cursor.moveToNext()){
            String id = Integer.toString(cursor.getInt(cursor.getColumnIndex(ContactContract.ContactEntry.CONTACT_ID)));
            String name = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.NAME));
            String email = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.EMAIL));

            info += "\n\n" + "Id : "+id+"\nName : "+name+"\nEmail : "+email;
        }

        Txt_View_Contacts.setText(info);
        contactDbHelper.close();


    }

}
