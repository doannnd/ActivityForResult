package com.nguyendinhdoan.activityforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import timber.log.Timber;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String USER_NAME_KEY = "USER_NAME_KEY";
    public
    static final String PASSWORD_KEY = "PASSWORD_KEY";
    private Button registerButton;
    private EditText userNameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();
        addEvents();
    }

    private void initViews() {
        registerButton = findViewById(R.id.register_button);
        userNameEditText = findViewById(R.id.user_name_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
    }

    private void addEvents() {
        registerButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.register_button) {
            sendDataToLogin();
        }
    }

    private void sendDataToLogin() {
        String userName = userNameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        Intent intentRegister = new Intent();
        intentRegister.putExtra(USER_NAME_KEY, userName);
        intentRegister.putExtra(PASSWORD_KEY, password);
        setResult(Activity.RESULT_OK, intentRegister);
        finish();
    }

    @Override
    public void onBackPressed() {
        Timber.d("back to login activity");
        setResult(Activity.RESULT_CANCELED);
        super.onBackPressed();
    }
}
