package com.lucas.papa.ui.binding_adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.lucas.architecture.utils.ClickUtils;

/**
 * Created by lucas
 * Date: 2020/9/26 16:03
 */
public class CommonBindingAdapter {

    @BindingAdapter(value = {"imageUrl", "placeHolder"}, requireAll = false)
    public static void loadUrl(ImageView view, String url, Drawable placeHolder) {
        Glide.with(view.getContext()).load(url).placeholder(placeHolder).into(view);
    }

    @BindingAdapter(value = {"visible"}, requireAll = false)
    public static void visible(View view, boolean visible) {
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter(value = {"showDrawable", "drawableShowed"}, requireAll = false)
    public static void showDrawable(ImageView view, boolean showDrawable, int drawableShowed) {
        view.setImageResource(showDrawable ? drawableShowed : android.R.color.transparent);
    }

    @BindingAdapter(value = {"textColor"}, requireAll = false)
    public static void setTextColor(TextView textView, int textColorRes) {
        textView.setTextColor(textView.getResources().getColor(textColorRes));
    }

    @BindingAdapter(value = {"imageRes"}, requireAll = false)
    public static void setImageRes(ImageView imageView, int imageRes) {
        imageView.setImageResource(imageRes);
    }

    @BindingAdapter(value = {"selected"}, requireAll = false)
    public static void selected(View view, boolean select) {
        view.setSelected(select);
    }


    @BindingAdapter(value = {"onClickWithDebouncing"}, requireAll = false)
    public static void onClickWithDebouncing(View view, View.OnClickListener clickListener) {
        ClickUtils.applySingleDebouncing(view, clickListener);
    }

    @BindingAdapter(value = {"adjustWidth"})
    public static void adjustWidth(View view, int adjustWidth) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = adjustWidth;
        view.setLayoutParams(params);
    }

    @BindingAdapter(value = {"adjustHeight"})
    public static void adjustHeight(View view, int adjustHeight) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.height = adjustHeight;
        view.setLayoutParams(params);
    }
}
