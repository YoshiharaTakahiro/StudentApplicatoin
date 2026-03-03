package ecccomp.college.it.studentapplicatoin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.File

class StorageActivity : AppCompatActivity() {

    lateinit var internalEditText : EditText
    lateinit var internalTextView: TextView
    lateinit var internalSaveButton: Button
    lateinit var internalLoadButton: Button
    lateinit var internalDeleteButton: Button

    lateinit var externalEditText : EditText
    lateinit var externalTextView: TextView
    lateinit var externalSaveButton: Button
    lateinit var externalLoadButton: Button
    lateinit var externalDeleteButton: Button

    lateinit var moveCameraButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_storage)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 内部ストレージ関連 View
        internalEditText = findViewById(R.id.internalEditText)
        internalTextView = findViewById(R.id.internalTextView)
        internalSaveButton = findViewById(R.id.internalSaveButton)
        internalLoadButton = findViewById(R.id.internalLoadButton)
        internalDeleteButton = findViewById(R.id.internalDeleteButton)

        internalSaveButton.setOnClickListener {

            if(internalEditText.text.isNotEmpty()){
                // ファイル名を指定して内部ストレージ領域に書き込み処理を行う

            }else{
                // 未入力の場合はトースト表示
                Toast.makeText(this, "名前を入力してください", Toast.LENGTH_SHORT).show()
            }
        }


        internalLoadButton.setOnClickListener {
            // ファイルの存在チェックをしてから、読み込み処理を行う

        }

        internalDeleteButton.setOnClickListener {
            // ファイルの存在チェックをしてから、削除処理を行う

        }

        // 外部ストレージ関連 View
        externalEditText = findViewById(R.id.externalEditText)
        externalTextView = findViewById(R.id.externalTextView)
        externalSaveButton = findViewById(R.id.externalSaveButton)
        externalLoadButton = findViewById(R.id.externalLoadButton)
        externalDeleteButton = findViewById(R.id.externalDeleteButton)

        // アプリ固有の外部ストレージ領域にファイルを宣言


        externalSaveButton.setOnClickListener {

            if(externalEditText.text.isNotEmpty()){
                // ファイルに対して書き込み処理を行う

            }else{
                // 未入力の場合はトースト表示
                Toast.makeText(this, "文章を入力してください", Toast.LENGTH_SHORT).show()
            }
        }

        externalLoadButton.setOnClickListener {
            // ファイルの存在チェックをしてから、読み込み処理を行う

        }

        externalDeleteButton.setOnClickListener {
            // ファイルの存在チェックをしてから、削除処理を行う

        }

        // カメラアクティビティへの画面遷移
        moveCameraButton = findViewById(R.id.moveCameraButton)
        moveCameraButton.setOnClickListener {
            val intent = Intent(this, CameraActivity::class.java)
            startActivity(intent)
        }

    }
}