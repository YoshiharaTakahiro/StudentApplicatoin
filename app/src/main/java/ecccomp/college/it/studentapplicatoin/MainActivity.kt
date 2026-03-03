package ecccomp.college.it.studentapplicatoin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // 定数（キー名）をまとめて定義する
    // companion object はクラスに属する定数を作るために使う
    companion object {
        private const val TITLE = "title"
        private const val CONTENT = "content"
        private const val ACTIVITY_CLASS = "activityClass"
    }

    // リストビューに表示するデータ
    // タイトル・説明文・遷移先Activityを1セットにしたリスト
    val menuItems = listOf(
        mapOf(TITLE to "画面操作", CONTENT to "画面デザイン、イベント、画面遷移などのハンズオン", ACTIVITY_CLASS to null), // LayoutActivity::classに後ほど変更します
        mapOf(TITLE to "一覧表示", CONTENT to "リストビュー操作のハンズオン", ACTIVITY_CLASS to ListActivity::class.java),
        mapOf(TITLE to "ブラウザとマップ", CONTENT to "暗黙的インテントについてのハンズオン", ACTIVITY_CLASS to ImplicitIntentActivity::class.java),
        mapOf(TITLE to "カメラ", CONTENT to "既存カメラアプリを利用するためのハンズオン", ACTIVITY_CLASS to CameraActivity::class.java),
        mapOf(TITLE to "パーミッション", CONTENT to "権限管理のハンズオン", ACTIVITY_CLASS to PermissionActivity::class.java),
        mapOf(TITLE to "ストレージ", CONTENT to "ファイル操作のハンズオン", ACTIVITY_CLASS to StorageActivity::class.java),
        mapOf(TITLE to "プレファレンス", CONTENT to "設定ファイルのハンズオン", ACTIVITY_CLASS to PreferencesActivity::class.java),
        mapOf(TITLE to "データベース", CONTENT to "Roomデータベースのハンズオン", ACTIVITY_CLASS to UserSelectActivity::class.java),
        mapOf(TITLE to "非同期処理", CONTENT to "コルーチンのハンズオン", ACTIVITY_CLASS to CoroutineActivity::class.java),
    )

    lateinit var menuListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ステータスバーやナビゲーションバーの領域まで画面を広げる設定
        enableEdgeToEdge()
        // レイアウトXMLを適用
        setContentView(R.layout.activity_main)
        // ステータスバーやナビゲーションバーと重ならないように余白を設定する
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // レイアウトで設定したIDをもとにビュー情報を取得
        menuListView = findViewById(R.id.menuListView)

        // リストビューのレイアウト、表示するデータの設定
        menuListView.adapter = SimpleAdapter(
            this,
            menuItems,
            android.R.layout.simple_list_item_2,
            arrayOf(TITLE, CONTENT),
            intArrayOf(android.R.id.text1, android.R.id.text2))

        // メニューのアイテムをタップした時のイベント処理
        menuListView.setOnItemClickListener { parent, view, position, id ->

            // タップされた位置(position)のデータから遷移先のActivityクラスを取得する
            val activityClass = menuItems.get(position).get(ACTIVITY_CLASS) as Class<*>?
            activityClass?.let{
                val nextIntent = Intent(this, it)
                startActivity(nextIntent)

            } ?: run {
                // アクティビティクラスが取得できなければ、トーストメッセージを表示
                Toast.makeText(this, "今はまだ画面遷移できません", Toast.LENGTH_SHORT).show()
            }

        }
    }
}