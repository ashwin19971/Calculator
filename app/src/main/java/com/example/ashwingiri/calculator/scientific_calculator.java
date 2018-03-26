package com.example.ashwingiri.calculator;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import static java.lang.Math.exp;
import static java.lang.Math.log;
import static java.lang.Math.log10;

public class scientific_calculator extends AppCompatActivity implements View.OnClickListener {

    Button btXsq,btX3,bt2x,btAc,btDel,btMod,btDiv;

    Button btEx,bt10x,bt1x,btSev,btEight,btNine,btMul;

    Button btln,btlog,btxF,btFour,btFive,btSix,btSub;
    StringBuilder res=new StringBuilder("0");
    Button btSqrt,btSinh,btCosh,btOne,btTwo,btThree,btAdd;

    Button btsin,btcos,btTan,btZero,btDecimal,btEqual;

    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int rotation=getResources().getConfiguration().orientation;
        setContentView(R.layout.activity_scientific_calculator);

        if(rotation==Configuration.ORIENTATION_PORTRAIT){
            Intent myIntent=new Intent(scientific_calculator.this,MainActivity.class);
            scientific_calculator.this.startActivity(myIntent);
        }

        readFile();

        btXsq=findViewById(R.id.btXsq);
        btX3=findViewById(R.id.btX3);
        bt2x=findViewById(R.id.bt2x);
        btAc=findViewById(R.id.btAc);
        btDel=findViewById(R.id.btDel);
        btMod=findViewById(R.id.btMod);
        btDiv=findViewById(R.id.btDiv);

        btEx=findViewById(R.id.btEx);
        bt10x=findViewById(R.id.bt10x);
        bt1x=findViewById(R.id.bt1x);
        btSev=findViewById(R.id.btSev);
        btEight=findViewById(R.id.btEight);
        btNine=findViewById(R.id.btNine);
        btMul=findViewById(R.id.btMul);

        btln=findViewById(R.id.btln);
        btlog=findViewById(R.id.btlog);
        btxF=findViewById(R.id.btxF);
        btFour=findViewById(R.id.btFour);
        btFive=findViewById(R.id.btFive);
        btSix=findViewById(R.id.btSix);
        btSub=findViewById(R.id.btSub);

        btSqrt=findViewById(R.id.btSqrt);
        btSinh=findViewById(R.id.btSinh);
        btCosh=findViewById(R.id.btCosh);
        btOne=findViewById(R.id.btOne);
        btTwo=findViewById(R.id.btTwo);
        btThree=findViewById(R.id.btThree);
        btAdd=findViewById(R.id.btAdd);

        btsin=findViewById(R.id.btsin);
        btcos=findViewById(R.id.btCos);
        btTan=findViewById(R.id.btTan);
        btZero=findViewById(R.id.btZero);
        btDecimal=findViewById(R.id.btDecimal);
        btEqual=findViewById(R.id.btEqual);

        tvResult=findViewById(R.id.tvResult);

        btXsq.setOnClickListener(this);
        btX3.setOnClickListener(this);
        bt2x.setOnClickListener(this);
        btAc.setOnClickListener(this);
        btDel.setOnClickListener(this);
        btMod.setOnClickListener(this);
        btDiv.setOnClickListener(this);



        btEx.setOnClickListener(this);
        bt10x.setOnClickListener(this);
        bt1x.setOnClickListener(this);
        btSev.setOnClickListener(this);
        btEight.setOnClickListener(this);
        btNine.setOnClickListener(this);
        btMul.setOnClickListener(this);



        btln.setOnClickListener(this);
        btlog.setOnClickListener(this);
        btxF.setOnClickListener(this);
        btFour.setOnClickListener(this);
        btFive.setOnClickListener(this);
        btSix.setOnClickListener(this);
        btSub.setOnClickListener(this);


        btSqrt.setOnClickListener(this);
        btSinh.setOnClickListener(this);
        btCosh.setOnClickListener(this);
        btOne.setOnClickListener(this);
        btTwo.setOnClickListener(this);
        btThree.setOnClickListener(this);
        btAdd.setOnClickListener(this);



