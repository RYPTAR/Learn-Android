package nyc.scopeweb.data;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup
    static {
        System.loadLibrary("native-lib");
    }

    SharedPreferenceConfig preferenceConfig;
    EditText UserName, UserPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        preferenceConfig = new SharedPreferenceConfig(getApplicationContext());

        UserName = findViewById(R.id.user_name);
        UserPassword = findViewById(R.id.user_password);

        if(preferenceConfig.readLoginStatus() == true){
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public void loginUser(View view) {
        String username = UserName.getText().toString();
        String password = UserPassword.getText().toString();

        if(username.equals(getResources().getString(R.string.user_name))
                && password.equals(getResources().getString(R.string.user_password))){

            startActivity(new Intent(this, MainActivity.class));
            preferenceConfig.writeLoginStatus(true);
            finish();
        }
        else{
            Toast.makeText(this, "Login Failed... Please try again...", Toast.LENGTH_SHORT).show();
            UserName.setText("");
            UserPassword.setText("");
        }
    }
}
