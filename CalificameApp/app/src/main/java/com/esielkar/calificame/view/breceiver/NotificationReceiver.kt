package com.esielkar.calificame.view.breceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.esielkar.calificame.MainActivity
import com.esielkar.calificame.view.AddReviewFragment

class NotificationReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action == AddReviewFragment.ACTION_RECEIVED){
            Toast.makeText(context, "Review añadida exitosamente", Toast.LENGTH_LONG).show()
        }
    }
}
