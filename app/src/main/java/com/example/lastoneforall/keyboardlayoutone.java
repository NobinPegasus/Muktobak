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

public class keyboardlayoutone extends Fragment implements View.OnClickListener,View.OnLongClickListener {


    private InputConnection inputConnection;
    private Context context;
    EditText editext;
    private Onclicklistnerforkeyboardlayoutone listerner;
    private Onlongpresskeyboardone lonpressListener;
    private Button dho,doo,dhoo,aa,a,ddo,no,tho,thoo,too,to,bishorgo,b,chho,cho,fo,go,space,chondrobindu,gho,enterone,moreone,deleteone;












    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.keyboardone, container, false);
        enterone=v.findViewById(R.id.enterone);
        moreone=v.findViewById(R.id.moreone);
        deleteone=v.findViewById(R.id.deleteone);
        dho=v.findViewById(R.id.dho);
        doo=v.findViewById(R.id.doo);
        dhoo=v.findViewById(R.id.dhoo);
        aa=v.findViewById(R.id.aa);
        a=v.findViewById(R.id.a);
        ddo=v.findViewById(R.id.ddo);
        no=v.findViewById(R.id.no);
        tho=v.findViewById(R.id.tho);
        thoo=v.findViewById(R.id.thoo);
        too=v.findViewById(R.id.too);
        to=v.findViewById(R.id.to);
        bishorgo=v.findViewById(R.id.bishorgo);
        b=v.findViewById(R.id.bo);
        chho=v.findViewById(R.id.chho);
        cho=v.findViewById(R.id.cho);
        fo=v.findViewById(R.id.fo);
        go=v.findViewById(R.id.go);
        space=v.findViewById(R.id.spaceone);
        chondrobindu=v.findViewById(R.id.chodro_bindu);
        gho=v.findViewById(R.id.gho);
        chondrobindu.setOnClickListener(this);
        space.setOnClickListener(this);
        go.setOnClickListener(this);
        fo.setOnClickListener(this);
       cho .setOnClickListener(this);
        chho.setOnClickListener(this);
        b.setOnClickListener(this);
        bishorgo.setOnClickListener(this);
        to.setOnClickListener(this);
        too.setOnClickListener(this);
        tho.setOnClickListener(this);
        no.setOnClickListener(this);
        ddo.setOnClickListener(this);
        a.setOnClickListener(this);
        aa.setOnClickListener(this);
        dhoo.setOnClickListener(this);
        doo.setOnClickListener(this);
        dho.setOnClickListener(this);
         thoo.setOnClickListener(this);
         a.setOnLongClickListener(this);
         enterone.setOnClickListener(this);
         moreone.setOnClickListener(this);
         deleteone.setOnClickListener(this);






        return v;
    }
    void setInterfaceforgragemt(Onclicklistnerforkeyboardlayoutone listerner)
    {
        this.listerner=listerner;

    }
    void setInterfaceforlongpress(Onlongpresskeyboardone longpresslistener)
    {
        lonpressListener=longpresslistener;
    }

    @Override
    public void onClick(View v) {
        listerner.onClickListnerforkeyboardlayoutone(v);
    }

    @Override
    public boolean onLongClick(View v) {
        lonpressListener.onlongpresskeyboardone(v);
        return true;
    }

    interface Onclicklistnerforkeyboardlayoutone{
        void onClickListnerforkeyboardlayoutone(View v);

    }
    interface Onlongpresskeyboardone{
        void onlongpresskeyboardone(View v);

    }



}
