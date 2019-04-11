package camdich.com.dumv.game2048;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class OVuongAdapter extends ArrayAdapter<Integer> {
    private Context ct;
    private ArrayList<Integer> arr;
    public OVuongAdapter(@NonNull Context context, @LayoutRes int resource,@NonNull List<Integer> objects) {
        super(context, resource, objects);
        this.ct=context;
        this.arr= new ArrayList<>(objects);
    }

    @Override
    public void notifyDataSetChanged() {
        arr= Data.getInstance().getArr();
        super.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater=(LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.item_o_dat,null);
        }
        if(arr.size()>0){
            OVuong txvODat=(OVuong)convertView.findViewById(R.id.txvODat);
            txvODat.setTextt(arr.get(position));
        }
        return convertView;
    }
}
