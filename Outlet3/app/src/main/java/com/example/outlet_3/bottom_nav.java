package com.example.outlet_3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.outlet_3.bottom_fragments.browse_f;
import com.example.outlet_3.bottom_fragments.home_f;
import com.example.outlet_3.bottom_fragments.journal_f;
import com.example.outlet_3.bottom_fragments.warehouse_f;

import org.aviran.cookiebar2.CookieBar;

import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class bottom_nav extends AppCompatActivity {

    SmoothBottomBar b ;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);
        setUpActionBar();

        iv = findViewById(R.id.menuBTN);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertadd = new AlertDialog.Builder(bottom_nav.this,R.style.CustomDialog);
                LayoutInflater factory = LayoutInflater.from(bottom_nav.this);
                final View view = factory.inflate(R.layout.profile_dialog, null);
                alertadd.setView(view);
                alertadd.setNegativeButton(R.string.logout, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dlg, int sumthin) {
                      dlg.cancel();
                    }
                });

                alertadd.show();
            }
        });

        CookieBar.build(bottom_nav.this)
                .setTitle(R.string.app_name)
                .setTitleColor(R.color.black)
                .setBackgroundColor(R.color.primary)
                .setIcon(R.drawable.ic_android_black_24dp)
                .setMessage(R.string.message)
                .setDuration(10000)
                .show();

        CookieBar.build(bottom_nav.this)
                .setTitle("TITLE")
                .setMessage("MESSAGE")
                .setBackgroundColor(R.color.primary)
                .setCookiePosition(CookieBar.BOTTOM)
                .setEnableAutoDismiss(false)
                .show();

        b= findViewById(R.id.bottombar);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        ft.add(R.id.container,new home_f());
        ft.commit();

        b.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public boolean onItemSelect(int i) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                switch(i)
                {
                    case 0 :
                             ft.add(R.id.container,new home_f());
                             ft.commit();
                             ft.add(R.id.container,new home_f());
                             break;
                    case 1 : ft.add(R.id.container,new journal_f());
                             ft.commit();
                             ft.replace(R.id.container,new journal_f());
                             break;

                    case 2 :
                             ft.add(R.id.container,new browse_f());
                             ft.commit();
                             ft.replace(R.id.container,new browse_f());
                             break;

                    case 3 :
                             ft.add(R.id.container,new warehouse_f());
                             ft.commit();
                             ft.replace(R.id.container,new warehouse_f());
                             break;
                }
                return true;
            }
        });


    }
    private void setUpActionBar() {
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        // the custom action bar layout file
        getSupportActionBar().setCustomView(R.layout.custom_action_bar_layout);
        // the color of the action bar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.primary)));
        // make action bar support options menu
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        // to access any view in the action bar
        View view = getSupportActionBar().getCustomView();

        ImageView menu_BTN= (ImageView)view.findViewById(R.id.menuBTN);
        menu_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(bottom_nav.this, "Navigation btn", Toast.LENGTH_SHORT).show();
            }
        });
    }

}