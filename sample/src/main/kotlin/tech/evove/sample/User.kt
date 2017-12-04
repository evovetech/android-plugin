package tech.evove.sample

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class User : RealmObject() {
    @PrimaryKey
    var email: String? = null
    var firstName: String? = null
    var lastName: String? = null

    companion object {
        inline fun getOrCreate(email: String, init: User.() -> Unit): User {
            return realm().getOrCreate({
                equalTo("email", email)
                email
            }, init)
        }
    }
}
