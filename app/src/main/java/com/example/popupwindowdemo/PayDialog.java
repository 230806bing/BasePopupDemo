package com.example.popupwindowdemo;

import android.content.Context;
import android.view.animation.Animation;

import razerdp.basepopup.BasePopupWindow;
import razerdp.util.animation.AnimationHelper;
import razerdp.util.animation.TranslationConfig;

public class PayDialog extends BasePopupWindow {
    public PayDialog(Context context) {
        super(context);
        setContentView(R.layout.ppw_goods_pay);
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
}
