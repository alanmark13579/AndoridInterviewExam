package trans.example.androidinterview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class MainActivity : AppCompatActivity() {
    private var manager: FragmentManager? = null
    private var transaction: FragmentTransaction? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) //難以維護
        setContentView(R.layout.activity_main)

        //初始化先到FragmentFirst
        manager = supportFragmentManager //取得activity內所有的fragment
        transaction = manager!!.beginTransaction() //初始化manger的變化
        val fragment1 = FragmentFirst() //初始化接著要switch的fragment
        transaction!!.replace(R.id.center, fragment1) //switch　framgent
        transaction!!.commit() //使framgent變化生效
    }
}