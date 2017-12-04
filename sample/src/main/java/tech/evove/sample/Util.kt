package tech.evove.sample


import io.realm.Realm
import io.realm.RealmModel
import io.realm.RealmQuery

fun realm(): Realm {
    return Realm.getDefaultInstance()
}

inline fun <reified T : RealmModel> Realm.getOrCreate(query: RealmQuery<out T>.() -> Any?, init: T.() -> Unit): T {
    val w = where(T::class.java)
    val primaryKey = w.query()
    return w.findFirst() ?: createObject(primaryKey, init)
}

inline fun <reified T : RealmModel> Realm.createObject(init: T.() -> Unit): T {
    return createObject(primaryKey = null, init = init)
}

inline fun <reified T : RealmModel> Realm.createObject(primaryKey: Any?, init: T.() -> Unit): T {
    return execTransaction {
        val obj = primaryKey?.let { createObject(T::class.java, it) }
                ?: createObject(T::class.java)
        obj.init()
        return@execTransaction obj
    }
}

inline fun <T : Any?> Realm.execTransaction(f: Realm.() -> T): T {
    beginTransaction()
    val ret = this.f()
    commitTransaction()
    return ret
}
