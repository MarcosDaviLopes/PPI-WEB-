package br.com.ifsc.list;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AplicativosAdapter extends ArrayAdapter {

    Context context;
    List<ApplicationInfo> apps;
    int resoucerlayout;

    public AplicativosAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context=context;
        this.apps=objects;
        this.resoucerlayout=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(resoucerlayout, parent, false);

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView txtview = convertView.findViewById(R.id.txtview);

        ApplicationInfo app = apps.get(position);
        imageView.setImageDrawable(app.loadIcon(context.getPackageManager()));
        txtview.setText(app.loadLabel(context.getPackageManager()));

        return convertView;
    }

}
