package camdich.com.dumv.game2048;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

public class OVuong extends TextView {
    public OVuong(Context context) {
        super(context);
    }

    public OVuong(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public OVuong(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int i= getMeasuredWidth();
        setMeasuredDimension(i,i);
    }


public void setTextt(int a){
    String s=""+a;
    if(a<8){
        setTextColor(Color.BLACK);
    }else {
        setTextColor(Color.WHITE);
    }
    if(s.length()==4){
        setTextSize(30);
    }else if(s.length()<4){
        setTextSize(40);
    }else {
        setTextSize(20);
    }
    GradientDrawable bgShape = (GradientDrawable)this.getBackground();
    bgShape.setColor(Data.getInstance().setText(a));

    setBackground(bgShape);
    if(a==0){
        setText(" ");
    }else {
        setText(""+a);
    }

}

}
