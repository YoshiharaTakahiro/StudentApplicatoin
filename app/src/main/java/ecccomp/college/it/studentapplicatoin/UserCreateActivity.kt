package ecccomp.college.it.studentapplicatoin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class UserCreateActivity : AppCompatActivity() {

    lateinit var userNameEdit: EditText
    lateinit var genderRadioGroup: RadioGroup
    lateinit var createButton: Button

    // ユーザDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_create)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        userNameEdit = findViewById(R.id.userNameEdit)
        genderRadioGroup = findViewById(R.id.genderRadioGroup)
        createButton = findViewById(R.id.createButton)

        // Roomデータベース インスタンス化


        createButton.setOnClickListener {

            val radioId = genderRadioGroup.checkedRadioButtonId
            val radioButton = genderRadioGroup.findViewById<RadioButton>(radioId)
            val radioIndex = genderRadioGroup.indexOfChild(radioButton)

            // Userエンティティ インスタンス化

            // ユーザ情報 挿入処理


            finish()
        }
    }
}