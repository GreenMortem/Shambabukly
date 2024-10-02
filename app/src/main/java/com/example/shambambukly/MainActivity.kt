package com.example.shambambukly

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shambambukly.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var bindAM: ActivityMainBinding
    private val adapter = Adapter()
    var numbers: Array<Int> = arrayOf(4, 3, 2)
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindAM = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindAM.root)

        init()
    }

    private fun init() = with(bindAM) {
        rvAM.layoutManager = LinearLayoutManager(this@MainActivity)
        rvAM.adapter = adapter

        bCreate.setOnClickListener{

            var rnd = Random.nextInt(0, 2)

            if (rnd==0) {
                val cell = Cell(R.drawable.cell1,"Живая", "и шевелится!")
                adapter.createCell(cell)
            } else {
                val cell = Cell(R.drawable.cell2,"Мёртвая", "или прикидывается...")
                Log.d(ContentValues.TAG, " роб $cell")
                adapter.createCell(cell)
            }
            for (i in 0..1)
                numbers[i] = numbers[i+1]
            numbers[2] = rnd
            var x = adapter.getItemCount()
            val proverka = adapter.itemList[x-1]
            if(numbers[0]==numbers[1] && numbers[1]==numbers[2]){
                Log.d(ContentValues.TAG, " роб5 $numbers")
                numbers[2] = 2
                if(numbers[0]==0){
                    val cell = Cell(R.drawable.cell3,"Жизнь", "Ку-ку!")
                    Log.d(ContentValues.TAG, " робw $proverka")
                    adapter.createCell(cell)
                }else{
                    do{
                        val proverka = adapter.itemList[x-1]
                        Log.d(ContentValues.TAG, " робw $proverka")
                        if (proverka.imageID == R.drawable.cell3){
                            adapter.itemList[x-1].imageID = R.drawable.cell4
                            adapter.itemList[x-1].name = "Это уже мертво"
                            adapter.itemList[x-1].comment = "не сберегли..."
                            break
                        }
                        x-=1
                    }
                    while (x!=0)
                }
            }
            rvAM.scrollToPosition(adapter.getItemCount()-1)
            adapter.update()
        }
    }
}
