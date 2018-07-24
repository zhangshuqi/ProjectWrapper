package com.south.prefee.view;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.south.prefee.R;
import com.south.prefee.base.BaseCustomView;
import com.south.prefee.bean.MultiPicChooseBean;
import com.south.prefee.databinding.ItemMultiPicChooseBinding;
import com.south.prefee.databinding.ViewMultiPicChooseBinding;
import com.south.prefee.interfaces.ImagePickerListener;
import com.south.prefee.utils.IntentController;
import com.south.prefee.utils.PickFileTools;
import com.south.prefee.widget.databindingadapter.BaseBindingItemPresenter;
import com.south.prefee.widget.databindingadapter.BaseDataBindingDecorator;
import com.south.prefee.widget.databindingadapter.BindingViewHolder;
import com.south.prefee.widget.databindingadapter.SingleTypeBindingAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/4/11 0011.
 */

public class MultiPicChooseView extends BaseCustomView<ViewMultiPicChooseBinding> implements BaseBindingItemPresenter<MultiPicChooseBean>, BaseDataBindingDecorator<MultiPicChooseBean> {
    public static final int IMAGE_PICKER = 11;
    private List<MultiPicChooseBean> multiPicChooseBeanList;
    private SingleTypeBindingAdapter adapter;
    private ArrayList<String> pathList = new ArrayList<>();
    private PickFileTools pickFileTools;
    private AppCompatActivity mActivity;
    private int selectImageSize;
    private int showImageListType;
    //    private Transferee transferee;
//    private TransferConfig config;

    public MultiPicChooseView(Context context) {
        super(context);
    }

    public MultiPicChooseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        selectImageSize = 9;
        multiPicChooseBeanList = new ArrayList<>();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.view_multi_pic_choose;
    }

    @Override
    protected void initView(Context context, AttributeSet attrs) {

        multiPicChooseBeanList = MultiPicChooseBean.getAddImageBean();
        adapter = new SingleTypeBindingAdapter(context, multiPicChooseBeanList, R.layout.item_multi_pic_choose);
        adapter.setItemPresenter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 4, LinearLayoutManager.VERTICAL, false);
        mBinding.setLayoutManager(gridLayoutManager);
        mBinding.setAdapter(adapter);
        adapter.setItemDecorator(this);
        pickFileTools = PickFileTools.init((FragmentActivity) context);
    }

    @Override
    public void initEvent(Context context) {

    }

    @Override
    public void initView(Context context, View rootView, AttributeSet attrs) {

    }

    @Override
    public void initData(Context context) {

    }

    @Override
    public void onItemClick(int position, MultiPicChooseBean itemData) {
        if (showImageListType == 1) return;
        switch (itemData.type) {

            case 0:
                pickFileTools.pick(selectImageSize, true, false, new ImagePickerListener() {
                    @Override
                    public void getMultiUrlStringImages(List<String> imgs) {
                        if (imgs == null || imgs.size() == 0) {
                            return;
                        }
                        pathList.clear();
                        multiPicChooseBeanList.clear();
                        multiPicChooseBeanList = MultiPicChooseBean.getAddImageBean();
                        for (String uri : imgs) {

                            if (pathList.size() > selectImageSize) {
                                break;
                            }

                            pathList.add(0, uri);
                            MultiPicChooseBean pojo = new MultiPicChooseBean();
                            pojo.imgUrlString = uri;
                            pojo.type = 1;
                            int size = multiPicChooseBeanList.size();
                            multiPicChooseBeanList.add(0, pojo);
                        }
                        MultiPicChooseBean pojo = getBean();
                        if (pathList.size() > selectImageSize) {
                            pojo.setVisiable(false);
                        } else {
                            pojo.setVisiable(true);
                        }
                        adapter.refresh(multiPicChooseBeanList);

                    }
                });
                break;
        }
    }

    public void onShowImage(View iv, int position, MultiPicChooseBean itemData) {
        switch (itemData.type) {
            case 1:
                if (showImageListType == 1) {
                    // 表示显示作用
                    IntentController.toBigImageNetActivity((FragmentActivity) mContext, pathList, position);
                } else {
                    IntentController.toBigImageFileActivity((FragmentActivity) mContext, pathList, position);
                }
                break;
        }
    }


    public void deleteImage(int position, MultiPicChooseBean itemData) {
        pathList.remove(position);
        adapter.delete(position);
    }


    public void setChoosePicButtonView(boolean isShow) {
        MultiPicChooseBean pojo = getBean();
        pojo.setVisiable(isShow);
        adapter.refresh(multiPicChooseBeanList);
    }


    public MultiPicChooseBean getBean() {
        for (MultiPicChooseBean picChoosePojo : multiPicChooseBeanList) {
            if (picChoosePojo.type == 0) {
                return picChoosePojo;
            }
        }
        return null;
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (pickFileTools != null) pickFileTools.onActivityResult(requestCode, resultCode, data);
    }


    private List<ImageView> itemImageViews = new ArrayList<>();

    @Override
    public void decorator(BindingViewHolder holder, int position, int viewType, MultiPicChooseBean data) {
        if (data.type == 1) {
            ItemMultiPicChooseBinding bind = (ItemMultiPicChooseBinding) holder.getBinding();
            itemImageViews.add(bind.imgPhoto);
        }
    }

    public void setActivity(AppCompatActivity mActivity) {
        this.mActivity = mActivity;
    }

    public void setSelectImageSize(int selectImageSize) {
        this.selectImageSize = selectImageSize;
    }

    public void setImageList(List<String> imageList) {
        showImageListType = 1;
        pathList.addAll(imageList);
        List<MultiPicChooseBean> multiPicChooseBeans = new ArrayList<>();
        for (int i = 0; i < imageList.size(); i++) {
            String path = imageList.get(i);
            MultiPicChooseBean choosePojo = new MultiPicChooseBean(path, 1, "");
            multiPicChooseBeans.add(choosePojo);
        }
        adapter.refresh(multiPicChooseBeans);
    }
}
