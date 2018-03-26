package com.example.ashwingiri.calculator;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    TextView etRes;
    char c='\0';
    StringBuilder res=new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int rotation=getResources().getConfiguration().orientation;
        setContentView(R.layout.activity_main);
        if(rotation==Configuration.ORIENTATION_LANDSCAPE){
            Intent myIntent=new Intent(MainActivity.this,scientific_calculator.class);
            MainActivity.this.startActivity(myIntent);
        }
        etRes= findViewById(R.id.etRes);
        int perm = ContextCompat.checkSelfPermission(
                MainActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE);

        if (perm == PackageManager.PERMISSION_GRANTED) {
            readFile();
        } else {
            ActivityCompat.requestPermissions(
                    MainActivity.this,
                    new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},
                    45
            );
        }

        try{
            Button btAc=findViewById(R.id.btAc);
            Button btDel=findViewById(R.id.btDel);
            Button btmod=findViewById(R.id.btmod);
            Button btdiv=findViewById(R.id.btDiv);
            Button btSev=findViewById(R.id.btSev);
            Button btEig=findViewById(R.id.btEig);
            Button btNin=findViewById(R.id.btNine);
            Button btMul=findViewById(R.id.btMul);
            Button btFour = findViewById(R.id.btFour);
            Button btFive = findViewById(R.id.btFive);
            Button btSix = findViewById(R.id.btSix);
            Button btSub= findViewById(R.id.btSub);
            Button btOne= findViewById(R.id.btOne);
            Button btTwo = findViewById(R.id.btTwo);
            Button btThree= findViewById(R.id.btThree);
            Button btadd= findViewById(R.id.btAdd);
            Button btZero= findViewById(R.id.btZero);
            Button btEqual= findViewById(R.id.btEqual);
            Button btPoint= findViewById(R.id.btPoint);
            btAc.setOnClickListener(this);
            btSub.setOnClickListener(this);
            btDel.setOnClickListener(this);
            btmod.setOnClickListener(this);
            btdiv.setOnClickListener(this);
            btSev.setOnClickListener(this);
            btEig.setOnClickListener(this);
            btNin.setOnClickListener(this);
            btMul.setOnClickListener(this);
            btFour.setOnClickListener(this);
            btFive.setOnClickListener(this);
            btSix.setOnClickListener(this);
            btOne.setOnClickListener(this);
            btTwo.setOnClickListener(this);
            btThree.setOnClickListener(this);
            btadd.setOnClickListener(this);
            btZero.setOnClickListener(this);
            btEqual.setOnClickListener(this);
            btPoint.setOnClickListener(this);
        }catch(Exception e){
            etRes= findViewById(R.id.etRes);
            etRes.setText("Something Invalid!");
        }
    }


    private void readFile() {

        try {
            File sdCard = Environment.getExternalStorageDirectory();
            File Calc = new File(sdCard, "Calc.txt");
            FileInputStream finStream = new FileInputStream(Calc);
            BufferedReader br = new BufferedReader(new InputStreamReader(finStream));
            StringBuilder sb = new StringBuilder("");
            String buf = br.readLine();
            while (buf != null) {
                sb.append(buf);
                buf = br.readLine();
            }
            res=new StringBuilder();
            res.append(sb);
            etRes.setText(sb);
        } catch (IOException ioe) {
        }
    }

    @Override
    public void onClick(View view) {
        try{
            switch(view.getId()) {
                case R.id.btAc:
                    res = new StringBuilder();
                    etRes.setText(res);
                    break;

                case R.id.btDel:
                    if(res.length()>0)
                    res.deleteCharAt(res.length() - 1);
                    etRes.setText(res);
                    break;

                case R.id.btmod:
                    res.append("%");
                    etRes.setText(res);
                    break;

                case R.id.btDiv:
                    res.append("/");
                    etRes.setText(res);
                    break;

                case R.id.btSev:
                    res.append("7");
                    etRes.setText(res);
                    break;

                case R.id.btEig:
                    res.append("8");
                    etRes.setText(res);
                    break;

                case R.id.btNine:
                    res.append("9");
                    etRes.setText(res);
                    break;

                case R.id.btMul:
                    res.append("*");
                    etRes.setText(res);
                    break;

                case R.id.btFour:
                    res.append("4");
                    etRes.setText(res);
                    break;

                case R.id.btFive:
                    res.append("5");
                    etRes.setText(res);
                    break;

                case R.id.btSix:
                    res.append("6");
                    etRes.setText(res);
                    break;

                case R.id.btSub:
                    res.append("-");
                    etRes.setText(res);
                    break;

                case R.id.btOne:
                    res.append("1");
                    etRes.setText(res);
                    break;

                case R.id.btTwo:
                    res.append("2");
                    etRes.setText(res);
                    break;

                case R.id.btThree:
                    res.append("3");
                    res.append("3");
                    etRes.setText(res);
                    break;

                case R.id.btAdd:
                    res.append("+");
                    etRes.setText(res);
                    break;

                case R.id.btZero:
                    res.append("0");
                    etRes.setText(res);
                    break;

                case R.id.btEqual:
                    String res1 = result(res);
                    etRes.setText(res1);
                    res = new StringBuilder();
                    res.append(res1);
                    break;

                case R.id.btPoint:
                    res.append(".");
                    etRes.setText(res);
                    break;
            }
        }catch(Exception e){
            Toast.makeText(MainActivity.this,"Something Invalid!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        int perm = ContextCompat.checkSelfPermission(
                MainActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (perm == PackageManager.PERMISSION_GRANTED) {
            writeFile();
        } else {
            ActivityCompat.requestPermissions(
                    MainActivity.this,
                    new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    44
            );
        }

    }

    private void writeFile() {
        try {
            File sdCard = Environment.getExternalStorageDirectory();
            File Calc = new File(sdCard, "Calc.txt");
            if(Calc.exists()){
                Calc.delete();
            }
            FileOutputStream foutStream = new FileOutputStream(Calc, true);
            foutStream.write(res.toString().getBytes());
            Log.d("MainActivity", "String added");
        }
        catch (IOException e) {
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {

        if (requestCode == 44) { //write request
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                writeFile();
            } else {
                Toast.makeText(this, "Writing file required this permission", Toast.LENGTH_SHORT).show();

            }
        }

        if (requestCode == 45) { //read request
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                readFile();
            } else {
                Toast.makeText(this, "Reading file required this permission", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private String result(StringBuilder s) {
        try{
            if(s.charAt(0)=='+'||s.charAt(0)=='-'||s.charAt(0)=='*'||s.charAt(0)=='/'||s.charAt(0)=='%'){
                c=s.charAt(0);
                s.deleteCharAt(0);
            }
            Queue<String> val = new LinkedList<>();
            Queue<String> op = new LinkedList<>();
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '+') {
                    val.add(temp + "");
                    temp = new StringBuilder();
                    op.add("+");
                } else if (s.charAt(i) == '-') {
                    val.add(temp + "");
                    temp = new StringBuilder();
                    op.add("-");
                } else if (s.charAt(i) == '*') {
                    val.add(temp + "");
                    temp = new StringBuilder();
                    op.add("*");
                } else if (s.charAt(i) == '/') {
                    val.add(temp + "");
                    temp = new StringBuilder();
                    op.add("/");
                } else if (s.charAt(i) == '%') {
                    val.add(temp + "");
                    temp = new StringBuilder();
                    op.add("%");
                } else {
                    temp.append(s.charAt(i));
                    if (i == s.length() - 1) {
                        val.add(temp + "");
                    }
                }
            }
            if (s.charAt(s.length()-1) == '.' ||s.charAt(s.length()-1) == '+' || s.charAt(s.length()-1) == '-' || s.charAt(s.length()-1) == '*' || s.charAt(s.length()-1) == '/' || s.charAt(s.length()-1) == '%'){
                Toast.makeText(MainActivity.this, "Enter Correct data! ", Toast.LENGTH_LONG).show();
                return 0+"";
            }

            double result=0;
            result = Float.parseFloat(val.remove());
            if(c=='-') {
                result = result - 2 * result;
            }else if(c=='+'||c=='*'||c=='/'||c=='%'){
                Toast.makeText(MainActivity.this,"Enter Correct data! ",Toast.LENGTH_LONG).show();
                return "";
            }
            c='\0';

            while (!op.isEmpty() && !val.isEmpty()) {
                String c = op.remove();
                double a = Float.parseFloat(val.remove());
                if (c.equals("+")) {
                    result = result + a;
                } else if (c.equals("-")) {
                    result = result - a;
                } else if (c.equals("*")) {
                    result = result * a;
                } else if (c.equals("/")) {
                    result = result / a;
                } else {
                    result = result % a;
                }
            }
            return result + "";
        }catch(Exception e){
            Toast.makeText(MainActivity.this,"Something Invalid",Toast.LENGTH_SHORT).show();
        }
        return "";
    }

    @Override
    public void onBackPressed() {

    }
}
