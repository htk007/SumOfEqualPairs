package com.heka.equalsumpairs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val equalSumPairs = equalSumPairs(arr)
        Log.i("HASANLOG",equalSumPairs.toString());
    }

    fun equalSumPairs(arr: IntArray): List<Pair<Int, Int>> {
        val result = mutableListOf<Pair<Int, Int>>()
        val sumIndicesMap = HashMap<Int, MutableList<Int>>()

        for (i in arr.indices) {
            for (j in i + 1 until arr.size) {
                val sum = arr[i] + arr[j]
                if (sum in sumIndicesMap) {
                    for (index in sumIndicesMap[sum]!!) {
                        result.add(Pair(arr[index], arr[i]))
                        result.add(Pair(arr[index], arr[j]))
                    }
                }
                if (sum !in sumIndicesMap) {
                    sumIndicesMap[sum] = mutableListOf(i)
                } else {
                    sumIndicesMap[sum]!!.add(i)
                }
            }
        }

        return result
    }

}