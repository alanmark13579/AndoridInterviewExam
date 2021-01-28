package trans.example.androidinterview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class MainActivity : AppCompatActivity() {
    private var manager: FragmentManager? = null
    private var transaction: FragmentTransaction? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //初始化先到FragmentFirst
        manager = supportFragmentManager
        transaction = manager!!.beginTransaction()
        val fragment1 = FragmentFirst()
        transaction!!.replace(R.id.center, fragment1)
        transaction!!.commit()
    }
}