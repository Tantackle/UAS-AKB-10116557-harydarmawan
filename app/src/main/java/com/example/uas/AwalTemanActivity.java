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

public class AwalTemanActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnSimpan, btnTampil;
    EditText nim, nama,kelas,tlp,email,sosmed;
    String sNama,sKelas,sTlp,sEmail,sSosmed;
    Integer sNim;
    Realm realm;
    RealmHelper realmHelper;
    TemanModel temanModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awalteman);

        //Inisialisasi
        btnSimpan = findViewById(R.id.btnSimpan);
        btnTampil = findViewById(R.id.btnTampil);
        nim = findViewById(R.id.nim);
        nama = findViewById(R.id.nama);
        kelas = findViewById(R.id.kelas);
        tlp = findViewById(R.id.tlp);
        email = findViewById(R.id.email);
        sosmed = findViewById(R.id.sosmed);

        //Set up Realm
        Realm.init(AwalTemanActivity.this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);

        btnSimpan.setOnClickListener(this);
        btnTampil.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnSimpan){
            sNim = Integer.parseInt(nim.getText().toString());
            sNama = nama.getText().toString();
            sKelas = kelas.getText().toString();
            sTlp = tlp.getText().toString();
            sEmail = email.getText().toString();
            sSosmed = sosmed.getText().toString();


            if (!sNim.equals("") && !sNama.isEmpty() && !sKelas.isEmpty() && !sTlp.isEmpty() && !sEmail.isEmpty() && !sSosmed.isEmpty() ){
                temanModel = new TemanModel();
                temanModel.setNim(sNim);
                temanModel.setNama(sNama);
                temanModel.setKelas(sKelas);
                temanModel.setTlp(sTlp);
                temanModel.setEmail(sEmail);
                temanModel.setSosmed(sSosmed);

                realmHelper = new RealmHelper(realm);
                realmHelper.save(temanModel);

                Toast.makeText(AwalTemanActivity.this, "Berhasil Disimpan!", Toast.LENGTH_SHORT).show();

                nim.setText("");
                nama.setText("");
                kelas.setText("");
                tlp.setText("");
                email.setText("");
                sosmed.setText("");
            }else {
                Toast.makeText(AwalTemanActivity.this, "Terdapat inputan yang kosong", Toast.LENGTH_SHORT).show();
            }
        }else if (v == btnTampil){
            startActivity(new Intent(AwalTemanActivity.this, TemanActivity.class));
        }
    }
}
