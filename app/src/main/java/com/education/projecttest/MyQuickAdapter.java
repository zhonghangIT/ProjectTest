package com.education.projecttest;

import android.net.Uri;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.education.projecttest.bean.RoomBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by zhonghang on 2016/10/19.
 */

public class MyQuickAdapter extends BaseQuickAdapter<RoomBean> {
    public MyQuickAdapter(int layoutResId, List<RoomBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RoomBean item) {
        SimpleDraweeView draweeView = helper.getView(R.id.simpleview);
        draweeView.setImageURI(Uri.parse(item.getVerticalSrc()));
    }
}