        btsin.setOnClickListener(this);
        btcos.setOnClickListener(this);
        btTan.setOnClickListener(this);
        btZero.setOnClickListener(this);
        btDecimal.setOnClickListener(this);
        btEqual.setOnClickListener(this);
        tvResult.setText(res);
    }


    double temp=0;
    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btXsq:
                temp=Result(res);
                res=new StringBuilder(Math.pow(temp,2)+"");
                tvResult.setText(res);
                break;

            case R.id.btX3:
                temp=Result(res);
                res=new StringBuilder(Math.pow(temp,3)+"");
                tvResult.setText(res);
                break;

            case R.id.bt2x:
                temp=Result(res);
                res=new StringBuilder(Math.pow(2,temp)+"");
                tvResult.setText(res);
                break;

            case R.id.btAc:
                res=new StringBuilder("0");
                tvResult.setText(res);
                break;

            case R.id.btDel:
                if(res.length()>0)
                    res.deleteCharAt(res.length() - 1);
                else
                    Toast.makeText(scientific_calculator.this, "Enter Something!", Toast.LENGTH_SHORT).show();
                tvResult.setText(res);
                break;

            case R.id.btMod:
                res.append("%");
                tvResult.setText(res);
                break;

            case R.id.btDiv:
                res.append("/");
                tvResult.setText(res);
                break;


            case R.id.btEx:
                temp=Result(res);
                res=new StringBuilder(exp(temp)+"");
                tvResult.setText(res);
                break;

            case R.id.bt10x:
                temp=Result(res);
                res=new StringBuilder(Math.pow(10,temp)+"");
                tvResult.setText(res);
                break;

            case R.id.bt1x:
                temp=Result(res);
                res=new StringBuilder(Math.pow(temp,-1)+"");
                tvResult.setText(res);
                break;

            case R.id.btSev:
                res.append("7");
                tvResult.setText(res);
                break;

            case R.id.btEight:
                res.append("8");
                tvResult.setText(res);
                break;

            case R.id.btNine:
                res.append("9");
                tvResult.setText(res);
                break;

            case R.id.btMul:
                res.append("*");
                tvResult.setText(res);
                break;




            case R.id.btln:
                temp=Result(res);
                res=new StringBuilder(log(temp)+"");
                tvResult.setText(res);
                break;

            case R.id.btlog:
                temp=Result(res);
                res=new StringBuilder(log10(temp)+"");
                tvResult.setText(res);
                break;

            case R.id.btxF:
                temp=Result(res);
                res=new StringBuilder(factorial(temp)+"");
                tvResult.setText(res);
                break;

            case R.id.btFour:
                res.append("4");
                tvResult.setText(res);
                break;

            case R.id.btFive:
                res.append("5");
                tvResult.setText(res);
                break;

            case R.id.btSix:
                res.append("6");
                tvResult.setText(res);
                break;

            case R.id.btSub:
                res.append("-");
                tvResult.setText(res);
                break;




            case R.id.btSqrt:
                temp=Result(res);
                res=new StringBuilder(Math.sqrt(temp)+"");
                tvResult.setText(res);
                break;

            case R.id.btSinh:
                temp=Result(res);
                res=new StringBuilder(Math.sinh(temp)+"");
                tvResult.setText(res);
                break;

            case R.id.btCosh:
                temp=Result(res);
                res=new StringBuilder(Math.cosh(temp)+"");
                tvResult.setText(res);
                break;

            case R.id.btOne:
                res.append("1");
                tvResult.setText(res);
                break;

            case R.id.btTwo:
                res.append("2");
                tvResult.setText(res);
                break;

            case R.id.btThree:
                res.append("3");
                tvResult.setText(res);
                break;

            case R.id.btAdd:
                res.append("+");
                tvResult.setText(res);
                break;



            case R.id.btsin:
                temp=Result(res);
                res=new StringBuilder(Math.sin(temp)+"");
                tvResult.setText(res);
                break;

            case R.id.btCos:
                temp=Result(res);
                res=new StringBuilder(Math.cos(temp)+"");
                tvResult.setText(res);
                break;

            case R.id.btTan:
                temp=Result(res);
                res=new StringBuilder(Math.tan(temp)+"");
                tvResult.setText(res);
                break;

            case R.id.btZero:
                res.append("0");
                tvResult.setText(res);
                break;

            case R.id.btDecimal:
                res.append(".");
                tvResult.setText(res);
                break;

            case R.id.btEqual:
                double d=Result(res);
                if(d==0)
                    res=new StringBuilder(0+"");
                else
                    res = new StringBuilder(Result(res) + "");
                tvResult.setText(res);
                break;

        }

    }
    @Override
    protected void onDestroy() {

        super.onDestroy();
        writeFile();

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
        }
        catch (IOException e) {
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
            Log.d("abc", "readFile: "+res);
        }
        catch (IOException ioe) {
        }
    }


    private double factorial(double temp) {
        double fact=1;
        while(temp>0){
            fact=fact*temp;
            temp--;
        }
        return fact;
    }

    public double Result(StringBuilder s){
        char c='\0';
        try {
            if (s.charAt(0) == '+' || s.charAt(0) == '-' || s.charAt(0) == '*' || s.charAt(0) == '/' || s.charAt(0) == '%') {
                c = s.charAt(0);
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
                Toast.makeText(scientific_calculator.this, "Enter Correct data! ", Toast.LENGTH_LONG).show();
                return 0;
            }
            double result=0;
            result = Float.parseFloat(val.remove());
            if(!val.isEmpty()) {
                if (c == '-') {
                    result = result - 2 * result;
                } else if (c == '+' || c == '*' || c == '/' || c == '%') {
                    Toast.makeText(scientific_calculator.this, "Enter Correct data! ", Toast.LENGTH_LONG).show();
                    return 0;
                }
            }
            while (!op.isEmpty() && !val.isEmpty()) {
                String temp_op = op.remove();
                double a = Float.parseFloat(val.remove());
                switch (temp_op) {
                    case "+":
                        result = result + a;
                        break;
                    case "-":
                        result = result - a;
                        break;
                    case "*":
                        result = result * a;
                        break;
                    case "/":
                        result = result / a;
                        break;
                    default:
                        result = result % a;
                        break;
                }
            }

            return result;
        }catch(Exception e) {
            Toast.makeText(scientific_calculator.this, "Something Invalid", Toast.LENGTH_SHORT).show();
            return 0;
        }
    }

    @Override
    public void onBackPressed() {

    }
}
