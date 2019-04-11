package camdich.com.dumv.game2048;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class Custom_Gridview_banco extends ArrayAdapter<Integer> {
    Context context;
    int resource;
    private TextView tvSpin;
    private Spinner spingiatien;
    Integer[] objects;
    Integer[] giatien = {0,100,200,300,400,500};
    ArrayAdapter<Integer> adapter;
    public Custom_Gridview_banco(Context context, int resource, Integer[] objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
        adapter = new ArrayAdapter<Integer>(context,android.R.layout.simple_spinner_item,giatien);

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = View.inflate(context,resource,null);
        ImageView imgbanco = (ImageView) view.findViewById(R.id.imgbanco);
        final TextView tvSpin = (TextView) view.findViewById(R.id.tvSpin);
        final Spinner spingiatien = (Spinner) view.findViewById(R.id.spingiatien);
        imgbanco.setImageResource(objects[position]);
        spingiatien.setAdapter(adapter);
        spingiatien.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int positionspin, long id) {

                BauCuaActivity.gtdatcuoc[position] = giatien[positionspin];
                tvSpin.setText(spingiatien.getSelectedItem().toString());
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });

        return view;
    }

}
