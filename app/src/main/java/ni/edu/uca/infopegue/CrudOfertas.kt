package ni.edu.uca.infopegue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import ni.edu.uca.infopegue.dao.ShareObjectAdp
import ni.edu.uca.infopegue.dao.ShareObjectAdp.Companion.preferShared
import ni.edu.uca.infopegue.databinding.FragmentCrudOfertasBinding


class CrudOfertas : Fragment() {
    private lateinit var binding: FragmentCrudOfertasBinding
    var ObtenerKeys: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCrudOfertasBinding.inflate(layoutInflater)
        iniciar()
        Acciones()
        load()
        clean()
        return binding.root
    }

    private fun load() {
        val tempKey = preferShared.getTempKey()

        with(binding) {
            etNombreOferta.setText(preferShared.getNombreOf(tempKey))
            etContacto.setText(preferShared.getContactoOf(tempKey))
            etRequisitos.setText(preferShared.getRequisitoOf(tempKey))
            etUbicacion.setText(preferShared.getUbicacionOf(tempKey))
            etDescripOferta.setText(preferShared.getDescripcionOf(tempKey))
            ObtenerKeys = preferShared.getKey(tempKey)

        }
    }
    private fun clean() {
        with(binding) {
            btnLimpiar.setOnClickListener {
                etNombreOferta.setText("")
                etContacto.setText("")
                etRequisitos.setText("")
                etUbicacion.setText("")
                etDescripOferta.setText("")
            }
        }
    }
    private fun iniciar() {
        val tempKey: String = preferShared.getTempKey()
        with(binding) {
            binding.btnGuardar.setOnClickListener {
                val nombreOf = etNombreOferta.text.toString()
                val descripcioOf = etDescripOferta.text.toString()
                val contactoOf = etContacto.text.toString()
                val requisitosOf = etRequisitos.text.toString()
                val ubicacionOf = etUbicacion.text.toString()

                with(preferShared) {
                    saveNameOf(tempKey, nombreOf)
                    saveDescripcionOf(tempKey, descripcioOf)
                    saveContactoOf(tempKey, contactoOf)
                    saveUbicacionOf(tempKey, ubicacionOf)
                    saveRequisitoOf(tempKey, requisitosOf)

                }

            }
        }


        binding.btnEliminar.setOnClickListener {
            var arreglo = preferShared.getArray()
            arreglo[tempKey]!!.eliminado  = true
            preferShared.wipe()
            Toast.makeText(this.context, "Datos Borrados", Toast.LENGTH_SHORT).show()
            var ktemp = "A"
            var y:String = ""
            for(x in arreglo.keys){
                if(!y.equals("")){
                    if(!arreglo[x]!!.eliminado){
                        with(preferShared){
                            saveKey(y, x)
                            saveNameOf(x, arreglo[x]!!.nombreOferta)
                            saveDescripcionOf(x, arreglo[x]!!.descripcionOferta)
                            saveContactoOf(x, arreglo[x]!!.contactoOf)
                            saveRequisitoOf(x, arreglo[x]!!.requisito)
                            saveUbicacionOf(x, arreglo[x]!!.ubicacion)
                            clean()
                        }
                    }
                }
                y = x
            }
        }
    }


    private fun Acciones() {

        binding.IvPersona.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.PantallaDatosEmpresa)
        }
        binding.IvInicio.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.PantallaOfertasEmpresa)
        }
        binding.IvMail.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.PantallaRespuestasDeOfertas)
        }
    }
}