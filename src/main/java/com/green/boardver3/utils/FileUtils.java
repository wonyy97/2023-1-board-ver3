package com.green.boardver3.utils;

import java.util.UUID;

public class FileUtils {
    //확장자 리턴하는 메소드
    public static String getExt(String fileNm) {    //abcd.123.hhh.jpg
        String ext = fileNm.substring(fileNm.lastIndexOf("."));
        return ext;
    }

    public static String getFileNm(String fileNm) {
        String FileName = fileNm.substring(0,fileNm.lastIndexOf("."));
        return FileName;
    }


    //UUID 이용, 랜덤값 파일명 리턴
    public static String makeRandomFileNm(String fileNm) {
        String uuid = UUID.randomUUID().toString();
        String ext = getExt(fileNm);

        String FullName = uuid+ext;

        return FullName;
    }



//    public static void main(String[] args) {
//        String fileNm = "124.34343.3434.jpg";
//
//        String result = getFileNm(fileNm);
//        System.out.println(result);
//
//        String resultRandomFileNm = makeRandomFileNm(fileNm);
//        System.out.println(resultRandomFileNm);
//    }
}
