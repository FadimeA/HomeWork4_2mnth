package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView registerText = findViewById(R.id.signInTextView);
        LinearLayout loginLayout = findViewById(R.id.linear);
        LinearLayout linearSecond = findViewById(R.id.linearSecond);
        EditText emailEditText = findViewById(R.id.emailEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.button);
        TextView welcomeTextView = findViewById(R.id.welcomeTextView);

        passwordEditText.setInputType(android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD);


        emailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateButtonColor(loginButton, emailEditText, passwordEditText);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateButtonColor(loginButton, emailEditText, passwordEditText);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        loginButton.setOnClickListener(v -> {
            String username = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (username.equals("admin") && password.equals("admin")) {
                Snackbar.make(v, "Вы успешно зарегистрировались", Snackbar.LENGTH_LONG).show();

                loginLayout.setVisibility(View.GONE);
                linearSecond.setVisibility(View.GONE);
                registerText.setVisibility(View.GONE);

                welcomeTextView.setText("Добро пожаловать!");
                welcomeTextView.setTextColor(Color.WHITE);
                welcomeTextView.setVisibility(View.VISIBLE);
            } else {
                Snackbar.make(v, "Неправильный логин и пароль", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private void updateButtonColor(Button loginButton, EditText emailEditText, EditText passwordEditText) {
        if (!emailEditText.getText().toString().isEmpty() && !passwordEditText.getText().toString().isEmpty()) {
            loginButton.setBackgroundColor(Color.parseColor("#FF8000"));
        } else {
            loginButton.setBackgroundColor(Color.parseColor("#808080"));
        }
    }
}