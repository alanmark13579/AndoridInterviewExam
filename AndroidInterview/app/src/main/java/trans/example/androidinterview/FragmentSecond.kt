package trans.example.androidinterview

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.recycle_item.*
import trans.example.androidinterview.databinding.FragmentFirstBinding
import trans.example.androidinterview.databinding.FragmentSecondBinding
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

var arrayList: ArrayList<HashMap<String, String>> = ArrayList()

// 測試RecyclerView的code
class FragmentSecond : Fragment()
{
    var TAG = "mExample"
    var mRecyclerView: RecyclerView? = null
    var myListAdapter: MyListAdapter? = null
    private var Secondbinding: FragmentSecondBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(trans.example.androidinterview.R.layout.fragment_second, container, false)
    }
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?, ) {
        super.onViewCreated(view, savedInstanceState)

        //製造資料
        for (i in 0..29) {
            val hashMap: HashMap<String, String> = HashMap()
            hashMap["Id"] = "座號：" + String.format("%02d", i + 1)
            hashMap["Sub1"] = java.lang.String.valueOf(Random().nextInt(80) + 20)
            hashMap["Sub2"] = java.lang.String.valueOf(Random().nextInt(80) + 20)
            hashMap["Avg"] = (
                    (hashMap["Sub1"]!!.toInt() + hashMap["Sub2"]!!.toInt()) / 2).toString()
            arrayList.add(hashMap)
        }
        //設置RecycleView
        mRecyclerView = recyclerview
        mRecyclerView!!.layoutManager = LinearLayoutManager(this.context)
        mRecyclerView!!.addItemDecoration(DividerItemDecoration(this.context,
            DividerItemDecoration.VERTICAL))
        myListAdapter = MyListAdapter()
        mRecyclerView!!.adapter = myListAdapter*/


    } //onCreate
   class MyListAdapter : RecyclerView.Adapter<MyListAdapter.ViewHolder>() {
       val binding = FragmentFirstBinding.bind(view)
       Secondbinding = binding

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val tvId: TextView = itemView.findViewById<View>(R.id.textView_Id) as TextView
            val tvSub1: TextView = itemView.findViewById(R.id.textView_sub1)
            val tvSub2: TextView = itemView.findViewById(R.id.textView_sub2)
            val tvAvg: TextView = itemView.findViewById(R.id.textView_avg)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycle_item, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
           // val avgS: Int = arrayList.get(position).get("Avg").toInt()

            holder.tvId.setText(arrayList.get(position).get("Id"))
            holder.tvSub1.setText(arrayList.get(position).get("Sub1"))
            holder.tvSub2.setText(arrayList.get(position).get("Sub2"))
            holder.tvAvg.setText(arrayList.get(position).get("Avg"))
        }

        override fun getItemCount(): Int {
            return arrayList.size
        }
    }

}
/*  從url抓圖片下來的code
{
    var mRecyclerView: RecyclerView? = null
    private var myListAdapter: MyListAdapter? = null
var arrayList: ArrayList<HashMap<String, String>> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)

        val queue = Volley.newRequestQueue(this.context)
        val url = "https://jsonplaceholder.typicode.com/photos"

        //val imageView = view.findViewById<View>(R.id.show_photo) as ImageView
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response -> // 連線成功
                //使用 Gson 解析 Json 資料
                val posts: Array<Json> = Gson().fromJson(
                    response,
                    Array<Json>::class.java
                )
                for (item in posts) {
                    val hashMap: HashMap<String, String> = HashMap()
                    hashMap["Id"] = String.format("%02d", posts[0].id)
                    hashMap["Title"] = String.format("%02d", posts[0].title)
                    hashMap["thumbnailUrl"] = String.format("%02d", posts[0].thumbnailUrl)
                    arrayList.add(hashMap);

                }
            }) { error -> // 連線失敗
            Log.d("HKT", error.toString())
        }
        queue.add(stringRequest)

        val view = inflater.inflate(fragment_second, container, false)
        val mRecyclerView = recyclerview
        mRecyclerView.layoutManager = LinearLayoutManager(this.context)
        mRecyclerView.addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        myListAdapter = MyListAdapter()
        mRecyclerView.adapter = myListAdapter
        return view
    }
    */