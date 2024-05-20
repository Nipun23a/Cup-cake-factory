package com.example.cupcakefactory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cupcakefactory.entity.User;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin;
    private TextView tvCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.username);
        etPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.loginbutton);
        tvCreateAccount = findViewById(R.id.linkTextView);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (isAdminValid(email, password)) {
                    startAdminDashboard();
                } else {
                    User authenticatedUser = authenticateUser(email, password);
                    if (authenticatedUser != null) {
                        startCustomerDashboard(authenticatedUser);
                    } else {
                        // Invalid credentials
                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        tvCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, CreateAccountActivity.class));
            }
        });
    }

    private boolean isAdminValid(String email, String password) {
        // Check for admin credentials
        return email.equals("admin") && password.equals("admin123");
    }

    private User authenticateUser(String email, String password) {
        ArrayList<User> userArrayList = User.getUserArrayList();
        for (User user : userArrayList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    private void startAdminDashboard() {
        Intent intent = new Intent(this, AdminActivity.class);
        startActivity(intent);
        finish();
    }


    private void startCustomerDashboard(User authenticatedUser) {
        Intent intent = new Intent(this, CustomerActivity.class);
        intent.putExtra("authenticatedUser", (CharSequence) authenticatedUser);
        startActivity(intent);
        finish();
    }
}
