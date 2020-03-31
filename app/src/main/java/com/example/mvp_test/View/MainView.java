package com.example.mvp_test.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvp_test.Presenter.DataPresenter;
import com.example.mvp_test.Presenter.IDataPresenter;
import com.example.mvp_test.R;

public class MainView extends AppCompatActivity implements IMainView {

    TextView f_name, l_name, email;
    EditText etxt_f, etxt_l, etxt_e;

    IDataPresenter dataPresenter = new DataPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        f_name = findViewById(R.id.fname);
        l_name = findViewById(R.id.lname);
        email = findViewById(R.id.email);

        etxt_f = findViewById(R.id.etxt_first);
        etxt_l = findViewById(R.id.etxt_last);
        etxt_e = findViewById(R.id.etxt_email);
    }

    public void loadData(View view){
        dataPresenter.onButtonClickLoadData(this);
    }

    public void saveData(View view){
        dataPresenter.onButtonClickStoreData(this, etxt_f.getText().toString(),
                etxt_l.getText().toString(), etxt_e.getText().toString());
    }

    @Override
    public void setAll(String fname, String lname, String _email){
        f_name.setText(fname);
        l_name.setText(lname);
        email.setText(_email);
    }
}
