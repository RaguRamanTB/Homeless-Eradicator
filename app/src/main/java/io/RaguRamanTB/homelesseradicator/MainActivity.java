package io.RaguRamanTB.homelesseradicator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static EditText emailId, password;
    private static Button loginButton, signUp, donate, forum;
    private static TextView forgotPassword;
    private static CheckBox show_hide_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiateViews();
        setListeners();
    }

    private void setListeners() {
        loginButton.setOnClickListener(this);
        forgotPassword.setOnClickListener(this);
        signUp.setOnClickListener(this);
        donate.setOnClickListener(this);
        forum.setOnClickListener(this);
        show_hide_password
                .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton button,
                                                 boolean isChecked) {
                        if (isChecked) {
                            show_hide_password.setText(R.string.hide_pwd);
                            password.setInputType(InputType.TYPE_CLASS_TEXT);
                            password.setTransformationMethod(HideReturnsTransformationMethod
                                    .getInstance());
                        } else {
                            show_hide_password.setText(R.string.show_pwd);
                            password.setInputType(InputType.TYPE_CLASS_TEXT
                                    | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                            password.setTransformationMethod(PasswordTransformationMethod
                                    .getInstance());
                        }
                    }
                });
    }

    private void initiateViews() {
        emailId = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.loginBtn);
        signUp = (Button) findViewById(R.id.createAccount);
        donate = findViewById(R.id.donate);
        forum = findViewById(R.id.forum);
        show_hide_password = findViewById(R.id.show_hide_password);
        forgotPassword = findViewById(R.id.forgot_password);
        @SuppressLint("ResourceType") XmlResourceParser xrp = getResources().getXml(R.drawable.text_selector);
        try {
            ColorStateList csl = ColorStateList.createFromXml(getResources(), xrp);
            forgotPassword.setTextColor(csl);
            show_hide_password.setTextColor(csl);
        } catch (Exception e) {
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginBtn:
                loginUser();
                break;

            case R.id.forgot_password:
                Toast.makeText(this, "Forgot Password to be done!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.createAccount:
                registerAccount();
                break;

            case R.id.donate:
                goToDonateActivity();
                break;

            case R.id.forum:
                goToForumActivity();
                break;
        }
    }

    private void goToForumActivity() {
        Toast.makeText(this, "Go to Forum to be done!", Toast.LENGTH_SHORT).show();
    }

    private void goToDonateActivity() {
        Toast.makeText(this, "Go to Donate to be done!", Toast.LENGTH_SHORT).show();
    }

    private void loginUser() {
//        Temporary Login is used now
        Intent i = new Intent(this, FunctionsActivity.class);
        startActivity(i);
    }

    private void registerAccount() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
