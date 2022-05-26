package org.techtown.logindb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    //DBHelper 생성자로 관리할 DB 이름과 버전 정보를 받음
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * 테이블 생성
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE USER_INFO (_num INTEGER PRIMARY KEY AUTOINCREMENT, id TEXT, name TEXT, age TEXT);");
    }

    //DB 업그레이드를 위해 버전이 변경될 때 호출되는 함수
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * 등록
     * @param id 아이디
     * @param name 이름
     * @param age 나이
     */

    public void insert(String id, String name, String age) {
        //읽고 쓰기가 가능하게 DB 열기
        SQLiteDatabase db = getWritableDatabase();

        Log.d("DBHelper", "id: " + id + ",name: " + name + ",age: " + age);

        //DB에 입력한 값으로 행 추가
        db.execSQL("INSERT INTO USER_INFO VALUES(null, " + id + ",  " + name + ",  " + age +");");
        db.close();
    }

    /**
     * 수정
     * @param id 아이디
     * @param age 나이
     */
    public void update(String id, int age) {
        SQLiteDatabase db = getWritableDatabase();
        //입력한 항목과 일치하는 행의 가격 정보 수정
        db.execSQL("USER_INFO USER_INFO SET age = " + age + "WHERE id = " + id + ";");
        db.close();
    }

    /**
     * 삭제
     * @param id 아이디
     */
    public void delete(String id) {
        SQLiteDatabase db = getWritableDatabase();
        //입력한 항목과 일치하는 행 삭제

        db.execSQL("DELETE FROM USER_INFO WHERE id = " + id + ";");
        db.close();
    }

    /**
     * 조회
     * @return
     */
    public Cursor getUserList() {
        //읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        //DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하요 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT id, name, age FROM USER_INFO ORDER BY id", null);

        return cursor;
    }
}
