package com.example.teststyle;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnBackLogin;
    private Button btnDangKy;
    private Button btnResetPassword;
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnBackLogin = (Button) findViewById(R.id.btn_back_login);
        btnDangKy = (Button) findViewById(R.id.btn_login_email);
        btnResetPassword = (Button) findViewById(R.id.btn_reset_password);
        edtEmail = (EditText) findViewById(R.id.tv_email);
        edtPassword = (EditText) findViewById(R.id.tv_password);

        btnBackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                byExtras();
                Toast.makeText(RegisterActivity.this, "Đăng Ký Thành Công.", Toast.LENGTH_SHORT).show();
            }
        });

        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }
    public void byExtras(){
        Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
        intent.putExtra(USERNAME,edtEmail.getText().toString());
        intent.putExtra(PASSWORD,edtPassword.getText().toString());
        startActivity(intent);
    }
    public void showDialog() {
        final Dialog dialog = new Dialog(RegisterActivity.this);
        dialog.setTitle("Quên Mật Khẩu");
        dialog.setContentView(R.layout.dialog);
        final EditText edtResetPass = (EditText) dialog.findViewById(R.id.tv_rsemail);
        Button btnDongY = (Button) dialog.findViewById(R.id.btnDongy);
        btnDongY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtResetPass.getText().length() != 0){
                    Toast.makeText(RegisterActivity.this, "Đã Đặt Lại Mật Khẩu.", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }else {
                    Toast.makeText(RegisterActivity.this, "Email không tồn tại hoặc sai định dạng.", Toast.LENGTH_SHORT).show();
                    edtResetPass.clearFocus();
                }

            }
        });

        dialog.show();
    }
}
