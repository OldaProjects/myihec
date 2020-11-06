package ihecso.pfe.myihec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity  implements View.OnClickListener {

    //create the activity tag
    //this is used for debugging, it helps identify where errors are occurring if we run into problems in the future
    private static final String TAG = "LoginActivity";

    //widgets
    private Button mLogin;
    private TextView txtInscription;
    private EditText cin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //any Log.d method calls designate a point in your code where a message will be printed to the logcat.
        //You can write a custom message
        Log.d(TAG,"onCreate: started." );

        //attach mLogin button to its ID
        mLogin = findViewById(R.id.btn_login);

        cin=(EditText)findViewById(R.id.txt_cin);

        //attach onClickListener to the login button so we can take an action when the user clicks it
        //this is in red, because it references an interface is not yet implemented
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = cin.getText().toString();
                if((user.equals("")) ||(user.equals("Olfa"))){
                    Intent intentMain = new Intent(LoginActivity.this, MainActivity.class);
                     Bundle dataToAccueil = new Bundle();
                     dataToAccueil.putString("user", user);
                     intentMain.putExtras(dataToAccueil);
                    startActivity(intentMain);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                }else {
                    openErrorDialog();
                }
            }
        });

        txtInscription = findViewById(R.id.change_language_txt);
        txtInscription.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        Intent intentMain = null;

        //discriminate between which widgets were being clicked
        switch(view.getId()){
            case  R.id.btn_login:
                String user = cin.getText().toString();
                if((user.equals("Tayssir")) ||(user.equals("Olfa"))){
                    intentMain = new Intent(LoginActivity.this, MainActivity.class);
                    // Bundle dataToAccueil = new Bundle();
                    // dataToAccueil.putString("user", user);
                    // intentMain.putExtras(dataToAccueil);
                    startActivity(intentMain);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                }else {
                    openErrorDialog();
                }
                break;
            case R.id.change_language_txt:
                openChangeLanguageDialog();
                break;
            default:
                break;

        }
    }
    public void openErrorDialog() {
        /*ErrorDialog errorDialog = new ErrorDialog();
        errorDialog.show(getSupportFragmentManager(), "Error message");*/
    }

    public void openChangeLanguageDialog() {
        /*ChangeLanguageDialog changeLanguageDialog = new ChangeLanguageDialog();
        changeLanguageDialog.show(getSupportFragmentManager(), "example dialog");*/
    }
}
