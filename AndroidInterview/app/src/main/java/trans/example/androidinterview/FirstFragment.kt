package trans.example.androidinterview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_first.*
import trans.example.androidinterview.R.layout.fragment_first

class FragmentFirst : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(fragment_first, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?, ) {
        super.onViewCreated(view, savedInstanceState)

        val manager = activity!!.supportFragmentManager
        val transaction = manager.beginTransaction()
        super.onViewCreated(view, savedInstanceState)
        val switchButton = SwitchButton
        switchButton.setOnClickListener {
            val fragment2 = FragmentSecond()
            transaction.replace(R.id.center, fragment2)
            transaction.commit()
        }
    }
}