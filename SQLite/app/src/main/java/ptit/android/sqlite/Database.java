package ptit.android.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import ptit.android.sqlite.model.Category;
import ptit.android.sqlite.model.Item;

public class Database extends SQLiteOpenHelper {
    private final static String DB_NAME = "tqh";
    private final static int VERSION = 1;
    public Database(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table categories(" +
                "id integer primary key autoincrement," +
                "name text)";
        sqLiteDatabase.execSQL(sql);

        sql = "create table items(" +
                "id integer primary key autoincrement," +
                "name text," +
                "cid integer," +
                "price real," +
                "dateUpdate text," +
                "foreign key(cid) references catagories(id))";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void insertCate(Category c){
        String sql = "insert into categories(name) " +
                "values(?);";
        String[] args = {c.getName()};
        SQLiteDatabase st = getWritableDatabase();
        st.execSQL(sql, args);
        st.close();
    }

    public long insertItem(Item i){
        ContentValues values = new ContentValues();
        values.put("name", i.getName());
        values.put("cid", i.getCategory().getId());
        values.put("price", i.getPrice());
        values.put("dateUpdate", i.getDateUpdate());
        SQLiteDatabase st = getWritableDatabase();
        long res = st.insert("items", null, values);
        st.close();
        return res;
    }

    public List<Category> getCates(){
        List<Category> list = new ArrayList<>();
        SQLiteDatabase st = getReadableDatabase();
        Cursor rs = st.query("categories", null, null, null, null, null, null);
        while (rs!=null && rs.moveToNext()){
            list.add(new Category(rs.getInt(0), rs.getString(1)));
        }
        st.close();
        return list;
    }
    public List<Item> getItems(){
        List<Item> list = new ArrayList<>();
        String sql = "select t.id, t.name, t.price, t.dateUpdate, c.id, c.name " +
                "from categories c inner join items t on (c.id = t.cid)" +
                " order by dateUpdate desc";
        SQLiteDatabase st = getReadableDatabase();
        Cursor rs = st.rawQuery(sql, null);
        while (rs!=null && rs.moveToNext()){
            Category category = new Category(rs.getInt(4), rs.getString(5));
            Item i = new Item(rs.getInt(0), rs.getString(1), rs.getFloat(2), rs.getString(3), category);
            list.add(i);
        }
        st.close();
        return list;
    }

    public Category getCateById(int id){
        String where = "id = ?";
        String[] args = {"" + id};
        SQLiteDatabase st = getReadableDatabase();
        Cursor rs = st.query("categories", null, where, args, null, null, null);
        if(rs!=null && rs.moveToNext()){
            return new Category(rs.getInt(0), rs.getString(1));
        }
        return null;
    }

    public Item getItemById(int id){
        String where = "id = ?";
        String[] args = {"" + id};
        SQLiteDatabase st = getReadableDatabase();
        Cursor rs = st.query("items", null, where, args, null, null, null);

        if(rs!=null && rs.moveToNext()){
            return new Item(rs.getInt(0), rs.getString(1), rs.getFloat(3), rs.getString(4), new Category(rs.getInt(2), ""));
        }
        st.close();
        return null;
    }

    public int update(Item i){
        ContentValues values = new ContentValues();
        values.put("name", i.getName());
        values.put("cid", i.getCategory().getId());
        values.put("price", i.getPrice());
        values.put("dateUpdate", i.getDateUpdate());
        String where = "id=?";
        String[] args = {"" + i.getId()};
        SQLiteDatabase st = getReadableDatabase();
        int res = st.update("items", values, where, args);
        st.close();
        return res;
    }

    public int delete(int id){
        String where = "id=?";
        String[] args = {"" + id};
        SQLiteDatabase st = getWritableDatabase();
        int res = st.delete("items", where, args);
        st.close();
        return res;
    }
    // search
    public List<Item> searchByKey(String key){
        List<Item> list = new ArrayList<>();
        String sql = "select t.id, t.name, t.price, t.dateUpdate, c.id, c.name " +
                "from categories c inner join items t on (c.id = t.cid) " +
                "where t.name like ? or c.name like ? order by dateUpdate desc";
        String[] args = {"%" + key + "%", "%" + key + "%"};
        SQLiteDatabase st = getReadableDatabase();
        Cursor rs = st.rawQuery(sql, args);
        while (rs!=null && rs.moveToNext()){
            Category category = new Category(rs.getInt(4), rs.getString(5));
            Item i = new Item(rs.getInt(0), rs.getString(1), rs.getFloat(2), rs.getString(3), category);
            list.add(i);
        }
        st.close();
        return list;
    }

    public List<Item> searchByPriceFromTo(float from, float to){
        List<Item> list = new ArrayList<>();
        String sql = "select t.id, t.name, t.price, t.dateUpdate, c.id, c.name " +
                "from categories c inner join items t on (c.id = t.cid) " +
                "where t.price > ? or t.price < ? order by dateUpdate desc";
        String[] args = {"" + from, "" + to};
        SQLiteDatabase st = getReadableDatabase();
        Cursor rs = st.rawQuery(sql, args);
        while (rs!=null && rs.moveToNext()){
            Category category = new Category(rs.getInt(4), rs.getString(5));
            Item i = new Item(rs.getInt(0), rs.getString(1), rs.getFloat(2), rs.getString(3), category);
            list.add(i);
        }
        st.close();
        return list;
    }
}
