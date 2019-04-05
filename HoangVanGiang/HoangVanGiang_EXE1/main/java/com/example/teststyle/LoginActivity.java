package com.example.teststyle;

import android.content.Intent;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    //Khai báo biến
    private Button btnDangKy;
    private Button btnDangNhap;
    private Button btnDangNhapFb;
    private Button btnMatPassword;
    private EditText edtUsername;
    private EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setControl();
        setEvent();
        edtUsername = (EditText) findViewById(R.id.tv_username);
        edtPassword = (EditText) findViewById(R.id.tv_password);
        Intent intent = getIntent();
        edtUsername.setText(intent.getStringExtra(RegisterActivity.USERNAME));
        edtPassword.setText(intent.getStringExtra(RegisterActivity.PASSWORD));

    }

    public void setControl(){
        btnDangKy = (Button) findViewById(R.id.tv_register);
        btnDangNhap = (Button) findViewById(R.id.btn_login_email);
        btnDangNhapFb = (Button) findViewById(R.id.btn_fb_login);
        btnMatPassword = (Button) findViewById(R.id.tv_lost_pass);


    }
    public void setEvent(){
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtUsername.getText().length() != 0 && edtPassword.getText().length() != 0){
                    //if (edtUsername.getText().toString().equals())
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    Toast.makeText(LoginActivity.this, "Đăng Nhập Thành Công.", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this, "Đăng Nhập Thất Bại.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnDangNhapFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                Toast.makeText(LoginActivity.this, "Đăng Nhập Thành Công.", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        btnMatPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
                //Toast.makeText(LoginActivity.this, "Đã Đặt Lại Mật Khẩu.", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void showDialog() {
        final Dialog dialog = new Dialog(LoginActivity.this);
        dialog.setTitle("Quên Mật Khẩu");
        dialog.setContentView(R.layout.dialog);
        final EditText edtResetPass = (EditText) dialog.findViewById(R.id.tv_rsemail);
        Button btnDongY = (Button) dialog.findViewById(R.id.btnDongy);
        btnDongY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtResetPass.getText().length() != 0){
                    Toast.makeText(LoginActivity.this, "Đã Đặt Lại Mật Khẩu.", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }else {
                    Toast.makeText(LoginActivity.this, "Email không tồn tại hoặc sai định dạng.", Toast.LENGTH_SHORT).show();
                    edtResetPass.clearFocus();
                }

            }
        });

        dialog.show();
    }
}
