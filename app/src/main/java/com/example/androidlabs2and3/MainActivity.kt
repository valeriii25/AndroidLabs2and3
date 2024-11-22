package com.example.androidlabs2and3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androidlabs2and3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityBinding: ActivityMainBinding
    private val adapter: ProductAdapter = ProductAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        mainActivityBinding.recyclerView.adapter = adapter
        mainActivityBinding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        adapter.add(Product(R.drawable.pic1, "Кофта", 1999.99, false))
        adapter.add(Product(R.drawable.pic2, "Штаны", 999.99, false))
        adapter.add(Product(R.drawable.pic3, "Перчатки", 799.99, false))
        adapter.add(Product(R.drawable.pic4, "Носки", 299.99, false))
        adapter.add(Product(R.drawable.pic5, "Кепка", 1399.99, false))
        adapter.add(Product(R.drawable.pic6, "Кроссовки", 4299.99, false))
        adapter.add(Product(R.drawable.pic7, "Ботинки", 5299.99, false))
        adapter.add(Product(R.drawable.pic8, "Шлепки", 2299.99, false))
        setContentView(mainActivityBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}