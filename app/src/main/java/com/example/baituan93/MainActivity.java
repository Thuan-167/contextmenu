package com.example.baituan93;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView =findViewById(R.id.lv);
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,mang);
        listView.setAdapter(arrayAdapter);
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater=getMenuInflater();

        inflater.inflate(R.menu.context_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    String[] mang= new String[]{"So1","So2","So3","So4","So5","So6"};
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = adapterContextMenuInfo.position;
        if(item.getItemId()==R.id.them)
        {
            Toast.makeText(MainActivity.this,"Thêm"+mang[index],Toast.LENGTH_LONG).show();
        }else if(item.getItemId()==R.id.sua)
        {
            Toast.makeText(MainActivity.this,"Sửa"+mang[index],Toast.LENGTH_LONG).show();
        }else if(item.getItemId()==R.id.xoa)
        {
            Toast.makeText(MainActivity.this,"Xóa"+mang[index],Toast.LENGTH_LONG).show();
        }
        return super.onContextItemSelected(item);
    }
}