package com.example.jsqdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity implements OnClickListener {
	private Button bt1;
	private Button bt2;
	private Button bt3;
	private Button bt4;
	private Button bt5;
	private Button bt6;
	private Button bt7;
	private Button bt8;
	private Button bt9;
	private Button bt0;
	private Button jia;
	private Button jie;
	private Button che;
	private Button chu;
	private Button deny;
	private Button qinc;
	private Button shanc;
	private Button dian;
	private EditText shurukuang;
	boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        SHH();
      
      
    }

	private void SHH() {
		// TODO Auto-generated method stub
		  bt1 = (Button) findViewById(R.id.bt1);
	        bt2 = (Button) findViewById(R.id.bt2);
	        bt3 = (Button) findViewById(R.id.bt3);
	        bt4 = (Button) findViewById(R.id.bt4);
	        bt5 = (Button) findViewById(R.id.bt5);
	        bt6 = (Button) findViewById(R.id.bt6);
	        bt7 = (Button) findViewById(R.id.bt7);
	        bt8 = (Button) findViewById(R.id.bt8);
	        bt9 = (Button) findViewById(R.id.bt9);
	        bt0 = (Button) findViewById(R.id.btn_0);
	        jia = (Button) findViewById(R.id.jia);
	        jie = (Button) findViewById(R.id.jian);
	        che = (Button) findViewById(R.id.cheng);
	        chu = (Button) findViewById(R.id.chu);
	        deny = (Button) findViewById(R.id.dy);
	        qinc = (Button) findViewById(R.id.c);
	        shanc = (Button) findViewById(R.id.del);
	        dian = (Button) findViewById(R.id.dian);
	        shurukuang =(EditText)findViewById(R.id.edit);
	        bt1.setOnClickListener(this);
	        bt2.setOnClickListener(this);
	        bt3.setOnClickListener(this);
	        bt4.setOnClickListener(this);
	        bt5.setOnClickListener(this);
	        bt6.setOnClickListener(this);
	        bt7.setOnClickListener(this);
	        bt8.setOnClickListener(this);
	        bt9.setOnClickListener(this);
	        bt0.setOnClickListener(this);
	        jia.setOnClickListener(this);
	        jie.setOnClickListener(this);
	        che.setOnClickListener(this);
	        chu.setOnClickListener(this);
	        deny.setOnClickListener(this);
	        qinc.setOnClickListener(this);
	        shanc.setOnClickListener(this);
	        dian.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String str =shurukuang.getText().toString();
		switch (v.getId()) {
		case R.id.bt1:
		case R.id.bt2:
		case R.id.bt3:
		case R.id.bt4:
		case R.id.bt5:
		case R.id.bt6:
		case R.id.bt7:
		case R.id.bt8:
		case R.id.bt9:
		case R.id.btn_0:	
		case R.id.dian:
			if(flag){
				flag=false;
				shurukuang.setText("");
			}
			shurukuang.setText(str+((Button)v).getText());
			break;
		case R.id.jia:
		case R.id.jian:
		case R.id.cheng:
		case R.id.chu:
			if(flag){
				flag=false;
				shurukuang.setText("");
			}
			shurukuang.setText(str+" "+((Button)v).getText()+" ");
			break;
		case R.id.c:
			flag=false;
			shurukuang.setText("");
			break;
		case R.id.del:
			if(flag){
				flag=false;
				shurukuang.setText("");
			
			}else if(str!=null&&str.equals("")){
				shurukuang.setText(str.substring(0, str.length()-1));
			}
			break;
		case R.id.dy:	
			getResult();
			break;
		}
	}
	//ß\Ëã½Y
	private void getResult(){
		String exp =shurukuang.getText().toString();
		if(exp==null||exp.equals("")){
			return;
		}
		if(!exp.contains(" ")){
			return;
		}
		if(flag){
			flag=false;
			return;
		}
		flag = true;
		double result = 0;
		String s1 = exp.substring(0, exp.indexOf(" "));//ß\Ëã·ûÇ°ÃæµÄ×Ö·û´®
		String op = exp.substring(exp.indexOf(" ")+1, exp.indexOf(" ")+2);
		String s2 = exp.substring(exp.indexOf(" ")+3);
		if(!s1.equals("")&&!s2.equals("")){
			double d1 = Double.parseDouble(s1);
			double d2 = Double.parseDouble(s2);
			if(op.equals("+")){
				result=d1+d2;
			}else if(op.equals("-")) {
				result=d1-d2;
			}else if(op.equals("*")){
				result=d1*d2;
			}else if(op.equals("/")){
				if(d2==0){
					result=0;
				}else{
					result=d1/d2;
				}
			}
			if(!s1.contains(".")&&s2.contains(".")){
				int r =(int) result;
				shurukuang.setText(r+"");
			}else{
				shurukuang.setText(result+"");
			}
		}else if(!s1.equals("")&&s2.equals("")){
			shurukuang.setText(exp);
		}else if(s1.equals("")&&!s2.equals("")){
			double d2 = Double.parseDouble(s2);
			if(op.equals("+")){
				result=0+d2;
			}else if(op.equals("-")) {
				result=0-d2;
			}else if(op.equals("*")){
				result=0;
			}else if(op.equals("/")){
					result=0;
			}
			if(s2.contains(".")){
				int r =(int) result;
				shurukuang.setText(r+"");
			}else{
				shurukuang.setText(result+"");
			}
		}else{
			shurukuang.setText("");
		}
	}

}
