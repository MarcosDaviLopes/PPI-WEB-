package br.com.ifsc.list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listview;

    PackageManager pm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listV);

        //Recurperar dados
        pm = getPackageManager();
        ArrayList<String> appNames= new ArrayList<>();
        List<ApplicationInfo> apps= pm.getInstalledApplications(PackageManager.GET_META_DATA);
        for (ApplicationInfo app:apps){
            appNames.add(app.loadLabel(pm).toString());
        }

        //Criar dor de Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,appNames
        );

        //Adaptador personalizado
            AplicativosAdapter adapter2 = new AplicativosAdapter(
               this,
               R.layout.item_view,apps
            );

        //setando adapter
        listview.setAdapter(adapter);
    }
}