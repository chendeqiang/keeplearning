package com.example.contentprovidertest

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri

/**
 * Created by deqiangchen on 2024/10/16.
 */
class MyProvider : ContentProvider() {

    private val tableDir = 0
    private val tableItem = 1
    private val table2Dir = 2
    private val table2Item = 3
    private val uriMatcher = UriMatcher(UriMatcher.NO_MATCH)

    init {
        uriMatcher.addURI("com.example.app.provider", "table1", tableDir)
        uriMatcher.addURI("com.example.app.provider", "table1/#", tableItem)
        uriMatcher.addURI("com.example.app.provider", "table2", table2Dir)
        uriMatcher.addURI("com.example.app.provider", "table2/#", table2Item)

    }

    override fun onCreate(): Boolean {
        return false
    }

    override fun query(
        uri: Uri,
        p1: Array<out String>?,
        p2: String?,
        p3: Array<out String>?,
        p4: String?
    ): Cursor? {
        when (uriMatcher.match(uri)) {
            tableDir -> {
                //查询table1表中的数据
            }
            tableItem ->{
                //查询table1表中的单条数据
            }
            table2Dir ->{

            }
            table2Item ->{


            }        }
        return null
    }

    override fun getType(uri: Uri) = when(uriMatcher.match(uri)){
        tableDir ->"vnd.android.cursor.dir/vnd.com.example.app.provider.table1"
        tableItem ->"vnd.android.cursor.item/vnd.com.example.app.provider.table1"
        table2Dir ->"vnd.android.cursor.dir/vnd.com.example.app.provider.table2"
        table2Item ->"vnd.android.cursor.item/vnd.com.example.app.provider.table2"
        else ->null
    }

    override fun insert(p0: Uri, p1: ContentValues?): Uri? {
        return null
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        return 0
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        return 0
    }
}