package com.example.lastoneforall;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class keyboardlayouttwo extends Fragment implements View.OnClickListener,View.OnLongClickListener {
    private InputConnection inputConnection;
    private Context context;
    EditText editext;
    private keyboardlayouttwo.Onclicklistnerforkeyboardlayouttwo listerner;
    private Button ho,i,io,jho,jo,k,kho,io1,mo,o,oi,onusshar,ooo,ou,po,r,so,u,uo,space1,entertwo,moretwo,deletetwo;
    private OnlongpressListenerforlayouttwo longpresslistenerfortwo;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.keyboardtwo, container, false);
        entertwo=v.findViewById(R.id.entertwo);
        moretwo=v.findViewById(R.id.moretwo);

        deletetwo=v.findViewById(R.id.deletetwo);
        ho=v.findViewById(R.id.ho);
        i=v.findViewById(R.id.i);
        io=v.findViewById(R.id.io);
        jho=v.findViewById(R.id.jho);
        jo=v.findViewById(R.id.jo);
        k=v.findViewById(R.id.k);
        kho=v.findViewById(R.id.kho);
        io1=v.findViewById(R.id.io1);
        mo=v.findViewById(R.id.mo);
        o=v.findViewById(R.id.o);
        oi=v.findViewById(R.id.oi);
        onusshar=v.findViewById(R.id.onusshar);
        ooo=v.findViewById(R.id.ooo);
        ou=v.findViewById(R.id.ou);
        po=v.findViewById(R.id.po);
        r=v.findViewById(R.id.r);
        so=v.findViewById(R.id.so);
        u=v.findViewById(R.id.u);
        uo=v.findViewById(R.id.uo);
        space1=v.findViewById(R.id.spacetwo);
       ho.setOnClickListener(this);
       i.setOnClickListener(this);
       io.setOnClickListener(this);
       jho.setOnClickListener(this);
       jo.setOnClickListener(this);
       k.setOnClickListener(this);
       kho.setOnClickListener(this);
       io.setOnClickListener(this);
       mo.setOnClickListener(this);
       o.setOnClickListener(this);
       oi.setOnClickListener(this);
       onusshar.setOnClickListener(this);
       ooo.setOnClickListener(this);
       ou.setOnClickListener(this);
       po.setOnClickListener(this);
       r.setOnClickListener(this);
       so.setOnClickListener(this);
       u.setOnClickListener(this);
       uo.setOnClickListener(this);
       io1.setOnClickListener(this);
       space1.setOnClickListener(this);
       i.setOnLongClickListener(this);
       moretwo.setOnClickListener(this);
       entertwo.setOnClickListener(this);
       deletetwo.setOnClickListener(this);

        return v;
    }
    void setInterfaceforgragemt(keyboardlayouttwo.Onclicklistnerforkeyboardlayouttwo listerner)
    {
        this.listerner=listerner;

    }
    void setInterfaceforLongpress(OnlongpressListenerforlayouttwo onlogpresslistener)
    {
        longpresslistenerfortwo=onlogpresslistener;
    }

    @Override
    public void onClick(View v) {
        listerner.onClickListnerforkeyboardlayouttwo(v);
    }

    @Override
    public boolean onLongClick(View v) {
        longpresslistenerfortwo.onlongpressListenerforlayoutwo(v);
        return true;
    }

    interface Onclicklistnerforkeyboardlayouttwo{
        void onClickListnerforkeyboardlayouttwo(View v);

    }
    interface OnlongpressListenerforlayouttwo{
        void onlongpressListenerforlayoutwo(View v);

    }
}
