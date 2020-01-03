package com.bawei6.common.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import com.bawei6.common.entity.LinkmanPhoneEntity;
import java.util.ArrayList;
import java.util.List;

public class ContentProviderUtils {

    private static int count = 0;
    private static String judge = "";

    /**
     * 获取手机联系人信息的方法
     * */
    public static List<LinkmanPhoneEntity> getPhoneInfo(Context context){
        List<LinkmanPhoneEntity> list = new ArrayList<>();
        ContentResolver resolver = context.getContentResolver();
        Uri phoneUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = resolver.query(phoneUri, null, null, null, "phonebook_label");
        while(cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            String phonebook_label = cursor.getString(cursor.getColumnIndex("phonebook_label"));
            if (!judge.equals(phonebook_label)){
                list.add(new LinkmanPhoneEntity(null,null,phonebook_label,0));
                list.add(new LinkmanPhoneEntity(name,number,null,1));
            }else {
                list.add(new LinkmanPhoneEntity(name,number,null,1));
            }
            judge = phonebook_label;
        }
        return list;
    }
}
