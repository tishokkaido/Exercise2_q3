package com.example.exercise3_q3

import android.content.Intent
import android.icu.util.ULocale
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Helloボタンのクリック処理
        findViewById<Button>(R.id.button_hello).setOnClickListener {
            // Intentの設定
            val intent = Intent()
            intent.action = "IntentTest"
            startActivity(intent)
        }

        // Mailボタンのクリック処理
        findViewById<Button>(R.id.button_mail).setOnClickListener {
            // Intentの設定
            val intent = Intent().also {
                it.action = Intent.ACTION_SENDTO
                it.data = Uri.parse("mailto:")
                it.putExtra(Intent.EXTRA_SUBJECT, "インテントフィルターのテスト")
                it.putExtra(Intent.EXTRA_TEXT, "起動に成功したよ")
            }
            startActivity(intent)
        }

        // Internetボタンのクリック処理
        findViewById<Button>(R.id.button_internet).setOnClickListener {
            // Intentの設定
            val intent = Intent().also {
                it.action = Intent.ACTION_VIEW
                it.data = Uri.parse("https://www.google.co.jp/")
            }
            startActivity(intent)
        }

        // Mapボタンのクリック処理
        findViewById<Button>(R.id.button_map).setOnClickListener {
            // Intentの設定
            val intent = Intent().also {
                it.action = Intent.ACTION_VIEW
                it.data = Uri.parse("geo:0,0?q=北海道")
            }
            startActivity(intent)
        }

        // Addressボタンのクリック処理
        findViewById<Button>(R.id.button_address).setOnClickListener {
            // Intentの設定
            val intent = Intent().also {
                it.action = Intent.ACTION_PICK
                it.type = ContactsContract.Contacts.CONTENT_TYPE
            }
            startActivity(intent)
        }
    }
}