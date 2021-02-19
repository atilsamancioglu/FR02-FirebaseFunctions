package com.atilsamancioglu.firebasefunctions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.functions.FirebaseFunctions
import com.google.firebase.functions.ktx.functions
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var functions: FirebaseFunctions
    private lateinit var db : FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        functions = Firebase.functions
        db = Firebase.firestore

        /*

        functions.getHttpsCallable("helloWorld").call().addOnSuccessListener { result ->
            val data = result.data
            println(data)
        }.addOnFailureListener { exception ->
            Toast.makeText(this,exception.localizedMessage,Toast.LENGTH_LONG).show()

        }

         */



    }

    fun upload( view : View) {

        val price = priceText.text.toString().toIntOrNull()
        val quantity = quantityText.text.toString().toIntOrNull()

        val dataMap = hashMapOf<String, Int>()
        if(price != null && quantity != null) {
            dataMap.put("price",price)
            dataMap.put("quantity",quantity)
        }

        db.collection("Commerce").document("Basket").set(dataMap).addOnSuccessListener {
            println("yep successful")
        }.addOnFailureListener { exception ->
            Toast.makeText(this,exception.localizedMessage,Toast.LENGTH_LONG).show()
        }

    }

}