package trans.example.androidinterview

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.google.gson.Gson
import trans.example.androidinterview.R.layout.fragment_second


class FragmentSecond : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)

        val queue = Volley.newRequestQueue(this.context)
        val url = "https://jsonplaceholder.typicode.com/photos"
        //val url = " https://via.placeholder.com/150/92c952"
      // Glide.get(context)
           //     .register(GlideUrl::class.java, InputStream::class.java, VolleyUrlLoader.Factory(queue))


        val view = inflater.inflate(fragment_second, container, false)
        val imageView = view.findViewById<View>(R.id.show_photo) as ImageView
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response -> // 連線成功
                //使用 Gson 解析 Json 資料
                val posts: Array<Json> = Gson().fromJson(
                    response,
                    Array<Json>::class.java
                )
                //   for (item in posts) {
                Log.d("HKT", "id: " + posts[0].id)
                Log.d("HKT", "title: " + posts[0].title)
                Log.d("HKT", "thumbnailUrl: " + posts[0].thumbnailUrl)
                //Glide.with(context).load(posts[0].thumbnailUrl).into(imageView)
                val url = GlideUrl(
                    posts[0].thumbnailUrl, LazyHeaders.Builder()
                        .addHeader("User-Agent", "your-user-agent")
                        .build()
                )
                Glide.with(this).load(url).into(imageView);
                //  }
            }) { error -> // 連線失敗
            Log.d("HKT", error.toString())
        }
        queue.add(stringRequest)
        return view
    }
}