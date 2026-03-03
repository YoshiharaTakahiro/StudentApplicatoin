package ecccomp.college.it.studentapplicatoin// package ecccomp.s70795.studentapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class UserSelectActivity : AppCompatActivity() {

    companion object{
        const val GENDER_MAN = 0
        const val GENDER_WOMAN = 1
        const val GENDER_OTHER = 2
    }

    lateinit var nameEdit: EditText
    lateinit var searchButton: Button
    lateinit var userListView: ListView
    lateinit var userCreateFab: FloatingActionButton

    lateinit var userIdTextView: TextView
    lateinit var nameTextView: TextView
    lateinit var genderTextView: TextView

    // ユーザ情報リスト

    // ユーザDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_select)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        nameEdit = findViewById(R.id.nameEdit)
        searchButton = findViewById(R.id.searchButton)
        userListView = findViewById(R.id.userListView)
        userCreateFab = findViewById(R.id.userCreateFab)

        userIdTextView = findViewById(R.id.userIdTextView)
        nameTextView = findViewById(R.id.nameTextView)
        genderTextView = findViewById(R.id.genderTextView)

        // Roomデータベース インスタンス化


        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, mutableListOf<String>())
        userListView.adapter = adapter

        searchButton.setOnClickListener {

            val searchText = nameEdit.text.toString()

            // ユーザ情報、リストビュー初期化

            // ユーザ情報 取得処理

            adapter.notifyDataSetChanged()
        }

        userListView.setOnItemClickListener{ parent, view, position, id ->

            // リストビューのインデックス番号を元にユーザ情報を取得

            // 詳細情報項目に値をセット
            userIdTextView.text = ""
            nameTextView.text = ""
            genderTextView.text = when(null){
                GENDER_MAN -> "男"
                GENDER_WOMAN -> "女"
                GENDER_OTHER -> "その他"
                else -> "アンノウン"
            }
        }

        userCreateFab.setOnClickListener {
            val intent = Intent(this, UserCreateActivity::class.java)
            startActivity(intent)
        }

    }
}