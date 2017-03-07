package app.a2017;

import android.app.Application;
import android.util.Log;

import org.litepal.LitePalApplication;
import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

import app.a2017.model.Book;
/**
 * Created by Administrator on 2017/2/17.
 */

public class MyApplication extends Application {
    private static final String TAG = "MyApplication";
    @Override
    public void onCreate() {
        super.onCreate();
        LitePalApplication.initialize(this);
        Connector.getDatabase();
      /*  Book book=new Book();
        book.setId(1);
        book.setName("");
        book.setPrice(22);
        book.setPublish("");
        book.save();
        book.setToDefault("price");
        book.updateAll("id=?","1");
        DataSupport.deleteAll(Book.class,"price<?","12");
        List<Book> books = DataSupport.findAll(Book.class);
        for (Book book1 : books) {
            Log.i(TAG,"name="+book1.getName()+" price="+book1.getPrice()+" publish="+book1.getPublish()+" id="+book1.getId()+"\n");
        }
*/
    }
}
