package com.daffzzaqihaq.puisiku;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.daffzzaqihaq.puisiku.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Recycle extends AppCompatActivity {

    @BindView(R.id.my_recycler_view)
    RecyclerView myRecyclerView;

    String[] namaHeroes, detailHeroes;
    int[] gambarHeroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        ButterKnife.bind(this);


        namaHeroes = getResources().getStringArray(R.array.name);
        detailHeroes = getResources().getStringArray(R.array.detail);
        gambarHeroes = new int[]{R.drawable.picture, R.drawable.picture, R.drawable.picture, R.drawable.picture, R.drawable.picture};

        Adapter adapter = new Adapter(Recycle.this, gambarHeroes, namaHeroes, detailHeroes);

        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(Recycle.this));
        myRecyclerView.setAdapter(adapter);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.about:
                intent = new Intent(this, About.class);
                startActivity(intent);
                break;

            case R.id.support:
                Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Daffzzaqihaq"));
                startActivity(implicit);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}



