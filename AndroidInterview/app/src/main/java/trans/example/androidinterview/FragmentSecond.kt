package trans.example.androidinterview

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson


class FragmentSecond : Fragment() {

        override fun onCreate(savedInstanceState: Bundle?)
        {
            super.onCreate(savedInstanceState)
            val queue = Volley.newRequestQueue(this.context)
            //val url = "https://jsonplaceholder.typicode.com/photos"
            val url = " https://via.placeholder.com/150/92c952"
            val stringRequest = StringRequest(
                Request.Method.GET, url,
                { response -> // 連線成功
                    //使用 Gson 解析 Json 資料
                    val posts: Array<Json> = Gson().fromJson(
                        response,
                        Array<Json>::class.java
                    )
                    for (item in posts) {
                        Log.d("HKT", "id: " + item.id)
                        Log.d("HKT", "title: " + item.title)
                        Log.d("HKT", "body: " + item.body)
                        Log.d("HKT", "userId: " + item.userId)
                    }
                }) { error -> // 連線失敗
                Log.d("HKT", error.toString())
            }

            queue.add(stringRequest)

        }
}