package com.rajnish.services.kotlin

import android.app.*
import android.content.Intent
import android.content.res.Configuration
import android.os.Binder
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import java.io.FileDescriptor
import java.io.PrintWriter


class MyServices : Service()
{
     lateinit var mNM: NotificationManager
    // Unique Identification Number for the Notification.
    // We use it on Notification start, and to cancel it.
    // var NOTIFICATION: Int = 121

    /**
     * Class for clients to access.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with
     * IPC.
     */
    class LocalBinder : Binder() {
        val service: MyServices get() = this.service
    }
    /**
     * Class for clients to access.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with
     * IPC.
     */
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
    }

    override fun dump(fd: FileDescriptor?, writer: PrintWriter?, args: Array<out String>?) {
        super.dump(fd, writer, args)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Thread({
            println("Service is sleep mode")

            Thread.sleep(1000)
            for (item in 1..10)
            {
                println("Value is printed in services {$item}")
            }
        }).start()
        return START_STICKY;
    }

    override fun onCreate() {

        mNM = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        // Display a notification about us starting.  We put an icon in the status bar.
    }

    override fun onLowMemory() {
        super.onLowMemory()
    }
    override fun onTaskRemoved(rootIntent: Intent?) {
        super.onTaskRemoved(rootIntent)
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
    }

    override fun onUnbind(intent: Intent?): Boolean {
        return super.onUnbind(intent)
    }

    override fun onDestroy()
    {
        // Cancel the persistent notification.
        //mNM.cancel(NOTIFICATION)

       // mNM.cancel(NOTIFICATION)

        // Tell the user we stopped.
        Toast.makeText(this, "local_service_stopped", Toast.LENGTH_SHORT).show();

    }

}