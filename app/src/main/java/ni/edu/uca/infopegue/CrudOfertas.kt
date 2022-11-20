package ni.edu.uca.infopegue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import ni.edu.uca.infopegue.dao.ShareObjectAdp.Companion.preferShared
import ni.edu.uca.infopegue.databinding.FragmentCrudOfertasBinding


class CrudOfertas : Fragment() {
    private lateinit var binding: FragmentCrudOfertasBinding


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
        return binding.root
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
            with(binding) {
                preferShared.RemoveNombreOf(etNombreOferta.text.toString())
                preferShared.RemoveDescripcionf(etDescripOferta.text.toString())
                preferShared.RemoveRequisitosOf(etRequisitos.text.toString())
                preferShared.RemoveUbicacionOf(etUbicacion.text.toString())
                preferShared.RemoveContactoOf(etContacto.text.toString())
            }
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
            Navigation.findNavController(binding.root).navigate(R.id.PantallaSolicitudesCliente)
        }
    }
}