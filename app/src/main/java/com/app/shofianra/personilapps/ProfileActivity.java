package com.app.shofianra.personilapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.app.shofianra.personilapps.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity {

    @BindView(R.id.image_mahasiswa)
    ImageView imageMahasiswa;
    @BindView(R.id.txt_nama)
    TextView txtNama;
    @BindView(R.id.txt_nim)
    TextView txtNim;
    @BindView(R.id.txt_tanggal_lahir)
    TextView txtTanggalLahir;
    @BindView(R.id.txt_alamat)
    TextView txtAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_personil);
        ButterKnife.bind(this);

        initToolbar();
        initUI();
    }

    private void initToolbar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.detail_profil_mahasiswa));
    }

    private void initUI() {
        Glide.with(this)
                .load("")
                .into(imageMahasiswa);
        txtNama.setText("Shofian Rahmat Apria");
        txtNim.setText("1157050156");
        txtTanggalLahir.setText("Magetan, 11 April 1996");
        txtAlamat.setText("Masjid Ilaa Khoiri Ummah Pasirbiru, Cibiru, Bandung");
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
