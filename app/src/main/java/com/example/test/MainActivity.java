package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    str xls=new str();
    String flag="";
    String err="";
    int sflag=0;
    private TextView t2,t5,t6,t8,t11,t12,zat3,zat6,yst4,yst5,yst6;
    private ImageView i2;
    private TextInputEditText tiet1;
    private Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sp = getSharedPreferences("info", MODE_PRIVATE);
        setContentView(R.layout.activity_main);
         t2=(TextView) findViewById(R.id.textView2);
         t5=(TextView) findViewById(R.id.textView5);
         t6=(TextView) findViewById(R.id.textView6);
         t8=(TextView) findViewById(R.id.textView8);
         t11=(TextView) findViewById(R.id.textView11);
         t12=(TextView) findViewById(R.id.textView12);
         i2=(ImageView) findViewById(R.id.imageView2);
         zat3=(TextView) findViewById(R.id.zat3);
        zat6=(TextView) findViewById(R.id.zat6);
        yst4=(TextView) findViewById(R.id.yst4);
        yst5=(TextView) findViewById(R.id.yst5);
        yst6=(TextView) findViewById(R.id.yst6);
        tiet1=(TextInputEditText) findViewById(R.id.bzsrl);
        bt1=(Button) findViewById(R.id.button);
    }
    public void check(){
        xls.getDay();
        xls.getMouth();
        xls.getGh();
        xls.getFth();



    }
    private boolean copyStr(String copyStr) {
        try {
            //获取剪贴板管理器
            ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            // 创建普通字符型ClipData
            ClipData mClipData = ClipData.newPlainText("Label", copyStr);
            // 将ClipData内容放到系统剪贴板里。
            cm.setPrimaryClip(mClipData);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    //将内容放入剪切板，成功回1，失败回0
    public void ptdialog(){
        AlertDialog.Builder normalDialog = new AlertDialog.Builder(MainActivity.this);
        normalDialog.setIcon(R.mipmap.ic_launcher);
        String a=xls.getstr(xls);
        normalDialog.setTitle("你即将复制以下字段");
        normalDialog.setMessage(a);
        normalDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(copyStr(a))
                            Toast.makeText(MainActivity.this,
                                    "复制成功", Toast.LENGTH_SHORT).show();
                    }
                });
        normalDialog.setNegativeButton("关闭",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(!copyStr(a))
                            Toast.makeText(MainActivity.this,
                                    "复制失败", Toast.LENGTH_SHORT).show();
                    }
                });
        // 显示
        normalDialog.show();

    }

    private void showToastShort(String a) {
        Toast.makeText(MainActivity.this,a+"213123",Toast.LENGTH_SHORT);
    }
    public void fixedit(EditText e,int sflag){
        switch (sflag)
        { case 0:break;
            case 1:
                   e.setText(xls.getDch());
                   e.selectAll();
                break;
            case 2:
                e.setText(xls.getGh());e.selectAll();
                break;
            case 3:
                e.setText(xls.getFth());e.selectAll();
                break;
            case 4:
                    e.setText(Integer.toString(xls.getGb()));e.selectAll();
                break;
            case 5:
                    e.setText(xls.getKs());e.selectAll();
                break;
            case 6:
                    e.setText(xls.getIng());e.selectAll();
                break;
            case 7:
                    e.setText(xls.getEnd());e.selectAll();
                break;
        }
    }
    public void dchlog(){
        final EditText editText =new EditText(this);

        AlertDialog.Builder inputDialog =new AlertDialog.Builder(this);
        inputDialog.setTitle("输入"+flag+err).setView(editText);
        fixedit(editText,sflag);
        inputDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @SuppressLint("ResourceAsColor")
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String data=editText.getText().toString();
                        if (!data.equals("")){
                        if (data.length()<30){
                            err="";
                        switch (sflag)
                        { case 0:break;
                            case 1: xls.setDch(data);
                                    t5.setText(data);

                                    t5.setTextColor(R.color.grey);
                                    t6.setText("");
                                    break;
                            case 2: xls.setGh(data);

                                    t8.setText(data);
                                    t8.setTextColor(R.color.grey);
                                    break;
                            case 3: xls.setFth(data);
                                    t11.setText(data);
                                    t11.setTextColor(R.color.grey);
                                    t12.setText("");
                                    break;
                            case 4:
                                try {
                                    xls.setGb(Integer.parseInt(data));
                                    err="";
                                    zat6.setText(data + "元");
                                    zat6.setTextColor(R.color.grey);
                                }catch (Exception e){
                                    err="       请输入数字";
                                    Toast.makeText(MainActivity.this,"请输入数字",Toast.LENGTH_SHORT);
                                    dchlog();
                                }
                                break;
                            case 5: xls.setKs(data);
                                yst4.setText(data);
                                yst4.setTextColor(R.color.grey);

                                break;
                            case 6: xls.setIng(data);
                                yst5.setText(data);
                                yst5.setTextColor(R.color.grey);

                                break;
                            case 7: xls.setEnd(data);
                                yst6.setText(data);
                                yst6.setTextColor(R.color.grey);

                                break;

                        }
                        }
                        else
                        {
                            err="      数据过长";
                            dchlog();
                            }

                        }
                        else{}


                       }
                }).show();



    }

    public void datelog(){
    Calendar ca = Calendar.getInstance(Locale.CHINA);
    final int[] mYear = {ca.get(Calendar.YEAR)};
    final int[] mMonth = {ca.get(Calendar.MONTH)};
    final int[] mDay = {ca.get(Calendar.DAY_OF_MONTH)};
    DatePickerDialog datePickerDialog = new DatePickerDialog(this,
            new DatePickerDialog.OnDateSetListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    mYear[0] = year;
                    mMonth[0] = month;
                    mDay[0] = dayOfMonth;
                    xls.setMouth(month+1);
                    xls.setDay(dayOfMonth);
                    final String data =  xls.getMouth() + "月" + xls.getDay() + "日 ";
                    Toast.makeText(MainActivity.this,data, Toast.LENGTH_SHORT).show();
                    if (xls.getMouth()!=0||xls.getDay()!=0)
                    {t2.setText(data);
                     t2.setTextColor(R.color.grey);
                    }
                }
            },
            mYear[0], mMonth[0], mDay[0]);


    datePickerDialog.show();

}

    @SuppressLint("ResourceAsColor")
    public void cholog(){
        final String[] items = { "有","无" };
         int[] yourChoice = {0};
        AlertDialog.Builder singleChoiceDialog =
                new AlertDialog.Builder(MainActivity.this);
        singleChoiceDialog.setTitle("有无打单费(默认为10元)");
        // 第二个参数是默认选项，此处设置为0
        singleChoiceDialog.setSingleChoiceItems(items, 0,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        yourChoice[0] = which;

                    }
                });
        singleChoiceDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (yourChoice[0]==0)
                        { xls.setDd(10);
                            zat3.setText("有");
                            zat3.setTextColor(R.color.grey);
                        }
                        else
                        {   xls.setDd(0);
                            zat3.setText("无");
                            zat3.setTextColor(R.color.grey);
                        }

                    }
                });
        singleChoiceDialog.show();




    }
    public void onClick(View a) {

        switch(a.getId()) {

            case R.id.k1:

                datelog();

                break;
            case R.id.k2:
                flag="订仓号";
                sflag=1;

                dchlog();
                break;

            case R.id.k3:
                flag="柜号";
                sflag=2;
                dchlog();
                break;

            case R.id.k4:
                flag="封条号";
                sflag=3;
                dchlog();
                break;

            case R.id.k6:
                cholog();
                break;

            case R.id.k7:
                flag="过磅费";
                sflag=4;
                dchlog();
                break;
            case R.id.yst4:
                flag="提柜地";
                sflag=5;
                dchlog();
                break;
            case R.id.yst5:
                flag="装货地";
                sflag=6;
                dchlog();
                break;
            case R.id.yst6:
                flag="还柜地";
                sflag=7;
                dchlog();
                break;

            case R.id.button:
                xls.setBz(tiet1.getText().toString());
               ptdialog();

                break;
        }
    }
    public void typeSizeClick(View view){
        PopupMenu popupMenu = new PopupMenu(this,view);
        //创建弹出式菜单
        popupMenu.inflate(R.menu.menu);
        //将自制的弹出布局绑定菜单
        popupMenu.setOnMenuItemClickListener(this);
        //弹出式菜单的单击事件
        popupMenu.show();
        //显示菜单
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.s:
                flag="提柜点";
                sflag=5;
                dchlog();

                break;
            case R.id.m:
                flag="途径地";
                sflag=6;
                dchlog();

                break;
            case R.id.l:
                flag="还柜点";
                sflag=7;
                dchlog();

                break;
        }
        return false;
    }
}
