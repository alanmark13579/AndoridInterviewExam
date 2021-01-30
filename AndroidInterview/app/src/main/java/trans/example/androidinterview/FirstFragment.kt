package trans.example.androidinterview

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import trans.example.androidinterview.R.layout.fragment_first
import trans.example.androidinterview.databinding.FragmentFirstBinding

class FragmentFirst : Fragment() {
    private var Firstbinding: FragmentFirstBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(fragment_first, container, false)
    }
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        val binding = FragmentFirstBinding.bind(view)
        Firstbinding = binding
        val manager = activity!!.supportFragmentManager
        val transaction = manager.beginTransaction()
        val switchButton = binding.SwitchButton
        switchButton.setOnClickListener() {
            val fragment2 = FragmentSecond()
            transaction.replace(R.id.center, fragment2)
            transaction.commit()
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Firstbinding = null
    }

}