package com.example.databasetest

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.contentValuesOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.composetutorial.R
import com.example.composetutorial.databinding.ActivityDatabaseBinding
import com.example.kotlintest.cvOf

class DatabaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDatabaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatabaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dbHelper = MyDatabaseHelper(this, "BookStore.db", 2)
        binding.createDatabase.setOnClickListener {
            dbHelper.writableDatabase
        }

        binding.addData.setOnClickListener {
            val db = dbHelper.writableDatabase
                //添加数据
//            db.execSQL("insert into Book(name,author,pages,price) values(?,?,?,?)", arrayOf("The Da Vinci Code","Dan Brown","454","16.96"))
//            db.execSQL("insert into Book(name,author,pages,price) values(?,?,?,?)", arrayOf("The Lost Symbol","Dan Brown","510","19.95"))


//            val values1 = ContentValues().apply {
//                //开始组装第一条数据
//                put("name", "The Da Vinci Code")
//                put("author", "Dan Brown")
//                put("pages", 454)
//                put("price", 16.96)
//            }
            //val values1 = cvOf("name" to "The Da Vinci Code","author" to "Dan Brown","pages" to 454,"price" to 16.96)
            val values1 = contentValuesOf("name" to "The Da Vinci Code","author" to "Dan Brown","pages" to 454,"price" to 16.96)
            db.insert("Book", null, values1)//插入第一条数据

            val values2 = ContentValues().apply {
                //开始组装第二条数据
                put("name", "The Lost Symbol")
                put("author", "Dan Brown")
                put("pages", 510)
                put("price", 19.95)
            }
            db.insert("Book", null, values2)//插入第二条数据
        }

        binding.updateData.setOnClickListener {
            val db = dbHelper.writableDatabase
            //sql更新数据
            //db.execSQL("update Book set price=? where name=?", arrayOf("10.99","The Da Vinci Code"))
            val values = ContentValues()
            values.put("price", 10.99)
            db.update("Book", values, "name=?", arrayOf("The Da Vinci Code"))
        }

        binding.deleteData.setOnClickListener {
            val db = dbHelper.writableDatabase
            //db.execSQL("delete from Book where pages>?", arrayOf("500"))
            db.delete("Book", "pages>?", arrayOf("500"))
        }

        binding.queryData.setOnClickListener {
            val db = dbHelper.writableDatabase
            //val cursor= db.rawQuery("select * from Book",null)
            //查询book表中所有数据
            val cursor = db.query("Book", null, null, null, null, null, null)
            if (cursor.moveToFirst()) {
                do {
                    //遍历cursor对象，取出数据并打印
                    val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
                    val author =cursor.getString(cursor.getColumnIndexOrThrow("author"))
                    val pages = cursor.getString(cursor.getColumnIndexOrThrow("pages"))
                    val price =cursor.getString(cursor.getColumnIndexOrThrow("price"))
                    Log.d("DatabaseActivity","book name is $name")
                    Log.d("DatabaseActivity","book author is $author")
                    Log.d("DatabaseActivity","book pages is $pages")
                    Log.d("DatabaseActivity","book price is $price")
                }while (cursor.moveToNext())
            }
            cursor.close()
        }
        binding.replaceData.setOnClickListener {
            val db = dbHelper.writableDatabase
            //开启事务
            db.beginTransaction()
            try {
                db.delete("Book",null,null)
                if (true){
                    //手动抛出一个异常，让事务失败
                    throw NullPointerException()
                }
                val values = ContentValues().apply {
                    put("name","Game of Thrones")
                    put("author","George Martin")
                    put("pages",720)
                    put("price",20.85)
                }
                db.insert("Book",null,values)
                db.setTransactionSuccessful()//事务已经执行成功
            }catch (e:Exception){
                e.printStackTrace()
            }finally {
                //结束事务
                db.endTransaction()
            }
        }
    }
}