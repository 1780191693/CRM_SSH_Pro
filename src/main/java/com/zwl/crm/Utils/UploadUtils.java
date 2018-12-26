package com.zwl.crm.Utils;

import java.util.UUID;

public class UploadUtils {
    public static String getUuidFileName(String fileName){
        int idx = fileName.lastIndexOf(".");
        String extions = fileName.substring(idx);
        return UUID.randomUUID().toString().replace("-", "")+extions;
    }


    /**
     * 目录分离
     */
    public static String getPath(String fileName){
        int hashCode = fileName.hashCode();
        int d1 = hashCode & 0xf;  //d1作为一级目录
        int hashCode2 = hashCode >>> 4;
        int d2 = hashCode2 & 0xf; //d2作为二级目录
        return "/"+d1+"/"+d2;

    }
}
