package nesca.giuseppe.volleytutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.text.Layout;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    int egg = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab); //azione alla pressione del floating button
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_TEXT, "type something about VolleyTutorial");
                intent.putExtra(Intent.EXTRA_SUBJECT, "VolleyTutorial app feedback");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"emailsviluppatore@gmail.com"});
                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {    //setta i menù a seconda della view presentata dal flipper

        invalidateOptionsMenu();
        ViewFlipper viewFlipper = (ViewFlipper) findViewById(R.id.vf);
        switch (viewFlipper.getDisplayedChild()) {
            case 1:
                getMenuInflater().inflate(R.menu.main, menu);
                break;          //spike
            case 2:
                getMenuInflater().inflate(R.menu.main2, menu);
                break;        //palleggio
            case 3:
                getMenuInflater().inflate(R.menu.main3, menu);
                break;         //Muro
            case 4:
                getMenuInflater().inflate(R.menu.main4, menu);
                break;          //Bagher
            case 5:
                getMenuInflater().inflate(R.menu.main5, menu);
                break;          //Battuta
            default:
                getMenuInflater().inflate(R.menu.main0, menu);
                break;          //MainView
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {   //azioni del menù: scroll rapido verso i vari sottocapitoli
        int id = item.getItemId();

        if (id == R.id.action_scrollSalto) {
            ScrollView scrollView = (ScrollView) findViewById(R.id.spikeContent);
            TextView textView = (TextView) findViewById(R.id.saltoTitle);
            myscroll(scrollView, textView);
            return true;
        }
        if (id == R.id.action_scrollMani) {
            ScrollView scrollView = (ScrollView) findViewById(R.id.spikeContent);
            TextView textView = (TextView) findViewById(R.id.movManT);
            myscroll(scrollView, textView);
            return true;
        }
        if (id == R.id.action_scrollAInf) {
            ScrollView scrollView = (ScrollView) findViewById(R.id.palleggioContent);
            TextView textView = (TextView) findViewById(R.id.inferioriTitPall);
            myscroll(scrollView, textView);
            return true;
        }
        if (id == R.id.action_scrollASup) {
            ScrollView scrollView = (ScrollView) findViewById(R.id.palleggioContent);
            TextView textView = (TextView) findViewById(R.id.superioriTitPall);
            myscroll(scrollView, textView);
            return true;
        }
        if (id == R.id.action_scrollTronco) {
            ScrollView scrollView = (ScrollView) findViewById(R.id.palleggioContent);
            TextView textView = (TextView) findViewById(R.id.troncoTitoloPall);
            myscroll(scrollView, textView);
            return true;
        }
        if (id == R.id.action_scrollTecnica) {
            ScrollView scrollView = (ScrollView) findViewById(R.id.blockContent);
            TextView textView = (TextView) findViewById(R.id.blockTecnicaTitle);
            myscroll(scrollView, textView);
        }
        if (id == R.id.action_scrollStrategie) {
            ScrollView scrollView = (ScrollView) findViewById(R.id.blockContent);
            TextView textView = (TextView) findViewById(R.id.blockStrategieTitle);
            myscroll(scrollView, textView);
        }
        if (id == R.id.action_scrollRicezione) {
            ScrollView scrollView = (ScrollView) findViewById(R.id.bagherContent);
            TextView textView = (TextView) findViewById(R.id.bagherRicezioneTitle);
            myscroll(scrollView, textView);
        }
        if (id == R.id.action_scrollDifesa) {
            ScrollView scrollView = (ScrollView) findViewById(R.id.bagherContent);
            TextView textView = (TextView) findViewById(R.id.bagherDifesaTitle);
            myscroll(scrollView, textView);
        }
        if (id == R.id.action_scrollSpin) {
            ScrollView scrollView = (ScrollView) findViewById(R.id.servContent);
            TextView textView = (TextView) findViewById(R.id.servSpinTitle);
            myscroll(scrollView, textView);
        }
        if (id == R.id.action_scrollFloat) {
            ScrollView scrollView = (ScrollView) findViewById(R.id.servContent);
            TextView textView = (TextView) findViewById(R.id.servFloatTitle);
            myscroll(scrollView, textView);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setBackgroundTintList(getResources().getColorStateList(R.color.colorPrimaryDark));
        if (id == R.id.nav_spike) {
            changeContent(1);
        } else if (id == R.id.nav_palleggio) {
            changeContent(2);
        } else if (id == R.id.nav_block) {
            changeContent(3);
        } else if (id == R.id.nav_bagher) {
            changeContent(4);
        } else if (id == R.id.nav_servizio) {
            changeContent(5);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void info(View view) {   //un easteregg che si ottiene premendo il pallone presente all'inizio di vari content
        TextView textView = (TextView) findViewById(R.id.welcomeText);
        textView.setText("May the ball be with you"); //gust an easter egg
    }

    public void returnmainview(View view) { //cliccando su text o icona nel titolo nel drawer permette di tornare nella home
        changeContent(0);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setBackgroundTintList(getResources().getColorStateList(R.color.colorAccent));
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    public void changeContent(int n) {
        ViewFlipper viewFlipper = (ViewFlipper) findViewById(R.id.vf);
        viewFlipper.setDisplayedChild(n);
    }

    public void myscroll(ScrollView scrollView, TextView textView) //effetta scroll al sottocapitolo passato nella view data.
    {

        int y = textView.getTop() - textView.getHeight();
        //scrollView.scrollTo(0, y); //scroll immediato
        scrollView.smoothScrollTo(0, y); //scroll lento, più piacevole graficamente.
    }
}
