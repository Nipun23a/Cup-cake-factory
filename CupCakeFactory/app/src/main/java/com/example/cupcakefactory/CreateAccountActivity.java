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

public class CreateAccountActivity extends AppCompatActivity {

    private EditText etEmail, etName, etPassword, etConfirmPassword;
    private Button btnCreateAccount;
    private TextView tvLogInAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        etEmail = findViewById(R.id.email);
        etName = findViewById(R.id.name);
        etPassword = findViewById(R.id.password);
        btnCreateAccount = findViewById(R.id.signupbutton);
        tvLogInAccount = findViewById(R.id.linkcreateTextView);

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String name = etName.getText().toString().trim();

                if (email.isEmpty() || password.isEmpty() || name.isEmpty()) {
                    Toast.makeText(CreateAccountActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    User user = new User(name, password, email);
                    User.addUser(user); // Add the new user to the userArrayList
                    Toast.makeText(CreateAccountActivity.this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(CreateAccountActivity.this, LoginActivity.class));
                    finish();
                }
            }
        });
    }
}