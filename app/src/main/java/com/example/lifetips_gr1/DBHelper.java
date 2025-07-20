package com.example.lifetips_gr1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "users.db";

    public DBHelper(Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("CREATE TABLE users(username TEXT primary key, password TEXT)");

        MyDB.execSQL("CREATE TABLE health(id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, description TEXT, imageUrl TEXT)");
        MyDB.execSQL("CREATE TABLE exercise(id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, description TEXT, imageUrl TEXT)");

        MyDB.execSQL("INSERT INTO health (title, description, imageUrl) VALUES " +
                "('Uống đủ nước', 'Nên uống 2 lít nước mỗi ngày', 'https://cdn.pixabay.com/photo/2016/02/18/06/57/glass-1206584_1280.jpg')," +
                "('Ngủ đúng giờ', 'Ngủ đủ giấc giúp tăng cường sức khỏe', 'https://cdn.pixabay.com/photo/2024/12/20/16/46/baby-9280577_1280.jpg')," +
                "('Tập thể dục', 'Giúp cơ thể khỏe mạnh', 'https://media.istockphoto.com/id/1679800838/vi/anh/c%E1%BA%ADn-c%E1%BA%A3nh-%C4%91%C3%B4i-ch%C3%A2n-v%E1%BA%ADn-%C4%91%E1%BB%99ng-vi%C3%AAn-th%E1%BB%83-thao-ch%E1%BA%A1y-tr%C3%AAn-m%C3%A1y-ch%E1%BA%A1y-b%E1%BB%99-trong-c%C3%A2u-l%E1%BA%A1c-b%E1%BB%99-th%E1%BB%83-h%C3%ACnh-t%E1%BA%ADp.jpg?s=612x612&w=0&k=20&c=fHPGhbqfzMrSFmPBK5L406mT1dLihA85fS8-CPerADI=')," +
                "('Hít thở sâu', 'Giảm căng thẳng và lo âu', 'https://media.istockphoto.com/id/1472399571/vi/anh/yoga-tr%C3%AAn-gi%C6%B0%E1%BB%9Dng-ng%C6%B0%E1%BB%9Di-%C4%91%C3%A0n-%C3%B4ng-n%C3%A0y-ch%E1%BB%89-ra-c%C3%A1ch-t%E1%BA%A1o-th%C3%B3i-quen-bu%E1%BB%95i-s%C3%A1ng-y%C3%AAn-b%C3%ACnh.jpg?s=612x612&w=0&k=20&c=_1t_eWmp8LCq4UxLr3KUdDBPWwh_FCYurnUIrCuTO6o=')," +
                "('Ăn sáng đầy đủ', 'Giúp cung cấp năng lượng cho ngày mới', 'https://media.istockphoto.com/id/861254984/vi/anh/tr%E1%BA%BB-em-%C4%83n-v%E1%BA%A3y-ng%C3%B4.jpg?s=612x612&w=0&k=20&c=xaHi7sPnEbw1eXoclopgXUFoNY1lJhbZCQssGawU0io=')," +
                "('Tránh xa thuốc lá', 'Giảm nguy cơ bệnh tim mạch', 'https://cdn.pixabay.com/photo/2017/01/31/21/22/nicotine-2024671_1280.jpg')," +
                "('Rửa tay thường xuyên', 'Ngăn ngừa vi khuẩn lây lan', 'https://cdn.pixabay.com/photo/2020/03/27/17/23/wash-hands-4974549_1280.jpg')," +
                "('Giữ vệ sinh cá nhân', 'Tránh lây nhiễm vi khuẩn', 'https://cdn.pixabay.com/photo/2017/03/30/12/44/woman-2181420_1280.jpg')");

        MyDB.execSQL("INSERT INTO exercise (title, description, imageUrl) VALUES " +
                "('Đi bộ mỗi ngày', 'Giúp tuần hoàn tốt', 'https://cdn.pixabay.com/photo/2017/04/12/19/25/walk-2228865_1280.jpg')," +
                "('Tập yoga', 'Giúp thư giãn', 'https://cdn.pixabay.com/photo/2017/01/20/00/30/people-1991235_1280.jpg')," +
                "('Đạp xe', 'Tốt cho tim mạch', 'https://cdn.pixabay.com/photo/2016/11/29/04/00/cycling-1869622_1280.jpg')," +
                "('Bơi lội', 'Tăng sức bền', 'https://cdn.pixabay.com/photo/2015/07/02/10/18/swimmer-828732_1280.jpg')," +
                "('Tham gia thể thao', 'Bóng đá, bóng rổ, cầu lông v.v.', 'https://cdn.pixabay.com/photo/2016/03/27/07/08/soccer-1284661_1280.jpg')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("DROP TABLE IF EXISTS users");
        MyDB.execSQL("DROP TABLE IF EXISTS health");
        MyDB.execSQL("DROP TABLE IF EXISTS exercise");
        onCreate(MyDB);
    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
        return result != -1;
    }

    public Boolean checkUsernamePassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username, password});
        return cursor.getCount() > 0;
    }

    public Boolean checkUsername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[] {username});
        return cursor.getCount() > 0;
    }
}
