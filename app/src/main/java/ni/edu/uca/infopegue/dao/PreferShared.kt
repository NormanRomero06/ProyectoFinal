package ni.edu.uca.infopegue.dao

import android.content.Context
import ni.edu.uca.infopegue.entidades.Oferta

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

    // SHARED OFERTA
    val SHARED_OFERTA_NOMBREOF = "NombreOf"
    val SHARED_OFERTA_DESCRIPCIONOF = "DescripcionOf"
    val SHARED_OFERTA_CONTACTOF = "Contactof"
    val SHARED_OFERTA_UBICACION = "Ubicaciof"
    val SHARED_OFERTA_REQUISITOS = "RequisitosF"
    val SHARED_OFERTA_KEY = "A"
    val SHARED_TEMP_KEY = "R"


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

    fun saveCorreo(Correo: String) {
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

    fun getDescripcion(): String {
        return storage.getString(SHARED_USER_DESCRIPCION, "")!!
    }

    fun getCorreo(): String {
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

    fun wipe() {
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

    fun saveDescripcionEm(DescripcionEm: String) {
        storage.edit().putString(SHARED_ENTIDAD_DESCRIPCIONEM, DescripcionEm).apply()
    }

    fun getNombre(): String {
        return storage.getString(SHARED_ENTIDAD_NOMBRE, "")!!
    }

    fun getDireccion(): String {
        return storage.getString(SHARED_ENTIDAD_DIRECCION, "")!!
    }

    fun getRepresentante(): String {
        return storage.getString(SHARED_ENTIDAD_REPRESENTANTE, "")!!
    }

    fun getContacto(): String {
        return storage.getString(SHARED_ENTIDAD_CONTACTO, "")!!
    }

    fun getCorreoEmp(): String {
        return storage.getString(SHARED_ENTIDAD_CORREO, "")!!
    }

    fun getDescripcionEmp(): String {
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
    // Metodos de ofertas

    fun saveNameOf(Key: String, nameOf: String) {
        storage.edit().putString(Key + SHARED_OFERTA_NOMBREOF, nameOf).apply()
    }

    fun saveDescripcionOf(Key: String, DescripcionOf: String) {
        storage.edit().putString(Key + SHARED_OFERTA_DESCRIPCIONOF, DescripcionOf).apply()
    }

    fun saveContactoOf(Key: String, ContactoOf: String) {
        storage.edit().putString(Key + SHARED_OFERTA_CONTACTOF, ContactoOf).apply()
    }

    fun saveUbicacionOf(Key: String, UbicacionOf: String) {
        storage.edit().putString(Key + SHARED_OFERTA_UBICACION, UbicacionOf).apply()
    }

    fun saveRequisitoOf(Key: String, RequisitosOf: String) {
        storage.edit().putString(Key + SHARED_OFERTA_REQUISITOS, RequisitosOf).apply()
    }

    fun saveKey(oldKey: String, newKey: String) {
        storage.edit().putString(oldKey, newKey).apply()
    }

    fun SaveTempKey(Key: String) {
        storage.edit().putString(SHARED_TEMP_KEY, Key).apply()
    }

    fun getNombreOf(Key: String): String {
        return storage.getString(Key + SHARED_OFERTA_NOMBREOF, "")!!
    }

    fun getDescripcionOf(Key: String): String {
        return storage.getString(Key + SHARED_OFERTA_DESCRIPCIONOF, "")!!
    }

    fun getContactoOf(Key: String): String {
        return storage.getString(Key + SHARED_OFERTA_CONTACTOF, "")!!
    }

    fun getUbicacionOf(Key: String): String {
        return storage.getString(Key + SHARED_OFERTA_UBICACION, "")!!
    }

    fun getRequisitoOf(Key: String): String {
        return storage.getString(Key + SHARED_OFERTA_REQUISITOS, "")!!
    }

    fun getTempKey(): String {
        return storage.getString(SHARED_TEMP_KEY, "")!!
    }

    fun getKey(key: String): String {
        return storage.getString(key, "")!!

    }
    fun RemoveNombreOf(Key: String, toString: String) {
        return storage.edit().remove(SHARED_OFERTA_NOMBREOF).apply()
    }
    fun RemoveDescripcionf(toString: String) {
        return storage.edit().remove(SHARED_OFERTA_DESCRIPCIONOF).apply()
    }
    fun RemoveContactoOf(toString: String) {
        return storage.edit().remove(SHARED_OFERTA_CONTACTOF).apply()
    }
    fun RemoveUbicacionOf(toString: String) {
        return storage.edit().remove(SHARED_OFERTA_UBICACION).apply()
    }
    fun RemoveRequisitosOf(toString: String) {
        return storage.edit().remove(SHARED_OFERTA_REQUISITOS).apply()
    }

    fun getArray(): HashMap<String, Oferta> {
        var tempKey = SHARED_OFERTA_KEY
        var arreglo = HashMap<String, Oferta>()
        while (tempKey.isNotEmpty()) {
            val nombreOf:String = getNombreOf(tempKey)
            val descripcionOf:String = getDescripcionOf(tempKey)
            val contactoOf: String = getContactoOf(tempKey)
            val ubicacionOf: String = getUbicacionOf(tempKey)
            val requisitosOf: String = getRequisitoOf(tempKey)
            val of = Oferta(nombreOf, descripcionOf, contactoOf, ubicacionOf,requisitosOf)
            arreglo.put(tempKey, of)
            tempKey = getKey(tempKey)
        }
        return arreglo
    }
    fun createKey(): String{
        var keyTemp = SHARED_OFERTA_KEY
        while(true){
            if(!getKey(keyTemp).equals("") || getKey(keyTemp).isNotEmpty()){
                keyTemp = getKey(keyTemp)
            }else{break}
        }
        return keyTemp + "A"
    }
}
