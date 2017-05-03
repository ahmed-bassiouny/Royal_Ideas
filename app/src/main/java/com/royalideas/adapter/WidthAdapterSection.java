package com.royalideas.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.royalideas.R;

import java.util.ArrayList;

/**
 * Created by ahmed on 03/05/17.
 */

public class WidthAdapterSection extends ArrayAdapter<ProductsCategories> {
    Context context;
    ArrayList<ProductsCategories> arr;
    int count=0;
    public WidthAdapterSection(Context context, ArrayList<ProductsCategories> arr) {
        super(context, R.layout.width,arr);
        this.context=context;
        this.arr=arr;
    }

    @Override
    public View getView (int position, View convertview, ViewGroup parent){
        ViewCach viewcach;
        TextView nameproduct;
        View rowview=convertview;
        if(rowview==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowview = inflater.inflate(R.layout.width, parent, false);
            count++;
            viewcach=new ViewCach(rowview);
            rowview.setTag(viewcach);

        }else{
            viewcach=(ViewCach)rowview.getTag();
        }

        nameproduct =viewcach.getmytxt();
        nameproduct.setText(arr.get(position).name);
        Log.i("*** tag *** ", "*** tag *** "+arr.get(position).name);
        return rowview;
    }
    public class ViewCach {

        private TextView nameproduct;
        private View myview;
        public ViewCach(View myview){
            this.myview=myview;
        }
        public View getview(){
            return myview;
        }
        public TextView getmytxt(){
            if(nameproduct ==null)
                nameproduct=(TextView)myview.findViewById(R.id.nameproduct);
            return  nameproduct;
        }
    }
}
