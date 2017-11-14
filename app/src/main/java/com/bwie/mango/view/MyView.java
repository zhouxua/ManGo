package com.bwie.mango.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.bwie.mango.R;

/**
 * 周旋
 * 2017/10/24  10:52
 */

public class MyView extends LinearLayout{

    private EditText content;

    public MyView(Context context) {
        super(context);
        init(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    private  void init(Context context){
        View view =  LayoutInflater.from(context).inflate(R.layout.view_layout,null);
        addView(view);
        Button revserse = (Button) view.findViewById(R.id.revserse);
        Button add = (Button) view.findViewById(R.id.add);
        content = (EditText) view.findViewById(R.id.content);

        revserse.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String  result =   content.getText().toString().trim() ;
                int integerResult =  Integer.valueOf(result);
                if(integerResult > 1){
                    integerResult = integerResult - 1 ;
                    content.setText(integerResult+"");
                    if(listener != null){
                        listener.onChange(integerResult);
                    }
                }
            }
        });

        add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String  result =   content.getText().toString().trim() ;
                int integerResult =  Integer.valueOf(result) ;
                integerResult = integerResult + 1 ;
                content.setText(integerResult+"");
                if(listener != null){
                    listener.onChange(integerResult);
                }
            }
        });
        content.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                if(listener != null){
                    listener.onChange(Integer.parseInt(s.toString()));
                }
            }
        });
    }
    public ChangeListener listener ;

    public void setListener(ChangeListener listener){
        this.listener = listener;
    }
    public interface ChangeListener{
        void onChange(int count);
    }
}
