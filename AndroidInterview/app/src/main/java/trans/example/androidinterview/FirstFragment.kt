package trans.example.androidinterview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentFirst : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val manager = activity!!.supportFragmentManager
        val transaction = manager.beginTransaction()
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        val switchButton = view.findViewById<View>(R.id.SwitchButton) as Button

        switchButton.setOnClickListener {
            val fragment2 = FragmentSecond() //初始化接著要switch的fragment
            transaction.replace(R.id.center, fragment2) //switch　framgent
            transaction.commit() //使framgent變化生效
        }
        return view
    }
}