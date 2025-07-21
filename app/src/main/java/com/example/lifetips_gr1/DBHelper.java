package com.example.lifetips_gr1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "users.db";

    public DBHelper(Context context) {
        super(context, DBNAME, null, 11);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("CREATE TABLE users(username TEXT primary key, password TEXT)");

        MyDB.execSQL("CREATE TABLE health(id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, description TEXT, imageUrl TEXT)");
        MyDB.execSQL("CREATE TABLE food(id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, description TEXT, imageUrl TEXT)");
        MyDB.execSQL("CREATE TABLE exercise(id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, description TEXT, imageUrl TEXT)");
        MyDB.execSQL("CREATE TABLE medication(id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, description TEXT, imageUrl TEXT)");

        MyDB.execSQL("INSERT INTO health (title, description, imageUrl) VALUES " +
                "('Uống đủ nước', 'Nên uống 2 lít nước mỗi ngày', 'https://cdn.pixabay.com/photo/2016/02/18/06/57/glass-1206584_1280.jpg')," +
                "('Ngủ đúng giờ', 'Ngủ đủ giấc giúp cơ thể được nghỉ ngơi', 'https://cdn.pixabay.com/photo/2024/12/20/16/46/baby-9280577_1280.jpg')," +
                "('Nuôi thú cưng', 'Giúp cơ thể tạo dopamin tích cực', 'https://media.istockphoto.com/id/1433858575/vi/anh/ng%C6%B0%E1%BB%9Di-%C4%91%C3%A0n-%C3%B4ng-vu%E1%BB%91t-ve-gi%C3%A0-c%E1%BB%A7a-m%C3%ACnh.jpg?s=612x612&w=0&k=20&c=QOELnGx9FIhaw-RKtcX-yDSA_2Kljtr9z4q5LA-XHDM=')," +
                "('Hít thở sâu - Thiền', 'Giảm căng thẳng và lo âu', 'https://media.istockphoto.com/id/1472399571/vi/anh/yoga-tr%C3%AAn-gi%C6%B0%E1%BB%9Dng-ng%C6%B0%E1%BB%9Di-%C4%91%C3%A0n-%C3%B4ng-n%C3%A0y-ch%E1%BB%89-ra-c%C3%A1ch-t%E1%BA%A1o-th%C3%B3i-quen-bu%E1%BB%95i-s%C3%A1ng-y%C3%AAn-b%C3%ACnh.jpg?s=612x612&w=0&k=20&c=_1t_eWmp8LCq4UxLr3KUdDBPWwh_FCYurnUIrCuTO6o=')," +
                "('Ăn sáng đầy đủ', 'Giúp cung cấp năng lượng cho ngày mới', 'https://media.istockphoto.com/id/861254984/vi/anh/tr%E1%BA%BB-em-%C4%83n-v%E1%BA%A3y-ng%C3%B4.jpg?s=612x612&w=0&k=20&c=xaHi7sPnEbw1eXoclopgXUFoNY1lJhbZCQssGawU0io=')," +
                "('Tránh xa thuốc lá', 'Giảm nguy cơ bệnh tim mạch và đường hô hấp', 'https://media.istockphoto.com/id/851767906/vi/vec-to/kh%C3%B4ng-%C4%91%C6%B0%E1%BB%A3c-h%C3%BAt-thu%E1%BB%91c.jpg?s=612x612&w=0&k=20&c=xpuuDHErsXn5afexnOjgzrhUvhD2-GB3Ft6pylAyrSE=')," +
                "('Đọc sách', 'Tăng sức khả năng tư duy cải thiện tinh thần', 'https://media.istockphoto.com/id/1373105718/vi/anh/ng%C6%B0%E1%BB%9Di-%C4%91%C3%A0n-%C3%B4ng-l%C3%A0m-vi%E1%BB%87c-ho%E1%BA%B7c-h%E1%BB%8Dc-t%E1%BA%ADp-v%E1%BB%9Bi-s%C3%A1ch-kh%C3%A1i-ni%E1%BB%87m-kinh-doanh-v%C3%A0-gi%C3%A1o-d%E1%BB%A5c.jpg?s=612x612&w=0&k=20&c=rQPZMWhtqLOwxasIvYa9RZ23HY1cj1qYG-AdTa74RBU=')," +
                "('Tắm nắng sáng sớm', 'Tổng hợp vitamin D', 'https://media.istockphoto.com/id/129178966/vi/anh/woman-with-teenage-friend-lying-on-lounge-chair-near-pool.jpg?s=612x612&w=0&k=20&c=w3OWi5q8egCLzWXXc8eOldrbXQ_j2ZusQQ6viHHljqQ=')," +
                "('Rửa tay thường xuyên', 'Ngăn ngừa vi khuẩn lây lan', 'https://media.istockphoto.com/id/514363103/vi/anh/v%E1%BB%87-sinh-t%E1%BB%91t-m%E1%BB%99t-th%C3%B3i-quen-tuy%E1%BB%87t-v%E1%BB%9Di.jpg?s=612x612&w=0&k=20&c=6o5iyEP8KqUgecoqEbRtOk9bTC_hemGMmg0cwPP0Q5k=')," +
                "('Tắm rửa thường xuyên', 'Tránh cơ thể bị nhiễm vi khuẩn', 'https://media.istockphoto.com/id/1169793341/vi/vec-to/ch%C3%A0ng-trai-tr%E1%BA%BB-%C4%91i-t%E1%BA%AFm-th%C3%A0nh-ph%E1%BA%A7n-h%C3%ACnh-tr%C3%B2n-ch%C3%A0ng-trai-h%E1%BA%A1nh-ph%C3%BAc-g%E1%BB%99i-%C4%91%E1%BA%A7u-l%C3%B4ng-x%C3%A0-ph%C3%B2ng-c%C6%A1-th%E1%BB%83.jpg?s=612x612&w=0&k=20&c=wgwx7vsbrng8C2gOnc-Cr8H-OsZaYVT69Ujw3S8t2OE=')");

        MyDB.execSQL("INSERT INTO food (title, description, imageUrl) VALUES " +
                "('Ăn rau xanh', 'Chứa nhiều vitamin và chất xơ', 'https://cdn.pixabay.com/photo/2016/11/29/09/08/vegetables-1866584_1280.jpg')," +
                "('Tránh thức ăn nhanh', 'Gây béo phì và bệnh tim', 'https://cdn.pixabay.com/photo/2015/05/15/14/47/hamburger-768159_1280.jpg')," +
                "('Ăn trái cây mỗi ngày', 'Tăng sức đề kháng', 'https://cdn.pixabay.com/photo/2016/01/05/13/58/apple-1122537_1280.jpg')," +
                "('Ăn ngũ cốc nguyên cám', 'Giảm nguy cơ tim mạch', 'https://cdn.pixabay.com/photo/2017/06/06/22/59/cereal-2378724_1280.jpg')");

        MyDB.execSQL("INSERT INTO exercise (title, description, imageUrl) VALUES " +
                "('Đi bộ', 'Giúp tuần hoàn tốt', 'https://media.istockphoto.com/id/1445417525/vi/anh/ngh%E1%BB%89-h%C6%B0u-t%E1%BA%ADp-th%E1%BB%83-d%E1%BB%A5c-v%C3%A0-%C4%91i-d%E1%BA%A1o-v%E1%BB%9Bi-ch%C3%B3-v%C3%A0-c%E1%BA%B7p-v%E1%BB%A3-ch%E1%BB%93ng-trong-c%C3%B4ng-vi%C3%AAn-khu-ph%E1%BB%91-%C4%91%E1%BB%83-th%C6%B0-gi%C3%A3n-t%E1%BA%ADp.jpg?s=612x612&w=0&k=20&c=kP8U3evrAk2lnVR6AoP8_m2dFggwaDTzLouBrFXHFXs=')," +
                "('Tập yoga', 'Giúp thư giãn', 'https://media.istockphoto.com/id/1483989816/vi/anh/ng%C6%B0%E1%BB%9Di-%C4%91%C3%A0n-%C3%B4ng-%E1%BA%A3-r%E1%BA%ADp-tr%C6%B0%E1%BB%9Fng-th%C3%A0nh-v%E1%BB%9Bi-m%C3%A1i-t%C3%B3c-%C4%91u%C3%B4i-ng%E1%BB%B1a-thi%E1%BB%81n-trong-m%E1%BB%99t-l%E1%BB%9Bp-h%E1%BB%8Dc-yoga.jpg?s=612x612&w=0&k=20&c=nBTZ0AVmkgGkAHqc4KyxEaA4rGS9FML501B0-_hKsxU=')," +
                "('Đạp xe', 'Tốt cho tim mạch', 'https://media.istockphoto.com/id/1402134774/vi/anh/ng%C6%B0%E1%BB%9Di-%C4%91i-xe-%C4%91%E1%BA%A1p-%C4%91%C6%B0%E1%BB%9Dng-b%E1%BB%99-chuy%C3%AAn-nghi%E1%BB%87p-tr%C3%AAn-m%E1%BB%99t-chuy%E1%BA%BFn-%C4%91i-%C4%91%C3%A0o-t%E1%BA%A1o.jpg?s=612x612&w=0&k=20&c=ZG6QppDC6uILHdHtFhyEE6fm_5df8SGFrbYF-1FjH7Q=')," +
                "('Bơi lội', 'Tăng sức bền cải thiện hô hấp', 'https://media.istockphoto.com/id/1332857654/vi/anh/b%C6%A1i-l%E1%BB%99i-nam-tr%C3%AAn-kh%C3%B4ng-trong-h%E1%BB%93-b%C6%A1i-%C4%91%C3%A0o-t%E1%BA%A1o-v%E1%BA%ADn-%C4%91%E1%BB%99ng-vi%C3%AAn-quy%E1%BA%BFt-t%C3%A2m-chuy%C3%AAn-nghi%E1%BB%87p-cho-gi%E1%BA%A3i-v%C3%B4.jpg?s=612x612&w=0&k=20&c=VQBiShFAHFCKHSQQw7QBjQOZTswHZP4nOPwo2gc17pQ=')," +
                "('Leo núi', 'Giúp rèn luyện sức bền', 'https://media.istockphoto.com/id/667315360/vi/anh/gi%C3%BAp-%C4%91%E1%BB%A1-ng%C6%B0%E1%BB%9Di-%C4%91i-b%E1%BB%99-%C4%91%C6%B0%E1%BB%9Dng-d%C3%A0i.jpg?s=612x612&w=0&k=20&c=F-cS7bpbjFPxzhUZu-05IubSVKwn0bXDC2bAYfmz3bU=')," +
                "('Đá bóng', 'Giúp cơ thể đốt mỡ thừa', 'https://media.istockphoto.com/id/2171339103/vi/anh/tr%E1%BA%BB-em-ch%C6%A1i-b%C3%B3ng-%C4%91%C3%A1-t%E1%BA%A1i-s%C3%A2n-ngo%C3%A0i-tr%E1%BB%9Di.jpg?s=612x612&w=0&k=20&c=TA8VZdK6ByFUtuK6sW2sBGPRZAuYDHMOfvQZ4CdtXV0=')," +
                "('Nhảy dây', 'Tăng sức bền đốt calo', 'https://media.istockphoto.com/id/2174204066/vi/anh/ng%C6%B0%E1%BB%9Di-ph%E1%BB%A5-n%E1%BB%AF-tr%E1%BA%BB-m%E1%BA%B7c-%C4%91%E1%BB%93-th%E1%BB%83-thao-nh%E1%BA%A3y-d%C3%A2y-trong-ph%C3%B2ng-kh%C3%A1ch-trong-m%E1%BB%99t-bu%E1%BB%95i-t%E1%BA%ADp-luy%E1%BB%87n-t%E1%BA%A1i-nh%C3%A0.jpg?s=612x612&w=0&k=20&c=SwbHRe6TM9FIek0mX7jqGh9DXZ2Uj-o6hTSCxHQNnb4=')," +
                "('Tập gym', 'Body khỏe đẹp', 'https://media.istockphoto.com/id/2027278927/vi/anh/ng%C6%B0%E1%BB%9Di-ph%E1%BB%A5-n%E1%BB%AF-tr%E1%BA%BB-th%E1%BB%83-thao-t%E1%BA%ADp-th%E1%BB%83-d%E1%BB%A5c-v%E1%BB%9Bi-thanh-t%E1%BA%A1-trong-qu%C3%A1-tr%C3%ACnh-t%E1%BA%ADp-luy%E1%BB%87n-th%E1%BB%83-thao-trong.jpg?s=612x612&w=0&k=20&c=7ss4dsh0UHkOEQAJ0sb-HeC65E1u93U8tc1AW0yUYS0=')," +
                "('Đánh cầu lông', 'Cải thiện vóc dáng , giảm stress', 'https://media.istockphoto.com/id/497021110/vi/vec-to/%C3%A1p-ph%C3%ADch-th%E1%BB%83-thao-v%E1%BB%9Bi-c%E1%BA%A7u-th%E1%BB%A7-c%E1%BA%A7u-l%C3%B4ng.jpg?s=612x612&w=0&k=20&c=BMAHZw8C9yJxrLnIdX7MKtZA62iQsD31BoXjsfkSDc4=')," +
                "('Đánh pickleball', 'Thư giãn gân cốt', 'https://media.istockphoto.com/id/1355170007/vi/anh/thanh-ni%C3%AAn-ch%C6%A1i-pickleball.jpg?s=612x612&w=0&k=20&c=o2H1lwVVD_HaBTSCwHkmuAtKB9R61VIsOomuVBWyqm0=')");

        MyDB.execSQL("INSERT INTO medication (title, description, imageUrl) VALUES " +
                "('Paracetamol', 'Giảm đau, hạ sốt', 'https://cdn.pixabay.com/photo/2021/06/08/09/38/tablets-6318985_1280.jpg')," +
                "('Vitamin C', 'Tăng đề kháng', 'https://cdn.pixabay.com/photo/2016/10/07/14/11/tangerines-1721633_1280.jpg')," +
                "('Magie', 'Giảm căng thẳng', 'https://cdn.pixabay.com/photo/2021/06/08/09/38/magnesium-6318987_1280.jpg')");


    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("DROP TABLE IF EXISTS users");
        MyDB.execSQL("DROP TABLE IF EXISTS health");
        MyDB.execSQL("DROP TABLE IF EXISTS food");
        MyDB.execSQL("DROP TABLE IF EXISTS exercise");
        MyDB.execSQL("DROP TABLE IF EXISTS medication");
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
