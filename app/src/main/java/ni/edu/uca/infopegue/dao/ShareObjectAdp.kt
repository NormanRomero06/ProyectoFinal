package ni.edu.uca.infopegue.dao

import android.app.Application

class ShareObjectAdp: Application(){
    companion object{
        lateinit var preferShared: PreferShared
    }

    override fun onCreate() {
        super.onCreate()
        preferShared = PreferShared(applicationContext)
    }
}