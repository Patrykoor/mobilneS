package com.example.appkajava1;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.appkajava1.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    private Button t_przyckisk;
    private Button f_przyckisk;
    private Button d_przyckisk;
    private TextView pyt_view;
    private int currentInd=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);

         t_przyckisk=findViewById(R.id.t_przyckisk);
         f_przyckisk=findViewById(R.id.f_przyckisk);
         d_przyckisk=findViewById(R.id.d_przyckisk);
         pyt_view=findViewById(R.id.pyt_view);


       // setSupportActionBar(binding.toolbar);

       // NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
      //  appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
      //  NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        t_przyckisk.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                CheckPoprawnosci(true);
            }

        });

        f_przyckisk.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                CheckPoprawnosci(false);
            }

        });

        d_przyckisk.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                currentInd=(currentInd+1)%pytania.length;
                setNextPyt();
            }

        });
        setNextPyt();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
    private Question[] pytania= new Question[]{
            new Question(R.string.q1, true),
            new Question(R.string.q2, true ),
            new Question(R.string.q3, false ),
            new Question(R.string.q4, false ),
            new Question(R.string.q5, true ),
    };

    private void CheckPoprawnosci(boolean useranswer) {
        boolean poprawnaOdp=pytania[currentInd].isTrue();
        int tmp =0;
        if(useranswer==poprawnaOdp)
        {
            tmp=R.string.correct_answer;
        }else
        {
            tmp=R.string.incorrect_answer;
        }
        Toast.makeText(this,tmp,Toast.LENGTH_SHORT).show();
    }
    private void setNextPyt(){
        pyt_view.setText(pytania[currentInd].getQuestionId());
    }

}

