package com.app.shofianra.personilapps;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.app.shofianra.personilapps.R;
import com.app.shofianra.personilapps.PersonilAdapter;
import com.app.shofianra.personilapps.Personil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_personil)
    RecyclerView rvPersonil;

    private PersonilAdapter mAdapter;

    List<Personil> listPersonil = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initPersonilData();
        initRecyclerView();
    }

    private void initRecyclerView() {
        rvPersonil.setHasFixedSize(true);
        rvPersonil.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new PersonilAdapter(this, listPersonil);
        rvPersonil.setAdapter(mAdapter);
    }

    private void initPersonilData() {
        listPersonil.add(new Personil("Shofian Rahmat Apria", "Laki-laki", "Cibiru, Bandung", "Magetan, 11 April 1996", "src='@drawable/cek'"));
        listPersonil.add(new Personil("Ahmaduddin", "Laki-laki", "Cibiru, Bandung", "Yogyakarta, 26 April 1998", "src='@drawable/cek2"));
        listPersonil.add(new Personil("Abdullah", "Laki-laki", "Cibiru, Bandung", "Bandung, 14 April 1996", "src='@drawable/cek3'"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_profile:
                Intent i = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(i);
                break;
            case R.id.nav_bahasa:
                Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
                startActivity(intent);
                break;
        }
        return true;
    }
}