package id.sch.smktelkom_mlg.xiirpl20011.laundryqu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama, etTelp;
    TextView tvHasil;
    CheckBox cbb, cbt,cbs;
    RadioGroup rgl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNama = (EditText) findViewById(R.id.editTextNama);
        etTelp = (EditText) findViewById(R.id.editTextTelp);
        tvHasil = (TextView) findViewById(R.id.textViewH);
        cbb = (CheckBox) findViewById(R.id.checkBoxB);
        cbt = (CheckBox) findViewById(R.id.checkBoxT);
        cbs = (CheckBox) findViewById(R.id.checkBoxS);
        rgl = (RadioGroup) findViewById(R.id.rg);

        findViewById(R.id.buttonP).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });
    }

    private void doClick() {
        String nama = etNama.getText().toString();
        int telp = Integer.parseInt(etTelp.getText().toString());
        StringBuilder builder = new StringBuilder();
        String hasil = null;
        if (rgl.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton) findViewById(rgl.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }
        String laundry = "Laundry yang diplih \t\n";
        int startlen = laundry.length();
        if (cbt.isChecked()) laundry += "\t  " + cbt.getText() + "\n";
        if (cbb.isChecked()) laundry += "\t  " + cbb.getText() + "\n";
        if (cbs.isChecked()) laundry += "\t  " + cbs.getText() + "\n";
        if (laundry.length() == startlen) {
            tvHasil.setText("Tidak ada laundry yang dipilih\n");
        } else {
            if (hasil == null) {
                tvHasil.setText("Anda belum memilih Jenis Kelamin\n");
            } else {
                builder.append("Nama : " + nama + "\n");
                builder.append("Telp : " + telp + "\n");
                builder.append("Jenis Kelamin : " + hasil + "\n");
                builder.append("\n" + laundry);
                tvHasil.setText(builder);
            }
        }
    }
}
