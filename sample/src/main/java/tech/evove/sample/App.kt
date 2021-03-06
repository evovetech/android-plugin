package tech.evove.sample

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val config = RealmConfiguration.Builder()
                .name("app.realm")
                .schemaVersion(1)
                .build()
        Realm.setDefaultConfiguration(config)
    }
}
