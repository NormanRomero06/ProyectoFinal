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
    val SHARED_USER_CORREO = "Correo"

    // SHARED EMPRESA
     val SHARED_ENTIDAD_NOMBRE = "NombreEmp"
    val SHARED_ENTIDAD_DIRECCION = "Direccion"
    val SHARED_ENTIDAD_REPRESENTANTE = "Representante"
    val SHARED_ENTIDAD_CONTACTO = "Contacto"
    val SHARED_ENTIDAD_CORREO = "Correo"
    val SHARED_ENTIDAD_DESCRIPCIONEM = "DescripcionEm"

 //Variable de acceso al BD
    val storage = context.getSharedPreferences(SHARED_NAME, 0)

    //Metodos de guardar y mostrar Empleados
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
    fun saveCorreo(Correo: String){
        storage.edit().putString(SHARED_USER_CORREO, Correo).apply()
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

    fun getSapellido(): String {
        return storage.getString(SHARED_USER_SAPELLIDO, "")!!
    }

    fun getEdad(): Int {
        return storage.getInt(SHARED_USER_EDAD, 0)
    }

    fun getProfesion(): String {
        return storage.getString(SHARED_USER_PROFESION, "")!!
    }
    fun getDescripcion():String{
        return storage.getString(SHARED_USER_DESCRIPCION,"")!!
    }
    fun getCorreo():String{
        return storage.getString(SHARED_USER_CORREO, "")!!
    }

    fun RemoveNombre(toString: String) {
       return storage.edit().remove(SHARED_USER_FNAME).apply()
    }
    fun RemoveNombre2(toString: String) {
        return storage.edit().remove(SHARED_USER_SNAME).apply()
    }
    fun RemoveApellido(toString: String) {
        return storage.edit().remove(SHARED_USER_FAPELLIDO).apply()
    }
    fun RemoveApellido2(toString: String) {
        return storage.edit().remove(SHARED_USER_SAPELLIDO).apply()
    }
    fun RemoveEdad(toInt: Int) {
        return storage.edit().remove(SHARED_USER_EDAD).apply()
    }
    fun RemoveProfesion(toString: String) {
        return storage.edit().remove(SHARED_USER_PROFESION).apply()
    }
    fun RemoveCorreo(toString: String) {
        return storage.edit().remove(SHARED_USER_CORREO).apply()
    }
    fun RemoveDescripcion(toString: String) {
        return storage.edit().remove(SHARED_USER_DESCRIPCION).apply()
    }
    fun wipe(){
        storage.edit().clear().apply()
    }
    //Metodos de Guardar y Mostrar Empresa

    fun saveNombre(NombreEm: String) {
        storage.edit().putString(SHARED_ENTIDAD_NOMBRE, NombreEm).apply()
    }
    fun saveDireccion(DireccionEm: String) {
        storage.edit().putString(SHARED_ENTIDAD_DIRECCION, DireccionEm).apply()
    }
    fun saveRepresentante(RepresentanteEm: String) {
        storage.edit().putString(SHARED_ENTIDAD_REPRESENTANTE, RepresentanteEm).apply()
    }
    fun saveContacto(ContactoEm: String) {
        storage.edit().putString(SHARED_ENTIDAD_CONTACTO, ContactoEm).apply()
    }
    fun saveCorreoEm(CorreoEm: String) {
        storage.edit().putString(SHARED_ENTIDAD_CORREO, CorreoEm).apply()
    }
   fun saveDescripcionEm(DescripcionEm: String){
        storage.edit().putString(SHARED_ENTIDAD_DESCRIPCIONEM, DescripcionEm).apply()
    }
    fun  getNombre():String{
        return storage.getString(SHARED_ENTIDAD_NOMBRE, "")!!
    }

    fun  getDireccion():String{
        return storage.getString(SHARED_ENTIDAD_DIRECCION, "")!!
    }
    fun  getRepresentante():String{
        return storage.getString(SHARED_ENTIDAD_REPRESENTANTE, "")!!
    }
    fun  getContacto():String{
        return storage.getString(SHARED_ENTIDAD_CONTACTO, "")!!
    }
    fun getCorreoEmp():String{
        return storage.getString(SHARED_ENTIDAD_CORREO, "")!!
    }
    fun  getDescripcionEmp():String{
        return storage.getString(SHARED_ENTIDAD_DESCRIPCIONEM, "")!!
    }
    fun RemoveNombreEm(toString: String) {
        return storage.edit().remove(SHARED_ENTIDAD_NOMBRE).apply()
    }
    fun RemoveDireccion(toString: String) {
        return storage.edit().remove(SHARED_ENTIDAD_DIRECCION).apply()
    }
    fun RemoveRepresentante(toString: String) {
        return storage.edit().remove(SHARED_ENTIDAD_REPRESENTANTE).apply()
    }
    fun RemoveContactoEm(toString: String) {
        return storage.edit().remove(SHARED_ENTIDAD_CONTACTO).apply()
    }
    fun RemoveCorreoEm(toString: String) {
        return storage.edit().remove(SHARED_ENTIDAD_CORREO).apply()
    }
    fun RemoveDescripcionEM(toString: String) {
        return storage.edit().remove(SHARED_ENTIDAD_DESCRIPCIONEM).apply()
    }
}