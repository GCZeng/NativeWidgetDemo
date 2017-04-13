package org.widget.activity;

import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.apache.commons.lang.StringUtils;
import org.widget.R;
import org.widget.activity.base.BaseActivity;

/**
 * Created by Nick on 2017/4/12
 */
public class TextInputLayoutActivity extends BaseActivity {
    private Button btn_login;
    private TextInputLayout til_account;
    private TextInputLayout til_password;

    @Override
    protected int providerLayout() {
        return R.layout.activity_textinputlayout;
    }

    @Override
    protected void initView() {
        btn_login = (Button) findViewById(R.id.btn_login);
        til_account = (TextInputLayout) findViewById(R.id.til_account);
        til_password = (TextInputLayout) findViewById(R.id.til_password);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = til_account.getEditText().getText().toString();
                String password = til_password.getEditText().getText().toString();

                til_account.setErrorEnabled(false);
                til_password.setErrorEnabled(false);

                //验证用户名和密码
                if(validateAccount(account)&&validatePassword(password)){
                    Toast.makeText(TextInputLayoutActivity.this,"登录成功",Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    /**
     * 验证用户名
     * @param account
     * @return
     */
    private boolean validateAccount(String account){
        if(StringUtils.isEmpty(account)){
            showError(til_account,"用户名不能为空");
            return false;
        }
        return true;
    }

    /**
     * 验证密码
     * @param password
     * @return
     */
    private boolean validatePassword(String password) {
        if (StringUtils.isEmpty(password)) {
            showError(til_password,"密码不能为空");
            return false;
        }

        if (password.length() < 6 || password.length() > 18) {
            showError(til_password,"密码长度为6-18位");
            return false;
        }

        return true;
    }

    /**
     * 显示错误提示，并获取焦点
     * @param textInputLayout
     * @param error
     */
    private void showError(TextInputLayout textInputLayout,String error){
        textInputLayout.setError(error);
        textInputLayout.getEditText().setFocusable(true);
        textInputLayout.getEditText().setFocusableInTouchMode(true);
        textInputLayout.getEditText().requestFocus();
    }

    @Override
    protected void initData() {
        setTitle(getIntent().getStringExtra("title"));
    }


}
