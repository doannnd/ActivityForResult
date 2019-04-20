package com.nguyendinhdoan.activityforresult;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

import timber.log.Timber;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int LOGIN_REQUEST_CODE = 100;
    private Button loginButton;
    private Button registerButton;
    private EditText userNameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
        addEvents();
    }

    private void initViews() {
        loginButton = findViewById(R.id.login_button);
        registerButton = findViewById(R.id.register_button);
        userNameEditText = findViewById(R.id.user_name_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
    }

    private void addEvents() {
        loginButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button: {
                break;
            }
            case R.id.register_button: {
                handleRegister();
                break;
            }
        }
    }

    private void handleRegister() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivityForResult(intent, LOGIN_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (LOGIN_REQUEST_CODE == requestCode && data != null) {
            if (resultCode == Activity.RESULT_OK) {
                // get username and password from register activity and set for edit text
                String userName = data.getStringExtra(RegisterActivity.USER_NAME_KEY);
                String password = data.getStringExtra(RegisterActivity.PASSWORD_KEY);
                Timber.d("username: %s", userName);
                Timber.d("password: %s", password);

                userNameEditText.setText(userName);
                passwordEditText.setText(password);

            } else if (resultCode == Activity.RESULT_CANCELED) {
                Timber.d("no result return");
            }

        }
    }
}
