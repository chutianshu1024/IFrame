//package com.zytdsj.citywindow.lib_project.utils;
//
//import android.content.Context;
//import android.view.Gravity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.DrawableRes;
//
//import com.zytdsj.citywindow.lib_project.R;
//
///**
// * @Description: Toast工具类
// * @Author: Cts
// * @Date: 2016-05-10 17:14
// */
//public class ToastUtils {
//    private volatile static ToastUtils instance;
//    private android.widget.Toast toast = null;
//    private android.widget.Toast toast_img = null;
//    private static Context context;
//
//    /**
//     * 单例
//     *
//     * @return
//     */
//    public static ToastUtils getInstance() {
//        if (instance == null) {
//            //当变量为空时,同步(将同步写在方法内部,所以此同步方法只会运行一次，提高了效率)
//            synchronized (ToastUtils.class) {
//                if (instance == null) {
//                    instance = new ToastUtils();
//                }
//            }
//        }
//        if (context == null) {
//            context = Utils.getApp();
//        }
//        return instance;
//    }
//
//    /**
//     * @param
//     * @return void 返回类型
//     * @throws
//     * @Title: toastShow
//     * @Description: 使Toast不会因多次点击而显示时间过长
//     */
//    public void toastShow(String text) {
//        if (toast == null) {
//            toast = android.widget.Toast.makeText(context, text, android.widget.Toast.LENGTH_SHORT);
//        } else {
//            toast.cancel();
//            toast = android.widget.Toast.makeText(context, text, android.widget.Toast.LENGTH_SHORT);
////            toast.setText(text);
//        }
//        toast.show();
//    }
//
//    private View view;
//    private ImageView iv;
//    private TextView title;
//
//    /**
//     * 成功toast 带图片的
//     */
//    public void toastSuccess(String mes) {
//        if (toast_img == null) {
//            toast_img = new Toast(context);
//        } else {
//            toast_img.cancel();
//            toast_img = new Toast(context);
//        }
//
//        view = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.layout_toast_img, null); //加載layout下的布局
//        iv = view.findViewById(R.id.toast_img);
//        iv.setImageResource(R.drawable.ic_toast_success);
//        title = view.findViewById(R.id.toast_tv);
//
//        title.setText(mes); //toast的标题
//        toast_img.setGravity(Gravity.CENTER, 0, 0);//setGravity用来设置Toast显示的位置，相当于xml中的android:gravity或android:layout_gravity
//        toast_img.setDuration(Toast.LENGTH_SHORT);
//        toast_img.setView(view); //添加视图文件
//        toast_img.show();
//    }
//
//
//    /**
//     * 失败toast 带图片的
//     */
//    public void toastWarn(String mes) {
//        if (toast_img == null) {
//            toast_img = new Toast(context);
//        } else {
//            toast_img.cancel();
//            toast_img = new Toast(context);
//        }
//
//        view = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.layout_toast_img, null); //加載layout下的布局
//        iv = view.findViewById(R.id.toast_img);
//        iv.setImageResource(R.drawable.ic_toast_warning);
//        title = view.findViewById(R.id.toast_tv);
//
//        title.setText(mes); //toast的标题
//        toast_img.setGravity(Gravity.CENTER, 0, 0);//setGravity用来设置Toast显示的位置，相当于xml中的android:gravity或android:layout_gravity
//        toast_img.setDuration(Toast.LENGTH_SHORT);
//        toast_img.setView(view); //添加视图文件
//        toast_img.show();
//    }
//
//    /**
//     * 失败toast 带图片的
//     */
//    public void toastError(String mes) {
//        if (toast_img == null) {
//            toast_img = new Toast(context);
//        } else {
//            toast_img.cancel();
//            toast_img = new Toast(context);
//        }
//
//        view = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.layout_toast_img, null); //加載layout下的布局
//        iv = view.findViewById(R.id.toast_img);
//        iv.setImageResource(R.drawable.ic_toast_error);
//        title = view.findViewById(R.id.toast_tv);
//
//        title.setText(mes); //toast的标题
//        toast_img.setGravity(Gravity.CENTER, 0, 0);//setGravity用来设置Toast显示的位置，相当于xml中的android:gravity或android:layout_gravity
//        toast_img.setDuration(Toast.LENGTH_SHORT);
//        toast_img.setView(view); //添加视图文件
//        toast_img.show();
//    }
//
//    /**
//     * 失败toast 带图片的
//     */
//    public void toastWithImg(String mes, @DrawableRes int imgId) {
//        if (toast_img == null) {
//            toast_img = new Toast(context);
//            view = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.layout_toast_img, null); //加載layout下的布局
//            iv = view.findViewById(R.id.toast_img);
//            iv.setImageResource(R.drawable.ic_toast_warning);
//            title = view.findViewById(R.id.toast_tv);
//        }
//
//        title.setText(mes); //toast的标题
//        toast_img.setGravity(Gravity.CENTER, 0, 0);//setGravity用来设置Toast显示的位置，相当于xml中的android:gravity或android:layout_gravity
//        toast_img.setDuration(Toast.LENGTH_SHORT);
//        toast_img.setView(view); //添加视图文件
//        toast_img.show();
//    }
//
//    /**
//     * 关闭toast
//     */
//    public void cancelToast() {
//        if (toast != null) {
//            toast.cancel();
//            toast = null;
//        }
//        if (toast_img != null) {
//            toast_img.cancel();
//            toast_img = null;
//        }
//    }
//}
