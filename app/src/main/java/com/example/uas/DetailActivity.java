package com.example.uas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmConfiguration;
//Tanggal :13 Agustus 2019
//Nim     :10116557
//Nama    :Hari Darmawan
//Kelas   :IF-13

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etNim, etNama,etKelas,etTlp,etEmail,etSosmed;
    String nim, nama,kelas,tlp,email,sosmed;
    Integer id;
    Button btn_ubah, btn_hapus, btn_kembali;
    RealmHelper realmHelper;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Set up
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);
        realmHelper = new RealmHelper(realm);

        // Inisialisasi
        etNim = findViewById(R.id.etNim);
        etNama = findViewById(R.id.etNama);
        etKelas = findViewById(R.id.etKelas);
        etTlp = findViewById(R.id.etTlp);
        etEmail = findViewById(R.id.etEmail);
        etSosmed = findViewById(R.id.etsosmed);
        btn_ubah = findViewById(R.id.btnUpdate);
        btn_hapus = findViewById(R.id.btnHapus);
        btn_kembali = findViewById(R.id.btnCancel);

        id = Integer.parseInt(getIntent().getStringExtra("id"));
        nim = getIntent().getStringExtra("nim");
        nama = getIntent().getStringExtra("nama");
        kelas = getIntent().getStringExtra("kelas");
        tlp = getIntent().getStringExtra("tlp");
        email = getIntent().getStringExtra("email");
        sosmed = getIntent().getStringExtra("sosmed");

        etNim.setText(nim);
        etNama.setText(nama);
        etKelas.setText(kelas);
        etTlp.setText(tlp);
        etEmail.setText(email);
        etSosmed.setText(sosmed);

        btn_kembali.setOnClickListener(this);
        btn_hapus.setOnClickListener(this);
        btn_ubah.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btn_ubah){
            realmHelper.update(id, Integer.parseInt(etNim.getText().toString()),etNama.getText().toString(),etKelas.getText().toString() ,etTlp.getText().toString() ,etEmail.getText().toString() ,etSosmed.getText().toString());
            Toast.makeText(DetailActivity.this, "Update Success", Toast.LENGTH_SHORT).show();
            etNim.setText("");
            etNama.setText("");
            etKelas.setText("");
            etTlp.setText("");
            etEmail.setText("");
            etSosmed.setText("");
            finish();
        }else if (v == btn_hapus) {
            realmHelper.delete(id);
            Toast.makeText(DetailActivity.this, "Delete Success", Toast.LENGTH_SHORT).show();
            finish();
        }else if (v == btn_kembali) {
            startActivity(new Intent(DetailActivity.this, TemanActivity.class));
            finish();
        }
    }
}
