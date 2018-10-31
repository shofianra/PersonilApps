package com.app.shofianra.personilapps;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.app.shofianra.personilapps.R;
import com.app.shofianra.personilapps.Personil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailPersonilActivity extends AppCompatActivity {

    @BindView(R.id.image_personil)
    ImageView imagePersonil;
    @BindView(R.id.txt_nama_personil)
    TextView txtNamaPersonil;
    @BindView(R.id.txt_jenis_kelamin)
    TextView txtJenisKelamin;
    @BindView(R.id.txt_tanggal_lahir)
    TextView txtTanggalLahir;
    @BindView(R.id.txt_alamat)
    TextView txtAlamat;

    Personil personil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_personil);
        ButterKnife.bind(this);

        personil = (Personil) getIntent().getSerializableExtra("personil");

        initToolbar();
        initUI();
    }

    private void initToolbar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.detail_profil_personil));
        getSupportActionBar().setSubtitle(personil.getNama());
    }

    private void initUI() {
        Glide.with(this).load(personil.getImage()).into(imagePersonil);
        txtNamaPersonil.setText(personil.getNama());
        txtJenisKelamin.setText(personil.getJenisKelamin());
        txtTanggalLahir.setText(personil.getTanggalLahir());
        txtAlamat.setText(personil.getAlamat());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home : {
                finish();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}