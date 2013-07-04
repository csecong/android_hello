package com.example.c;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.loopj.android.http.*;

public class MainActivity extends Activity {
	AsyncHttpClient client = new AsyncHttpClient();
	private TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (TextView) findViewById(R.id.textView1);
        t1.setText("测试");
        Button b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new OnClickListener()
        {
        	public void onClick(View v)
        	{
        		t1.setText("测试1");
        		client.get("http://www.baidu.com", new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(String response) {
                    	t1.setText("获取");
                    	t1.setText(response.toString());
                        System.out.println(response);
                    }
                    @Override  
                    public void onStart() {  
                        super.onStart();  
                        System.out.println("onStart");
                        t1.setText("开始");
                    }
                    
                    /*
                    @Override  
                    public void onFinish() {  
                        super.onFinish();  
                        System.out.println("onFinish");
                        t1.setText("完成");
                    } 
                    */
                    
                    @Override
                    public void onFailure(Throwable error, String content)
                    {
                    	t1.setText(content);
                    }
                });
        	}
        });
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
