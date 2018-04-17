package com.example.usuari.leercontactos;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarContactos();
    }
    public void cargarContactos(){
        ContentResolver resolver = this.getContentResolver();
        Cursor cursor = resolver.query(ContactsContract.Data.CONTENT_URI,null,ContactsContract.Data.MIMETYPE+"='"+ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE+"'",null,null);
        String[] nombres={ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER};
        int[] ids={android.R.id.text1,android.R.id.text2};
        SimpleCursorAdapter sc = new SimpleCursorAdapter(this,
                android.R.layout.two_line_list_item,
                cursor,
                nombres,
                ids,
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        ListView lvContacto = (ListView) this.findViewById(R.id.lvContactos);
        lvContacto.setAdapter(sc);
    }
}
