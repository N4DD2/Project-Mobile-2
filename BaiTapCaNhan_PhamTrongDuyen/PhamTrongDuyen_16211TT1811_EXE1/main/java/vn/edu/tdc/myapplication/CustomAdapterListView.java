package vn.edu.tdc.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class CustomAdapterListView extends ArrayAdapter<DataModel> {
    private Context context;
    ArrayList<DataModel> dataset;
    int resource;

    public static class MyViewHolder {

        TextView textViewName;
        TextView textViewVersion;
        ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            this.textViewVersion = (TextView) itemView.findViewById(R.id.textViewVersion);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }


    public CustomAdapterListView(Context context, int resource, ArrayList<DataModel> objects) {
        super(context, resource, objects);
        this.context = context;
        this.dataset = objects;
    }

    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        MyViewHolder holder = null;

        final DataModel rowItem = this.dataset.get(position);
        LayoutInflater mInflater = ((Activity)context).getLayoutInflater();


        if (convertView == null)
        {
            convertView = mInflater.inflate(R.layout.listview_layout,null);
            holder = new MyViewHolder(convertView);
            convertView.setTag(holder);


        }
        else
        {
            holder = (MyViewHolder) convertView.getTag();
        }


        holder.textViewName.setText(rowItem.getName());
        holder.textViewVersion.setText(rowItem.getVersion());
        holder.imageViewIcon.setImageResource(rowItem.getImage());


        return  convertView;
    }
}
