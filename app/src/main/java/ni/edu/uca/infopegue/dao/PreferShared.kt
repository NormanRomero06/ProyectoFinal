package ni.edu.uca.infopegue.dao

import android.content.Context

class PreferShared(val context: Context) {

    val SHARED_NAME = "BdInfoPegue"
    val SHARED_USER_FNAME = "Fnombre"
    val SHARED_USER_SNAME = "Snombre"
    val SHARED_USER_FAPELLIDO = "Fapellido"
    val SHARED_USER_SAPELLIDO = "Sapellido"
    val SHARED_USER_EDAD = "Edad"
    val SHARED_USER_PROFESION = "Profesion"
    val SHARED_USER_DESCRIPCION = "Descripcion"

    val storage = context.getSharedPreferences(SHARED_NAME, 0)

    fun saveFnombre(Pnombre: String) {
        storage.edit().putString(SHARED_USER_FNAME, Pnombre).apply()
    }

    fun saveSnombre(Snombre: String) {
        storage.edit().putString(SHARED_USER_SNAME, Snombre).apply()
    }

    fun saveFapellido(Papellido: String) {
        storage.edit().putString(SHARED_USER_FAPELLIDO, Papellido).apply()
    }

    fun saveSapellido(Sapellido: String) {
        storage.edit().putString(SHARED_USER_SAPELLIDO, Sapellido).apply()
    }

    fun saveEdad(Edad: Int) {
        storage.edit().putInt(SHARED_USER_EDAD, Edad).apply()
    }

    fun saveProfesion(Profesion: String) {
        storage.edit().putString(SHARED_USER_PROFESION, Profesion).apply()
    }

    fun saveDescripcion(Descripcion: String) {
        storage.edit().putString(SHARED_USER_DESCRIPCION, Descripcion).apply()
    }

    fun getFnombre(): String {
        return storage.getString(SHARED_USER_FNAME, "")!!
    }

    fun getSnombre(): String {
        return storage.getString(SHARED_USER_SNAME, "")!!
    }

    fun getFapellido(): String {
        return storage.getString(SHARED_USER_FAPELLIDO, "")!!
    }

    fun getFSapellido(): String {
        return storage.getString(SHARED_USER_SAPELLIDO, "")!!
    }

    fun getEdad(): Int {
        return storage.getInt(SHARED_USER_EDAD, -1)
    }

    fun getProfesion(): String {
        return storage.getString(SHARED_USER_PROFESION, "")!!
    }
    fun getDescripcion():String{
        return storage.getString(SHARED_USER_DESCRIPCION,"")!!
    }
    fun wipe(){
        storage.edit().clear().apply()
    }
}