package com.example.lifetips_gr1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "users.db";

    public DBHelper(Context context) {
        super(context, DBNAME, null, 12);
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
                "('Ăn rau củ', 'Chứa nhiều vitamin và chất xơ', 'https://media.istockphoto.com/id/2150857924/vi/anh/ng%C6%B0%E1%BB%9Di-ph%E1%BB%A5-n%E1%BB%AF-%C4%83n-salad-m%C3%A0u-c%E1%BA%A7u-v%E1%BB%93ng-t%C6%B0%C6%A1i-n%E1%BB%81n-tr%C3%A1i-c%C3%A2y-v%C3%A0-rau-qu%E1%BA%A3-nhi%E1%BB%81u-m%C3%A0u-kh%C3%A1i-ni%E1%BB%87m-%C4%83n-u%E1%BB%91ng.jpg?s=612x612&w=0&k=20&c=SNYcbR7Z5FSRt-vl74nwSeXrnnYX7ZepcqCbhmbyn0I=')," +
                "('Tránh thức ăn nhanh', 'Gây béo phì và ảnh hưởng mỡ máu', 'https://media.istockphoto.com/id/1305925945/vi/anh/m%E1%BB%99t-ng%C6%B0%E1%BB%9Di-ph%E1%BB%A5-n%E1%BB%AF-l%C3%A0m-d%E1%BA%A5u-hi%E1%BB%87u-tay-%C4%91%E1%BB%83-t%E1%BB%AB-ch%E1%BB%91i-m%E1%BB%99t-chi%E1%BA%BFc-hamburger-khoai-t%C3%A2y-chi%C3%AAn-v%C3%A0-g%C3%A0-r%C3%A1n-tr%C3%AAn.jpg?s=612x612&w=0&k=20&c=ZRoWobS0ryOEkCNlda5GsdXs6MwUpkPgs-gYEMjtMh0=')," +
                "('Uống trà xanh', 'Giảm stress và giảm mỡ trong máu', 'https://media.istockphoto.com/id/471942753/vi/anh/ng%C6%B0%E1%BB%9Di-ph%E1%BB%A5-n%E1%BB%AF-nh%E1%BA%A5m-nh%C3%A1p-tr%C3%A0-xanh-t%E1%BB%AB-m%E1%BB%99t-t%C3%A1ch-l%E1%BB%9Bn-trong-v%E1%BA%AFt.jpg?s=612x612&w=0&k=20&c=266xIQf87EnCpwtELSyFzlxKVBtTeqOWaLt792b7aJk=')," +
                "('Ăn sữa chua', 'Tốt cho đường tiêu hóa', 'https://media.istockphoto.com/id/1435026978/vi/anh/b%C3%A1t-s%E1%BB%AFa-chua-hy-l%E1%BA%A1p-xanh-v%C3%A0-qu%E1%BA%A3-m%E1%BB%8Dng-t%C6%B0%C6%A1i-b%E1%BB%8B-c%C3%B4-l%E1%BA%ADp-tr%C3%AAn-n%E1%BB%81n-tr%E1%BA%AFng.jpg?s=612x612&w=0&k=20&c=Fk_AF6CRAizsphXAbe8KcaR-99zr2jgnBIVZGEkrJss=')," +
                "('Uống detox', 'Giảm mỡ thừa đào thải độc tố', 'https://media.istockphoto.com/id/641975492/vi/anh/ba-lo%E1%BA%A1i-tr%C3%A1i-c%C3%A2y-v%C3%A0-rau-qu%E1%BA%A3-gi%E1%BA%A3i-%C4%91%E1%BB%99c-%C4%91%E1%BB%93-u%E1%BB%91ng.jpg?s=612x612&w=0&k=20&c=H9ZwMeuEwEHZf-GYvHlmu46JFvXEdra296oQRD4z_QQ=')," +
                "('Ăn đường ăn kiêng', 'Giảm bớt lượng calo nạp vào cơ thể', 'https://media.istockphoto.com/id/658974698/vi/anh/v%C4%83n-b%E1%BA%A3n-kh%C3%B4ng-c%C3%B3-%C4%91%C6%B0%E1%BB%9Dng-%C4%91%C6%B0%E1%BB%A3c-vi%E1%BA%BFt-b%E1%BA%B1ng-%C4%91%C6%B0%E1%BB%9Dng.jpg?s=612x612&w=0&k=20&c=tgNq8xodiB6mt17bTMiQP_QnuQZj9r85SGDTikt_V0I=')," +
                "('Bột Yến mạch', 'Giàu chất dinh dưỡng', 'https://media.istockphoto.com/id/874247746/vi/anh/y%E1%BA%BFn-m%E1%BA%A1ch-c%C3%A1n-ho%E1%BA%B7c-b%E1%BB%99t-y%E1%BA%BFn-m%E1%BA%A1ch-trong-b%C3%A1t-g%E1%BB%97-tr%C3%AAn-n%E1%BB%81n-%C4%91%C3%A1.jpg?s=612x612&w=0&k=20&c=6PjlBXGvfy4XuZLWXJmnyySDmKHYh3QfbIieAJsF_no=')," +
                "('Uống nước ép trái cây', 'Tăng sức đề kháng và cung cấp vitamin', 'https://media.istockphoto.com/id/155376375/vi/anh/n%C6%B0%E1%BB%9Bc-%C3%A9p-tr%C3%A1i-c%C3%A2y.jpg?s=612x612&w=0&k=20&c=PAFj6muZYVCWOA-yc5BKfE72zdZ2Un1KF_4P9BJ_1t0=')," +
                "('Ngũ cốc', 'Giảm nguy cơ tim mạch', 'https://media.istockphoto.com/id/835833518/vi/anh/th%E1%BB%A9c-%C4%83n-nguy%C3%AAn-h%E1%BA%A1t-v%E1%BA%ABn-c%C3%B2n-s%E1%BB%91ng-%C4%91%C6%B0%E1%BB%A3c-ch%E1%BB%A5p-tr%C3%AAn-b%C3%A0n-g%E1%BB%97-m%E1%BB%99c-m%E1%BA%A1c.jpg?s=612x612&w=0&k=20&c=fkZHiY0V2OkHT8P5zcLRBKgWbwF6Ot-wIn0WMc-jPmQ=')");

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
                "('Paracetamol', 'Giảm đau, hạ sốt', 'https://media.istockphoto.com/id/932555698/vi/anh/hydrocodone-l%C3%A0-thu%E1%BB%91c-gi%E1%BA%A3m-%C4%91au-%C4%91%C6%B0%E1%BB%A3c-k%C3%AA-%C4%91%C6%A1n-l%C3%A0-thu%E1%BB%91c-gi%E1%BA%A3m-%C4%91au-m%E1%BA%A1nh.jpg?s=612x612&w=0&k=20&c=GZyTmLAogRm0yUBhXDFFSjytIefvXRnu4Kgz4ndGQ5w=')," +
                "('Vitamin C', 'Tăng đề kháng', 'https://media.istockphoto.com/id/1392131094/vi/vec-to/kh%C3%A1i-ni%E1%BB%87m-vector-d%E1%BA%A5u-hi%E1%BB%87u-dinh-d%C6%B0%E1%BB%A1ng-s%E1%BB%A9c-m%E1%BA%A1nh-c%E1%BB%A7a-vitamin-c-c%C3%B4ng-th%E1%BB%A9c-h%C3%B3a-h%E1%BB%8Dc.jpg?s=612x612&w=0&k=20&c=QwJ8J3Y7lSFb1NocXDO-thu6auL_2E6c_cwqiDtkbf4=')," +
                "('Vitamin D', 'Cải thiện chiều cao', 'https://media.istockphoto.com/id/1366807729/vi/anh/t%E1%BB%AB-vitamin-d-v%E1%BB%9Bi-m%E1%BB%99t-c%E1%BB%91c-nh%E1%BB%8F-vi%C3%AAn-nang-vitamin-d3-tr%C3%AAn-%C4%91%C3%B3.jpg?s=612x612&w=0&k=20&c=8EOnKELhg8H8L06hRMrMSPNZQgv41ndVfNzkXT49e3g=')," +
                "('Vitamin E', 'Tăng đề kháng chống Oxy hóa', 'https://media.istockphoto.com/id/626784936/vi/anh/thu%E1%BB%91c-xanh-ho%E1%BA%B7c-vi%C3%AAn-nang-ch%E1%BB%A9a-%C4%91%E1%BA%A7y-vitamin-e.jpg?s=612x612&w=0&k=20&c=d5bdqIQaz0Z3T-Ge7wK-dIKh246sA9ZnwV3o8_YTYyI=')," +
                "('Vitamin A', 'Giúp cải thiện sáng mắt', 'https://media.istockphoto.com/id/803299426/vi/anh/c%C3%B4ng-th%E1%BB%A9c-h%C3%B3a-h%E1%BB%8Dc-c%E1%BB%A7a-vitamin-a-v%E1%BB%9Bi-b%C3%BAt-%C4%91en.jpg?s=612x612&w=0&k=20&c=eHqoJwSOLCLReHfdFYDQeyazIZg7xb6VdAqmDm038XE=')," +
                "('Vitamin B1', 'Cải thiện cho người thiếu máu', 'https://media.istockphoto.com/id/542578154/vi/anh/vi%C3%AAn-nang-vitamin-b1-thu%E1%BB%91c-v%E1%BB%9Bi-thiamine-b%E1%BB%95-sung-ch%E1%BA%BF-%C4%91%E1%BB%99-%C4%83n-u%E1%BB%91ng.jpg?s=612x612&w=0&k=20&c=R4FbNSaQe4a40Am4SjkxLe4D3JkeFxSEvX0_19_hmeM=')," +
                "('Sâm', 'Tăng cường sức khỏe phục hồi thể lực', 'https://media.istockphoto.com/id/1027128646/vi/anh/y-h%E1%BB%8Dc-trung-qu%E1%BB%91c.jpg?s=612x612&w=0&k=20&c=GZCuuRMIx0bhrq3uKoDjdMcSUsI1NVbl6UcLixCRcXQ=')," +
                "('Roket', 'Tăng đcường sinh lý', 'https://media.istockphoto.com/id/1438325892/vi/vec-to/11-11-ng%C3%A0y-mua-s%E1%BA%AFm.jpg?s=612x612&w=0&k=20&c=fzy3VjhPSUEuK_RGjInT8xpl6vSeGWqvEPOoD2TPO5I=')," +
                "('Collagen Powder', 'Tăng cường khả năng phục hồi', 'https://media.istockphoto.com/id/1129779844/vi/anh/b%E1%BB%99t-collagen-v%C3%A0-thu%E1%BB%91c-tr%C3%AAn-n%E1%BB%81n-h%E1%BB%93ng.jpg?s=612x612&w=0&k=20&c=c3Micm62us8QjbGwz6erIGf2e_bKsS73JDFNOpg6tug=')," +
                "('Magie', 'Giảm căng thẳng', 'https://media.istockphoto.com/id/2190244751/vi/anh/magnesium-mineral-supplement.jpg?s=612x612&w=0&k=20&c=bfvkTYFW2a8v-RNK21Xr66WO79qk0V6NAof6gRNEpBM=')");


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
