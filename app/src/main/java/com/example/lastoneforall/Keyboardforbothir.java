package com.example.lastoneforall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Keyboardforbothir extends AppCompatActivity implements keyboardlayoutone.Onclicklistnerforkeyboardlayoutone,keyboardlayouttwo.Onclicklistnerforkeyboardlayouttwo,
keyboardlayouttwo.OnlongpressListenerforlayouttwo,keyboardlayoutone.Onlongpresskeyboardone{

    private keyboardlayoutone keyboardone;
    private keyboardlayouttwo keyboardtwo;
    private InputConnection ic;
    private keyboardlayoutone thisforchanging;
    private EditText edittext;





    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard);
        edittext=findViewById(R.id.inputnibo);
        edittext.setRawInputType(InputType.TYPE_CLASS_TEXT);
        edittext.setTextIsSelectable(true);
        ic=edittext.onCreateInputConnection(new EditorInfo());

        FragmentManager fragmentManager=getSupportFragmentManager();
        keyboardone=new keyboardlayoutone();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.containerforload,keyboardone);
        fragmentTransaction.commit();

    }


    @Override
    public void onClickListnerforkeyboardlayoutone(View v) {
if(v.getId()==R.id.moreone)
{
    FragmentManager fragmentManager=getSupportFragmentManager();
    keyboardtwo=new keyboardlayouttwo();
    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
    fragmentTransaction.replace(R.id.containerforload,keyboardtwo);
    fragmentTransaction.commit();
}

        if(v.getId()==R.id.spaceone){
            ic.commitText(" ",1);
        }
        if(v.getId()==R.id.enterone){
            String a=edittext.getText().toString();
            Intent intent =new Intent(this,texttosignvideo.class);
            intent.putExtra("videofortext",a);
            edittext.setText("");
            startActivity(intent);

        }

        if(v.getId()==R.id.deleteone){
            CharSequence selectedText = ic.getSelectedText(0);

            if (TextUtils.isEmpty(selectedText)) {
                ic.deleteSurroundingText(1, 0);
            } else {
                ic.commitText("", 1);
            }
        }

        if(v.getId()==R.id.dho)
        {
          ic.commitText("ঢ",1);
        }
        if(v.getId()==R.id.doo)
        {
            ic.commitText("দ",1);
        }
        if(v.getId()==R.id.dhoo)
        {
            ic.commitText("ধ",1);

        }
        if(v.getId()==R.id.aa)
        {
            ic.commitText("এ",1);

        }
        if(v.getId()==R.id.a)
        {
            ic.commitText("আ",1);

        }
        if(v.getId()==R.id.ddo)
        {
            ic.commitText("ড",1);

        }
        if(v.getId()==R.id.ho)
        {
            ic.commitText("হ",1);

        }
        if(v.getId()==R.id.tho)
        {
            ic.commitText("ঠ",1);

        }
        if(v.getId()==R.id.thoo)
        {
            ic.commitText("থ",1);

        }
        if(v.getId()==R.id.too)
        {
            ic.commitText("ত",1);


        }
        if(v.getId()==R.id.to)
        {
            ic.commitText("ট",1);

        }
        if(v.getId()==R.id.bishorgo)
        {
            ic.commitText("ঃ",1);
           // Toast.makeText(this,"this is not available right now",Toast.LENGTH_SHORT).show();

        }
        if(v.getId()==R.id.bo)
        {
            ic.commitText("ব",1);

        }
        if(v.getId()==R.id.chho)
        {
            ic.commitText("ছ",1);

        }
        if(v.getId()==R.id.cho)
        {
            ic.commitText("চ",1);

        }
        if(v.getId()==R.id.fo)
        {
            ic.commitText("ফ",1);

        }

        if(v.getId()==R.id.chodro_bindu)
        {
            ic.commitText(" ঁ",1);

        }
        if(v.getId()==R.id.to)
        {
            ic.commitText("ট",1);

        }
        if(v.getId()==R.id.gho)
        {
            ic.commitText("ঘ",1);

        }

    }

    @Override
    public void onClickListnerforkeyboardlayouttwo(View v) {
        if(v.getId()==R.id.moretwo)
        {
            FragmentManager fragmentManager=getSupportFragmentManager();
            thisforchanging=new keyboardlayoutone();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.containerforload,thisforchanging);
            fragmentTransaction.commit();
        }


        if(v.getId()==R.id.spacetwo){
            ic.commitText(" ",1);
        }
        if(v.getId()==R.id.entertwo){
            String a=edittext.getText().toString();
            Intent intent =new Intent(this,texttosignvideo.class);
            intent.putExtra("videofortext",a);
            edittext.setText("");
            startActivity(intent);

        }

        if(v.getId()==R.id.deletetwo){
            CharSequence selectedText = ic.getSelectedText(0);

            if (TextUtils.isEmpty(selectedText)) {
                ic.deleteSurroundingText(1, 0);
            } else {
                ic.commitText("", 1);
            }
        }
        if(v.getId()==R.id.ho)
        {
            ic.commitText("হ",1);

        }
        if(v.getId()==R.id.i)
        {
            ic.commitText(" ই",1);

        } if(v.getId()==R.id.io)
        {
            ic.commitText("ঞ",1);

        }
        if(v.getId()==R.id.jho)
        {
            ic.commitText("ঝ",1);

        }
        if(v.getId()==R.id.jo)
        {
            ic.commitText("জ",1);

        }
        if(v.getId()==R.id.k)
        {
            ic.commitText("ক",1);

        }
        if(v.getId()==R.id.kho)
        {
            ic.commitText("খ",1);

        }
        if(v.getId()==R.id.io)
        {
            ic.commitText("ঞ",1);

        } if(v.getId()==R.id.mo)
        {
            ic.commitText("ম",1);

        } if(v.getId()==R.id.o)
        {
            ic.commitText("অ",1);

        } if(v.getId()==R.id.io1)
        {
            ic.commitText("ঞ",1);

        }
        if(v.getId()==R.id.oi)
        {
            ic.commitText("ঐ",1);

        } if(v.getId()==R.id.onusshar)
        {
            ic.commitText("ং",1);

        }
        if(v.getId()==R.id.ooo)
        {
            ic.commitText("ও",1);

        }
        if(v.getId()==R.id.ou)
        {
            ic.commitText("ঔ",1);

        }
        if(v.getId()==R.id.po)
        {
            ic.commitText("প",1);

        }
        if(v.getId()==R.id.r)
        {
            ic.commitText("র",1);

        }
        if(v.getId()==R.id.so)
        {
            ic.commitText("স",1);

        }
        if(v.getId()==R.id.u)
        {
            ic.commitText("উ",1);

        }
        if(v.getId()==R.id.gho)
        {
            ic.commitText("ঘ",1);

        }
        if(v.getId()==R.id.uo)
        {
            ic.commitText("ঙ",1);

        }




    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        if(fragment instanceof keyboardlayoutone)
        {
            keyboardlayoutone keyboard=(keyboardlayoutone) fragment;
            keyboard.setInterfaceforgragemt(this);
            keyboard.setInterfaceforlongpress(this);
        }
        if(fragment instanceof  keyboardlayouttwo)
        {
            keyboardlayouttwo forFragment=(keyboardlayouttwo) fragment;
            forFragment.setInterfaceforgragemt(this);
            forFragment.setInterfaceforLongpress(this);
        }

    }

    @Override
    public void onlongpresskeyboardone(View v) {
        if(v.getId()==R.id.a)
        {
            Button b;

            b=findViewById(R.id.a);
            //Toast.makeText(this,"aa",Toast.LENGTH_SHORT).show();
            PopupMenuCustomLayout popupMenu = new PopupMenuCustomLayout(
                    Keyboardforbothir.this, R.layout.popupfora,
                    new PopupMenuCustomLayout.PopupMenuCustomOnClickListener() {
                        @Override
                        public void onClick(int itemId) {
                            // log statement: "Clicked on: " + itemId
                            switch (itemId) {
                                case R.id.popupfor:
                                    ic.commitText("া",1);
                                    // log statement: "Item A was clicked!"
                                    break;
                            }
                        }
                    });
            popupMenu.show(b, Gravity.CENTER, 0, 0);
        }
        }


    @Override
    public void onlongpressListenerforlayoutwo(View v) {
        if(v.getId()==R.id.i)
        {
            Button b;

            b=findViewById(R.id.i);
            //Toast.makeText(this,"aa",Toast.LENGTH_SHORT).show();
            PopupMenuCustomLayout popupMenu = new PopupMenuCustomLayout(
                    Keyboardforbothir.this, R.layout.popupfori,
                    new PopupMenuCustomLayout.PopupMenuCustomOnClickListener() {
                        @Override
                        public void onClick(int itemId) {
                            // log statement: "Clicked on: " + itemId
                            switch (itemId) {
                                case R.id.icar:
                                    ic.commitText("ি",1);
                                    break;
                                case R.id.iicar:
                                    ic.commitText("ী",1);

                                    // log statement: "Item A was clicked!"
                                    break;
                            }
                        }
                    });

            popupMenu.show(b, Gravity.CENTER, 0, 0);
        }

    }
}
