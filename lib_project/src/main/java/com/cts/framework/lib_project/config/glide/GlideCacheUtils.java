//package com.zytdsj.citywindow.com.zytdsj.citywindow.lib_project.config.glide;
//
//
//import android.os.Looper;
//
//import com.bumptech.glide.Glide;
//import com.miaotong.caocaoemployee.utils.Utils;
//
//import java.io.File;
//import java.math.BigDecimal;
//
///**
// * @Description: Glide缓存相关
// * @suthor: CTS
// * @Date: 2017/5/12 10:31
// */
//
//public class GlideCacheUtils {
//    //volatile关键字确保当instance被初始化为ChineseUtil的实例时，多个线程正确处理instance变量
//    private volatile static GlideCacheUtils INSTANCE;
//    private final String ImageExternalCatchDir = Utils.getApp().getCacheDir() + "/" + GlideModelConfig.GLIDE_CARCH_DIR;
//
//    /**
//     * 单例
//     *
//     * @return
//     */
//    public static GlideCacheUtils getInstances() {
//        if (INSTANCE == null) {
//            //当变量为空时,同步(将同步写在方法内部,所以此同步方法只会运行一次，提高了效率)
//            synchronized (GlideCacheUtils.class) {
//                if (INSTANCE == null) {
//                    INSTANCE = new GlideCacheUtils();
//                }
//            }
//        }
//        return INSTANCE;
//    }
//
//    // 获取Glide磁盘缓存大小
//    public String getCacheSize() {
//        try {
//            return getFormatSize(getFolderSize(new File(ImageExternalCatchDir)));
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "获取失败";
//        }
//    }
//
//    // 清除Glide磁盘缓存，自己获取缓存文件夹并删除方法
//    public boolean cleanCatchDisk() {
//        return deleteFolderFile(ImageExternalCatchDir, true);
//    }
//
//    // 清除图片磁盘缓存，调用Glide自带方法
//    public boolean clearCacheDiskSelf() {
//        try {
//            if (Looper.myLooper() == Looper.getMainLooper()) {
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Glide.get(Utils.getApp()).clearDiskCache();
//                    }
//                }).start();
//            } else {
//                Glide.get(Utils.getApp()).clearDiskCache();
//            }
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    // 清除Glide内存缓存
//    public boolean clearCacheMemory() {
//        try {
//            if (Looper.myLooper() == Looper.getMainLooper()) { //只能在主线程执行
//                Glide.get(Utils.getApp()).clearMemory();
//                return true;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//
//    // 获取指定文件夹内所有文件大小的和
//    private long getFolderSize(File file) throws Exception {
//        long size = 0;
//        try {
//            File[] fileList = file.listFiles();
//            for (File aFileList : fileList) {
//                if (aFileList.isDirectory()) {
//                    size = size + getFolderSize(aFileList);
//                } else {
//                    size = size + aFileList.length();
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return size;
//    }
//
//    // 格式化单位
//    private static String getFormatSize(double size) {
//        double kiloByte = size / 1024;
//        if (kiloByte < 1) {
//            return size + "Byte";
//        }
//        double megaByte = kiloByte / 1024;
//        if (megaByte < 1) {
//            BigDecimal result1 = new BigDecimal(Double.toString(kiloByte));
//            return result1.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "KB";
//        }
//        double gigaByte = megaByte / 1024;
//        if (gigaByte < 1) {
//            BigDecimal result2 = new BigDecimal(Double.toString(megaByte));
//            return result2.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "MB";
//        }
//        double teraBytes = gigaByte / 1024;
//        if (teraBytes < 1) {
//            BigDecimal result3 = new BigDecimal(Double.toString(gigaByte));
//            return result3.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "GB";
//        }
//        BigDecimal result4 = new BigDecimal(teraBytes);
//        return result4.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "TB";
//    }
//
//    // 按目录删除文件夹文件方法
//    private boolean deleteFolderFile(String filePath, boolean deleteThisPath) {
//        try {
//            File file = new File(filePath);
//            if (file.isDirectory()) {
//                File files[] = file.listFiles();
//                for (File file1 : files) {
//                    deleteFolderFile(file1.getAbsolutePath(), true);
//                }
//            }
//            if (deleteThisPath) {
//                if (!file.isDirectory()) {
//                    file.delete();
//                } else {
//                    if (file.listFiles().length == 0) {
//                        file.delete();
//                    }
//                }
//            }
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//}
