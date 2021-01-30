package trans.example.androidinterview

import android.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.load.model.GlideUrl
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.recycle_item.*
import trans.example.androidinterview.R.layout.fragment_second


class FragmentSecond : Fragment()
{
    var mRecyclerView: RecyclerView? = null
//    private var myListAdapter: MyListAdapter? = null
    public var arrayList: ArrayList<HashMap<String, String>> = ArrayList()

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

                    hashMap["Id"] = String.format("%02d", item.id)
                    hashMap["Title"] = item.title.toString()
                    hashMap["thumbnailUrl"] = item.thumbnailUrl.toString()
                    //Log.d("HKT",  hashMap["thumbnailUrl"].toString() )
                    arrayList.add(hashMap);
                }

            }) { error -> // 連線失敗
            Log.d("HKT", error.toString())
        }
        queue.add(stringRequest)

        val view = inflater.inflate(fragment_second, container, false)
       /* val mRecyclerView = recyclerview
        mRecyclerView.layoutManager = LinearLayoutManager(this.context)
        mRecyclerView.addItemDecoration(
            DividerItemDecoration(
                this.context,
                DividerItemDecoration.VERTICAL
            )
        )
        myListAdapter = MyListAdapter()
        mRecyclerView.adapter = myListAdapter*/
        return view
    }


}
/*
private class MyListAdapter : RecyclerView.Adapter<MyListAdapter.ViewHolder>() {

    internal class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val thumbnailUrl: ImageView = show_photo_1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.recycle_item,
                parent,
                false
            )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val avgS: Int = arrayList.get(position).get("thumbnailUrl").toInt()

        holder.thumbnailUrl.

        val url = GlideUrl(
            arrayList.get(position).get("thumbnailUrl")[0].thumbnailUrl, LazyHeaders.Builder()
                .addHeader("User-Agent", "your-user-agent")
                .build()
        )
        Glide.with(this).load(url).into(imageView);
    }
    override fun getItemCount(): Int {
        return arrayList.size()
    }
}*/