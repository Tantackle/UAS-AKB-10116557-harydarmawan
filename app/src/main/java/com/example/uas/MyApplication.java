package com.example.uas;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;


//Tanggal :13 Agustus 2019
//Nim     :10116557
//Nama    :Hari Darmawan
//Kelas   :IF-13
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("mahasiswa.db")
                .schemaVersion(0)
                .build();
        Realm.setDefaultConfiguration(configuration);
    }

}
