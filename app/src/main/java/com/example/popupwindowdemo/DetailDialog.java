package com.example.popupwindowdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;

import razerdp.basepopup.BasePopupWindow;
import razerdp.util.animation.AnimationHelper;
import razerdp.util.animation.TranslationConfig;

public class DetailDialog extends BasePopupWindow {
    private TagFlowLayout mFirstChooseTag;
    private TagFlowLayout mSecondChooseTag;
    private ArrayList mFirstTagList;
    private ArrayList mSecondTagList;
    private Button mNextBtn;
    private Button mDecreaseBtn;
    private Button mAddBtn;
    private TextView mNumberTv;

    public DetailDialog(Context context) {
        super(context);
        setContentView(createPopupById(R.layout.ppw_goods_detail));
        mNextBtn = findViewById(R.id.btn_goods_next);
        mDecreaseBtn = findViewById(R.id.btn_goods_decrease);
        mAddBtn = findViewById(R.id.btn_goods_add);
        mNumberTv = findViewById(R.id.tv_goods_amount);
        initController();
        initTag();
        initListener();
    }

    @Override
    protected Animation onCreateShowAnimation() {
        return AnimationHelper.asAnimation()
                .withTranslation(TranslationConfig.FROM_BOTTOM)
                .toShow();
    }
    @Override
    protected Animation onCreateDismissAnimation() {
        return AnimationHelper.asAnimation()
                .withTranslation(TranslationConfig.TO_BOTTOM)
                .toShow();
    }

    private void initController() {
        mFirstTagList = new ArrayList<>();
        mFirstChooseTag = findViewById(R.id.tfl_goods_choose1);
        mSecondTagList = new ArrayList<>();
        mSecondChooseTag = findViewById(R.id.tfl_goods_choose2);
    }

    private void initListener() {
        mFirstChooseTag.setAdapter(new TagAdapter<String>(mFirstTagList) {
            @Override
            public View getView(FlowLayout parent, int position, String  s) {
                TextView tv = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.tv_style,parent,false);
                tv.setText(s);
                return tv;
            }

            @Override
            public void onSelected(int position, View view) {
                view.setBackground(getContext().getResources().getDrawable(R.drawable.shape_goods_tag_selected));
            }

            @Override
            public void unSelected(int position, View view) {
                view.setBackground(getContext().getResources().getDrawable(R.drawable.shape_goods_tag_unselected));
            }
        });
        mSecondChooseTag.setAdapter(new TagAdapter<String>(mSecondTagList) {
            @Override
            public View getView(FlowLayout parent, int position, String  s) {
                TextView tv = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.tv_style,parent,false);
                tv.setText(s);
                return tv;
            }

            @Override
            public void onSelected(int position, View view) {
                view.setBackground(getContext().getResources().getDrawable(R.drawable.shape_goods_tag_selected));
            }

            @Override
            public void unSelected(int position, View view) {
                view.setBackground(getContext().getResources().getDrawable(R.drawable.shape_goods_tag_unselected));
            }

        });
        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PayDialog(getContext()).showPopupWindow();
            }
        });
        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.valueOf(mNumberTv.getText().toString());
                mNumberTv.setText("");
                mNumberTv.setText(String.valueOf(i+1));
            }
        });
        mDecreaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.valueOf(mNumberTv.getText().toString())>1){
                    int i = Integer.valueOf(mNumberTv.getText().toString());
                    mNumberTv.setText("");
                    mNumberTv.setText(String.valueOf(i-1));
                }
                else{
                    mNumberTv.setText("1");
                }
            }
        });
    }

    private void initTag() {
        mFirstTagList.add("红色");
        mFirstTagList.add("白色");

        mSecondTagList.add("S");
        mSecondTagList.add("M");
        mSecondTagList.add("L");
    }
}
